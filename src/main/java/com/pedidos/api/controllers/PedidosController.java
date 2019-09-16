package com.pedidos.api.controllers;

import com.pedidos.api.dtos.PedidoDto;
import com.pedidos.api.responses.Response;
import com.pedidos.api.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService service;

    @GetMapping
    public ResponseEntity<Page<PedidoDto>> findAll(Integer page, Integer size, Sort sort) {

        PageRequest pageable = new PageRequest(page, size, sort);

        Page<PedidoDto> pagePedidos = service.findAll(pageable);

        return ResponseEntity.ok(pagePedidos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> findOne(@PathVariable("id") Long id) {

        PedidoDto pedidoDto = service.findOne(id);

        return ResponseEntity.ok(pedidoDto);
    }

    @PostMapping
    public ResponseEntity<Response<PedidoDto>> save(@Valid @RequestBody PedidoDto pedidoDto,
                                                    BindingResult result) {

        Response<PedidoDto> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(service.save(pedidoDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
