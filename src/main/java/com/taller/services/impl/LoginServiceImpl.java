package com.taller.services.impl;

import com.taller.dto.request.LoginDto;
import com.taller.dto.response.JwtDto;
import com.taller.entity.UserEntity;
import com.taller.repository.UserRepository;
import com.taller.services.ILoginService;
import com.taller.services.security.JwtService;
import com.taller.services.security.UserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService{


    AuthenticationManager authenticationManager;

    UserRepository repository;

    JwtService jwtService;

    UserDetailsServiceImpl userDetailsService;

    public LoginServiceImpl(AuthenticationManager authenticationManager,
                            UserRepository repository, JwtService jwtService,
                            UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public JwtDto login(LoginDto loginDto) {

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword());
        authenticationManager.authenticate(auth);

        UserEntity userEntity = repository.findByUsername(loginDto.getUsername()).get();
        UserDetails user = this.userDetailsService.loadUserByUsername(loginDto.getUsername());
        String jwt = jwtService.generate(userEntity, generateExtraClaims(user));
        return new JwtDto(jwt);
    }

    private Map<String, Object> generateExtraClaims(UserDetails user) {
        Map<String, Object> extraClaims = new HashMap<>();
        System.out.println(user.getAuthorities());
        // Obtengo la lista de roles asignados al usuario
        extraClaims.put("roles", user.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).toList());
        return extraClaims;
    }
}
