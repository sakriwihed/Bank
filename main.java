import bank.Bank;

public class main{
    public static void main(String [] args){
        Bank bank=new Bank();
        int acc1= bank.open(true);
        int acc2=bank.open(false);
        for (int i=0;i<3;i++){ //diese 3 Operationen :deposit , Withdraw, update wurden 3 mal wiederholt 
            bank.deposit(acc1,Math.random()*501); // wir nehmen einen random Betrag
            bank.withdraw(acc1,300);
            System.out.println();
            bank.deposit(acc2,Math.random()*701);
            bank.withdraw(acc2,1050);
            System.out.println();
            bank.update();
        }
        bank.close(acc2); // acc2 wurde schliesslich geloescht 
        
    }
}