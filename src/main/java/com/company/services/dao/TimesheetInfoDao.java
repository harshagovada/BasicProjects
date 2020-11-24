/**
 * 
 */
package com.company.services.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.services.entity.EmployeeTimesheets;

/**
 * @author Harsha Govada
 *
 * 
 */
public interface TimesheetInfoDao extends JpaRepository<EmployeeTimesheets, String> {

	/**
	 * @param employeeId
	 * @return
	 */
	List<EmployeeTimesheets> findByEmployeeId(String employeeId);
	
	//@Query("select * from employee_timesheets t where t.employeeId ='?1'")
	List<EmployeeTimesheets> findByEmployeeIdAndWeekBeginDateAndWeekEndDate(String employeeId, String fromDate, String toDate);

}
