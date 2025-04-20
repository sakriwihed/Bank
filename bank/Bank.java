package bank;

public class Bank {
    private Account[] accounts;
    private int counter;

    public Bank(){ // Konstruktor der Klasse Bank
        accounts=new Account[30];
        counter=20; // angenommen haben wir bereits 20 Konten 
    }

    public void update(){
        for(Account a:accounts){
            if(a instanceof SavingsAccount ){ // um den Typ des Kontos zu wissen
                ((SavingsAccount) a).interest(); // wenn moeglich , die Zinsen hinzufuegen 
                System.out.println("also ist das neue Balance nach dem Update :  "+a.getBalance());
            }
            if(a instanceof CurrentAccount){
                if (a.getBalance() > (((CurrentAccount)a).getLimit())) { 
                    System.out.println("Girokonto ist ueberzogen : also wir haben das Limit erreichen! "); //das Limit ist erreicht
                }
            }
        }
    }

    //diese Methode offnet ein neues Konto 
    public int open(boolean Typ){ 
        counter++;
        if(counter>30){
            System.out.println("kein Kapazitaet mehr "); // das Bank hat die Kapazitaet fuer nur 30 Konten
            return -1;                                  //wir koennen kein konto eroeffnen
        }

        //falls Typ==True wurde ein Sayvingsaccount geoeffnet , sonst ein CurrentAccount 
        Account account = Typ ? new SavingsAccount(counter,0.0,0.03) : new CurrentAccount(counter,0.0,-1000);
        accounts[counter-1]=account; // das Array accounts in dem Index counter-1 erhalt ein neues Konto (account)
        
        return counter;

    }
 
    // diese Methode schliesst ein Konto , das die Nummer num hat 
    public boolean close(int num){
        if (num > 0 && num <= accounts.length && accounts[num - 1] != null) { // wenn die angegeben Nummer und das Konto mit dem index num-1 existiert 
            accounts[num - 1] = null; //der Inhalt dieses Index wurde geloescht 
            System.out.println("Account nummer : " + num + " ist geschlossen");
            return true;
        }
        return false;
    }
    // diese Methode addiert eine Einzahlung zum Balance
    public void deposit(int acc, double Betrag){
        if (acc > 0 && acc <= accounts.length && accounts[acc - 1]!=null) {
            accounts[acc - 1].deposit(Betrag); //wir fuegen einen Betrag zum Konto acc hin
            System.out.println("wir haben den Betrag: " + Betrag + " zum Konto Nummer " + acc + " eingezahlen, also das neue Balance ist: " + accounts[acc - 1].getBalance());
        } else {
            System.out.println("keine Einzahlung ist leider moeglich! da es keine valid Kontonummer gibt ");
        }
    }


    public void withdraw(int acc, double Betrag){
        if (accounts[acc - 1] != null) {
            accounts[acc - 1].withdraw(Betrag);//wir heben einen Betrag vom Konto acc ab
            System.out.println("aktueller Betrag ist jetzt "+accounts[acc-1].getBalance());
        }
    }
}
