package com.bikin2ai.notes.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreationDTO {
    private String name;

    private String email;
}
