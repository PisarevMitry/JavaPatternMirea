package com.example.task18.service.base;

import com.example.task18.entity.GameAuthor;
import com.example.task18.service.CrudService;

import java.util.List;

public interface GameAuthorService extends CrudService<GameAuthor> {
    List<GameAuthor> findFilter(String field, String value);
}
