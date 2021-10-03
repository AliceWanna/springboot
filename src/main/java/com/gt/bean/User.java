package com.gt.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
//@ConfigurationProperties(prefix = "user")
public class User {
    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String password;

    @TableId(type=IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
//    private String userName;
//    private Boolean boss;
//    private Date birth;
//    private Integer age;
//    private Pet pet;
//    private String[] interests;
//    private List<String> animal;
//    private Map<String, Object> score;
//    private Set<Double> salarys;
//    private Map<String, List<Pet>> allPets;
}
