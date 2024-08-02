package com.taller.services;

import com.taller.dto.request.UserAuthRequestDto;
import com.taller.dto.request.UserUpdateRequestDto;
import com.taller.dto.request.UserRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseUserDto;
import com.taller.entity.PermissionEntity;
import com.taller.entity.RoleEntity;
import com.taller.entity.UserEntity;
import com.taller.repository.PermissionRepository;
import com.taller.repository.RoleRepository;
import com.taller.repository.UserEntityRepository;
import com.taller.services.impl.UserEntityServiceImpl;
import com.taller.utils.UserObjectUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Permission;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserEntityServiceTest {

    @Mock
    UserEntityRepository repository;

    @Mock
    RoleRepository roleRepository;

    @Mock
    PermissionRepository permissionRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserEntityServiceImpl service;

    @Test
    @DisplayName("Test OK para find all users")
    void findAllUsrTestOK(){
        List<UserEntity> users = UserObjectUtils.listaUsers();
        List<ResponseUserDto> expected = UserObjectUtils.listaUsersDto();

        when(repository.findAll()).thenReturn(users);
        List<ResponseUserDto> actual = service.findAllUsers();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para save user")
    void saveUserTestOK(){
        UserEntity user = UserObjectUtils.user1();
        UserRequestDto argumentSut = UserObjectUtils.userReqDto();
        RoleEntity rol = UserObjectUtils.role1();
        PermissionEntity permiso = UserObjectUtils.permission();
        ResponseDto expected = new ResponseDto("Usuario guardado con éxito");

        when(roleRepository.findByRoleEnum(any())).thenReturn(Optional.of(rol));
        when(permissionRepository.findByPermission(any())).thenReturn(Optional.of(permiso));
        when(repository.save(any())).thenReturn(user);
        ResponseDto actual = service.createUser(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update user")
    void updateUserTestOK(){
        Long id = 1L;
        UserEntity user = UserObjectUtils.user1();
        UserEntity modificado = UserObjectUtils.user3();
        UserUpdateRequestDto argumentSut = UserObjectUtils.userUpdateReqDto();
        ResponseDto expected = new ResponseDto("User modificado con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(user));
        when(repository.save(any())).thenReturn(modificado);
        ResponseDto actual = service.updateUser(argumentSut, id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para update Authorities")
    void updateAuthoritiesTestOK(){
        Long id = 1L;
        UserAuthRequestDto argumentSut = UserObjectUtils.authRequestDto();
        UserEntity user = UserObjectUtils.user1();
        RoleEntity rol = UserObjectUtils.role2();
        PermissionEntity permiso = UserObjectUtils.permission2();
        UserEntity userAuth = UserObjectUtils.userAuth();
        ResponseDto expected = new ResponseDto("Autorizaciones modificadas con éxito");

        when(repository.findById(any())).thenReturn(Optional.of(user));
        when(roleRepository.findById(any())).thenReturn(Optional.of(rol));
        when(permissionRepository.findById(any())).thenReturn(Optional.of(permiso));
        when(repository.save(any())).thenReturn(userAuth);
        ResponseDto actual = service.updateAuthorties(argumentSut, id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test OK para delete user")
    void deleteUserTestOK(){
        Long id = 1L;
        boolean response = true;
        ResponseDto expected = new ResponseDto("User eliminado con éxito");

        when(repository.existsById(any())).thenReturn(response);
        ResponseDto actual = service.deleteUser(id);

        assertEquals(expected, actual);
    }
}
