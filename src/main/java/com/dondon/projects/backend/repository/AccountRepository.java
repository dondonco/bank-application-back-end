package com.dondon.projects.backend.repository;

import com.dondon.projects.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Integer, Account> {
}
