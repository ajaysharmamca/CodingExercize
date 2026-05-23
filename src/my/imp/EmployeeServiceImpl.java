package my.imp;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    @Override
    public boolean deleteEmployee(int empId) {
        Employee employee = getEmployee(empId);
        return employees.remove(employee);
    }

    @Override
    public Employee getEmployee(int empId) {
        List<Employee> list = employees.stream().filter(e -> e.id() == empId).toList();
        return list.get(0);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
