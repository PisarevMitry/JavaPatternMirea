package com.example.task18.repository;

import com.example.task18.entity.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameAuthorRepository extends JpaRepository<GameAuthor, Long> {
}
