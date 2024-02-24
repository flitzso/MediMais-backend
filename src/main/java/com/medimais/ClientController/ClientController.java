package com.medimais.ClientController;

import com.medimais.DTO.ClientDTO;
import com.medimais.DTO.LoginDTO;
import com.medimais.LoginResponse.LoginMesage;
import com.medimais.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping(path = "/save")
    public String saveClient(@RequestBody ClientDTO clientDTO)
    {
        String id = clientService.addClient(clientDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginClient(@RequestBody LoginDTO loginDTO)
    {
        LoginMesage loginResponse = clientService.loginClient(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}