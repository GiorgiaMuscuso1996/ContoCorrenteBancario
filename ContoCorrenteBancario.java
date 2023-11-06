import java.util.Scanner;

public class ContoCorrenteBancario {

    private String nomeTitolare;
    private String numeroConto;
    private double saldoIniziale;

    public ContoCorrenteBancario(String nomeTitolare, String numeroConto, double saldoIniziale) {
        this.nomeTitolare = nomeTitolare;
        this.numeroConto = numeroConto;
        this.saldoIniziale = saldoIniziale;
    }

    public void deposito(double importo) {

        if (importo > 0) {
            saldoIniziale += importo;
            System.out.println("Deposito di " + importo + " effettuato con successo.");
        } else {
            System.out.println("Importo non valido per il deposito.");

        }
    }

    public void prelievo(double importo) {

        if (importo > 0 && importo <= saldoIniziale) {
            saldoIniziale -= importo;
            System.out.println("Prelievo di " + importo + " effettuato con successo.");
        } else {
            System.out.println("Fondi insufficienti o importo non valido per il prelievo.");
        }
    }

    public void stampaSaldo() {
        System.out.println("Saldo attuale del conto corrente " + numeroConto + ": " + saldoIniziale);
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Inserisci nome del titolare del conto: ");
        String nomeTitolare = console.nextLine();

        System.out.println("Inserisci il numero del conto corrente: ");
        String numeroConto = console.nextLine();

        System.out.println("Accesso al conto corrente numero " + numeroConto + " al nome di " + nomeTitolare);

        ContoCorrenteBancario ccb = new ContoCorrenteBancario(nomeTitolare, numeroConto, 1000);

        while (true) {

            System.out.println(
                    "Digita 'd' per depositare, 'p' per prelevare, 's' per visualizzare il saldo o 'f' per uscire: ");
            String sceltaUtente = console.nextLine().toUpperCase();

            switch (sceltaUtente) {

                case "D": {
                    System.out.println("Inserisci cifra da depositare: ");
                    double importo = console.nextDouble();
                    console.nextLine();
                    ccb.deposito(importo);
                    ccb.stampaSaldo();
                    break;
                }

                case "P": {
                    System.out.println("Inserisci cifra da prelevare: ");
                    double importo = console.nextDouble();
                    console.nextLine();
                    ccb.prelievo(importo);
                    ccb.stampaSaldo();
                    break;
                }

                case "S": {
                    ccb.stampaSaldo();
                    break;
                }

                case "F": {
                    System.out.println("Sei uscito dal conto");
                    System.exit(0);
                    break;
                }

                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }
    }
}