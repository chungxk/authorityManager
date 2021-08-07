package chung.manager.mapper;

import chung.manager.entities.EmployeeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo> {
    EmployeeInfo queryByUsername(String username);
}
