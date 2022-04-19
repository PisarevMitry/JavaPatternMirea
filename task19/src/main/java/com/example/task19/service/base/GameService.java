package com.example.task19.service.base;

import com.example.task19.entity.Game;
import com.example.task19.service.CrudService;

import java.util.List;

public interface GameService extends CrudService<Game> {
    List<Game> getGameFullList();

    List<Game> findFilter(String field, String value);
}
