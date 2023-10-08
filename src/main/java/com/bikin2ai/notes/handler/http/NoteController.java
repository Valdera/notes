package com.bikin2ai.notes.handler.http;

import com.bikin2ai.notes.dto.request.NoteCreationDTO;
import com.bikin2ai.notes.dto.response.NoteDTO;
import com.bikin2ai.notes.entity.Note;
import com.bikin2ai.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/api/v1/note/{id}")
    public NoteDTO getNoteByID(@PathVariable("id") UUID id) {
        Optional<NoteDTO> note = noteService.getNoteById(id);

        return note.get();
    }

    @PostMapping("/api/v1/note")
    public NoteDTO createNote(@Validated @RequestBody NoteCreationDTO body) {
        return noteService.createNote(body);
    }

    @PutMapping("/api/v1/note/{id}")
    public ResponseEntity<HttpStatus> updateNoteByID(@PathVariable("id") UUID id) {
        return null;
    }

    @DeleteMapping("/api/v1/note/{id}")
    public ResponseEntity<HttpStatus> deleteNoteByID(@PathVariable("id") UUID id) {
        return null;
    }

}
