package chung.manager.service;

import chung.manager.entities.EmployeeInfo;

public interface EmployeeInfoService {
    EmployeeInfo queryByUsername(String username);
}
