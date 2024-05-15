package com.app.xmartbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.xmartbe.service.CustomerService;

@RestController
@RequestMapping("/master-management")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<Object> getListCustomer() {
        return customerService.getListCustomer();
    }

    @GetMapping("/customer/{qrcode}")
    public ResponseEntity<Object> getDetailCustomer(@PathVariable("qrcode") String qrcode) {
        return customerService.getDetailCustomer(qrcode);
    }
}
