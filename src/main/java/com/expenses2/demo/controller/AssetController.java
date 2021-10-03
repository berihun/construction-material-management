package com.expenses2.demo.controller;

import com.expenses2.demo.model.Asset;
import com.expenses2.demo.repository.AssetRepository;
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
public class AssetController {
    @Autowired
    AssetRepository assetRepository;

    @GetMapping("/assets")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @GetMapping("/assets/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Asset> getAssetsById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + id));
        return ResponseEntity.ok().body(asset);
    }

    @PostMapping("/assets")
    @PreAuthorize("hasRole('ADMIN')")
    public Asset createAssets(@Valid @RequestBody Asset asset) {
        return assetRepository.save(asset);
    }

    @PutMapping("/assets/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Asset> updateAssets(@PathVariable(value = "id") long id,
                                              @Valid @RequestBody Asset assetDetails) throws ResourceNotFoundException {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + id));
        asset.setId(assetDetails.getId());
        asset.setName(assetDetails.getName());
        asset.setVersion(assetDetails.getVersion());
        asset.setVendor(assetDetails.getVendor());
        asset.setYearOfDevelopment(assetDetails.getYearOfDevelopment());
        asset.setYearOfDevelopment(assetDetails.getYearOfDeployment());
        final Asset updatedAsset = assetRepository.save(asset);
        return ResponseEntity.ok(updatedAsset);
    }

    @DeleteMapping("/assets/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteAssets(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + id));

        assetRepository.delete(asset);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
