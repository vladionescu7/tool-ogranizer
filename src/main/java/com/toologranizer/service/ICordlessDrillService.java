package com.toologranizer.service;

import com.toologranizer.model.CordlessDrill;

import java.util.List;
import java.util.Optional;

public interface ICordlessDrillService {

    CordlessDrill save(CordlessDrill cordlessDrill);

    List<CordlessDrill> findAll();

    Optional<CordlessDrill> findById(Long id);

    Optional<CordlessDrill> findByModel(String model);

    Optional<CordlessDrill> findByBrand(String brand);

    void updateCordlessDrill(CordlessDrill drill);

    void delete(Long id);
}
