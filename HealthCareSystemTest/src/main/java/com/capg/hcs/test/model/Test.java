package com.capg.hcs.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "test_info")
public class Test {
	
	@Id
    private String testId;
    private String testName;
    private int testPrice;
    private String diagnosticCentre;
	public Test() {
		super();
	}

	public Test(String testName, String testId, int testPrice,String diagnosticCentre ) {
		super();
		this.testName = testName;
		this.testId = testId;
		this.setTestPrice(testPrice);
		this.setDiagnosticCentre(diagnosticCentre);
		this.diagnosticCentre=diagnosticCentre;
	}
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "DiagnosticTest [testName=" + testName + ", testId=" + testId + ", testPrice="+testPrice+",diagnosticCentre="+diagnosticCentre+"]";
	}

	public int getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}

	public String getDiagnosticCentre() {
		return diagnosticCentre;
	}

	public void setDiagnosticCentre(String diagnosticCentre) {
		this.diagnosticCentre = diagnosticCentre;
	}
   
}
