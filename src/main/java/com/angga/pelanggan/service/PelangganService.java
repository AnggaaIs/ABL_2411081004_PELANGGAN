package com.angga.pelanggan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angga.pelanggan.entity.Pelanggan;
import com.angga.pelanggan.repository.PelangganRepository;

@Service
public class PelangganService {
  @Autowired
  private PelangganRepository pelangganRepository;

  public Pelanggan getPelangganById(Long id) {
    return pelangganRepository.findById(id).orElse(null);
  }

  public List<Pelanggan> getAllPelanggan() {
    return pelangganRepository.findAll();
  }

  public Pelanggan updatePelanggan(Long id, Pelanggan pelanggan) {
    Pelanggan existing = pelangganRepository.findById(id).orElse(null);
    if (existing == null) {
      return null;
    }

    existing.setNama(pelanggan.getNama());
    existing.setAlamat(pelanggan.getAlamat());
    existing.setJenis_kelamin(pelanggan.getJenis_kelamin());

    return pelangganRepository.save(existing);
  }
}
