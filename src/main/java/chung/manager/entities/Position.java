package chung.manager.entities;

import lombok.*;
/*职位表*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Position {
    /*职位id*/
    private Integer posId;
    /*职位名*/
    private String posName;
}
