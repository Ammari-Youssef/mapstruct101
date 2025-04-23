package com.moushtario.mapstruct101.service;

import com.moushtario.mapstruct101.Mapper.AddressMapper;
import com.moushtario.mapstruct101.domain.dto.AddressDto;
import com.moushtario.mapstruct101.domain.entity.Address;
import com.moushtario.mapstruct101.exception.ResourceNotFoundException;
import com.moushtario.mapstruct101.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dell
 * @version 1.0
 * @created 23/04/2025
 */
@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressDto createAddress(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toDto(savedAddress);
    }

    public AddressDto getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
    }

    public List<AddressDto> getAllAddresses() {
        List<Address> addressList = addressRepository.findAll();
        return addressMapper.toDtoList(addressList);
    }

    public AddressDto updateAddress(Long id, AddressDto addressDto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));

        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());

        Address updatedAddress = addressRepository.save(address);
        return addressMapper.toDto(updatedAddress);
    }

    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException("Address not found with id: " + id);
        }
        addressRepository.deleteById(id);
    }

}
