package com.medimais.Service;

import com.medimais.DTO.ClientDTO;
import com.medimais.DTO.LoginDTO;
import com.medimais.LoginResponse.LoginMesage;

public interface ClientService {
    String addClient(ClientDTO employeeDTO);
    LoginMesage loginClient(LoginDTO loginDTO);
}