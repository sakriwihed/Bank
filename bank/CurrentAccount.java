package bank;

public class CurrentAccount extends Account {
    private double  limit ;
    public CurrentAccount(int accnum,double balance,double limit){ // das ist der Kontruktor des CurrentAccount 
        super(accnum,balance); // ruft accnum und balance von der Klasse Account 
        this.limit=limit; 
    }

    // diese Methode behandelt sich verschiedene Faelle von der Auszahlung aus Girokonto :
    @Override
    public void withdraw(double amount) { 
        
        if ((getBalance()- amount >= limit)) {
            if(getBalance()-amount>0){ //wenn wir genug Geld haben 
                super.withdraw(amount);
                System.out.println("Wir haben " + amount + " aus Girokonto nummer " + getAccnum() + " ausgezahlen , also das neue Balance ist : " + getBalance());
            }
            else {
                if(getBalance()-amount<0){ // wenn wir Geld von der Bank ausleihen werden und wir haben das Limit nicht erreicht
                    balance = -(amount - balance);
                    System.out.println("Wir haben " + amount + " aus Girokonto nummer  " + getAccnum() + " ausgezahlen , also das neue Balance ist :  " + getBalance());
                }
            }
        }
        else { // das Limit wurde leider erreicht , also keine Auszahlung ist moeglich 
            System.out.println("wir koennen nicht dieser Betrag:" + amount + " aus Girokonto nummer " + getAccnum() + " auszahlen , da das Limit ist -1000 !!!");
        }
    }
    
    public double getLimit(){
        return limit;
    }
}
