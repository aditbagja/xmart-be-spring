package com.app.xmartbe.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDTO {
    private String message;
    private int statusCode;
    private String status;
}
