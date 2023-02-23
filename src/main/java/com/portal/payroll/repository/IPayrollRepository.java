package com.portal.payroll.repository;

import com.portal.payroll.model.Payroll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IPayrollRepository extends MongoRepository<Payroll, Integer> {

    @Query("{'employeeId':?0}")
    Payroll findByEmployeeId(Integer employeeId);
}
