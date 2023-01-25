package com.checklistback.checklist.repository;

import com.checklistback.checklist.models.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

}