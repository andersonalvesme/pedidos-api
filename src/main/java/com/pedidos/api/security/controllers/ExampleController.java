package com.pedidos.api.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/examplo")
public class ExampleController {

    @GetMapping(value = "/{name}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String exemplo(@PathVariable("nome") String nome) {
        return "Olá" + nome;
    }

}
