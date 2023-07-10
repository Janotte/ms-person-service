package br.net.supptech.personservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "TB_PERSONS")
public class PersonModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    private UUID personId;

    @Column(nullable = false, unique = true, length = 80)
    private String name;
}