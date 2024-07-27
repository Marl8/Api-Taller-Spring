package com.taller.services.security;

import com.taller.entity.UserEntity;
import com.taller.errors.GenericException;
import com.taller.repository.UserEntityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserEntityRepository repository;

    public UserDetailsServiceImpl(UserEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findUserEntityByUsername(username).orElseThrow(
                () -> new GenericException("User " + username + " not found", HttpStatus.NOT_FOUND)
        );

        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        userEntity.getRoleList().forEach(role -> authList.add(
                new SimpleGrantedAuthority("ROLE_" + role.getRoleEnum().name())));
        userEntity.getRoleList().stream()
                .flatMap(role-> role.getPermissionsList().stream())
                .forEach(p -> authList.add(new SimpleGrantedAuthority(
                        p.getPermission().name()
                )));
        System.out.println(authList);
        System.out.println(userEntity);
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnable(), userEntity.isAccountNonExpired(),
                        userEntity.isCredentialsNonExpired(), userEntity.isAccountNonLocked(), authList);
    }
}
