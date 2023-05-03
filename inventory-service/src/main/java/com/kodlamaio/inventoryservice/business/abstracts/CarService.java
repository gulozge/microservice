package com.kodlamaio.inventoryservice.business.abstracts;

import com.kodlamaio.inventoryservice.business.dto.request.create.CreateBrandRequest;
import com.kodlamaio.inventoryservice.business.dto.request.create.CreateCarRequest;
import com.kodlamaio.inventoryservice.business.dto.request.update.UpdateBrandRequest;
import com.kodlamaio.inventoryservice.business.dto.request.update.UpdateCarRequest;
import com.kodlamaio.inventoryservice.business.dto.response.create.CreateBrandResponse;
import com.kodlamaio.inventoryservice.business.dto.response.create.CreateCarResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetAllBrandsResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetAllCarsResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetBrandResponse;
import com.kodlamaio.inventoryservice.business.dto.response.get.GetCarResponse;
import com.kodlamaio.inventoryservice.business.dto.response.update.UpdateBrandResponse;
import com.kodlamaio.inventoryservice.business.dto.response.update.UpdateCarResponse;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetCarResponse getById(UUID id);
    CreateCarResponse add(CreateCarRequest request);
    UpdateCarResponse update(UUID id , UpdateCarRequest request);
    void delete(UUID id);
}
