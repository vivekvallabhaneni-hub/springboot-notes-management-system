package com.example.Noteproject.Repository;

import com.example.Noteproject.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {
    List<Note> findByTitleContainingOrContentContaining(String title, String content);
}
