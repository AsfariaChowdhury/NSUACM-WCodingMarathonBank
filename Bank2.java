//https://github.com/AsfariaChowdhury/NSUACM-WCodingMarathonBank

/*
    NSU ACM-W Coding Marathon 2020
    Asfaria CHOWDHURY
*/
package bank2;

import java.util.Scanner;

public class Bank2 extends Balance {
    
    public static void main(String[] args) {
        Bank2 obj = new Bank2();
        
        //creating new account
        obj.newAccount();
        //logging in
        obj.login();
        
        menu(obj);
        
    }
    
    public static void menu(Bank2 obj){
        LOG("Do you want to:");
        LOG("(1) Change PIN\n(2) Change Email\n(3) Change Mobile Number");
        LOG("(4) Change Home Address\n(5) Withdraw\n(6) Deposit");
        LOG("(7) Check Transaction\n(8) Exit");
        
        Scanner numInput = new Scanner(System.in);
        int menuInput = numInput.nextInt();
        
        switch(menuInput){
            case 1:
                obj.changePIN();
                numInput.close();
                menu(obj);
                break;
            case 2:
                obj.updateEmail();
                numInput.close();
                menu(obj);
                break;
            case 3:
                obj.updateMobile();
                numInput.close();
                menu(obj);
                break;
            case 4:
                obj.updateAddress();
                numInput.close();
                menu(obj);
                break;
            case 5:
                obj.account_withdraw();
                numInput.close();
                menu(obj);
                break;
            case 6:
                obj.account_deposit();
                numInput.close();
                menu(obj);
                break;
            case 7:
                obj.account_balance();
                numInput.close();
                menu(obj);
                break;
            case 8:
                numInput.close();
                System.exit(0);
                break;
            default:
                LOG("You have used wrong input.");
                LOG("Please enter again.");
                numInput.close();
                menu(obj);
        }
        
    }
    
}














