package com.example.task15.service.impl;

import com.example.task15.entity.GameAuthor;
import com.example.task15.repository.GameAuthorRepository;
import com.example.task15.service.base.GameAuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameAuthorServiceImpl implements GameAuthorService {

    private final GameAuthorRepository gameAuthorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameAuthorServiceImpl(GameAuthorRepository gameAuthorRepository) {
        this.gameAuthorRepository = gameAuthorRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public GameAuthor findById(Long id) {
        return modelMapper.map(gameAuthorRepository.findById(id), GameAuthor.class);
    }

    @Override
    public List<GameAuthor> findAll() {
        return gameAuthorRepository.findAll();
    }

    @Override
    public void save(GameAuthor entity) {
        gameAuthorRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        gameAuthorRepository.deleteById(id);
    }
}
