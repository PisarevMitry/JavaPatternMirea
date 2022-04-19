package com.example.task14.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameAuthor {
    private Long id;
    private String nickname;
    private String birthDate;


}
