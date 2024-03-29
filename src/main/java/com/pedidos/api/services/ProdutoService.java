package com.pedidos.api.services;

import com.pedidos.api.dtos.ProdutoDto;
import com.pedidos.api.entities.Produto;
import com.pedidos.api.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository repository;

    public Page<ProdutoDto> findAll(PageRequest pageable) {

        Page<Produto> produtos = repository.findAll(pageable);
        Type listType = new TypeToken<Page<ProdutoDto>>() {}.getType();

        return modelMapper.map(produtos, listType);
    }

    public ProdutoDto findOne(Long id) {

        Optional<Produto> produto = repository.findById(id);

        return modelMapper.map(produto, ProdutoDto.class);
    }

    public ProdutoDto save(ProdutoDto produtoDto) {

        Produto produto = modelMapper.map(produtoDto, Produto.class);

        Produto produtoSaved = repository.save(produto);

        return modelMapper.map(produtoSaved, ProdutoDto.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
