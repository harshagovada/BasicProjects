/**
 * 
 */
package com.company.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.company.services.dao.EmployeeInfoDao;
import com.company.services.dao.TimesheetInfoDao;
import com.company.services.entity.EmployeeTimesheets;
import com.company.services.service.EmployeeService;

/**
 * @author Harsha Govada
 *
 * 
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private TimesheetInfoDao timesheetRepo;

	@Autowired
	private EmployeeInfoDao employeeInfoRepo;

	@SuppressWarnings("deprecation")
	@Override
	public List<EmployeeTimesheets> getTimeSheetByEmployee(String employeeId, String fromDate, String toDate)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			if (StringUtils.isEmpty(employeeId)) {
				return null;
			}
			if (StringUtils.isEmpty(fromDate) || StringUtils.isEmpty(toDate)) {
				return timesheetRepo.findByEmployeeId(employeeId);
			} else
				return timesheetRepo.findByEmployeeIdAndWeekBeginDateAndWeekEndDate(employeeId, fromDate, toDate);
		} catch (Exception e) {
			throw (new Exception("Invalid input data"));
		}
	}

	@Override
	public String submitTimeSheetByEmployee(EmployeeTimesheets employeeTimesheets) throws Exception {
		// TODO Auto-generated method stub
		try {
			Integer id = (int) (new Date().getTime() / 1000);
			employeeTimesheets.setId(id.toString());
			employeeTimesheets.setStatus("Submitted");
			employeeTimesheets.setSubmittedTime((new Date()).toString());
			timesheetRepo.save(employeeTimesheets);

			return "Successfully submitted timesheet for "
					+ employeeInfoRepo.findById(employeeTimesheets.getEmployeeId()).get().getFirstName() + " "
					+ employeeInfoRepo.findById(employeeTimesheets.getEmployeeId()).get().getLastName()
					+ " with confirmation id " + id;
		} catch (Exception e) {
			throw (new Exception("Invalid input data"));
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Object> approveTimeSheet(EmployeeTimesheets employeeTimesheets) throws Exception {
		// TODO Auto-generated method stub
		try {
			if (!StringUtils.isEmpty(employeeTimesheets.getId()) && !StringUtils.isEmpty(employeeTimesheets.getStatus())
					&& !StringUtils.isEmpty(employeeTimesheets.getEmployeeId())) {
				List<Object> approvalStatus = new ArrayList<Object>();

				if (employeeInfoRepo.findById(employeeTimesheets.getEmployeeId()).get().getRole().equals("A")) {
					approvalStatus.add("Only Manager can approve/reject the timesheets");
					approvalStatus.add(timesheetRepo.findById(employeeTimesheets.getId()));
				} else {
					EmployeeTimesheets existingTimesheet = timesheetRepo.findById(employeeTimesheets.getId())
							.orElse(null);
					existingTimesheet.setStatus(employeeTimesheets.getStatus());
					approvalStatus.add("Timesheet " + employeeTimesheets.getId() + " has been "
							+ employeeTimesheets.getStatus() + " by "
							+ employeeInfoRepo.findById(employeeTimesheets.getEmployeeId()).get().getFirstName() + " "
							+ employeeInfoRepo.findById(employeeTimesheets.getEmployeeId()).get().getLastName());
					approvalStatus.add(timesheetRepo.save(existingTimesheet));

					if (employeeTimesheets.getStatus().equals("Rejected"))
						timesheetRepo.deleteById(employeeTimesheets.getId());
				}
				return approvalStatus;
			} else
				return null;
		} catch (Exception e) {
			throw (new Exception("Invalid input data"));
		}
	}

}
