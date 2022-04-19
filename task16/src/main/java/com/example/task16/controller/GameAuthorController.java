package com.example.task16.controller;

import com.example.task16.entity.GameAuthor;
import com.example.task16.service.impl.GameAuthorServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GameAuthorController {

    private final GameAuthorServiceImpl gameAuthorService;

    private static Long ID = 0L;

    public GameAuthorController(GameAuthorServiceImpl gameAuthorService) {
        this.gameAuthorService = gameAuthorService;
    }

    @GetMapping("/game-authors/all")
    public List<GameAuthor> getAll() {
        return gameAuthorService.findAll();
    }

    @GetMapping("/game-authors")
    public GameAuthor getById(@RequestParam Long id) {
        return gameAuthorService.findById(id);
    }

    @PostMapping("/game-authors")
    public void save(@RequestParam String nickname, @RequestParam String birthDate) {
        gameAuthorService.save(new GameAuthor(ID++, nickname, birthDate));
    }

    @DeleteMapping("/game-authors")
    public void delete(@RequestParam Long id) {
        gameAuthorService.deleteById(id);
    }
}