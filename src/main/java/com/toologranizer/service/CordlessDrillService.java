package com.toologranizer.service;

import com.toologranizer.model.CordlessDrill;
import com.toologranizer.repository.CordlessDrillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CordlessDrillService implements ICordlessDrillService {

    private static final Logger logger = LoggerFactory.getLogger(CordlessDrill.class);

    private CordlessDrillRepository cordlessDrillRepository;

    @Autowired
    public CordlessDrillService(CordlessDrillRepository cordlessDrillRepository) {this.cordlessDrillRepository = cordlessDrillRepository;}

    public CordlessDrill save(CordlessDrill cordlessDrill){
        logger.debug(cordlessDrill.getBrand() + cordlessDrill.getModel() + "created");
        return cordlessDrillRepository.save(cordlessDrill);
    }

    public List<CordlessDrill> findAll() {
        logger.debug("find all drills..");
        List<CordlessDrill> drills = cordlessDrillRepository.findAll();

        return drills;
    }

    public Optional<CordlessDrill> findById(Long id) {

        return cordlessDrillRepository.findById(id);
    }

    public Optional<CordlessDrill> findByModel(String model) {

        return cordlessDrillRepository.findByModel(model);
    }

    public Optional<CordlessDrill> findByBrand(String brand) {

        return cordlessDrillRepository.findByBrand(brand);
    }

    public CordlessDrill update(Long id) {
        CordlessDrill cordlessDrill = cordlessDrillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("drill not found"));

        updateCordlessDrill(cordlessDrill);

        CordlessDrill updatedCordlessDrill = cordlessDrillRepository.save(cordlessDrill);

        return updatedCordlessDrill;
    }

    public void updateCordlessDrill(CordlessDrill drill){
        drill.setTaken(drill.getTaken());
    }

    public void delete(Long id) {
        logger.debug("drill with id: " + id + " has been deleted");
        cordlessDrillRepository.deleteById(id);
    }
}
