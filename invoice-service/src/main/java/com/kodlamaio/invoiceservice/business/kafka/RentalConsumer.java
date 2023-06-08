package com.kodlamaio.invoiceservice.business.kafka;

import com.kodlamaio.commonpackage.events.rental.InvoiceCreatedEvent;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.dto.requests.CreateInvoiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalConsumer {
    private final InvoiceService service;
    private final ModelMapperService mapper;
    @KafkaListener(
            topics = "invoice-created",
            groupId = "invoice-create"
    )
    public void consume(InvoiceCreatedEvent event) {
        var invoice = mapper.forRequest().map(event, CreateInvoiceRequest.class);
        service.add(invoice);
        log.info("Invoice created event consumed {}", event);
    }
}