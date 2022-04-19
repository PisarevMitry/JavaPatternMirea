package com.example.task16.repository;

import com.example.task16.entity.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameAuthorRepository extends JpaRepository<GameAuthor, Long> {
}
