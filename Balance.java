//https://github.com/AsfariaChowdhury/NSUACM-WCodingMarathonBank

/*
    NSU ACM-W Coding Marathon 2020
    Asfaria CHOWDHURY
*/

//-----------------------------------------------------------------------------

/*
    Balance is the child class of Account and implements Account's abstract methods
    Balance deals with deposit and withdraw.
    Balance is the grandchild class of User.
*/

package bank2;

import java.util.Date;
import java.util.Scanner;

public class Balance extends Account {
    private double withdraw, deposit;
    private Date withdrawDate, depositDate;
    
    public void setWithdraw(double withdraw){
        this.withdraw = withdraw;
    }
    
    public double getWithdraw(){
        return withdraw;
    }
    
    public void setDeposit(double deposit){
        this.deposit = deposit;
    }
    
    public double getDeposit(){
        return deposit;
    }
    
    //method overloading - 1
    private void updateBalance(double userWithdraw){
        double userBalance = getBalance() - withdraw;
        setBalance(userBalance);
        LOG("Your current balance is " + getBalance() + ".");
    }
    
    //method overloading - 2
    private void updateBalance(){
        double userBalance = getBalance() + deposit;
        setBalance(userBalance);
        LOG("Your current balance is " + getBalance() + ".");
    }
    
    public void account_withdraw(){
        int flag = 0;   //recursion does not occur if amount withdrawn is within 500 and 100000
        //or, if amount to be withdrawn is greater than balance
        //flag = 1, recusion occurs
        
        withdrawDate = new Date();
        
        Scanner numInput = new Scanner(System.in);
        LOG("Please enter amount to be withdrawn.");
        double userWithdraw = numInput.nextDouble();
        
        try{
            if(userWithdraw < min_cashOut || userWithdraw > max_cashOut){
                flag++;
                throw new CustomException("Please enter amount within 500 and 100000");
            }
            else if(userWithdraw > getBalance()){
                flag++;
                throw new CustomException("Amount to be withdrawn is greater than balance.\nPlease enter again.");
            }
        }catch(CustomException e){
            LOG(e.getMessage());
        }finally{
            if(flag == 1){
                flag = 0;
                account_withdraw();     //recursion
            }
            else{
                withdraw = userWithdraw;
                LOG("You have successfully withdrawn Tk " + withdraw + ".");
                //numInput.close();
                updateBalance(userWithdraw);
            }
        }
        
    }
    
    public void account_deposit(){
        depositDate = new Date();
        
        Scanner numInput = new Scanner(System.in);
        LOG("Please enter amount to be deposited.");
        double userDeposit = numInput.nextDouble();
        deposit = userDeposit;
        LOG("You have successfully deposited Tk " + deposit + ".");
        //numInput.close();
        updateBalance();
    }
    
    public void account_balance(){
        LOG("Your balance is Tk " + getBalance() + ".");
    }
    
    public void transaction(){
        LOG("WITHDRAW");
        LOG("Date: " + withdrawDate);
        LOG("Amount: Tk " + withdraw);
        
        LOG("DEPOSIT");
        LOG("Date: " + depositDate);
        LOG("Amount: Tk " + deposit);
        
        LOG("\n\n\nCurrent balance: Tk " + getBalance());
    }
    
}











