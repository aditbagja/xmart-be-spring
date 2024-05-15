package com.app.xmartbe.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.xmartbe.dto.request.TransaksiRequestDTO;
import com.app.xmartbe.dto.response.ResponseListDTO;
import com.app.xmartbe.exception.classes.DataNotFoundException;
import com.app.xmartbe.model.*;
import com.app.xmartbe.repository.*;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransaksiService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private TransaksiRepository transaksiRepository;

    private static final HttpStatus STATUS_OK = HttpStatus.OK;

    @Transactional
    public ResponseEntity<Object> createTransaksi(TransaksiRequestDTO request) {
        Customer customer = customerRepository.findById(request.getQrcode())
                .orElseThrow(() -> new DataNotFoundException("Customer tidak tersedia"));
        Barang barang = barangRepository.findById(request.getRfid())
                .orElseThrow(() -> new DataNotFoundException("Barang tidak tersedia"));

        Transaksi newTransaksi = Transaksi.builder()
                .transaksiId(request.getTransaksiId())
                .customer(customer)
                .barang(barang)
                .hargaSatuan(barang.getHargaSatuan())
                .jumlah(request.getJumlah())
                .waktuTransaksi(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        transaksiRepository.save(newTransaksi);

        String message = "Berhasil menambahkan Transaksi";

        log.info(message);

        return new ResponseEntity<>(newTransaksi, STATUS_OK);
    }

    public ResponseEntity<Object> getListTransaksi(String qrcode) {
        List<Transaksi> transaksis = transaksiRepository.findAllByCustomer_Qrcode(qrcode);

        String message = "Berhasil memuat Data Transaksi";

        ResponseListDTO response = ResponseListDTO.builder()
                .total(transaksis.size())
                .data(transaksis)
                .message(message)
                .statusCode(STATUS_OK.value())
                .status(STATUS_OK.getReasonPhrase())
                .build();

        log.info(message);

        return new ResponseEntity<>(response, STATUS_OK);
    }
}
