package ru.penzgtu.ponamorev.passwordmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.penzgtu.ponamorev.passwordmanagement.domain.Device;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
    Device findByName(String name);
    Device findByAddress(String address);
}