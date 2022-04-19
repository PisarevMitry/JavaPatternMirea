package com.example.task18.service.base;

import com.example.task18.entity.Game;
import com.example.task18.service.CrudService;

import java.util.List;

public interface GameService extends CrudService<Game> {
    List<Game> getGameFullList();

    List<Game> findFilter(String field, String value);
}
