package com.example.task14.Controllers;

import com.example.task14.Entity.GameAuthor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameAuthorController {

    private final Map<Long, GameAuthor> gameAuthorList = new HashMap<>();

    private static Long ID = 0L;

    @GetMapping("/game-authors/all")
    public String getAll() {
        return gameAuthorList.toString();
    }

    @GetMapping("/game-authors")
    public String getById(@RequestParam Long id) {
        return gameAuthorList.get(id).toString();
    }

    @PostMapping("/game-authors")
    public void save(@RequestParam String nickname, @RequestParam String birthDate) {
        gameAuthorList.put(ID++, new GameAuthor(ID++, nickname, birthDate));
    }

    @DeleteMapping("/game-authors")
    public void delete(@RequestParam Long id) {
        gameAuthorList.remove(id);
    }
}