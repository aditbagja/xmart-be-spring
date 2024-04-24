package com.app.xmartbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.xmartbe.dto.response.ResponseListDTO;
import com.app.xmartbe.exception.classes.DataNotFoundException;
import com.app.xmartbe.model.Barang;
import com.app.xmartbe.repository.BarangRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BarangService {
    @Autowired
    private BarangRepository barangRepository;

    private static final HttpStatus STATUS_OK = HttpStatus.OK;
    private static final String BARANG_NOT_FOUND = "Data Barang tidak ditemukan";
    private static final String BARANG_SUCCESS = "Berhasil memuat Data Barang";

    public ResponseEntity<Object> getAllBarang() {
        List<Barang> barangs = barangRepository.findAll();

        if (barangs.isEmpty()) {
            throw new DataNotFoundException(BARANG_NOT_FOUND);
        }

        ResponseListDTO response = ResponseListDTO.builder()
                .total(barangs.size())
                .data(barangs)
                .message(BARANG_SUCCESS)
                .statusCode(STATUS_OK.value())
                .status(STATUS_OK.getReasonPhrase())
                .build();

        log.info(BARANG_SUCCESS);

        return new ResponseEntity<>(response, STATUS_OK);
    }

    public ResponseEntity<Object> getDetailBarang(String rfid) {
        Barang barang = barangRepository.findById(rfid).orElseThrow(() -> new DataNotFoundException(BARANG_NOT_FOUND));

        ResponseListDTO response = ResponseListDTO.builder()
                .total(1)
                .data(barang)
                .message(BARANG_SUCCESS)
                .statusCode(STATUS_OK.value())
                .status(STATUS_OK.getReasonPhrase())
                .build();

        log.info(BARANG_SUCCESS);

        return new ResponseEntity<>(response, STATUS_OK);
    }
}
