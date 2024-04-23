package com.app.xmartbe.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "barang")
public class Barang {
    @Id
    @Column(nullable = false)
    private String rfid;

    @Column
    private String namaBarang;

    @Column
    private Integer hargaSatuan;
}
