package com.toologranizer.repository;

import com.toologranizer.model.CordlessDrill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CordlessDrillRepository  extends JpaRepository<CordlessDrill, Long> {

    Optional<CordlessDrill> findByModel(String model);

    Optional<CordlessDrill> findByBrand(String brand);
}
