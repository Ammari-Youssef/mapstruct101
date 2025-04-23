package com.moushtario.mapstruct101.controller;

import com.moushtario.mapstruct101.domain.dto.AddressDto;
import com.moushtario.mapstruct101.domain.entity.Address;
import com.moushtario.mapstruct101.repository.AddressRepository;
import com.moushtario.mapstruct101.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Youssef
 * @version 1.0
 * @created 23/04/2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/people/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(AddressDto addressDto) {
        return ResponseEntity.ok(addressService.createAddress(addressDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

}
