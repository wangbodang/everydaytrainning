package util.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class User extends BaseRowModel {
    /** id */
    @ExcelProperty(index = 0 , value = "id")
    private String id;
    /** 姓名 **/
    @ExcelProperty(index = 1 , value = "姓名")
    private String name;
    /** 生日 **/
    @ExcelProperty(index = 2 , value = "生日" , format = "yyyy-MM-dd")
    private String birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
