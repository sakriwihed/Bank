package bank;
public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(int accnum,double balance,double interestRate){ // das ist der Konstruktor der Klasse SavingsAccount
        super(accnum,balance);
        this.interestRate=interestRate;
    }

    // diese Methode rechnet die Zinsen , falls es moeglich ist
    public void interest(){ 
        if(getBalance()>=100){  
            double s=getBalance()*interestRate;
            super.deposit(s);
        }
        else {
            System.out.println("wir koennen leider keine Zinsen hinzufuegen"); // wenn Balance ist unter 100 euro
        }
    }
}
