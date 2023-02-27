package com.portal.payroll.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "employee_payroll_topic", groupId = "employee_payroll_group")
    public void receiveMessage(String message){
        System.out.println("MESSAGE: "+message);
    }
}
