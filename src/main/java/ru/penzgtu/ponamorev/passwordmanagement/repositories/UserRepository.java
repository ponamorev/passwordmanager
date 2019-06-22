package ru.penzgtu.ponamorev.passwordmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.penzgtu.ponamorev.passwordmanagement.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}