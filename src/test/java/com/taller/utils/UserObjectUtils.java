package com.taller.utils;

import com.taller.dto.request.UserAuthRequestDto;
import com.taller.dto.request.UserUpdateRequestDto;
import com.taller.dto.request.UserRequestDto;
import com.taller.dto.response.ResponseUserDto;
import com.taller.entity.PermissionEntity;
import com.taller.entity.RoleEntity;
import com.taller.entity.UserEntity;
import com.taller.entity.enums.PermissionEnum;
import com.taller.entity.enums.RoleEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserObjectUtils {

    public static UserEntity user1(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("prueba");
        user.setPassword("123");
        return user;
    }

    public static UserEntity user2(){
        UserEntity user = new UserEntity();
        user.setId(2L);
        user.setUsername("usuario");
        user.setPassword("456");
        return user;
    }

    public static UserEntity user3(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("prueba");
        user.setPassword("12356789");
        return user;
    }

    public static ResponseUserDto userDto1(){
        ResponseUserDto user = new ResponseUserDto();
        user.setId(1L);
        user.setUsername("prueba");
        return user;
    }

    public static ResponseUserDto userDto2(){
        ResponseUserDto user = new ResponseUserDto();
        user.setId(2L);
        user.setUsername("usuario");
        return user;
    }

    public static UserRequestDto userReqDto(){
        UserRequestDto user = new UserRequestDto();
        user.setUsername("prueba");
        user.setPassword("123");
        return user;
    }

    public static UserUpdateRequestDto userUpdateReqDto(){
        UserUpdateRequestDto  user = new UserUpdateRequestDto ();
        user.setPassword("12356789");
        return user;
    }

    public static List<UserEntity> listaUsers(){
        return List.of(user1(),user2());
    }

    public static List<ResponseUserDto> listaUsersDto(){
        return List.of(userDto1(),userDto2());
    }

    public static RoleEntity role1(){
        RoleEntity role = new RoleEntity();
        role.setId(1L);
        role.setRoleEnum(RoleEnum.USER);
        Set<PermissionEntity> permisos = new HashSet<>();
        permisos.add(permission());
        role.setPermissionsList(permisos);
        return role;
    }

    public static RoleEntity role2(){
        RoleEntity role = new RoleEntity();
        role.setId(2L);
        role.setRoleEnum(RoleEnum.ADMIN);
        Set<PermissionEntity> permisos = new HashSet<>();
        permisos.add(permission());
        permisos.add(permission2());
        permisos.add(permission3());
        permisos.add(permission4());
        role.setPermissionsList(permisos);
        return role;
    }

    public static PermissionEntity permission(){
        PermissionEntity permission = new PermissionEntity();
        permission.setId(1L);
        permission.setPermission(PermissionEnum.READ);
        return permission;
    }

    public static PermissionEntity permission2(){
        PermissionEntity permission = new PermissionEntity();
        permission.setId(2L);
        permission.setPermission(PermissionEnum.CREATED);
        return permission;
    }

    public static PermissionEntity permission3(){
        PermissionEntity permission = new PermissionEntity();
        permission.setId(3L);
        permission.setPermission(PermissionEnum.UPDATE);
        return permission;
    }

    public static PermissionEntity permission4(){
        PermissionEntity permission = new PermissionEntity();
        permission.setId(4L);
        permission.setPermission(PermissionEnum.DELETE);
        return permission;
    }

    public static List<RoleEntity> listaRoles(){
        return List.of(role1(),role2());
    }

    public static List<PermissionEntity> listaPermisos(){
        return List.of(permission(),permission2(),permission3(),permission4());
    }

    public static UserAuthRequestDto authRequestDto(){
        UserAuthRequestDto req = new UserAuthRequestDto();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        req.setRoles(list);
        return req;
    }

    public static UserEntity userAuth(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("prueba");
        user.setPassword("123");
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(role1());
        roles.add(role2());
        user.setRoleList(roles);
        return user;
    }
}
