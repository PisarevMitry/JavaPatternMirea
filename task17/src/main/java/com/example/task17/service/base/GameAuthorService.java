package com.example.task17.service.base;

import com.example.task17.entity.GameAuthor;
import com.example.task17.service.CrudService;

import java.util.List;

public interface GameAuthorService extends CrudService<GameAuthor> {
    List<GameAuthor> findFilter(String field, String value);
}
