package com.app.xmartbe.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
