package com.app.xmartbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.xmartbe.model.Barang;
import com.app.xmartbe.model.Customer;
import com.app.xmartbe.service.CMSService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cms")
public class CMSController {
    @Autowired
    private CMSService cmsService;

    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer request) {
        return cmsService.createCustomer(request);
    }

    @PostMapping("/barang")
    public ResponseEntity<Object> createBarang(@RequestBody Barang request) {
        return cmsService.createBarang(request);
    }
}
