package com.moushtario.mapstruct101.DB;

/**
 * @author dell
 * @version 1.0
 * @created 23/04/2025
 */

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/seed")
@Profile("dev")
@AllArgsConstructor
public class SeederController {

    private DBSeeder databaseSeeder;

    @PostMapping
    public String seedDatabase() {
        databaseSeeder.run(); // Manually trigger the seeder
        return "Database seeding completed!";
    }
}

