package com.pjx.demo2018.learning;
import	java.util.function.BiPredicate;
import	java.util.Arrays;
import	java.util.ArrayList;
import com.pjx.demo2018.domain.Employee;
import com.pjx.demo2018.learning.imp.FilterEmployeeByAge;
import com.pjx.demo2018.learning.interfaces.MyPredicate;
import org.junit.Test;

import	java.util.List;
import java.util.function.Consumer;

public class TestLambda {

    List<Employee> employees = Arrays.<Employee> asList(
            new Employee("张三",19, 2000D),
            new Employee("李四",29, 3000D),
            new Employee("王五",39, 4000D),
            new Employee("赵六",49, 5000D)
            );
    @Test
    public void testMain() {
        System.out.println("************传统方式************");
        List<Employee> employees = filterEmployeesByAge(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        System.out.println("------换一种过滤方式，会产生很多冗余的代码--------");
        employees = filterEmployeesBySalary(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        System.out.println("************设计模式方式, 也会产生冗余代码************");
        List<Employee> employees1 = filterEmployeesByPredicate(employees, new FilterEmployeeByAge());
        for (Employee employee : employees1) {
            System.out.println(employee.getName());
        }
        System.out.println("------匿名内部类--------");
        employees1 = filterEmployeesByPredicate(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary()>=3000D;
            }
        });
        for (Employee employee : employees1) {
            System.out.println(employee.getName());
        }
        System.out.println("************lambda表达式************");
        List<Employee> employees2 = filterEmployeesByPredicate(employees, (x) -> x.getAge()>=20);
        employees2.forEach(System.out::println);
        System.out.println("------过滤不同维度--------");
        employees2 = filterEmployeesByPredicate(employees, (x) -> x.getSalary()>=3000D);
        employees2.forEach(System.out::println);

        System.out.println("************stream方式************");
        employees.stream()
                .filter((e) -> e.getSalary() >= 3000D)
                .limit(2)
                .forEach(System.out::println);

        employees.stream()
                .filter((e) -> e.getAge() >= 20)
                .map((e)->e.getName())
                .forEach(System.out :: println);

    }
    private List<Employee> filterEmployeesByPredicate(List<Employee> employees, MyPredicate<Employee> myPredicate) {
        List<Employee> result = new ArrayList<> ();
        for (Employee employee : employees) {
            if (myPredicate.test(employee)) {
                result.add(employee);
            }
        }
        return result;
    }

    private List<Employee> filterEmployeesByAge(List<Employee> employees) {
        List<Employee> result = new ArrayList<> ();
        for (Employee employee : employees) {
            if (employee.getAge() >= 20) {
                result.add(employee);
            }
        }
        return result;
    }

    private List<Employee> filterEmployeesBySalary(List<Employee> employees) {
        List<Employee> result = new ArrayList<> ();
        for (Employee employee : employees) {
            if (employee.getSalary() >= 3000D) {
                result.add(employee);
            }
        }
        return result;
    }
}
