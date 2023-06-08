package com.kodlamaio.rentalservice.business.rules;

import com.kodlamaio.commonpackage.events.rental.InvoiceCreatedEvent;
import com.kodlamaio.commonpackage.utils.dto.*;
import com.kodlamaio.commonpackage.utils.exceptions.BusinessException;
import com.kodlamaio.rentalservice.api.clients.CarClient;
import com.kodlamaio.rentalservice.api.clients.PaymentClient;
import com.kodlamaio.rentalservice.business.dto.requests.CreateRentalRequest;
import com.kodlamaio.rentalservice.entities.Rental;
import com.kodlamaio.rentalservice.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository repository;
    private final CarClient carClient;
    private final PaymentClient paymentClient;

    public void checkIfRentalExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("RENTAL_NOT_EXISTS");
        }
    }

    public void ensureCarIsAvailable(UUID carId) {
        var response = carClient.checkIfCarAvailable(carId);
        if (!response.isSuccess()) {
            throw new BusinessException(response.getMessage());
        }
    }
    public void ensurePaymentIsSuccess(CreateRentalPaymentRequest paymentRequest) {
        var response = paymentClient.processRentalPayment(paymentRequest);
        if (!response.isSuccess()) {
            throw new BusinessException(response.getMessage());
        }
    }
    public InvoiceCreatedEvent createInvoice(CreateRentalRequest request, Rental rental, Jwt jwt){
        InvoiceCreatedEvent event =new InvoiceCreatedEvent();
        GetCarResponse car = carClient.checkIfCarInRental(request.getCarId());
        event.setCustomerId((String) jwt.getClaims().get("sub"));
        event.setRentedAt(rental.getRentedAt());
        event.setModelName(car.getModelName());
        event.setBrandName(car.getModelBrandName());
        event.setDailyPrice(request.getDailyPrice());
        event.setRentedForDays(request.getRentedForDays());
        event.setCardHolder(request.getPaymentRequest().getCardHolder());
        event.setPlate(car.getPlate());
        event.setModelYear(car.getModelYear());
        return event;
    }
}