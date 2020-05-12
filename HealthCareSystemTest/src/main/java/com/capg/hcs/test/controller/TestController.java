package com.capg.hcs.test.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcs.test.model.Test;
import com.capg.hcs.test.model.TestList;
import com.capg.hcs.test.service.TestServiceImpl;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	TestServiceImpl service;
	
	@GetMapping("/tests")
	public TestList getAllTests(){
		return new TestList(service.getAllTests());
	}
	@GetMapping("/tests/{testId}")
	public Test getTest(@PathVariable String testId){
		return service.getTestById(testId);
	}
	@PostMapping("/tests")
	public ResponseEntity<Test> addTest(@RequestBody Test test) {
		return new ResponseEntity<Test>(service.addTest(test), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/tests/{testId}")
	public boolean removeTest(@PathVariable String testId) {
		Test test=getTest(testId);
		return service.removeTest(test);
	}
	
	@DeleteMapping("/tests")
	public String removeAllTests() {
		service.removeAllTests();
		return "All Test Removed";
	}
	@GetMapping("/tests/diag/{diagnosticCentre}")
	public Test getTestByDiagnosticCentre(@PathVariable String diagnosticCentre){
		return service.getTestByDiagnosticCentre(diagnosticCentre);
	}
	
}
