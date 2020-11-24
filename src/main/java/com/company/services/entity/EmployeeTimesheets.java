/**
 * 
 */
package com.company.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@Table(name = "employee_timesheets")
public class EmployeeTimesheets {
	@Id
	@Column(name="timesheet_id")
	private String id;
	
	@Column(name="employee_id")
	private String employeeId;
	
	@Column(name="timesheet_status")
	private String status;
	
	@Column(name="timesheet_weekBeginDate")
	private String weekBeginDate; 
	
	@Column(name="timesheet_weekEndDate")
	private String weekEndDate; 
	
	@Column(name="timesheet_projectCode")
	private String projectCode;
	
	@Column(name="timesheet_activity")
	private String activity;
	
	@Column(name="timesheet_MON")
	private Float mon;
	
	@Column(name="timesheet_TUE")
	private Float tue;
	
	@Column(name="timesheet_WED")
	private Float wed;
	
	@Column(name="timesheet_THU")
	private Float thu;
	
	@Column(name="timesheet_FRI")
	private Float fri;
	
	@Column(name="timesheet_SAT")
	private Float sat;
	
	@Column(name="timesheet_SUN")
	private Float sun;
	
	@Column(name="timesheet_submittedTime")
	private String submittedTime;
	
	@Column(name="timesheet_totalHoursOnProject")
	private Float totalHoursonProject; 
	
}
