package com.reactjs.reactjsspringproject.controller.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GenericResponse {
    private String message;
}
