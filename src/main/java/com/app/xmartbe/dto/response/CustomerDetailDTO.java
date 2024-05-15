package com.app.xmartbe.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailDTO {
    private Object customer;
    private Object transaksi;
    private String message;
    private int statusCode;
    private String status;
}
