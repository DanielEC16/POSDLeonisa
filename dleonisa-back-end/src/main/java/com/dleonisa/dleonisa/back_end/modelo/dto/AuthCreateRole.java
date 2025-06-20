package com.dleonisa.dleonisa.back_end.modelo.dto;

import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public record AuthCreateRole(
        ) {
}
