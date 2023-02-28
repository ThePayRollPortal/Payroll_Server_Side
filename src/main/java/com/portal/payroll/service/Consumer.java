package com.portal.payroll.service;

import com.portal.payroll.utility.PayrollInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    IPayrollService payrollService;

    @KafkaListener(topics = "employee_payroll_topic", groupId = "employee_payroll_group")
    public void receiveMessage(String message) throws PayrollInfoException {
        Double updatedCTC;
        Integer employeeId;
        try {
            String[] rd = message.split(":");
            updatedCTC = Double.parseDouble(rd[1].strip());
            employeeId = Integer.parseInt(rd[3].strip());
            payrollService.updatePayrollInfo(employeeId, updatedCTC);
        } catch (NumberFormatException ex) {
            throw new PayrollInfoException("Invalid format message");
        }
    }
}
