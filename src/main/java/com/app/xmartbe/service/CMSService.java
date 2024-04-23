package com.app.xmartbe.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.xmartbe.model.Barang;
import com.app.xmartbe.model.Customer;
import com.app.xmartbe.repository.BarangRepository;
import com.app.xmartbe.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CMSService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BarangRepository barangRepository;

    private static final HttpStatus STATUS_OK = HttpStatus.OK;

    @Transactional
    public ResponseEntity<Object> createCustomer(Customer customer) {
        Customer newCustomer = Customer.builder()
                .qrcode(UUID.randomUUID().toString())
                .nama(customer.getNama())
                .wallet(customer.getWallet())
                .build();

        customerRepository.save(newCustomer);

        return new ResponseEntity<>(newCustomer, STATUS_OK);
    }

    @Transactional
    public ResponseEntity<Object> createBarang(Barang barang) {
        Barang newBarang = Barang.builder()
                .rfid(UUID.randomUUID().toString())
                .namaBarang(barang.getNamaBarang())
                .hargaSatuan(barang.getHargaSatuan())
                .build();

        barangRepository.save(newBarang);

        return new ResponseEntity<>(newBarang, STATUS_OK);
    }
}
