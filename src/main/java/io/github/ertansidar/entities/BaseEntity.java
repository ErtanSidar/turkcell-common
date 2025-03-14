package io.github.ertansidar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<T> {

    @Id
    private T id;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @PrePersist
    protected void prePersist() {
        if (id == null) {
            id = generateId();
        }
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

    @PreRemove
    protected void preRemove() {
        deletedDate = LocalDateTime.now();
    }

    protected T generateId() {
        throw new UnsupportedOperationException("ID generation must be implemented in subclasses.");
    }

}