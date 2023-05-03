package com.example.inventoryservice.business.abstracts;

import com.example.inventoryservice.business.dto.request.create.CreateBrandRequest;
import com.example.inventoryservice.business.dto.request.update.UpdateBrandRequest;
import com.example.inventoryservice.business.dto.response.create.CreateBrandResponse;
import com.example.inventoryservice.business.dto.response.get.GetAllBrandsResponse;
import com.example.inventoryservice.business.dto.response.get.GetBrandResponse;
import com.example.inventoryservice.business.dto.response.update.UpdateBrandResponse;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(UUID id);
    CreateBrandResponse add(CreateBrandRequest createBrandRequest);
    UpdateBrandResponse update(UUID id ,UpdateBrandRequest request);
    void delete(UUID id);
}
