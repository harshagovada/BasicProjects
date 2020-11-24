/**
 * 
 */
package com.company.services.service;

import java.util.List;

import com.company.services.entity.EmployeeTimesheets;

/**
 * @author Harsha Govada
 *
 * 
 */
public interface EmployeeService {

	/**
	 * @param employeeTimesheets
	 * @return
	 */
	public List<EmployeeTimesheets> getTimeSheetByEmployee(String id,String fromDate,String toDate) throws Exception;

	/**
	 * @param employeeTimesheets
	 * @return
	 */
	public String submitTimeSheetByEmployee(EmployeeTimesheets employeeTimesheets) throws Exception;

	/**
	 * @param employeeTimesheets
	 * @return
	 */
	public List<Object> approveTimeSheet(EmployeeTimesheets employeeTimesheets) throws Exception;

}
