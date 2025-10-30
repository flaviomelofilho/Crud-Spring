package com.loiane.servive;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.loiane.model.Course;
import com.loiane.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Validated
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> list(){
        return courseRepository.findAll();
    }

    public Optional<Course> findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id);
    }

    public ResponseEntity<Course> create(@Valid Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }

    public Optional<Course> update(@NotNull @Positive Long id, @Valid Course course){
        return courseRepository.findById(id)
            .map(record -> {
                record.setName(course.getName());
                record.setCategory(course.getCategory());
                Course update = courseRepository.save(record);
                return courseRepository.save(record);
            });
    }

    public boolean delete(@NotNull @Positive Long id){
        return courseRepository.findById(id)
            .map(record -> {
                courseRepository.deleteById(id);
                return true;
            })
            .orElse(false);
    }
    
}
