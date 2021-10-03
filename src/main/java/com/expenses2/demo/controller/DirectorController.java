package com.expenses2.demo.controller;

import com.expenses2.demo.exception.ResourceNotFoundException;
import com.expenses2.demo.model.Chief;
import com.expenses2.demo.model.Director;
import com.expenses2.demo.repository.ChiefRepository;
import com.expenses2.demo.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DirectorController {
    @Autowired
    DirectorRepository directorRepository;

    @GetMapping("/directors")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @GetMapping("/directors/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Director> getDirectorsById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Director chief = directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found for this id :: " + id));
        return ResponseEntity.ok().body(chief);
    }

    @PostMapping("/directors")
    @PreAuthorize("hasRole('ADMIN')")
    public Director createDirector(@Valid @RequestBody Director director) {
        return directorRepository.save(director);
    }

    @PutMapping("/directors/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Director> updateDirectors(@PathVariable(value = "id") long id,
                                                    @Valid @RequestBody Director directorDetails) throws ResourceNotFoundException {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found for this id :: " + id));
        director.setId(directorDetails.getId());
        director.setName(directorDetails.getName());

        final Director updatedDirector = directorRepository.save(director);
        return ResponseEntity.ok(updatedDirector);
    }

    @DeleteMapping("/directors/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteDirectors(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found for this id :: " + id));

        directorRepository.delete(director);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
