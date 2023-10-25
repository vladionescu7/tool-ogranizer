package com.toologranizer.repository;

import com.toologranizer.model.CordlessDrill;
import com.toologranizer.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Optional<Worker> findByName(String name);
}
