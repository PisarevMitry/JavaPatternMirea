package com.example.task15.repository;

import com.example.task15.entity.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameAuthorRepository extends JpaRepository<GameAuthor, Long> {
}
