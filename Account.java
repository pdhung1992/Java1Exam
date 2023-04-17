package com.exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    String customerCode;
    String customerName;
    int accNumber;
    long amount = 0;
    long money;


    public void inputAccDetail() throws Exception {
        Pattern pattern = Pattern.compile("\\d{6}");
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Input Customer code: ");
            String sCode = input.nextLine();
            if(sCode.length() != 5){
                throw new Exception("Customer Code must be 5 characters long");
            }
            this.customerCode = sCode;

            System.out.print("Input customer name: ");
            String sName = input.nextLine();
            if(sName.equals("")){
                throw new Exception("Name can not be empty");
            }
            this.customerName = sName;

            System.out.print("Input Account number:");
            String sAcc = input.nextLine();
            if(!sAcc.startsWith("100")) {
                throw new Exception("Account number must be start with 100");
            }

            Matcher matcher = pattern.matcher(sAcc);
            if(!matcher.matches()) {
                throw new Exception("Account number must be 6 digits");
            }
            this.accNumber = Integer.parseInt(sAcc);

            System.out.print("Input Amount: ");
            String sAmount = input.nextLine();
            if (sAmount.equals("")){
                throw new Exception("Amount can not be empty!");
            }
            try {
                this.amount = Long.parseLong(sAmount);
            }catch (Exception e){
                throw  new Exception("Amount must be number");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    public void depositAndWithdraw() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls choose a function: ");
        System.out.println("0. Deposit");
        System.out.println("1. Withdraw");
        int type = scanner.nextInt();
        switch (type){
            case 0:
                System.out.print("Input amount to deposit: ");
                money = scanner.nextLong();
                amount += money;
                break;
            case 1:
                System.out.print("Input amount to withdraw: ");
                long money = scanner.nextLong();
                if(money > amount){
                    throw new Exception("Non- sufficient funds");
                }
                amount -=money;
                break;
        }
    }
    public String display (){
        return this.customerCode + ", "+ this.customerName + ", "+ this.accNumber+ ", "+ this.amount;
    }
}
