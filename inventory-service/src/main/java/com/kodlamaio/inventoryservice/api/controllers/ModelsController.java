package com.kodlamaio.inventoryservice.api.controllers;

import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.dto.request.create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.request.update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.response.create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetAllModelsResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.dto.response.update.UpdateModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
    private final ModelService service;

    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@Valid @RequestBody CreateModelRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateModelResponse add(@PathVariable UUID id,@Valid @RequestBody UpdateModelRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
