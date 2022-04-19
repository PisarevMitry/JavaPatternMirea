package com.example.task19.repository;

import com.example.task19.entity.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameAuthorRepository extends JpaRepository<GameAuthor, Long> {
}
