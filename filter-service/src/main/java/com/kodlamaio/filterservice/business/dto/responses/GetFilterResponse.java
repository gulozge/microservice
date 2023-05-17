package com.kodlamaio.filterservice.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetFilterResponse {

        private String id;
        private UUID carId;
        private UUID modelId;
        private UUID brandId;
        private String modelName;
        private String brandName;
        private String plate;
        private int modelYear;
        private double dailyPrice;
        private String state;
}
