package com.portal.payroll.service;

import com.portal.payroll.dto.PayrollDTO;
import com.portal.payroll.utility.PayrollInfoException;

public interface IPayrollService {

    PayrollDTO getPayrollInfoByEmployeeId(Integer employeeId) throws PayrollInfoException;

    void updatePayrollInfo(Integer employeeId, Double updatedCTC) throws PayrollInfoException;

    void createPayrollInfo(PayrollDTO payrollDTO);

}
