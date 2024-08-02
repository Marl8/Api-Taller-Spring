package com.taller.services;

import com.taller.dto.request.UserAuthRequestDto;
import com.taller.dto.request.UserUpdateRequestDto;
import com.taller.dto.request.UserRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseUserDto;

import java.util.List;

public interface IUserEntityService {

    ResponseDto createUser(UserRequestDto userDto);

    ResponseDto updateUser(UserUpdateRequestDto userDto, Long id);

    ResponseDto updateAuthorties(UserAuthRequestDto userDto, Long idUser);

    ResponseDto deleteUser(Long id);

    List<ResponseUserDto> findAllUsers();
}
