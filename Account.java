//https://github.com/AsfariaChowdhury/NSUACM-WCodingMarathonBank

/*
    NSU ACM-W Coding Marathon 2020
    Asfaria CHOWDHURY
*/

//-----------------------------------------------------------------------------

/*
    Account is the child of User.
    User has basic atributes, such as bank account no.
    Account deals with old and new accounts.
*/
package bank2;

import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public abstract class Account extends User {
    
    private double balance;
    double min_cashOut = 500;		//No less than this can be withdrawn
    double max_cashOut = 100000;	//No more than this can be withdrawn
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public static void LOG(String output){
        System.out.println(output);
    }
    
    
    
    /**************************************************************************/
    //abstract methods will be implemented in Balance class
    public abstract void account_withdraw();
    public abstract void account_deposit();
    public abstract void account_balance();
    /**************************************************************************/
    
    
    
    public void setUserPIN(){
        int flag = 0;   //recursion will not occur if PIN is 4 digits
        //flag = 1, recursion occurs
        
        LOG("Please enter a new PIN.");
        Scanner stringInput = new Scanner(System.in);
        
        String userPIN = stringInput.nextLine();
        try{
            if(userPIN.length() != 4){
                flag++;
                throw new CustomException("PIN must be four digits.\nPlease enter again.");
            }
        }catch(CustomException e){
            LOG(e.getMessage());
        }finally{
            if(flag == 1){
                flag = 0;
                setUserPIN();   //recursion
            }
            else{
                stringInput.close();
                setPIN(userPIN);    //PIN is correct, so set it to private attribute of User class
                setOldPIN(userPIN); //setUserPIN method is used only for new account creation
                //when the pin is changed for the first time, the very first created PIN is accessed as old PIN
            }
        }
        
    }
    
    /*
        newAccount() calls the following methods:
        (1) setUserPIN
        (2) LOG
    */
    public void newAccount(){
        LOG("Please enter full name.");
        Scanner stringInput = new Scanner(System.in);
        String username = stringInput.nextLine();
        setName(username);
            
        Random rd = new Random();
        Long userAccount_no = rd.nextLong();
        userAccount_no = Math.abs(userAccount_no);
        setAccount_no(userAccount_no);
        System.out.println("Your account number is " + getAccount_no());
            
        setUserPIN();
            
        Date account_createdOn = new Date();
        setDate(account_createdOn);
            
        LOG("Please enter your email address.");
        String userEmail = stringInput.nextLine();
        setEmail(userEmail);
            
        LOG("Please enter your mobile no");
        String userMobile = stringInput.nextLine();
        setMobile(userMobile);
            
        LOG("Please enter your house address.");
        String userAddress = stringInput.nextLine();
        setAddress(userAddress);
        
    }
    
    /*
        login() calls the following methods:
        (1) enterPIN
        (2) LOG
    */
    public void login(){
        int flag = 0;   //recursion will not occur if correct bank account no is entered
        //flag = 1, recursion occurs
        
        LOG("Please enter your bank account no.");
        Scanner numInput = new Scanner(System.in);
        long userAccount_no = numInput.nextLong();
        long compareValidInput = getAccount_no();
        
        try{
            if(userAccount_no != compareValidInput){
                flag++;
                throw new CustomException("You've entered wrong bank account number.\nPlease enter again.");
            }
        }catch(CustomException e){
            LOG(e.getMessage());
        }finally{
            if(flag == 1){
                flag = 0;
                login();   //recursion
            }
            else{
                numInput.close();
                enterPIN(userAccount_no);
            }
        }
        
    }
    
    public void enterPIN(long userAccount_no){
        int flag = 0;   //recursion will not occur if PIN is correct
        //flag = 1, recursion occurs
        
        Scanner stringInput = new Scanner(System.in);
        LOG("Please enter PIN.");
        String userPIN = stringInput.nextLine();
        String compareValidInput = getPIN();
        
        try{
            if(!(userPIN.equals(compareValidInput))){
                flag++;
                throw new CustomException("You have entered wrong PIN.\nPlease enter again.");
            }
        }catch(CustomException e){
            LOG(e.getMessage());
        }finally{
            if(flag == 1){
                flag = 0;
                enterPIN(userAccount_no);   //recursion 
            }
            else{
                LOG("You've successfully logged in.");
                stringInput.close();
            }
        }
        
    }
    
    public void changePIN(){
        int flag = 0;   //recursion will not occur if PIN is correct
        //flag = 1, recursion occurs
        
        LOG("Please enter new PIN.");
        Scanner stringInput = new Scanner(System.in);
        String userPIN = stringInput.nextLine();
        
        try{
            if(userPIN.equals(getOldPIN())){
                flag++;
                throw new CustomException("New PIN is equal to old Old PIN.\nPlease enter another PIN.");
            }
        }catch(CustomException e){
            LOG(e.getMessage());
        }finally{
            if(flag == 1){
                flag = 0;
                changePIN();
            }        
        }
        
        
        setOldPIN(getPIN());    //PIN attribute in User class is still not updated
        //getPIN() is used to set old PIN value
        
        
        try{
            if(userPIN.length() != 4){
                flag++;
                throw new CustomException("PIN should be 4 digits. Please enter again.");
            }
        }catch(CustomException e){
            LOG(e.getMessage());
        }finally{
            if(flag == 1){
                flag = 0;
                changePIN();
            }
            else{
                setPIN(userPIN);
                LOG("PIN has been successfully changed!");
                stringInput.close();
            }
        }
    }
    
    public void updateEmail(){
        Scanner stringInput = new Scanner(System.in);
        LOG("Please enter new email address.");
        String userEmail = stringInput.nextLine();
        setEmail(userEmail);
        stringInput.close();
    }
    
    public void updateMobile(){
        Scanner stringInput = new Scanner(System.in);
        LOG("Please enter a new mobile number.");
        String userMobile = stringInput.nextLine();
        setMobile(userMobile);
        stringInput.close();
    }
    
    public void updateAddress(){
        Scanner stringInput = new Scanner(System.in);
        LOG("Please enter a new house address.");
        String userAddress = stringInput.nextLine();
        setAddress(userAddress);
        stringInput.close();
    }
    
    
}






























