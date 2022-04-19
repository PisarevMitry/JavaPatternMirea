package com.example.task15.service.impl;

import com.example.task15.entity.Game;
import com.example.task15.repository.GameRepository;
import com.example.task15.service.base.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    private final ModelMapper modelMapper;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Game findById(Long id) {
        return modelMapper.map(gameRepository.findById(id), Game.class);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void save(Game entity) {
        gameRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }
}
