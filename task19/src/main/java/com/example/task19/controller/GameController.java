package com.example.task19.controller;

import com.example.task19.entity.Game;
import com.example.task19.service.impl.GameServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GameController {

    private final GameServiceImpl gameService;

    private static Long ID = 0L;

    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games/full")
    public List<Game> getFullGameList() {
        return gameService.getGameFullList();
    }

    @GetMapping("/games/all")
    public List<Game> getAll() {
        return gameService.findAll();
    }

    @GetMapping("/games/test")
    public String test() {
        return "success";
    }

    @GetMapping("/games")
    public Game getById(
            @RequestParam
                    Long id) {
        return gameService.findById(id);
    }

    @PostMapping("/games")
    public void save(
            @RequestParam
                    String name,
            @RequestParam
                    String creationDate) {
        gameService.save(new Game(ID++, name, creationDate, null));
    }

    @DeleteMapping("/games")
    public void delete(
            @RequestParam
                    Long id) {
        gameService.deleteById(id);
    }

    @GetMapping("/games/filter")
    public List<Game> userFilter(
            @RequestParam(defaultValue = "")
                    String field,
            @RequestParam(defaultValue = "")
                    String value) {
        List<Game> gameList;
        if (field.equals("") || value.equals("")) {
            gameList = gameService.findAll();
        } else {
            gameList = gameService.findFilter(field, value);
        }
        return gameList;
    }
}
