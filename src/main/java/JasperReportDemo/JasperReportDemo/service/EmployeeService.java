package JasperReportDemo.JasperReportDemo.service;

import JasperReportDemo.JasperReportDemo.entity.Employee;
import java.util.List;

public interface EmployeeService {
  List<Employee> getAllEmployees();
  String exportReport() throws Exception;
}
