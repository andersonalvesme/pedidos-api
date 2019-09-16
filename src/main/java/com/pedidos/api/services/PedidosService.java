package com.pedidos.api.services;

import com.pedidos.api.dtos.PedidoDto;
import com.pedidos.api.entities.Pedido;
import com.pedidos.api.repositories.PedidosRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class PedidosService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PedidosRepository repository;

    public Page<PedidoDto> findAll(PageRequest pageable) {

        Page<Pedido> pedidos = repository.findAll(pageable);
        Type listType = new TypeToken<Page<PedidoDto>>() {}.getType();

        return modelMapper.map(pedidos, listType);
    }

    public PedidoDto findOne(Long id) {

        Pedido pedido = repository.findOne(id);

        return modelMapper.map(pedido, PedidoDto.class);
    }

    public PedidoDto save(PedidoDto pedidoDto) {

        Pedido pedido = modelMapper.map(pedidoDto, Pedido.class);

        Pedido pedidoSaved = repository.save(pedido);

        return modelMapper.map(pedidoSaved, PedidoDto.class);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
