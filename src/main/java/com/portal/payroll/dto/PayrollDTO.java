package com.portal.payroll.dto;

import com.portal.payroll.model.Payroll;


public class PayrollDTO {

    private Integer payrollId;
    private Integer employeeId;
    private String registeredBank;
    private String bankAccountNumber;
    private Double monthlySalary;

    public PayrollDTO() {

    }

    public PayrollDTO(Integer payrollId, Integer employeeId, String registeredBank, String bankAccountNumber, Double monthlySalary) {
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

    public static PayrollDTO convertToDTO(Payroll payroll) {
        return new PayrollDTO(payroll.getPayrollId(), payroll.getEmployeeId(), payroll.getRegisteredBank(), payroll.getBankAccountNumber(), payroll.getMonthlySalary());
    }

    @Override
    public String toString() {
        return "PayrollDTO{" +
                "payrollId=" + payrollId +
                ", employeeId=" + employeeId +
                ", registeredBank='" + registeredBank + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", monthlySalary=" + monthlySalary +
                '}';
    }
}
