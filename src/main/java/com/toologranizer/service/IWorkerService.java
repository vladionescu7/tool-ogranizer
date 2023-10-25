package com.toologranizer.service;

import com.toologranizer.model.Worker;

import java.util.List;
import java.util.Optional;

public interface IWorkerService {

    Worker save(Worker worker);

    List<Worker> findAll();

    Optional<Worker> findById(Long id);

    Optional<Worker> findByName(String name);

    void updateWorker(Worker worker);

    void delete(Long id);
}
