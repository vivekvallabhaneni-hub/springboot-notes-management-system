package com.example.Noteproject.DTOS;

import com.example.Noteproject.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequest {
     private String title;
     private  String content;
     private int categoryId;

}
