package bank;

  public class Account {
    private int accnum;
    protected double balance;


    public Account(int accnum,double balance){ // Konstuktor der Klasse Account 
        this.accnum=accnum;
        this.balance=balance;

    }

    public int getAccnum(){
        return accnum;
    }

    public double getBalance(){
        return balance;
    }


    public void deposit(double betrag){ // Geld einzahlen 
        if(betrag>0){
            balance+=betrag;
        }
    }

    public void withdraw(double betrag){ // Geld auszahlen 
        if((betrag>0) && (balance>betrag)){
            balance-=betrag;
        }
    }

}
