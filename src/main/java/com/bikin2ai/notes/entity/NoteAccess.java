package com.bikin2ai.notes.entity;

import com.bikin2ai.notes.enums.AccessType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Builder
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notes_accesses")
public class NoteAccess {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "user_id")
        private UUID userID;

        @Column(name = "note_id")
        private UUID noteID;

        public Id() {
        }

        public Id(UUID userID, UUID noteID) {
            this.userID = userID;
            this.noteID = noteID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Id id = (Id) o;

            if (!Objects.equals(userID, id.userID)) return false;
            return Objects.equals(noteID, id.noteID);
        }

        @Override
        public int hashCode() {
            int result = userID != null ? userID.hashCode() : 0;
            result = 31 * result + (noteID != null ? noteID.hashCode() : 0);
            return result;
        }
    }
    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "note_id",
            insertable = false, updatable = false)
    private Note note;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "access_types",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id"), @JoinColumn(name="note_id", referencedColumnName="note_id")}
    )
    @Column(name = "type")
    @Enumerated
    private Set<AccessType> accessTypes = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Boolean deleted = Boolean.FALSE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteAccess that = (NoteAccess) o;

        if (!Objects.equals(id, that.id)) return false;
//        if (!Objects.equals(accessTypes, that.accessTypes)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(updatedAt, that.updatedAt)) return false;
        return Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (accessTypes != null ? accessTypes.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
