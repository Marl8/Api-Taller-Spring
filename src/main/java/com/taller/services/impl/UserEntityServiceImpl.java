package com.taller.services.impl;

import com.taller.dto.request.UserRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.entity.PermissionEntity;
import com.taller.entity.RoleEntity;
import com.taller.entity.UserEntity;
import com.taller.entity.enums.PermissionEnum;
import com.taller.entity.enums.RoleEnum;
import com.taller.errors.GenericException;
import com.taller.repository.PermissionRepository;
import com.taller.repository.RoleRepository;
import com.taller.repository.UserEntityRepository;
import com.taller.services.IUserEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserEntityServiceImpl implements IUserEntityService {

    UserEntityRepository repository;

    RoleRepository roleRepository;

    PermissionRepository permissionRepository;

    PasswordEncoder passwordEncoder;

    public UserEntityServiceImpl(UserEntityRepository repository, RoleRepository roleRepository,
                                 PermissionRepository permissionRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseDto createUser(UserRequestDto userDto) {
        Optional<UserEntity> existe = repository.findUserEntityByUsername(userDto.getUsername());
        if(existe.isPresent()) {
            throw new GenericException("User already exists", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        user.setEnable(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        RoleEntity role = roleRepository.findByRoleEnum(RoleEnum.USER).orElseThrow(
                () -> new GenericException("Role not found", HttpStatus.NOT_FOUND));
        System.out.println(role);
        PermissionEntity permission = permissionRepository.findByPermission(PermissionEnum.READ)
                .orElseThrow(()-> new GenericException("Permission not found", HttpStatus.NOT_FOUND));
        System.out.println(permission);
        Set<PermissionEntity> permissions = new HashSet<>();
        permissions.add(permission);
        role.setPermissionsList(permissions);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(role);
        user.setRoleList(roles);
        repository.save(user);
        return new ResponseDto("Usuario guardado con éxito");
    }
}
