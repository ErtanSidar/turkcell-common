package io.github.ertansidar.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<T> {

    @Id
    private T id;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @Field("created_at")
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    @Field("created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    @Field("updated_at")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by", insertable = false)
    @Field("updated_by")
    private String updatedBy;


    @Column(name = "deleted_at")
    @Field("deleted_at")
    private LocalDateTime deletedAt;


    @Column(name = "deleted_by")
    @Field("deleted_by")
    private String deletedBy;

    protected BaseEntity() {
        this.id = generateId();
    }

    protected abstract T generateId();

}