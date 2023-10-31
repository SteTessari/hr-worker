package com.example.hrworker.services;

import com.example.hrworker.dtos.WorkerDTO;
import com.example.hrworker.exceptions.HrWorkerException;
import com.example.hrworker.mappers.WorkerMapper;
import com.example.hrworker.models.Worker;
import com.example.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    private final WorkerMapper workerMapper = WorkerMapper.INSTANCE;

    public void inserir(WorkerDTO workerDTO){
        Worker worker = workerMapper.toObject(workerDTO);

        Optional<Worker> workerOptional = workerRepository.findByNameAndDailyIncome(workerDTO.getName(), workerDTO.getDailyIncome());

        if (workerOptional.isPresent())
            throw new HrWorkerException(HttpStatus.CONFLICT, "Worker already exists");

        workerRepository.save(worker);
    }

    public Page<WorkerDTO> buscarTodos(Pageable pageable){

        Page<Worker> workersPage = workerRepository.findAll(pageable);

        return workersPage.map(workerMapper::toDTO);
    }

    public WorkerDTO buscarPorId(Long idWorker){
        Worker worker = workerRepository.findById(idWorker)
                .orElseThrow(() -> new HrWorkerException(HttpStatus.NOT_FOUND, "No workers found"));

        return workerMapper.toDTO(worker);
    }
}
