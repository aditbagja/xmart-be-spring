package com.app.xmartbe.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListDTO {
    private int total;
    private Object data;
    private String message;
    private int statusCode;
    private String status;
}
