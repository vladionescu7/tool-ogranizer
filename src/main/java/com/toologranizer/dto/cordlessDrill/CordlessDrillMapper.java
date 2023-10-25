package com.toologranizer.dto.cordlessDrill;

import com.toologranizer.model.CordlessDrill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CordlessDrillMapper {

    public CordlessDrill toEntity(CordlessDrillRequest cordlessDrillRequest) {
        CordlessDrill drill = new CordlessDrill();
        drill.setBrand(cordlessDrillRequest.getBrand());
        drill.setModel(cordlessDrillRequest.getModel());
        drill.setTaken(cordlessDrillRequest.getTaken());

        return drill;
    }

    public List<CordlessDrill> toEntity(List<CordlessDrillRequest> cordlessDrillRequests) {
        List<CordlessDrill> drills = new ArrayList<>();
        for (CordlessDrillRequest cordlessDrillRequest : cordlessDrillRequests) {
            drills.add(toEntity(cordlessDrillRequest));
        }
        return drills;
    }

    public CordlessDrillResponse toDto(CordlessDrill drill) {
        CordlessDrillResponse dto = new CordlessDrillResponse();
        dto.setBrand(drill.getBrand());
        dto.setModel(drill.getModel());
        dto.setTaken(drill.getTaken());

        return dto;
    }

    public List<CordlessDrillResponse> toDto(List<CordlessDrill> drills) {
        return drills.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }
}
