package com.app.xmartbe.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaksiRequestDTO {
    private String transaksiId;
    private String qrcode;
    private String rfid;
    private Integer jumlah;
}
