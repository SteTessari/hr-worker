package com.example.hrworker.mappers;

import com.example.hrworker.dtos.WorkerDTO;
import com.example.hrworker.models.Worker;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    @Mapping(target = "id", ignore = true)
    Worker toObject(WorkerDTO workerDTO);

    WorkerDTO toDTO(Worker worker);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Worker updateFromDTO(WorkerDTO workerDTO, @MappingTarget Worker worker);
}
