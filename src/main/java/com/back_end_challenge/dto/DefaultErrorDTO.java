package com.back_end_challenge.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;
@Builder
public record DefaultErrorDTO(String type, HttpStatus status, String detail, String instance) {
}

