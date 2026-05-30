package com.example.Noteproject.Sevice;

import com.example.Noteproject.DTOS.NoteRequest;
import com.example.Noteproject.DTOS.NoteResponse;
import com.example.Noteproject.Entity.Category;
import com.example.Noteproject.Entity.Note;
import com.example.Noteproject.Repository.CategoryRepo;
import com.example.Noteproject.Repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepo repo;
    private final CategoryRepo catrepo;

    public NoteResponse saveNote(NoteRequest req) {

        Category category = catrepo.findById(req.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Note note = new Note();
        note.setTitle(req.getTitle());
        note.setContent(req.getContent());
        note.setCategory(category);

        Note savedNote = repo.save(note);

        return mapToResponse(savedNote);
    }

    public List<NoteResponse> getAllNote() {

        return repo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public NoteResponse getNoteById(Integer id) {

        Note note = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        return mapToResponse(note);
    }

    public NoteResponse updateNote(Integer id, NoteRequest req) {

        Note note = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        Category category = catrepo.findById(req.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        note.setTitle(req.getTitle());
        note.setContent(req.getContent());
        note.setCategory(category);

        Note updatedNote = repo.save(note);

        return mapToResponse(updatedNote);
    }

    public String deleteNote(Integer id) {

        Note note = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        repo.delete(note);

        return "Successfully Deleted";
    }

    private NoteResponse mapToResponse(Note note) {

        NoteResponse res = new NoteResponse();

        res.setId(note.getId());
        res.setTitle(note.getTitle());
        res.setContent(note.getContent());

        if (note.getCategory() != null) {
            res.setCategoryName(note.getCategory().getName());
        }

        res.setCreatedAt(note.getCreatedAt());
        res.setUpdatedAt(note.getUpdatedAt());

        return res;
    }
    public List<NoteResponse> searchNote(String keyword){
        return repo.findByTitleContainingOrContentContaining(keyword,keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();

    }
}