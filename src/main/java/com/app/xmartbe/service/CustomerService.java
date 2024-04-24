package com.app.xmartbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.xmartbe.dto.response.CustomerDetailDTO;
import com.app.xmartbe.dto.response.ResponseListDTO;
import com.app.xmartbe.exception.classes.DataNotFoundException;
import com.app.xmartbe.model.Customer;
import com.app.xmartbe.model.Transaksi;
import com.app.xmartbe.repository.CustomerRepository;
import com.app.xmartbe.repository.TransaksiRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransaksiRepository transaksiRepository;

    private static final HttpStatus STATUS_OK = HttpStatus.OK;
    private static final String CUSTOMER_NOT_FOUND = "Data Customer tidak ditemukan";
    private static final String CUSTOMER_SUCCESS = "Berhasil memuat Data Customer";

    public ResponseEntity<Object> getListCustomer() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            throw new DataNotFoundException(CUSTOMER_NOT_FOUND);
        }

        ResponseListDTO response = ResponseListDTO.builder()
                .total(customers.size())
                .data(customers)
                .message(CUSTOMER_SUCCESS)
                .statusCode(STATUS_OK.value())
                .status(STATUS_OK.getReasonPhrase())
                .build();

        log.info(CUSTOMER_SUCCESS);

        return new ResponseEntity<>(response, STATUS_OK);
    }

    public ResponseEntity<Object> getDetailCustomer(String qrcode) {
        Customer customer = customerRepository.findById(qrcode)
                .orElseThrow(() -> new DataNotFoundException(CUSTOMER_NOT_FOUND));
        List<Transaksi> transaksiList = transaksiRepository.findAllByCustomer_Qrcode(qrcode);

        CustomerDetailDTO response = CustomerDetailDTO.builder()
                .customer(customer)
                .transaksi(transaksiList)
                .message(CUSTOMER_SUCCESS)
                .statusCode(STATUS_OK.value())
                .status(STATUS_OK.getReasonPhrase())
                .build();

        log.info(CUSTOMER_SUCCESS);

        return new ResponseEntity<>(response, STATUS_OK);
    }
}
