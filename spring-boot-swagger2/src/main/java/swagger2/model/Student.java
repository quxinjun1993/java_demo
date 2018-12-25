package swagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("学生实体类")
public class Student {

    @ApiModelProperty(value = "学生id",name = "id")
    private int id;

    @ApiModelProperty(value = "学生姓名",name = "name")
    private String name;

    @ApiModelProperty(value = "学生年龄",name = "age")
    private int age;

    @ApiModelProperty(value = "学生邮箱",name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
