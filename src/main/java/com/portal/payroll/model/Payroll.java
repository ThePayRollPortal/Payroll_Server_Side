package com.portal.payroll.model;

import com.portal.payroll.dto.PayrollDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payroll {

    @Id
    private Integer payrollId;
    private Integer employeeId;
    private String registeredBank;
    private String bankAccountNumber;
    private Double monthlySalary;

    public Payroll() {

    }

    public Payroll(Integer payrollId, Integer employeeId, String registeredBank, String bankAccountNumber, Double monthlySalary) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.registeredBank = registeredBank;
        this.bankAccountNumber = bankAccountNumber;
        this.monthlySalary = monthlySalary;
    }

    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getRegisteredBank() {
        return registeredBank;
    }

    public void setRegisteredBank(String registeredBank) {
        this.registeredBank = registeredBank;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public static Payroll convertToEntity(PayrollDTO payrollDTO) {
        return new Payroll(payrollDTO.getPayrollId(), payrollDTO.getEmployeeId(), payrollDTO.getRegisteredBank(), payrollDTO.getBankAccountNumber(), payrollDTO.getMonthlySalary());
    }
}
