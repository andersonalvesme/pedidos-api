package com.pedidos.api;

import com.pedidos.api.security.entities.User;
import com.pedidos.api.security.entities.UserRoleEnum;
import com.pedidos.api.security.repositories.UserRepository;
import com.pedidos.api.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PedidosApiApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(PedidosApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            User user = new User();
            user.setEmail("usuario@email.com");
            user.setRoles(UserRoleEnum.ROLE_USER);
            user.setPassword(PasswordUtils.generate("123456"));
            this.userRepository.save(user);

            User admin = new User();
            admin.setEmail("admin@email.com");
            admin.setRoles(UserRoleEnum.ROLE_ADMIN);
            admin.setPassword(PasswordUtils.generate("123456"));
            this.userRepository.save(admin);
        };
    }

}
