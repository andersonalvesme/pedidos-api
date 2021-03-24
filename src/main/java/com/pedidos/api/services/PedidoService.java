package com.pedidos.api.services;

import com.pedidos.api.dtos.PedidoDto;
import com.pedidos.api.entities.Pedido;
import com.pedidos.api.repositories.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PedidoRepository repository;

    public Page<PedidoDto> findAll(PageRequest pageable) {

        Page<Pedido> pedidos = repository.findAll(pageable);
        Type listType = new TypeToken<Page<PedidoDto>>() {}.getType();

        return modelMapper.map(pedidos, listType);
    }

    public PedidoDto findOne(Long id) {

        Optional<Pedido> pedido = repository.findById(id);

        return modelMapper.map(pedido, PedidoDto.class);
    }

    public PedidoDto save(PedidoDto pedidoDto) {

        Pedido pedido = modelMapper.map(pedidoDto, Pedido.class);

        Pedido pedidoSaved = repository.save(pedido);

        return modelMapper.map(pedidoSaved, PedidoDto.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
