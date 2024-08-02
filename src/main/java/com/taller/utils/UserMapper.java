package com.taller.utils;

import com.taller.dto.response.ResponseUserDto;
import com.taller.entity.UserEntity;

import java.util.List;

public class UserMapper {

    public static List<ResponseUserDto> listaUserDto(List<UserEntity> lista){
        return lista.stream().map(u -> new ResponseUserDto(u.getId(), u.getUsername())).toList();
    }
}
