package com.pedidos.api.controllers;

import com.pedidos.api.dtos.ClienteDto;
import com.pedidos.api.responses.Response;
import com.pedidos.api.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//TODO
// Adicionar tratamento para error; (try/catch)
// Adicionar rota para listagem dos pedidos do cliente;
// Adicionar paginação padrão caso o usuário não informe nos parametros;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClientesService service;

    @GetMapping
    public ResponseEntity<Page<ClienteDto>> findAll(Integer page, Integer size, Sort sort) {

        PageRequest pageable = new PageRequest(page, size, sort);

        Page<ClienteDto> pageClientesDto = service.findAll(pageable);

        return ResponseEntity.ok(pageClientesDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> findOne(@PathVariable("id") Long id) {

        ClienteDto clienteDto = service.findOne(id);

        return ResponseEntity.ok(clienteDto);
    }

    @PostMapping
    public ResponseEntity<Response<ClienteDto>> save(@Valid @RequestBody ClienteDto clienteDto,
                                                     BindingResult result) {

        Response<ClienteDto> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(service.save(clienteDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
