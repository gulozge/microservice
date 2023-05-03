package com.example.inventoryservice.business.dto.request.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    @NotBlank
    @NotNull
    private UUID modelId;
    @Min(value = 200)
    private int modelYear;
    @NotNull
    @NotBlank
    private String plate;
    @Min(1)
    private double dailyPrice;
}
