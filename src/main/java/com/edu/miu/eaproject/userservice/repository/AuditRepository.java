package com.edu.miu.eaproject.userservice.repository;

import com.edu.miu.eaproject.userservice.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit,Integer> {
}
