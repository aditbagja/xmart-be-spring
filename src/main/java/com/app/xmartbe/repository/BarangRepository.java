package com.app.xmartbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.xmartbe.model.Barang;

@Repository
public interface BarangRepository extends JpaRepository<Barang, String> {

}
