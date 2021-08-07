package chung.manager.service.impl;

import chung.manager.entities.EmployeeInfo;
import chung.manager.mapper.EmployeeInfoMapper;
import chung.manager.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    @Override
    public EmployeeInfo queryByUsername(String username) {
        EmployeeInfo info = employeeInfoMapper.queryByUsername(username);
        return info;
    }
}
