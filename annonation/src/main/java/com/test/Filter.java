package com.test;

/**
 * Created by $lyl on 2017/8/19.
 */
@Table("UserDB")
public class Filter {

    @Column("id")
    private int id ;
    @Column("userName")
    private String userName;
    @Column("nickName")
    private String nickName;
    @Column("mobile")
    private String mobile;
    @Column("city")
    private String city;
    @Column("email")
    private String email;
    private int age ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
