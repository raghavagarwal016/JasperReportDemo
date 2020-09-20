package JasperReportDemo.JasperReportDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import JasperReportDemo.JasperReportDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
