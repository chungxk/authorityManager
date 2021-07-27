package chung.manager.entities;

import lombok.*;

import java.io.Serializable;
/*员工信息表*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee implements Serializable {
    /*工号*/
    private Integer empId;
    /*员工名*/
    private String empName;
    /*年龄*/
    private Integer empAge;
    /*婚姻状态*/
    private Integer marriage;
    /*入职日期*/
    private String entryDate;
    /*账号*/
    private String empUsername;
    /*密码*/
    private String password;
    /*籍贯*/
    private String nativePlace;
    /*出生日期*/
    private String birthday;
    /*政治面貌*/
    private String politicalOutlook;
    /*部门id*/
    private Department deptId;
    /*性别*/
    private Integer gender;
    /*手机号码*/
    private String tel;
    /*学历id*/
    private Integer eduId;
    /*毕业学校*/
    private String graduationSchool;
    /*身份证号码*/
    private String idNumber;
    /*职位id*/
    private Position posId;
    /*合同开始时间*/
    private String contractStartDate;
    /*合同结束时间*/
    private String contractEndDate;
}
