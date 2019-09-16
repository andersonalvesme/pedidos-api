package com.pedidos.api.services;

import com.pedidos.api.dtos.ClienteDto;
import com.pedidos.api.entities.Cliente;
import com.pedidos.api.repositories.ClientesRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class ClientesService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientesRepository repository;

    public Page<ClienteDto> findAll(PageRequest pageable) {

        Page<Cliente> clientes = repository.findAll(pageable);
        Type listType = new TypeToken<Page<ClienteDto>>() {}.getType();

        return modelMapper.map(clientes, listType);
    }

    public ClienteDto findOne(Long id) {

        Cliente cliente = repository.findOne(id);

        return modelMapper.map(cliente, ClienteDto.class);
    }

    public ClienteDto save(ClienteDto clienteDto) {

        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);

        Cliente clienteSaved = repository.save(cliente);

        return modelMapper.map(clienteSaved, ClienteDto.class);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
