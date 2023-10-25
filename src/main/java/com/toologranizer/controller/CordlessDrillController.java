package com.toologranizer.controller;

import com.toologranizer.dto.cordlessDrill.CordlessDrillMapper;
import com.toologranizer.dto.cordlessDrill.CordlessDrillRequest;
import com.toologranizer.dto.cordlessDrill.CordlessDrillResponse;
import com.toologranizer.dto.worker.WorkerResponse;
import com.toologranizer.model.CordlessDrill;
import com.toologranizer.service.CordlessDrillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(CordlessDrillController.API_CCORDLESSDRILL)
@RestController
public class CordlessDrillController {

    public static final String API_CCORDLESSDRILL = "/drills";

    private CordlessDrillService cordlessDrillService;

    private CordlessDrillMapper cordlessDrillMapper;

    @Autowired
    public CordlessDrillController(CordlessDrillService cordlessDrillService, CordlessDrillMapper cordlessDrillMapper) {
        this.cordlessDrillService = cordlessDrillService;
        this.cordlessDrillMapper = cordlessDrillMapper;
    }

    @PostMapping
    public ResponseEntity<CordlessDrillResponse> create(@RequestBody CordlessDrillRequest request){
        CordlessDrill drill = cordlessDrillMapper.toEntity(request);
        CordlessDrill savedDrill = cordlessDrillService.save(drill);
        CordlessDrillResponse response = cordlessDrillMapper.toDto(savedDrill);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<CordlessDrillResponse>> findAll() {
        List<CordlessDrill> drills = cordlessDrillService.findAll();
        List<CordlessDrillResponse> responseList = cordlessDrillMapper.toDto(drills);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{brand}")
    public ResponseEntity<CordlessDrillResponse> findByBrand(@PathVariable(name = "brand") String brand) {
        return cordlessDrillService.findByBrand(brand)
                .map(cordlessDrillMapper::toDto)
                .map(cordlessDrillResponse -> new ResponseEntity<>(cordlessDrillResponse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{model}")
    public ResponseEntity<CordlessDrillResponse> findByModel(@PathVariable(name = "model") String model) {
        return cordlessDrillService.findByModel(model)
                .map(cordlessDrillMapper::toDto)
                .map(cordlessDrillResponse -> new ResponseEntity<>(cordlessDrillResponse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        cordlessDrillService.delete(id);
        return new ResponseEntity<>("drill deleted", HttpStatus.OK);
    }
}
