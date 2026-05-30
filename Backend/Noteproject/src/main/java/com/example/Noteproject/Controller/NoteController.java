package com.example.Noteproject.Controller;

import com.example.Noteproject.DTOS.NoteRequest;
import com.example.Noteproject.DTOS.NoteResponse;
import com.example.Noteproject.Sevice.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService service;

    @PostMapping("/save")
    public NoteResponse saveNote(@RequestBody NoteRequest req) {
        return service.saveNote(req);
    }

    @GetMapping("/All")
    public List<NoteResponse> getAllNotes() {
        return service.getAllNote();
    }

    @GetMapping("/{id}")
    public NoteResponse getNoteById(@PathVariable Integer id) {
        return service.getNoteById(id);
    }

    @PutMapping("/{id}")
    public NoteResponse updateNote(
            @PathVariable Integer id,
            @RequestBody NoteRequest req) {

        return service.updateNote(id, req);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Integer id) {
        return service.deleteNote(id);
    }
    @GetMapping("/search")
    public List<NoteResponse> searchNotes(
            @RequestParam String keyword) {

        return service.searchNote(keyword);
    }
}