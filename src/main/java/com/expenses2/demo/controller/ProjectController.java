package com.expenses2.demo.controller;

import com.expenses2.demo.model.Company;
import com.expenses2.demo.model.Project;
import com.expenses2.demo.repository.ProjectRepository;
import com.expenses2.demo.exception.ResourceNotFoundException;
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
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Project> getProjectsById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
        return ResponseEntity.ok().body(project);
    }

    @PostMapping("/projects")
    @PreAuthorize("hasRole('ADMIN')")
    public Project createProjects(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/projects/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") long id,
                                                 @Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
        project.setId(projectDetails.getId());
        project.setName(projectDetails.getName());
        project.setLocation(projectDetails.getLocation());
        project.setTotalCost(projectDetails.getTotalCost());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        final Project updatedProject = projectRepository.save(project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/projects/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteProjects(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));

        projectRepository.delete(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
