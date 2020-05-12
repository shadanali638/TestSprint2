package com.capg.hcs.test.model;

import java.util.List;


public class TestList {

	private List<Test> testList;

	public TestList()
	{
		
	}
	
	public TestList(List<Test> testList) {
		super();
		this.testList = testList;
	}
	
	public List<Test> getTestList() {
		return testList;
	}
	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}
	
	@Override
	public String toString() {
		return "DiagnosticTestList [testList=" + testList + "]";
	}
	
}
