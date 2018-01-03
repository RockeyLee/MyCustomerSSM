package com.rockey.ssm.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rockey.ssm.controller.validation.IAddAndModifyCustomer;
import com.rockey.ssm.controller.validation.IFindCustomerByConds;

public class Customer {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.id
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.name
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    @Size(min=3,max=20,message="{customer.name.length.wrong}",groups={IAddAndModifyCustomer.class,IFindCustomerByConds.class})
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.gender
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.birthday
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    private String birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cellphone
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    @Size(min=3,max=20,message="{customer.name.length.wrong}",groups={IAddAndModifyCustomer.class,IFindCustomerByConds.class})
    private String cellphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.email
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.preference
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    private String preference;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.type
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.description
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    @Size(min=0,max=255,message="{customer.description.length.wrong}",groups={IAddAndModifyCustomer.class})
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.id
     *
     * @return the value of customer.id
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.id
     *
     * @param id the value for customer.id
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.name
     *
     * @return the value of customer.name
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.name
     *
     * @param name the value for customer.name
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.gender
     *
     * @return the value of customer.gender
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.gender
     *
     * @param gender the value for customer.gender
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.birthday
     *
     * @return the value of customer.birthday
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.birthday
     *
     * @param birthday the value for customer.birthday
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cellphone
     *
     * @return the value of customer.cellphone
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cellphone
     *
     * @param cellphone the value for customer.cellphone
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.email
     *
     * @return the value of customer.email
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.email
     *
     * @param email the value for customer.email
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.preference
     *
     * @return the value of customer.preference
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getPreference() {
        return preference;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.preference
     *
     * @param preference the value for customer.preference
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setPreference(String preference) {
        this.preference = preference == null ? null : preference.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.type
     *
     * @return the value of customer.type
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.type
     *
     * @param type the value for customer.type
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.description
     *
     * @return the value of customer.description
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.description
     *
     * @param description the value for customer.description
     *
     * @mbggenerated Wed Dec 27 22:51:57 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}