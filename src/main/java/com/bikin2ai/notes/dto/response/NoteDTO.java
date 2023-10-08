package com.bikin2ai.notes.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class NoteDTO {

    @NotNull
    private UUID id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
