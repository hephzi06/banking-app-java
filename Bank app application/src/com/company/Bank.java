package com.company;

import java.util.Date;
import java.util.Scanner;

public class Bank {

    String firstName;
    String secondName;
    String middleName;

    String gender;
    String phone;
    int age;
    String fullName ;

    long mainAmount = 0l;
    short pin ;

    public void createAccount(){
        Scanner createAccount = new Scanner(System.in);
        System.out.print("First name:   ");
        firstName = createAccount.nextLine();
        System.out.print("Second name:   ");
        secondName = createAccount.nextLine();
        System.out.print("Middle name:   ");
        middleName = createAccount.nextLine();
        System.out.print("Phone Number:   ");
        phone = createAccount.nextLine();
        System.out.print("Gender:   ");
        gender = createAccount.nextLine();
        System.out.print("Age:   ");
        age = createAccount.nextInt();
        fullName = firstName + " " +  secondName+ " " + middleName + " ";
        if(gender.equals("male") || gender.equals("female") && phone.length() == 11 && age > 5){
            System.out.println("Your account is pending just wait a little to be verified");
            System.out.println("----------------------------------------------------------- \n" +
                    "You have been Verified");
            intro();

        }else{
            System.out.println("Sorry you were not verified but Thanks for coming to Hephzi bank");
        }

    }
    public void intro(){
        Scanner intro = new Scanner(System.in);

        System.out.println("Welcome to Hephzi Bank " + fullName +
                "Would you like to take a tour \n" +
                "Your Account Balance is $0.00 ");
                makeDeposit();

        createPin();
        System.out.println("1. Make Deposit \n" +
                    "2. Transfer");
         byte pick  = intro.nextByte();
         if(pick == 1){
             makeDeposit();
         }else if( pick == 2){
             transfer();
         }else{
             System.out.println("Invalid option");
         }


    }

    public void createPin(){
        Scanner collect = new Scanner(System.in);
        System.out.print("Create a pin:  ");
        String  create = collect.nextLine();


         pin = (short) Integer.parseInt(create);
         if(create.length() == 4){
             System.out.println("Pin created");
         }else{
             System.out.println("Recreate pin");
         }

    }

    public  void makeDeposit() {
        System.out.println("Add money to your account");
        Scanner makedepo = new Scanner(System.in);


        System.out.print("Amount: ");
        double amount = makedepo.nextDouble();
        double newAmount = amount + mainAmount;
        System.out.println("You have successfully deposited into your account $" +newAmount + "\n " +
                "Your balance is " + newAmount);
        mainAmount =(long) newAmount;



    }



    public  void transfer(){
        Scanner transfer = new Scanner(System.in);
        System.out.print("Sender name: ");
        String senderName = transfer.nextLine();
        System.out.print("Bank name: ");
        String bankName =transfer.nextLine();
        System.out.print("Account Number: ");
        String accountNumber = transfer.nextLine();
        System.out.print("Amount: ");
        double amount = transfer.nextDouble();
        System.out.print("Enter pin: ");
        short transferPin = transfer.nextShort();
        double transferNewAmount = mainAmount - amount;
        Date today = new Date();
        if(accountNumber.length() == 10 && mainAmount >= amount  && transferPin == pin){

            System.out.println("Success $" + amount + " sent to " + senderName + " " + bankName + " your balance is $" + transferNewAmount + " on "+ today );

        }else{
            System.out.println("Error");
        }
        mainAmount= (long) transferNewAmount;

    }
}
// createPin();
//
