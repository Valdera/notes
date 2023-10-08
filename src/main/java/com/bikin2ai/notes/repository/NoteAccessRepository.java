package com.bikin2ai.notes.repository;

import com.bikin2ai.notes.entity.NoteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteAccessRepository extends JpaRepository<NoteAccess, UUID> {
}
