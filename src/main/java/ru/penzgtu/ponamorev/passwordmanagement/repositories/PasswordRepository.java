package ru.penzgtu.ponamorev.passwordmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.penzgtu.ponamorev.passwordmanagement.domain.Password;

@Repository
public interface PasswordRepository extends CrudRepository<Password, Long> {
    Password findByDeviceId(Long deviceId);
}