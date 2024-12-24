/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blacksilicon.rsa.encrypt;

/**
 *
 * @author mubarakanifowose
 */
public class NettCardPojo {

    private String card_number;
    private String cvv;
    private String expMonth;
     private String expYear;
    private String email;
    private String fullname;
    private String pin;

    /**
     * @return the card_number
     */
    public String getCard_number() {
        return card_number;
    }

    /**
     * @param card_number the card_number to set
     */
    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    /**
     * @return the cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * @return the expMonth
     */
    public String getExpMonth() {
        return expMonth;
    }

    /**
     * @param expMonth the expMonth to set
     */
    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    /**
     * @return the expYear
     */
    public String getExpYear() {
        return expYear;
    }

    /**
     * @param expYear the expYear to set
     */
    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
}
