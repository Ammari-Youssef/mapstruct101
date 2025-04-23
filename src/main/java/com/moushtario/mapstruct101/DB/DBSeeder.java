package com.moushtario.mapstruct101.DB;

import com.github.javafaker.Faker;
import com.moushtario.mapstruct101.domain.entity.Address;
import com.moushtario.mapstruct101.domain.entity.Person;
import com.moushtario.mapstruct101.repository.PersonRepository;
import com.moushtario.mapstruct101.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author Youssef
 * @version 1.0
 * @created 23/04/2025
 */
@Service
@RequiredArgsConstructor
public class DBSeeder implements CommandLineRunner {


    private final PersonRepository personRepository;
    private final AddressService addressService;

    private final Faker faker = new Faker();
    private final Random random = new Random();

    @Override
    public void run(String... args) {

        // Generate Fake People
        for (int i = 0; i < 10; i++) {
            Person person = Person.builder()
                    .name(faker.name().fullName())
                    .age(random.nextInt(80) + 20)
                    .address(
                            Address.builder()
                                    .street(faker.address().streetAddress())
                                    .city(faker.address().city())
                                    .zipCode(faker.address().zipCode())
                                    .build()
                    )
                    .build();
            personRepository.save(person);
        }



        System.out.println("Database seeding completed!");
    }
}
