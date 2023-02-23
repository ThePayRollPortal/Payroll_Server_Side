package com.portal.payroll.controller;

import com.portal.payroll.dto.PayrollDTO;
import com.portal.payroll.service.IPayrollService;
import com.portal.payroll.utility.PayrollInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class PayrollInfoController {

    @Autowired
    private IPayrollService payrollService;

    @GetMapping(value = "details/{employeeId}")
    public ResponseEntity<PayrollDTO> getPayrollDetailsByEmployeeId(@PathVariable Integer employeeId) throws PayrollInfoException {
        PayrollDTO payrollDTO = payrollService.getPayrollInfoByEmployeeId(employeeId);
        return new ResponseEntity<>(payrollDTO, HttpStatus.OK);
    }

    @PostMapping(value = "details")
    public ResponseEntity<String> createPayrollInfo(@RequestBody PayrollDTO payrollDTO) {
        payrollService.createPayrollInfo(payrollDTO);
        return new ResponseEntity<>("Created Payroll info for employeeId: "+payrollDTO.getEmployeeId(), HttpStatus.CREATED);
    }
}
