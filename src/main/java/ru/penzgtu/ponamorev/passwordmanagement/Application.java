package ru.penzgtu.ponamorev.passwordmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

/*
    @Bean
    public CommandLineRunner demo(DeviceRepository repository) {
        return (args) -> {
            // save three devices
            repository.save(new Device("Bulb", "14-D6-B4-A7-8B-91"));
            repository.save(new Device("Socket", "14-D6-B4-A7-8B-92"));
            repository.save(new Device("Teapot", "14-D6-B4-A7-8B-93"));

            // fetch all devices from db
            log.info("==========Devices===========");
            log.info("============================");
            for (Device device : repository.findAll()) {
                log.info(device.toString());
            }
            log.info("");

            // fetch an device by ID
            */
/*repository.findById(1L)
                    .ifPresent(device -> {
                        log.info("Device found with findById(1L):");
                        log.info("===============================");
                        log.info(device.toString());
                        log.info("");
                    });

            // fetch Devices by  name
            log.info("Device found with findByName('Teapot'):");
            log.info("--------------------------------------------");
            Device device = repository.findByName("Teapot");
                log.info(device.toString());
            log.info("");*//*

        };
    }
*/

}
