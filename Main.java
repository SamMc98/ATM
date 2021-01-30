import java.util.*;
class Main {
  //A simple ATM program with user interaction.

  private int pin = 1234, balance = 0, limit = 500, withdrawReceipt = 0, turn = 0;

  public Main(int pin, int balance, int limit){
    this.pin = pin;
    this.balance = balance;
    this.limit = limit;
    withdrawReceipt = 0;
  }

  public void setPin(int pin){
    this.pin = pin;
  }

  public int getPin(){
    return pin;
  }

  public void setBalance(int balance){
    this.balance = balance;
  }

  public int getBalance(){
    return balance;
  }

  public void setLimit(int limit){
    this.limit = limit;
  }

  public int getLimit(){
    return limit;
  }

  public void setWithdrawReceipt(int withdrawReceipt){
    this.withdrawReceipt = withdrawReceipt;
  }

  public int getWithdrawReceipt(){
    return withdrawReceipt;
  }

  public void withdraw(){
    Scanner input3 = new Scanner(System.in);
      System.out.println("\nHow much do you wish to withdraw?");
      int amount = input3.nextInt();
    if (amount > balance){
      System.out.println("\nYou don't have enough money in your account to withdraw this much!");
      withdrawAgain();
    }
    else if (amount > limit){
      System.out.println("\nYou can't withdraw any more money today!");
      withdrawAgain();
    }
    else {
      System.out.println("\nWithdrawing £" + amount + " from your account.\n....");
      
      withdrawReceipt = withdrawReceipt + amount;
      limit = limit - amount;
      balance = balance - amount;

      System.out.println("\n\nWithdraw successful!");
      withdrawAgain();
    }
    returnToMenu();
    input3.close();
  }

  public void withdrawAgain(){
    Scanner input5 = new Scanner(System.in);
      System.out.println("\nWould you like to withdraw again?");
      String choice = input5.nextLine();
      if (choice.toLowerCase().equals("yes")){
        withdraw();
      }
      if (choice.toLowerCase().equals("no")){
        returnToMenu();
      }
      else {
        System.out.println("\nCommand not recognised.");
        withdrawAgain();
      }
      input5.close();
  }

    public void showBalance(){
      System.out.println("\nCurrent Balance:\n£" + balance);
      returnToMenu();
    }

    public void printReceipt(){
      System.out.println("\nYour Receipt:\n£" + withdrawReceipt);
      returnToMenu();
    }

    public void enterPin(){
    
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Pin:");  
    int enteredPin = input.nextInt();

    if (enteredPin != pin){
      System.out.println("\nIncorrect Pin!");
      turn++;
      if (turn > 2){
      System.out.println("\nYou have entered an incorrect pin 3 times. Your account has been locked.");  
      System.exit(0);
      }
      enterPin();
    }
    else if (enteredPin == pin){
      Menu();
    }
    input.close(); //be sure to close the scanner
    
    }

    public void Menu(){
      Scanner input2 = new Scanner(System.in);
      System.out.println("\nWelcome!\nWhat would you like to do?\n\nShow Balance     Print Receipt     Withdraw     Quit");
      String cmmd = input2.nextLine();
      if (cmmd.toLowerCase().equals("show balance")){
        System.out.println("\nShow Balance.");
        showBalance();
      }
      else if (cmmd.toLowerCase().equals("print receipt")){
        System.out.println("\nPrint Receipt.");
        printReceipt();
      }
      else if (cmmd.toLowerCase().equals("withdraw")){
        System.out.println("\nWithdraw.");
        withdraw();
      }
      else if (cmmd.toLowerCase().equals("quit")){
        System.out.println("\nQuit.");
        System.exit(0);
      }
      else {
        System.out.println("\nCommand not recognised.");
        Menu();
      }
      input2.close();
    }

    public void returnToMenu(){
      Scanner input4 = new Scanner(System.in);
      System.out.println("\nWould you like to return to the main menu?");
      String cmmd = input4.nextLine();
      if (cmmd.toLowerCase().equals("yes")){
        Menu();
      }
      else if (cmmd.toLowerCase().equals("no")){
        System.out.println("\nQuit.");
        System.exit(0);
      }
      else {
        System.out.println("\nCommand not recognised.");
        returnToMenu();
      }
      input4.close();
    }

  public static void main(String[] args) {  
  Main Account1 = new Main(1234, 3000, 500);

  Account1.setPin(2468);
  Account1.enterPin();
  }
}