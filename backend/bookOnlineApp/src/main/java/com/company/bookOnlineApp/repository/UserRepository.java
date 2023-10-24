package com.company.bookOnlineApp.repository;

import com.company.bookOnlineApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
