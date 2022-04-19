package com.example.task14.Controllers;

import com.example.task14.Entity.Game;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {

    private final Map<Long, Game> gameList = new HashMap<>();

    private static Long ID = 0L;

    @GetMapping("/games/all")
    public String getAll() {
        return gameList.toString();
    }

    @GetMapping("/games")
    public String getById(@RequestParam Long id) {
        return gameList.get(id).toString();
    }

    @PostMapping("/games")
    public void save(@RequestParam String name, @RequestParam String creationDate) {
        gameList.put(ID++, new Game(ID++, name, creationDate));
    }

    @DeleteMapping("/games")
    public void delete(@RequestParam Long id) {
        gameList.remove(id);
    }
}
