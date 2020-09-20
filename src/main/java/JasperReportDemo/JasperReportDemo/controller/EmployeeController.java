package JasperReportDemo.JasperReportDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import JasperReportDemo.JasperReportDemo.entity.Employee;
import JasperReportDemo.JasperReportDemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
  }

  @GetMapping("/get-report")
  public ResponseEntity<String> generateReport() throws Exception {
    return new ResponseEntity<>(employeeService.exportReport(), HttpStatus.OK);
  }

}
