package com.example.task17.repository;

import com.example.task17.entity.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameAuthorRepository extends JpaRepository<GameAuthor, Long> {
}
