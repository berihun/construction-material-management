package com.expenses2.demo.controller;

import com.expenses2.demo.exception.ResourceNotFoundException;
import com.expenses2.demo.model.Asset;
import com.expenses2.demo.model.Chief;
import com.expenses2.demo.repository.AssetRepository;
import com.expenses2.demo.repository.ChiefRepository;
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
public class ChiefController {

    @Autowired
    ChiefRepository chiefRepository;

    @GetMapping("/chiefs")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Chief> getAllChiefs() {
        return chiefRepository.findAll();
    }

    @GetMapping("/chiefs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Chief> getChiefsById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Chief chief = chiefRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chief not found for this id :: " + id));
        return ResponseEntity.ok().body(chief);
    }

    @PostMapping("/chiefs")
    @PreAuthorize("hasRole('ADMIN')")
    public Chief createChief(@Valid @RequestBody Chief chief) {
        return chiefRepository.save(chief);
    }

    @PutMapping("/chiefs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Chief> updateChiefs(@PathVariable(value = "id") long id,
                                              @Valid @RequestBody Chief chiefDetails) throws ResourceNotFoundException {
        Chief chief = chiefRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chief not found for this id :: " + id));
        chief.setId(chiefDetails.getId());
        chief.setName(chiefDetails.getName());

        final Chief updatedChief = chiefRepository.save(chief);
        return ResponseEntity.ok(updatedChief);
    }

    @DeleteMapping("/chiefs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteChiefs(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Chief chief = chiefRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chief not found for this id :: " + id));

        chiefRepository.delete(chief);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
