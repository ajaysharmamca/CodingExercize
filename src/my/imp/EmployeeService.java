package my.imp;

import java.util.List;

public interface EmployeeService {
    public boolean addEmployee(Employee employee);
    public boolean deleteEmployee(int empId);
    public Employee getEmployee(int empId);
    public List<Employee> getAllEmployees();
}
