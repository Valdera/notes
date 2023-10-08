package com.bikin2ai.notes.mapper;

import com.bikin2ai.notes.dto.request.NoteCreationDTO;
import com.bikin2ai.notes.dto.request.NoteUpdationDTO;
import com.bikin2ai.notes.dto.response.NoteDTO;
import com.bikin2ai.notes.entity.Note;
import org.mapstruct.Mapper;

@Mapper
public interface NoteMapper {

    Note noteCreationDtoToNote(NoteCreationDTO dto);
    Note noteUpdationDtoToNote(NoteUpdationDTO dto);
    NoteDTO noteToNoteDto(Note entity);

}
