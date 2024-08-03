package com.taller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.taller.dto.request.LoginDto;
import com.taller.entity.PermissionEntity;
import com.taller.entity.RoleEntity;
import com.taller.entity.UserEntity;
import com.taller.entity.enums.RoleEnum;
import com.taller.services.security.JwtService;
import com.taller.utils.UserObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class LoginServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Test
    void loginServicesOktest() throws Exception {

        PermissionEntity permiso1 = UserObjectUtils.permission();
        PermissionEntity permiso2 = UserObjectUtils.permission2();
        PermissionEntity permiso3 = UserObjectUtils.permission3();
        PermissionEntity permiso4 = UserObjectUtils.permission4();
        Set<PermissionEntity> permisos = new HashSet<>();
        permisos.add(permiso1);
        permisos.add(permiso2);
        permisos.add(permiso3);
        permisos.add(permiso4);
        RoleEntity rol = new RoleEntity(1L, RoleEnum.ADMIN, permisos);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(rol);

        UserEntity usuario = new UserEntity();
        usuario.setUsername("prueba");
        usuario.setPassword(passwordEncoder.encode("12345"));
        usuario.setEnable(true);
        usuario.setAccountNonExpired(true);
        usuario.setAccountNonLocked(true);
        usuario.setCredentialsNonExpired(true);
        usuario.setRoleList(roles);

        LoginDto dto = new LoginDto();
        dto.setUsername("prueba");
        dto.setPassword("12345");

        ObjectMapper obMapper = new ObjectMapper();
        obMapper.registerModule(new JavaTimeModule());
        ObjectWriter mapper = obMapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = mapper.writeValueAsString(dto);

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("roles", usuario.getRoleList().stream()
                .map(r -> r.getRoleEnum().name()).toList());
        String token = jwtService.generate(usuario, extraClaims);

        MvcResult response = mockMvc.perform(post("/api/v1/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
                        .header("Authorization", "Bearer " + token))
                .andDo(print()) // imprime por consola el request y él response
                .andExpect(status().isOk())
                .andReturn();
    }
}
