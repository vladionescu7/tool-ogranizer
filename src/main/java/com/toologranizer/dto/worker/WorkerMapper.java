package com.toologranizer.dto.worker;

import com.toologranizer.model.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkerMapper {

    public Worker toEntity(WorkerRequest request) {
        Worker worker = new Worker();
        worker.setName(request.getName());
        worker.setCurrentTools(request.getCurrentTools());

        return worker;
    }

    public WorkerResponse toDo(Worker worker){
        WorkerResponse dto = new WorkerResponse();
    dto.setName(worker.getName());
    dto.setCurrentTools(worker.getCurrentTools());

    return dto;
    }
}
