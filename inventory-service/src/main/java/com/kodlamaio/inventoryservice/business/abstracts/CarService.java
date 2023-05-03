package com.example.inventoryservice.business.abstracts;

import com.example.inventoryservice.business.dto.request.create.CreateBrandRequest;
import com.example.inventoryservice.business.dto.request.create.CreateCarRequest;
import com.example.inventoryservice.business.dto.request.update.UpdateBrandRequest;
import com.example.inventoryservice.business.dto.request.update.UpdateCarRequest;
import com.example.inventoryservice.business.dto.response.create.CreateBrandResponse;
import com.example.inventoryservice.business.dto.response.create.CreateCarResponse;
import com.example.inventoryservice.business.dto.response.get.GetAllBrandsResponse;
import com.example.inventoryservice.business.dto.response.get.GetAllCarsResponse;
import com.example.inventoryservice.business.dto.response.get.GetBrandResponse;
import com.example.inventoryservice.business.dto.response.get.GetCarResponse;
import com.example.inventoryservice.business.dto.response.update.UpdateBrandResponse;
import com.example.inventoryservice.business.dto.response.update.UpdateCarResponse;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetCarResponse getById(UUID id);
    CreateCarResponse add(CreateCarRequest createBrandRequest);
    UpdateCarResponse update(UUID id , UpdateCarRequest request);
    void delete(UUID id);
}
