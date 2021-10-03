package com.expenses2.demo.controller;

import com.expenses2.demo.exception.ResourceNotFoundException;
import com.expenses2.demo.model.User;
import com.expenses2.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }


    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public User createDevices(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") long id,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        user.setId(userDetails.getId());
        user.setEmpid(userDetails.getEmpid());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setServiceUseId(userDetails.getServiceUseId());
        user.setEmail(userDetails.getEmail());
        user.setMobilePhone(userDetails.getMobilePhone());
        user.setWorkUnitId(userDetails.getWorkUnitId());
        user.setPosition(userDetails.getPosition());
        user.setAdminUserId(userDetails.getAdminUserId());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long id)
            throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/users/alluserid")
    @PreAuthorize("hasRole('ADMIN')")
    public List<String> getAllUserIds() {
        List<String> mm = new ArrayList<>();
        for (User d : userRepository.findAll()) {
            mm.add(d.getServiceUseId());
        }
        return mm;
    }
}
