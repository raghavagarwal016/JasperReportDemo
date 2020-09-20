package JasperReportDemo.JasperReportDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
  @Id
  private String id;
  private String name;
  private String department;
  private String profile;
  private double salary;
}
