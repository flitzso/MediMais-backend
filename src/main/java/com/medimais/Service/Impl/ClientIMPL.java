package com.medimais.Service.Impl;

import com.medimais.DTO.ClientDTO;
import com.medimais.DTO.LoginDTO;
import com.medimais.Entity.Client;
import com.medimais.LoginResponse.LoginMesage;
import com.medimais.Repository.ClientRepo;
import com.medimais.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientIMPL implements ClientService {
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addClient(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.getClientid(),
                clientDTO.getClientname(),
                clientDTO.getEmail(),
                this.passwordEncoder.encode(clientDTO.getPassword())
        );
        clientRepo.save(client);
        return client.getClientname();
    }
    ClientDTO clientDTO;
    @Override
    public LoginMesage loginClient(LoginDTO loginDTO) {
        String msg = "";
        Client client1 = clientRepo.findByEmail(loginDTO.getEmail());
        if (client1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = client1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Client> client = clientRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (client.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }
    }
}