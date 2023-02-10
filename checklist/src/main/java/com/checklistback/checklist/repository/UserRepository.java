package com.checklistback.checklist.repository;

import java.util.Optional;

import com.checklistback.checklist.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    Boolean existsByUsername(String username);

}
