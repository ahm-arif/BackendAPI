package com.dev.wellness.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.wellness.models.ERole;
import com.dev.wellness.models.Role;
import com.dev.wellness.repositories.RoleRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TestController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}


	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/admin1")
	public Optional<Role> findAdminByName(@RequestParam String name) {
		return roleRepository.findByName(ERole.ROLE_ADMIN);
	}

	// @GetMapping("/user/me")
    // @PreAuthorize("hasRole('ADMIN')")
    // public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
    //     return userRepository.findById(userPrincipal.getId())
    //             .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    // }
}
