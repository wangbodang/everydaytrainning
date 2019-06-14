package base.annotation;

import common.annotation.Column;
import common.annotation.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("student")
public class Student {
    @Column("id")
    private int id;
    @Column("user_name")
    private String username;
    @Column("age")
    private int age;
    @Column("city")
    private String city;
    @Column("phone")
    private String phone;

}
