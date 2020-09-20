package JasperReportDemo.JasperReportDemo.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import JasperReportDemo.JasperReportDemo.entity.Employee;
import JasperReportDemo.JasperReportDemo.repository.EmployeeRepository;
import JasperReportDemo.JasperReportDemo.service.EmployeeService;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;


  @PostConstruct
  public void initDb() {
    employeeRepository.deleteAll();
    IntStream.range(1, 101)
        .mapToObj(i -> new Employee(UUID.randomUUID().toString(), "NAME" + i, "DEPARTMENT" + i, "PROFILE" + i, 10000.0))
        .forEach(employee -> employeeRepository.save(employee));
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public String exportReport() throws Exception {
    List<Employee> employees = getAllEmployees();
    Map<String, Object> map = new HashMap<>();
    map.put("createdBy", "Raghav Agarwal");
    File file = ResourceUtils.getFile("classpath:emploees.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employees);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,jrBeanCollectionDataSource);
    JasperExportManager.exportReportToPdfFile(jasperPrint, "employees.pdf");
    return "report generated";
  }

}
