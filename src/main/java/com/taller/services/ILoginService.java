package com.taller.services;


import com.taller.dto.request.LoginDto;
import com.taller.dto.response.JwtDto;

public interface ILoginService {

    JwtDto login(LoginDto loginDto);
}
