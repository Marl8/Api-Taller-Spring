package com.taller.services;

import com.taller.dto.request.UserRequestDto;
import com.taller.dto.response.ResponseDto;

public interface IUserEntityService {

    ResponseDto createUser(UserRequestDto userDto);
}
