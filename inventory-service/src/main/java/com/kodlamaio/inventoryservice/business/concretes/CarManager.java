package com.example.inventoryservice.business.concretes;

import com.example.inventoryservice.business.abstracts.CarService;
import com.example.inventoryservice.business.dto.request.create.CreateCarRequest;
import com.example.inventoryservice.business.dto.request.update.UpdateCarRequest;
import com.example.inventoryservice.business.dto.response.create.CreateCarResponse;
import com.example.inventoryservice.business.dto.response.get.GetAllCarsResponse;
import com.example.inventoryservice.business.dto.response.get.GetCarResponse;
import com.example.inventoryservice.business.dto.response.update.UpdateCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    @Override
    public List<GetAllCarsResponse> getAll() {
        return null;
    }

    @Override
    public GetCarResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest createBrandRequest) {
        return null;
    }

    @Override
    public UpdateCarResponse update(UUID id, UpdateCarRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
