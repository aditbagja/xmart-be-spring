package com.app.xmartbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.xmartbe.service.BarangService;

@RestController
@RequestMapping("/master-management")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("/barang")
    public ResponseEntity<Object> getAllBarang() {
        return barangService.getAllBarang();
    }

    @GetMapping("/barang/{rfid}")
    public ResponseEntity<Object> getDetailBarang(@PathVariable("rfid") String rfid) {
        return barangService.getDetailBarang(rfid);
    }
}
