package com.example.task19.service.base;

import com.example.task19.entity.GameAuthor;
import com.example.task19.service.CrudService;

import java.util.List;

public interface GameAuthorService extends CrudService<GameAuthor> {
    List<GameAuthor> findFilter(String field, String value);
}
