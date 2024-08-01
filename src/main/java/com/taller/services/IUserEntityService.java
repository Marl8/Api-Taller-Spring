package com.taller.services;

import com.taller.dto.request.UserEntityAuthRequestDto;
import com.taller.dto.request.UserEntityUpdateRequestDto;
import com.taller.dto.request.UserRequestDto;
import com.taller.dto.response.ResponseDto;

public interface IUserEntityService {

    ResponseDto createUser(UserRequestDto userDto);

    ResponseDto updateUser(UserEntityUpdateRequestDto userDto, Long id);

    ResponseDto updateAuthorties(UserEntityAuthRequestDto userDto, Long idUser);

    ResponseDto deleteUser(Long id);
}
