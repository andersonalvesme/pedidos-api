package com.pedidos.api.services;

import com.pedidos.api.dtos.ProdutoDto;
import com.pedidos.api.entities.Produto;
import com.pedidos.api.repositories.ProdutosRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class ProdutosService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutosRepository repository;

    public Page<ProdutoDto> findAll(PageRequest pageable) {

        Page<Produto> produtos = repository.findAll(pageable);
        Type listType = new TypeToken<Page<ProdutoDto>>() {}.getType();

        return modelMapper.map(produtos, listType);
    }

    public ProdutoDto findOne(Long id) {

        Produto produto = repository.findOne(id);

        return modelMapper.map(produto, ProdutoDto.class);
    }

    public ProdutoDto save(ProdutoDto produtoDto) {

        Produto produto = modelMapper.map(produtoDto, Produto.class);

        Produto produtoSaved = repository.save(produto);

        return modelMapper.map(produtoSaved, ProdutoDto.class);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
