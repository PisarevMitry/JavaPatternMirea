package com.example.task16.service.base;

import com.example.task16.entity.Game;
import com.example.task16.service.CrudService;

import java.util.List;

public interface GameService extends CrudService<Game> {
    List<Game> getGameFullList();
}
