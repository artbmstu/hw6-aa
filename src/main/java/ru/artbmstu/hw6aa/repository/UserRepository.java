package ru.artbmstu.hw6aa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.artbmstu.hw6aa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}