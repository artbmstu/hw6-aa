package ru.artbmstu.hw6aa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artbmstu.hw6aa.model.VerificationToken;


public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
}