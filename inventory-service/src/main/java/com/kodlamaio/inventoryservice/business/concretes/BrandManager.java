package com.example.inventoryservice.business.concretes;

import com.example.inventoryservice.business.abstracts.BrandService;
import com.example.inventoryservice.business.dto.request.create.CreateBrandRequest;
import com.example.inventoryservice.business.dto.request.update.UpdateBrandRequest;
import com.example.inventoryservice.business.dto.response.create.CreateBrandResponse;
import com.example.inventoryservice.business.dto.response.get.GetAllBrandsResponse;
import com.example.inventoryservice.business.dto.response.get.GetBrandResponse;
import com.example.inventoryservice.business.dto.response.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    @Override
    public List<GetAllBrandsResponse> getAll() {
        return null;
    }

    @Override
    public GetBrandResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
        return null;
    }

    @Override
    public UpdateBrandResponse update(UUID id, UpdateBrandRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
