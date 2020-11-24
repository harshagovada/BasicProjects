/**
 * 
 */
package com.company.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.services.entity.EmployeeTimesheets;
import com.company.services.service.EmployeeService;

/**
 * @author Harsha Govada
 *
 * 
 */
@RestController
public class EmployeeActivity {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/timesheetById/{employeeId}")
	public List<EmployeeTimesheets> getTimeSheetInfoByEmployee(@PathVariable String employeeId,
			@RequestParam(required = false ,name = "fromDate") String fromDate, @RequestParam(required = false, name = "toDate") String toDate)
			throws Exception {
		return employeeService.getTimeSheetByEmployee(employeeId, fromDate, toDate);
	}

	@PostMapping("/submitTimeSheet")
	public String submitIndividualTimesheet(@RequestBody EmployeeTimesheets employeeTimesheets) throws Exception {
		return employeeService.submitTimeSheetByEmployee(employeeTimesheets);
	}

	@PutMapping("/approveTimeSheet")
	public List<Object> approveTimeSheet(@RequestBody EmployeeTimesheets employeeTimesheets) throws Exception{
		return employeeService.approveTimeSheet(employeeTimesheets);
	}
}
