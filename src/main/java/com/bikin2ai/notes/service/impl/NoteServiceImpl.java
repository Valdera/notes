package com.bikin2ai.notes.service.impl;

import com.bikin2ai.notes.dto.request.NoteCreationDTO;
import com.bikin2ai.notes.dto.request.NoteUpdationDTO;
import com.bikin2ai.notes.dto.response.NoteDTO;
import com.bikin2ai.notes.entity.Note;
import com.bikin2ai.notes.mapper.NoteMapper;
import com.bikin2ai.notes.repository.NoteRepository;
import com.bikin2ai.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public NoteDTO createNote(NoteCreationDTO body) {
        return noteMapper.noteToNoteDto(
                noteRepository.save(
                        noteMapper.noteCreationDtoToNote(body)
                )
        );
    }

    @Override
    public Optional<NoteDTO> getNoteById(UUID id) {
        return Optional.ofNullable(
                noteMapper.noteToNoteDto(
                        noteRepository.findById(id).orElse(null)
                )
        );
    }

    @Override
    public List<NoteDTO> getNoteByUserId(UUID id) {
        return null;
    }

    @Override
    public Optional<NoteDTO> updateNoteById(UUID id, NoteUpdationDTO body) {
        AtomicReference<Optional<NoteDTO>> atomicReference = new AtomicReference<>();

        noteRepository.findById(id).ifPresentOrElse(
                note -> {
                    note.setTitle(body.getTitle());
                    note.setContent(body.getContent());
//                    note.setCreatedBy(body.getUserId());
                    atomicReference.set(Optional.of(
                            noteMapper.noteToNoteDto(
                                    noteRepository.save(note)
                            )
                    ));
                },
                () -> {
                    atomicReference.set(Optional.empty());
                }
        );

        return atomicReference.get();
    }

    @Override
    public Boolean deleteNoteById(UUID id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
