package chung.manager.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@TableName("sys_const")
public class SysConst {
    /*id*/
    private Integer id;
    /*常量名*/
    private String constName;
    /*序号*/
    private Integer serialNumber;
    /*旧常量名*/
    private String oldConstName;
}
