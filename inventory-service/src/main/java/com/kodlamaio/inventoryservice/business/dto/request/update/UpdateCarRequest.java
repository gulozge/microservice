package com.kodlamaio.inventoryservice.business.dto.request.update;

import com.kodlamaio.commonpackage.utils.annotations.NotFutureYear;
import com.kodlamaio.commonpackage.utils.constants.Regex;
import com.kodlamaio.inventoryservice.entities.enums.State;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    @NotNull
    private UUID modelId;
    @NotFutureYear
    private int modelYear;
    @NotBlank
    @Pattern(regexp = Regex.Plate)
    private String plate;
   @NotNull
    private State state;
    @Min(1)
    private double dailyPrice;
}
