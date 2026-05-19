package com.kindergarten.saga.creditprocessorservice.controller;

import com.kindergarten.saga.core.dto.CreditCardProcessRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("ccp")
public class CreditCardProcessorController {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardProcessorController.class);

    @PostMapping("/process")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void processCreditCard(@RequestBody @Valid CreditCardProcessRequest request) {
        logger.info("Processing request: {}", request);
    }
}
