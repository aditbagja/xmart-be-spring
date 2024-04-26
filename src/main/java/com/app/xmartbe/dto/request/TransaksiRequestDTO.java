package com.app.xmartbe.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaksiRequestDTO {
    private String qrcode;
    private String rfid;
    private Integer jumlah;
}
