package com.app.xmartbe.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(nullable = false)
    private String qrcode;

    @Column
    private String nama;

    @Column
    private Integer wallet;
}
