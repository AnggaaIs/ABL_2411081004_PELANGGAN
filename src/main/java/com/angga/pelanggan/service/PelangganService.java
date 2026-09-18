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

  public Pelanggan savePelanggan(Pelanggan pelanggan) {
    return pelangganRepository.save(pelanggan);
  }

  public void deletePelanggan(Long id) {
    pelangganRepository.deleteById(id);
  }

  public Pelanggan updatePelanggan(Long id, Pelanggan pelanggan) {
    Pelanggan existingPelanggan = pelangganRepository.findById(id).orElse(null);
    if (existingPelanggan != null) {
      existingPelanggan.setNama(pelanggan.getNama());
      existingPelanggan.setAlamat(pelanggan.getAlamat());
      existingPelanggan.setJenis_kelamin(pelanggan.getJenis_kelamin());
      return pelangganRepository.save(existingPelanggan);
    }
    return null;
  }
}
