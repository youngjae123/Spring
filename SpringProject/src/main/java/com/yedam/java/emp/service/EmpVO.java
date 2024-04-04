package com.yedam.java.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	//@Data부터 작성 후 시작
	
	private Integer employeeId;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	@Override
	public String toString() {
		return "EmpVO [employeeId=" + employeeId + ", lastName=" + lastName + ", email=" + email + ", hireDate="
				+ hireDate + ", jobId=" + jobId + "]";
	}
	
}
