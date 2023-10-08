package com.bikin2ai.notes.dto.response;


import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserDTO {
    private UUID id;

    private String name;

    private String email;

    private List<NoteDTO> notes;
}
