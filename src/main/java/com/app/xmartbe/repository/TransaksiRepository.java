package com.app.xmartbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.xmartbe.model.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, String> {

}
