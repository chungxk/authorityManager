package chung.manager.entities;

import lombok.*;

import java.io.Serializable;
/*部门表*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Department implements Serializable {
    /*部门id*/
    private Integer deptId;
    /*部门名*/
    private String deptName;
    /*创建时间*/
    private String createDate;
    /*备注*/
    private String remark;
}
