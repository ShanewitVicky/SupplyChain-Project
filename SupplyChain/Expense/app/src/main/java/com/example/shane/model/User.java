package com.example.shane.model;

/**
 *
 */
  import java.io.Serializable;
  import java.util.Date;

/**
 * @author Shane
 *
 */
public class User implements Serializable{

    private int usrId;
    private String usrName;
    private String firstName;
    private String lastName;
    private String password;
    private String emailId;
    private String phNumber1;
    private String Url;
    private String address;
    private byte[] salt;

    /**
     * @param usrName
     * @param firstName
     * @param lastName
     * @param password
     * @param emailId
     * @param phNumber1
     * @param Url
     * @param address
     * @param dob
     */






    /**
     * @param usrName
     * @param password
     */
    public User(String usrName, String password) {

        this.usrName = usrName;
        this.password = password;
    }


    public User(int usrId, String usrName, String password, String firstName, String lastName, String emailId, String phNumber1, String url, String address) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailId = emailId;
        this.phNumber1 = phNumber1;
        Url = url;
        this.address = address;

    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordField() {
        return password;
    }

    public void setPasswordField(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhNumber1() {
        return phNumber1;
    }

    public void setPhNumber1(String phNumber1) {
        this.phNumber1 = phNumber1;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    /* (non-Javadoc)
             * @see java.lang.Object#toString()
             */
    @Override
    public String toString() {
        return "UserName" + this.getUsrName() + "FirstName=" + this.getFirstName() + "LastName="
                + this.getLastName() + ",Password=" + this.getPasswordField() + "EmailId=" + this.getEmailId()
                + "PhNumber1=" + this.getPhNumber1() + "Url=" + this.getUrl() + "Address"
                + this.getAddress()+"]";
    }





}
