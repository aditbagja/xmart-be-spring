package com.app.xmartbe.model;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaksi")
public class Transaksi {
    @Id
    private String transaksiId;

    @ManyToOne
    @JoinColumn(name = "qrcode")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "rfid")
    private Barang barang;

    @Column
    private Integer hargaSatuan;

    @Column
    private Integer jumlah;

    @Column
    private Timestamp waktuTransaksi;
}
