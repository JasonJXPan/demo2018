package com.pjx.demo2018.learning.imp;

import com.pjx.demo2018.domain.Employee;
import com.pjx.demo2018.learning.interfaces.MyPredicate;

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>=20;
    }
}
