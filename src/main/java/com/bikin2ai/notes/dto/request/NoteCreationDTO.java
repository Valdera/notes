package com.bikin2ai.notes.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class NoteCreationDTO {

    private UUID userId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
