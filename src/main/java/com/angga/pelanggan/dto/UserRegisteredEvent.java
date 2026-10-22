package com.angga.pelanggan.dto;

public class UserRegisteredEvent {
  private Long userId;
  private String username;
  private String email;
  private String nama;
  private String alamat;
  private String jenisKelamin;

  public UserRegisteredEvent() {
  }

  public UserRegisteredEvent(Long userId, String username, String email, String nama, String alamat,
      String jenisKelamin) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.nama = nama;
    this.alamat = alamat;
    this.jenisKelamin = jenisKelamin;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getJenisKelamin() {
    return jenisKelamin;
  }

  public void setJenisKelamin(String jenisKelamin) {
    this.jenisKelamin = jenisKelamin;
  }
}
