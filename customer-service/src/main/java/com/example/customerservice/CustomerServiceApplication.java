package com.example.customerservice;

import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {

            List<Customer> customerList=List.of(

                    Customer.builder()
                            .firstName("OUEDRAOGO")
                            .lastName("Dramane")
                            .email("oue123@gmail.com")
                            .build(),

                    Customer.builder()
                            .firstName("SAVADOGO")
                            .lastName("Ousmane")
                            .email("saking223@gmail.com")
                            .build()

            );

            customerRepository.saveAll(customerList);

        };
    }

}
