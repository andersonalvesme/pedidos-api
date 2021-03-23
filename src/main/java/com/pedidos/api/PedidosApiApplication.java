package com.pedidos.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PedidosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedidosApiApplication.class, args);
    }

}
