package com.pedidos.api.controllers;

import com.pedidos.api.dtos.ProdutoDto;
import com.pedidos.api.responses.Response;
import com.pedidos.api.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public ResponseEntity<Page<ProdutoDto>> findAll(Integer page, Integer size, Sort sort) {

        PageRequest pageable = new PageRequest(page, size, sort);

        Page<ProdutoDto> pageProdutosDto = service.findAll(pageable);

        return ResponseEntity.ok(pageProdutosDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDto> findOne(@PathVariable("id") Long id) {

        ProdutoDto produtoDto = service.findOne(id);

        return ResponseEntity.ok(produtoDto);
    }

    @PostMapping
    public ResponseEntity<Response<ProdutoDto>> save(@Valid @RequestBody ProdutoDto produtoDto,
                                                     BindingResult result) {

        Response<ProdutoDto> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(service.save(produtoDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
