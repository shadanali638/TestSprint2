package com.capg.hcs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcs.test.model.Test;

public interface TestRepo extends JpaRepository<Test, String>{

	boolean existsByDiagnosticCentre(String diagnosticCentre);

}
