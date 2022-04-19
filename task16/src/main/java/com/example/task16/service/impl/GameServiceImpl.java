package com.example.task16.service.impl;

import com.example.task16.entity.Game;
import com.example.task16.entity.GameAuthor;
import com.example.task16.repository.GameAuthorRepository;
import com.example.task16.repository.GameRepository;
import com.example.task16.service.base.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    private final GameAuthorRepository gameAuthorRepository;

    private final ModelMapper modelMapper;

    public GameServiceImpl(GameRepository gameRepository,
                           GameAuthorRepository gameAuthorRepository) {
        this.gameRepository = gameRepository;
        this.gameAuthorRepository = gameAuthorRepository;
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

    @Override
    public List<Game> getGameFullList() {
        List<Game> result = gameRepository.findAll().stream().map(el -> {
            el.setGameAuthor(
                    modelMapper.map(gameAuthorRepository.findById(el.getId()),
                            GameAuthor.class));
            return modelMapper.map(el, Game.class);
        }).collect(Collectors.toList());
        return result;
    }
}
