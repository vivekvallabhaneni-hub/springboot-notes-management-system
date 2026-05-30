package com.example.Noteproject.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    private int id;
    private String title;
    private String content;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
