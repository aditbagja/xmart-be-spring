package com.app.xmartbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.xmartbe.dto.request.TransaksiRequestDTO;
import com.app.xmartbe.service.TransaksiService;

@RestController
@RequestMapping("/transaksi-management")
public class TransaksiController {
    @Autowired
    private TransaksiService transaksiService;

    @PostMapping("/transaksi")
    public ResponseEntity<Object> createTransaksi(@RequestBody TransaksiRequestDTO request) {
        return transaksiService.createTransaksi(request);
    }

    @GetMapping("/customer-transaksi")
    public ResponseEntity<Object> getListTransaksi(@RequestParam String qrcode) {
        return transaksiService.getListTransaksi(qrcode);
    }
}
