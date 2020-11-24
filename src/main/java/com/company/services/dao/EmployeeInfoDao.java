/**
 * 
 */
package com.company.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.services.entity.EmployeeInfo;

/**
 * @author Harsha Govada
 *
 * 
 */

public interface EmployeeInfoDao extends JpaRepository<EmployeeInfo, String> {

}
