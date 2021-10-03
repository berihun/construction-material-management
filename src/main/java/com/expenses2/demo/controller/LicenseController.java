package com.expenses2.demo.controller;

import java.net.URLEncoder;
import java.net.URL;

import com.expenses2.demo.model.License;
import com.expenses2.demo.repository.LicenseRepository;
import com.expenses2.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@EnableScheduling
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class LicenseController {
    @Autowired
    LicenseRepository licenseRepository;

    @GetMapping("/licenses")
    @PreAuthorize("hasRole('ADMIN')")
    public List<License> getAllLicenses() {
        return licenseRepository.findAll();
    }

    @GetMapping("/licenses/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<License> getDeviceById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        License license = licenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("License not found for this id :: " + id));
        return ResponseEntity.ok().body(license);
    }

    @PostMapping("/licenses")
    @PreAuthorize("hasRole('ADMIN')")
    public License createLicenses(@Valid @RequestBody License license) {
        return licenseRepository.save(license);
    }

    @PutMapping("/licenses/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<License> updateLicenses(@PathVariable(value = "id") long id,
                                                  @Valid @RequestBody License licenseDetails) throws ResourceNotFoundException {
        License license = licenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("License not found for this id :: " + id));
        license.setId(licenseDetails.getId());
        license.setLicenceNumber(licenseDetails.getLicenceNumber());
        license.setCapacity(licenseDetails.getCapacity());
        license.setAmount(licenseDetails.getAmount());
        license.setLicenceType(licenseDetails.getLicenceType());
        license.setStartDate(licenseDetails.getStartDate());

        license.setExpiryDate(licenseDetails.getExpiryDate());
        license.setRemark(licenseDetails.getRemark());
        final License updatedLicense = licenseRepository.save(license);
        return ResponseEntity.ok(updatedLicense);
    }

    @DeleteMapping("/licenses/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteLicenses(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        License license = licenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("License not found for this id :: " + id));

        licenseRepository.delete(license);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @GetMapping("/licenses/expire")
//    @Scheduled(fixedRate = 1000)
    @PreAuthorize("hasRole('ADMIN')")
    public String reSendSms() {
        String message = "";
        try {

            String recipient = "0913016940";
            message = "Dear  Berihun, T24 license  will be expired on Aug 15, 2020 [test]";
            String username = "boa";
            String password = "boa";
            String requestUrl = "http://10.1.18.37/sendsms.php?"
                    + "user=" + URLEncoder.encode(username, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                    + "&text=" + URLEncoder.encode(message, "UTF-8")
                    + "&to=" + URLEncoder.encode(recipient, "UTF-8");
            URL url = new URL(requestUrl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();

            System.out.println(uc.getResponseMessage());
            uc.disconnect();

//            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message = "error to send message";
        }
        return message;
    }
}
