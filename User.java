//https://github.com/AsfariaChowdhury/NSUACM-WCodingMarathonBank

/*
    NSU ACM-W Coding Marathon 2020
    Asfaria CHOWDHURY
*/
package bank2;

import java.util.Date;

public class User {
    private String name;
    private long account_no;
    private String PIN;
    private String oldPIN;
    private Date date;
    
    private String email;
    private String mobile;
    private String address;
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setAccount_no(long account_no){
        this.account_no = account_no;
    }
    
    public long getAccount_no(){
        return account_no;
    }
    
    public void setPIN(String PIN){
        this.PIN = PIN;
    }
    
    public String getPIN(){
        return PIN;
    }
    
    public void setOldPIN(String oldPIN){
        this.oldPIN = oldPIN;
    }
    
    public String getOldPIN(){
        return oldPIN;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    public String getMobile(){
        return mobile;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
}










