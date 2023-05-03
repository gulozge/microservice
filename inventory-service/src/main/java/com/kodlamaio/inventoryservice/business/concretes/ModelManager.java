package com.kodlamaio.inventoryservice.business.concretes;

import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.abstracts.ModelService;
import com.kodlamaio.inventoryservice.business.dto.request.create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.request.create.CreateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.request.update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.request.update.UpdateModelRequest;
import com.kodlamaio.inventoryservice.business.dto.response.create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.dto.response.create.CreateModelResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetAllModelsResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetAllModelsResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetModelResponse;
import com.kodlamaio.inventoryservice.business.dto.response.update.UpdateModelResponse;
import com.kodlamaio.inventoryservice.business.dto.response.update.UpdateModelResponse;
import com.kodlamaio.inventoryservice.business.rules.ModelBusinessRules;
import com.kodlamaio.inventoryservice.entities.Model;
import com.kodlamaio.inventoryservice.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapperService mapper;
    private final ModelBusinessRules rules;
    @Override
    public List<GetAllModelsResponse> getAll() {
        var Models=repository.findAll();
        var response=Models
                .stream()
                .map(Model -> mapper.forResponse().map(Model, GetAllModelsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetModelResponse getById(UUID id) {
        rules.checkIfModelExists(id);
        var Model=repository.findById(id).orElseThrow();
        var response=mapper.forResponse().map(Model, GetModelResponse.class);
        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        var Model=mapper.forRequest().map(request, Model.class);
        Model.setId(null);
        repository.save(Model);
        var response=mapper.forResponse().map(Model, CreateModelResponse.class);
        return response;
    }

    @Override
    public UpdateModelResponse update(UUID id, UpdateModelRequest request) {
        rules.checkIfModelExists(id);
        var Model=mapper.forRequest().map(request,Model.class);
        Model.setId(id);
        repository.save(Model);
        var response=mapper.forResponse().map(Model, UpdateModelResponse.class);

        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfModelExists(id);
        repository.deleteById(id);
    }
}
