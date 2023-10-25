package com.toologranizer.dto.worker;

import com.toologranizer.model.CordlessDrill;

import java.util.List;
import java.util.Objects;

public class WorkerResponse {

    private Long id;

    private String name;

    private List<CordlessDrill> currentTools;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CordlessDrill> getCurrentTools() {
        return currentTools;
    }

    public void setCurrentTools(List<CordlessDrill> currentTools) {
        this.currentTools = currentTools;
    }
}
