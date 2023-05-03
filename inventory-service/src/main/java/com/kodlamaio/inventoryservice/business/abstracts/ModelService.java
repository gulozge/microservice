package com.example.inventoryservice.business.abstracts;

import com.example.inventoryservice.business.dto.request.create.CreateBrandRequest;
import com.example.inventoryservice.business.dto.request.create.CreateModelRequest;
import com.example.inventoryservice.business.dto.request.update.UpdateBrandRequest;
import com.example.inventoryservice.business.dto.request.update.UpdateModelRequest;
import com.example.inventoryservice.business.dto.response.create.CreateBrandResponse;
import com.example.inventoryservice.business.dto.response.create.CreateModelResponse;
import com.example.inventoryservice.business.dto.response.get.GetAllBrandsResponse;
import com.example.inventoryservice.business.dto.response.get.GetAllModelsResponse;
import com.example.inventoryservice.business.dto.response.get.GetBrandResponse;
import com.example.inventoryservice.business.dto.response.get.GetModelResponse;
import com.example.inventoryservice.business.dto.response.update.UpdateBrandResponse;
import com.example.inventoryservice.business.dto.response.update.UpdateModelResponse;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    GetModelResponse getById(UUID id);
    CreateModelResponse add(CreateModelRequest createBrandRequest);
    UpdateModelResponse update(UUID id , UpdateModelRequest request);
    void delete(UUID id);
}
