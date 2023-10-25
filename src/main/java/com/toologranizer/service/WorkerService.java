package com.toologranizer.service;

import com.toologranizer.model.CordlessDrill;
import com.toologranizer.model.Worker;
import com.toologranizer.repository.CordlessDrillRepository;
import com.toologranizer.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService implements IWorkerService {

    private static final Logger logger = LoggerFactory.getLogger(CordlessDrill.class);

    private WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {this.workerRepository = workerRepository;}

    public Worker save(Worker worker){
        logger.debug(worker.getName() + "created");
        return workerRepository.save(worker);
    }

    public List<Worker> findAll() {
        logger.debug("find all workers..");
        List<Worker> workers = workerRepository.findAll();

        return workers;
    }

    public Optional<Worker> findById(Long id) {

        return workerRepository.findById(id);
    }

    public Optional<Worker> findByName(String name) {

        return workerRepository.findByName(name);
    }

    public Worker update(Long id) {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("worker not found"));

        updateWorker(worker);

        Worker updatedWorker = workerRepository.save(worker);

        return updatedWorker;
    }

    public void updateWorker(Worker worker){

        worker.setCurrentTools(worker.getCurrentTools());
    }

    public void delete(Long id) {
        logger.debug("worker with id: " + id + " has been deleted");
        workerRepository.deleteById(id);
    }
}
