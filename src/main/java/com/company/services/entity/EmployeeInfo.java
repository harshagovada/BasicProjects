/**
 * 
 */
package com.company.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Harsha Govada
 *
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_info")
public class EmployeeInfo {
	@Id
	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "employee_firstName")
	private String firstName;

	@Column(name = "employee_lastName")
	private String lastName;

	@Column(name = "employee_role")
	private String role;

	@Column(name = "employee_projectCode")
	private String projectCode;

	@Column(name = "employee_managerId")
	private String managerId;

}
