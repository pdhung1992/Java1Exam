package com.exam;

public class MainClass {
    public static void main(String[] args) {
        Account account = new Account();

        try{
            account.inputAccDetail();
            account.depositAndWithdraw();
            System.out.println(account.display());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
