package com.taller.services.impl;

import com.taller.dto.request.UserAuthRequestDto;
import com.taller.dto.request.UserUpdateRequestDto;
import com.taller.dto.request.UserRequestDto;
import com.taller.dto.response.ResponseDto;
import com.taller.dto.response.ResponseUserDto;
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
import com.taller.utils.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
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
    public List<ResponseUserDto> findAllUsers() {
        List<UserEntity> listaUsers = repository.findAll();
        return UserMapper.listaUserDto(listaUsers);
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
        PermissionEntity permission = permissionRepository.findByPermission(PermissionEnum.READ)
                .orElseThrow(()-> new GenericException("Permission not found", HttpStatus.NOT_FOUND));
        Set<PermissionEntity> permissions = new HashSet<>();
        permissions.add(permission);
        role.setPermissionsList(permissions);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(role);
        user.setRoleList(roles);
        repository.save(user);
        return new ResponseDto("Usuario guardado con éxito");
    }

    @Override
    public ResponseDto updateUser(UserUpdateRequestDto userDto, Long id) {
        UserEntity user = repository.findById(id).orElseThrow(
                ()-> new GenericException("User not found", HttpStatus.NOT_FOUND)
        );
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        repository.save(user);
        return new ResponseDto("User modificado con éxito");
    }

    @Override
    public ResponseDto updateAuthorties(UserAuthRequestDto userDto, Long idUser) {
        UserEntity user = repository.findById(idUser).orElseThrow(
                ()-> new GenericException("User not found", HttpStatus.NOT_FOUND)
        );
        List<RoleEntity> roles = userDto.getRoles().stream()
                .map(r-> roleRepository
                        .findById(r)
                        .orElseThrow(()-> new GenericException("Role not found", HttpStatus.NOT_FOUND)))
                .toList();
        roles.forEach(r->{
            if(r.getRoleEnum().name().equals("ADMIN")){
                List<PermissionEntity> permisos = r.getPermissionsList().stream()
                        .map(p-> permissionRepository
                                .findById(p.getId())
                                .orElseThrow(()-> new GenericException("Permission not found", HttpStatus.NOT_FOUND)))
                        .toList();
                Set<PermissionEntity> lista = new HashSet<>(permisos);
                r.setPermissionsList(lista);
            }
        });
        Set<RoleEntity> listaRoles = new HashSet<>(roles);
        user.setRoleList(listaRoles);
        repository.save(user);
        return new ResponseDto("Autorizaciones modificadas con éxito");
    }

    @Override
    public ResponseDto deleteUser(Long id) {
        boolean existe = repository.existsById(id);
        if(existe){
            repository.deleteById(id);
        }else{
            throw new GenericException("User don't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseDto("User eliminado con éxito");
    }
}
