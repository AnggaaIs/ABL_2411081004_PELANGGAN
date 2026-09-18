package com.angga.pelanggan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelanggan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nama;
  private String alamat;

  @Enumerated(EnumType.STRING)
  private JenisKelamin jenis_kelamin;

  public Pelanggan() {
  }

  public Pelanggan(Long id, String nama, String alamat, JenisKelamin jenis_kelamin) {
    this.id = id;
    this.nama = nama;
    this.alamat = alamat;
    this.jenis_kelamin = jenis_kelamin;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public JenisKelamin getJenis_kelamin() {
    return jenis_kelamin;
  }

  public void setJenis_kelamin(JenisKelamin jenis_kelamin) {
    this.jenis_kelamin = jenis_kelamin;
  }
}
