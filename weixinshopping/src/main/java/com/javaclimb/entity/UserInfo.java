package com.javaclimb.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

/**
 * Database Table Remarks:
 *   用户信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user_info
 */
@Table(name = "user_info")
public class UserInfo {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Database Column Remarks:
     *   姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * Database Column Remarks:
     *   昵称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.nickName
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     * Database Column Remarks:
     *   性别
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * Database Column Remarks:
     *   年龄
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     * Database Column Remarks:
     *   生日
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.birthday
     *
     * @mbg.generated
     */
    private String birthday;

    /**
     * Database Column Remarks:
     *   手机号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * Database Column Remarks:
     *   地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     * Database Column Remarks:
     *   邮编
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.code
     *
     * @mbg.generated
     */
    private String code;

    /**
     * Database Column Remarks:
     *   电子邮便
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     * Database Column Remarks:
     *   身份证
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.carId
     *
     * @mbg.generated
     */
    private String carid;

    /**
     * Database Column Remarks:
     *   权限等级（1管理员 2卖家 3买家）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.level
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * Database Column Remarks:
     *   余额
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.account
     *
     * @mbg.generated
     */
    private Double account;

    @Transient
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.name
     *
     * @return the value of user_info.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.name
     *
     * @param name the value for user_info.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.password
     *
     * @return the value of user_info.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.password
     *
     * @param password the value for user_info.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.nickName
     *
     * @return the value of user_info.nickName
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.nickName
     *
     * @param nickname the value for user_info.nickName
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.sex
     *
     * @return the value of user_info.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.sex
     *
     * @param sex the value for user_info.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.age
     *
     * @return the value of user_info.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.age
     *
     * @param age the value for user_info.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.birthday
     *
     * @return the value of user_info.birthday
     *
     * @mbg.generated
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.birthday
     *
     * @param birthday the value for user_info.birthday
     *
     * @mbg.generated
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.phone
     *
     * @return the value of user_info.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.phone
     *
     * @param phone the value for user_info.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.address
     *
     * @return the value of user_info.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.address
     *
     * @param address the value for user_info.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.code
     *
     * @return the value of user_info.code
     *
     * @mbg.generated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.code
     *
     * @param code the value for user_info.code
     *
     * @mbg.generated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.email
     *
     * @return the value of user_info.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.email
     *
     * @param email the value for user_info.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.carId
     *
     * @return the value of user_info.carId
     *
     * @mbg.generated
     */
    public String getCarid() {
        return carid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.carId
     *
     * @param carid the value for user_info.carId
     *
     * @mbg.generated
     */
    public void setCarid(String carid) {
        this.carid = carid == null ? null : carid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.level
     *
     * @return the value of user_info.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.level
     *
     * @param level the value for user_info.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.account
     *
     * @return the value of user_info.account
     *
     * @mbg.generated
     */
    public Double getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.account
     *
     * @param account the value for user_info.account
     *
     * @mbg.generated
     */
    public void setAccount(Double account) {
        this.account = account;
    }
}