package com.angga.pelanggan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.angga.pelanggan.entity.JenisKelamin;
import com.angga.pelanggan.entity.Pelanggan;
import com.angga.pelanggan.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

  @Autowired
  private PelangganService pelangganService;

  @GetMapping
  public List<Pelanggan> getAllPelanggan() {
    return pelangganService.getAllPelanggan();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pelanggan> getPelangganById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(pelangganService.getPelangganById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pelanggan> updatePelanggan(@PathVariable("id") Long id, @RequestBody Pelanggan pelanggan) {
    return ResponseEntity.ok(pelangganService.updatePelanggan(id, pelanggan));
  }

  private JenisKelamin toJenisKelamin(String value) {
    if (value == null) {
      return null;
    }
    try {
      return JenisKelamin.valueOf(value);
    } catch (IllegalArgumentException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "jenis_kelamin harus LAKI_LAKI atau PEREMPUAN");
    }
  }
}
