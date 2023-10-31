package com.example.hrworker.repositories;

import com.example.hrworker.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findByNameAndDailyIncome(String name, BigDecimal dailyIncome);

}
