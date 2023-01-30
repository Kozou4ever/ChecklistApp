package com.checklistback.checklist.repository;

import com.checklistback.checklist.models.Checklist;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ChecklistRepository extends CrudRepository<Checklist, Long> {

}