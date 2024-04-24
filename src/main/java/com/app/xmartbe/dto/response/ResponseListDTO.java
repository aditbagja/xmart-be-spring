package com.app.xmartbe.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
