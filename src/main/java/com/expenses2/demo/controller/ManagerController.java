package com.expenses2.demo.controller;

import com.expenses2.demo.exception.ResourceNotFoundException;
import com.expenses2.demo.model.Director;
import com.expenses2.demo.model.Manager;
import com.expenses2.demo.repository.DirectorRepository;
import com.expenses2.demo.repository.ManagerRepository;
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
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;

    @GetMapping("/managers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @GetMapping("/managers/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Manager> getManagersById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manager not found for this id :: " + id));
        return ResponseEntity.ok().body(manager);
    }

    @PostMapping("/managers")
    @PreAuthorize("hasRole('ADMIN')")
    public Manager createManager(@Valid @RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    @PutMapping("/managers/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Manager> updateManagers(@PathVariable(value = "id") long id,
                                                  @Valid @RequestBody Manager managerDetails) throws ResourceNotFoundException {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manager not found for this id :: " + id));
        manager.setId(managerDetails.getId());
        manager.setName(managerDetails.getName());

        final Manager updatedManager = managerRepository.save(manager);
        return ResponseEntity.ok(updatedManager);
    }

    @DeleteMapping("/managers/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteManagers(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manager not found for this id :: " + id));

        managerRepository.delete(manager);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
