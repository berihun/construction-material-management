package com.expenses2.demo.controller;

import com.expenses2.demo.model.WorkUnit;
import com.expenses2.demo.repository.WorkUnitRepository;
import com.expenses2.demo.exception.ResourceNotFoundException;
//import com.expenses2.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class WorkunitController {

    @Autowired
    WorkUnitRepository repository;

    @GetMapping("/workunit")
    @PreAuthorize("hasRole('ADMIN')")
    public List<WorkUnit> getAllWorkunits() {
        return repository.findAll();
    }


    @GetMapping("/workunit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<WorkUnit> getWorkunitById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        WorkUnit workUnit = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("work unit not found for this id :: " + id));
        return ResponseEntity.ok().body(workUnit);
    }

    @PostMapping("/workunit")
    @PreAuthorize("hasRole('ADMIN')")
    public WorkUnit createWorkunit(@Valid @RequestBody WorkUnit workunit) {
        return repository.save(workunit);
    }

    @PutMapping("/workunit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<WorkUnit> updateWorkunits(@PathVariable(value = "id") long id,
                                                    @Valid @RequestBody WorkUnit workUnitDetails) throws ResourceNotFoundException {
        WorkUnit workUnit = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("work unit not found for this id :: " + id));
        workUnit.setId(workUnitDetails.getId());
        workUnit.setUnitname(workUnitDetails.getUnitname());
        workUnit.setEmail(workUnitDetails.getEmail());
        workUnit.setPhone(workUnitDetails.getPhone());
        final WorkUnit updatedWorkUnit1 = repository.save(workUnit);
        return ResponseEntity.ok(updatedWorkUnit1);
    }

    @DeleteMapping("/workunit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteWorkunits(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        WorkUnit user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("work unit not found for this id :: " + id));

        repository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
