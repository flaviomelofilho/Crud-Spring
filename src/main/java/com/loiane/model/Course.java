package com.loiane.model;

import org.hibernate.Length;

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

    
}
