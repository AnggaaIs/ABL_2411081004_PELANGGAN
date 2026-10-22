package com.angga.pelanggan.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angga.pelanggan.config.RabbitMQConfig;
import com.angga.pelanggan.dto.UserRegisteredEvent;
import com.angga.pelanggan.entity.JenisKelamin;
import com.angga.pelanggan.entity.Pelanggan;
import com.angga.pelanggan.repository.PelangganRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class UserRegisteredConsumer {

  @Autowired
  private PelangganRepository pelangganRepository;

  private final ObjectMapper objectMapper = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

  @RabbitListener(queues = RabbitMQConfig.USER_REGISTERED_QUEUE)
  public void receive(String payload) {
    try {
      UserRegisteredEvent event = objectMapper.readValue(payload, UserRegisteredEvent.class);

      if (pelangganRepository.findByEmail(event.getEmail()).isPresent()) {
        System.out.println("Sudah ada: " + event.getEmail());
        return;
      }

      Pelanggan pelanggan = new Pelanggan();
      pelanggan.setNama(event.getNama());
      pelanggan.setAlamat(event.getAlamat());
      pelanggan.setEmail(event.getEmail());
      pelanggan.setJenis_kelamin(toJenisKelamin(event.getJenisKelamin()));

      pelangganRepository.save(pelanggan);
      System.out.println("Pelanggan dibuat: " + pelanggan.getNama());
    } catch (Exception e) {
      System.err.println("Gagal: " + e.getMessage());
    }
  }

  private JenisKelamin toJenisKelamin(String value) {
    if (value == null) {
      return null;
    }
    try {
      return JenisKelamin.valueOf(value);
    } catch (IllegalArgumentException e) {
      System.err.println("jenis_kelamin salah: " + value);
      return null;
    }
  }
}
