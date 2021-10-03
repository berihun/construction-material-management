package com.expenses2.demo.controller;

import com.expenses2.demo.model.Company;
import com.expenses2.demo.repository.CompanyRepository;
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
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/companies")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/companies/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Company> getCompaniesById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
        return ResponseEntity.ok().body(company);
    }

    @PostMapping("/companies")
    @PreAuthorize("hasRole('ADMIN')")
    public Company createCompanies(@Valid @RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("/companies/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Company> updateCompanies(@PathVariable(value = "id") long id,
                                                   @Valid @RequestBody Company companyDetails) throws ResourceNotFoundException {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
        company.setId(companyDetails.getId());
        company.setName(companyDetails.getName());
        company.setCity(companyDetails.getCity());
        company.setPhone(companyDetails.getPhone());
        company.setEmail(companyDetails.getEmail());

        final Company updatedCompany = companyRepository.save(company);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/companies/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteCompanies(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));

        companyRepository.delete(company);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
