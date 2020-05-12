package com.capg.hcs.test.service;



import java.util.List;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcs.test.exception.ListisEmptyException;
import com.capg.hcs.test.exception.TestAlreadyExistException;
import com.capg.hcs.test.exception.TestNotFoundException;
import com.capg.hcs.test.model.Test;
import com.capg.hcs.test.repository.TestRepo;


@Service
public class TestServiceImpl implements TestService{
	
    @Autowired
	TestRepo testRepo;
    @Autowired
    Random random;
    /**
     * Method Name___________:addTest(Test test)
     * Method Description____:To add the test details in the database
     * Method Input Parameter:Test
     * Return Type___________:Test Object
     * Method Last Modified__:06/05/2020
     */
    @Override
    public Test addTest(Test test) {
    	test.setTestId(Integer.toString(random.nextInt(10000000)).substring(0,5));
    	
    	if(testRepo.existsById(test.getTestId())) {
			throw new TestAlreadyExistException("["+test.getTestId()+"] already exists");
		}
    	
		return testRepo.save(test);
	}
    /**
     * Method Name___________:removeTest(Test test)
     * Method Description____:To remove the test from the database
     * Method Input Parameter:Test
     * Return Type___________:boolean
     * Method Last Modified__:06/05/2020
     */
    @Override
	public boolean removeTest(Test test) {
		
		if(!testRepo.existsById(test.getTestId())) {
			throw new TestNotFoundException("["+test.getTestId()+"] is Not Found"); 
		}
		
		testRepo.deleteById(test.getTestId());
	    
	    return !testRepo.existsById(test.getTestId());
	}
	/**
     * Method Name___________:getAllTest()
     * Method Description____:To retrieve all the tests in the database
     * Method Input Parameter:None
     * Return Type___________:Test
     * Method Last Modified__:06/05/2020
     */
	@Override
	public List<Test> getAllTests(){
		
		if(testRepo.findAll().isEmpty()) {
			throw new ListisEmptyException("List is empty");
		}
		
		return testRepo.findAll();
	}
	/**
     * Method Name___________:getTestById(String testId)
     * Method Description____:To retrieve the test details using testId from the database
     * Method Input Parameter:testId
     * Return Type___________:Test
     * Method Last Modified__:06/05/2020
     */
    @Override
	public Test getTestById(String testId) {
	
		if(!testRepo.existsById(testId)) {
			throw new TestNotFoundException("["+testId+"] is Not Found"); 
		}
		return testRepo.getOne(testId);
	
	}
    /**
     * Method Name___________:removeAllTest()
     * Method Description____:To remove all the tests from the database
     * Method Input Parameter:
     * Return Type___________:Test
     * Method Last Modified__:06/05/2020
     */
    @Override
	public boolean removeAllTests() {
	
		testRepo.deleteAll();
		
		return true;
	}
    @Override
    public Test getTestByDiagnosticCentre(String diagnosticCentre)
    {
    	if(!testRepo.existsByDiagnosticCentre(diagnosticCentre)) {
			throw new TestNotFoundException("["+diagnosticCentre+"] is Not Found"); 
		}
		
		return testRepo.getOne(diagnosticCentre);
    	
    	
    	
    }
}
