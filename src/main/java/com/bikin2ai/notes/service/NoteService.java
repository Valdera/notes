package com.bikin2ai.notes.service;

import com.bikin2ai.notes.dto.request.NoteCreationDTO;
import com.bikin2ai.notes.dto.request.NoteUpdationDTO;
import com.bikin2ai.notes.dto.response.NoteDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteService {

    NoteDTO createNote(NoteCreationDTO body);
    Optional<NoteDTO> getNoteById(UUID id);
    List<NoteDTO> getNoteByUserId(UUID id);
    Optional<NoteDTO> updateNoteById(UUID id, NoteUpdationDTO body);
    Boolean deleteNoteById(UUID id);

}
