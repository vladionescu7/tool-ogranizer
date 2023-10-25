package com.toologranizer.controller;

import com.toologranizer.dto.worker.WorkerMapper;
import com.toologranizer.dto.worker.WorkerRequest;
import com.toologranizer.dto.worker.WorkerResponse;
import com.toologranizer.model.Worker;
import com.toologranizer.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(WorkerController.API_WORKER)
@RestController
public class WorkerController {

    public static final String API_WORKER = "/workers";

    private WorkerService workerservice;

    private WorkerMapper workerMapper;

    @Autowired
    public WorkerController(WorkerService workerservice, WorkerMapper workerMapper) {
        this.workerservice = workerservice;
        this.workerMapper = workerMapper;
    }

    @PostMapping
    public ResponseEntity<WorkerResponse> create(@RequestBody WorkerRequest request){
        Worker worker = workerMapper.toEntity(request);
        Worker savedWorker = workerservice.save(worker);
        WorkerResponse response = workerMapper.toDo(savedWorker);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }



    @GetMapping("/{name}")
    public ResponseEntity<WorkerResponse> findByName(@PathVariable(name = "name") String name){
        return workerservice.findByName(name)
                .map(workerMapper::toDo)
                .map(workerResponse -> new ResponseEntity<>(workerResponse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        workerservice.delete(id);
        return new ResponseEntity<>("worker deleted", HttpStatus.OK);
    }
}
