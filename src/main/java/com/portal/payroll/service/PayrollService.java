package com.portal.payroll.service;

import com.portal.payroll.dto.PayrollDTO;
import com.portal.payroll.model.Payroll;
import com.portal.payroll.repository.IPayrollRepository;
import com.portal.payroll.utility.PayrollInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollService implements IPayrollService {

    @Autowired
    private IPayrollRepository payrollRepository;

    public PayrollDTO getPayrollInfoByEmployeeId(Integer employeeId) throws PayrollInfoException {
        Payroll payroll = payrollRepository.findByEmployeeId(employeeId);
        if (payroll == null) {
            throw new PayrollInfoException("Payroll Information not found for the employee ID: " + employeeId);
        }
        return PayrollDTO.convertToDTO(payroll);
    }

    public void updatePayrollInfo(Integer employeeId, Double updatedCTC) throws PayrollInfoException {
        PayrollDTO payrollDTO = getPayrollInfoByEmployeeId(employeeId);
        payrollDTO.setMonthlySalary(updatedCTC / 12.0d);
        payrollRepository.save(Payroll.convertToEntity(payrollDTO));
    }

    public void createPayrollInfo(PayrollDTO payrollDTO) {
        payrollRepository.save(Payroll.convertToEntity(payrollDTO));
    }
}
