package com.capg.hcs.test.service;

import java.util.List;

import com.capg.hcs.test.model.Test;


public interface TestService {
	
	Test addTest(Test test);
    
	List<Test> getAllTests();
	
	Test getTestById(String testId);
	
	boolean removeAllTests();
	
	boolean removeTest(Test test);
	
    Test getTestByDiagnosticCentre(String diagnisticCentre);
}
