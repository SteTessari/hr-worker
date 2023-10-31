package com.example.hrworker.controllers;

import com.example.hrworker.dtos.WorkerDTO;
import com.example.hrworker.services.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping
    public ResponseEntity<String> inserir(@Valid @RequestBody WorkerDTO workerDTO){
        workerService.inserir(workerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inserido com sucesso!");
    }
    @GetMapping("/buscar-todos")
    public ResponseEntity<Page<WorkerDTO>> buscarTodos(@PageableDefault Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.buscarTodos(pageable));
    }
    @GetMapping("/{idWorker}")
    public ResponseEntity<WorkerDTO> buscarPorId(@PathVariable Long idWorker){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.buscarPorId(idWorker));
    }
}
