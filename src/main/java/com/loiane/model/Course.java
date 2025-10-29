package com.loiane.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity


@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?")
@SQLRestriction("status = 'Ativo'")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NonNull
    @Size(min = 5,max = 100)
    @Column(length = 100,nullable = false)
    private String name;

    @NonNull
    @Size(max = 15)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(length = 15,nullable = false)
    private String category;

    @NonNull
    @Size(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10,nullable = false)
    private String status = "Ativo";    

    
}
