package com.taller;

import com.taller.entity.*;
import com.taller.entity.enums.PermissionEnum;
import com.taller.entity.enums.RoleEnum;
import com.taller.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TallerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerSpringApplication.class, args);
	}

	/*@Autowired
	UserEntityRepository repository;

	@Bean
	CommandLineRunner init(){ // Comando que se ejecuta al iniciar el programa
		return args -> {
			/* PERMISSIONS
			PermissionEntity permission1 = PermissionEntity.builder()
					.permission(PermissionEnum.READ).build();
			PermissionEntity permission2 = PermissionEntity.builder()
					.permission(PermissionEnum.CREATED).build();
			PermissionEntity permission3 = PermissionEntity.builder()
					.permission(PermissionEnum.UPDATE).build();
			PermissionEntity permission4 = PermissionEntity.builder()
					.permission(PermissionEnum.DELETE).build();
			/* ROLE
			RoleEntity rol1 = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionsList(Set.of(permission1, permission2, permission3,permission4))
					.build();
			RoleEntity rol2 = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionsList(Set.of(permission1))
					.build();
			/* USER
			UserEntity user1 = UserEntity.builder()
					.username("prueba")
					.password("12345")
					.isEnable(true)
					.isAccountNonExpired(true)
					.isAccountNonLocked(true)
					.isCredentialsNonExpired(true)
					.roleList(Set.of(rol1))
					.build();

			UserEntity user2 = UserEntity.builder()
					.username("usuario")
					.password("123")
					.isEnable(true)
					.isAccountNonExpired(true)
					.isAccountNonLocked(true)
					.isCredentialsNonExpired(true)
					.roleList(Set.of(rol2))
					.build();
			repository.saveAll(List.of(user1,user2));
		};
	}*/
}
