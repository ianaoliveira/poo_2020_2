package lapiseira;

import java.util.Scanner;

class Grafite  {
    float calibre; 
    String dureza; 
    int tamanho;

    Grafite (float calibre, String dureza, int tamanho) {
        this.calibre = calibre;
        this.dureza = dureza;
        this.tamanho = tamanho; 
    }

    void desgastePorFolha () {
        if (dureza == "HB") {
            tamanho -= 1;
            return;
        }
        if (dureza == "2B") {
            tamanho -= 2;
            return;
        } 
        if (dureza == "4B") {
            tamanho -= 4; 
            return; 
        } 
        if (dureza == "6B") {
            tamanho -= 6;
            return;
        }
    }

    public String toString () {
        return "Calibre: " + calibre + " Dureza: " + dureza + " Tamanho: " + tamanho + " mm";
    }
    
}
public class Lapiseira {
    float calibre; 
    Grafite grafite;

    Lapiseira (float calibre) {
        this.calibre = calibre;
        this.grafite = null;
    }

    void inserir (Grafite grafite) {
        if (this.grafite != null) {
            System.out.println("Jà tem um grafite aqui dentro.");
            return;
        } else if (calibre < grafite.calibre) {
            System.out.println("A espessura do grafite não condiz com a espessura aceita pela lapiseira.");
            return; 
        } else {
            System.out.println("Inseri um grafite");
            this.grafite = grafite;  
        }
    }

    void retirar () {
        if (this.grafite != null) {
            this.grafite = null;
        } else {
            System.out.println("Não há grafites na lapiseira.");
        }
    }

    void escrever (int folhas) {
        if (this.grafite == null) {
            System.out.println("Não é possível escrever, pois não há grafite na lapiseira");
        } else {
            if (this.grafite.tamanho < folhas) {
                this.grafite.desgastePorFolha();
                System.out.println("Só foram escritas completamente " + folhas + " folhas");
                this.grafite = null;
            } else {
                this.grafite.desgastePorFolha ();
                System.out.println("Todas as folhas foram escritas.");
                return;
            }   
        }
    }
    
    public String toString () {
        return "Calibre: " + this.grafite.calibre + " Dureza: " + this.grafite.dureza + " Tamanho: " + this.grafite.tamanho + " mm";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o calibre da sua lapiseira:");
        Lapiseira lapiseiraum = new Lapiseira(scanner.nextFloat());
        System.out.println("COMANDOS: DIGITE sair PARA SAIR | DIGITE inserir PARA INSERIR | DIGITE retirar PARA RETIRAR | DIGITE escrever PARA ESCREVER.");

        while (true) {
        String line = scanner.nextLine();
        String[] com = line.split(" ");
            if (com[0].equals("sair")) {
                break;
            } else if (com[0].equals("inserir")) {
                Scanner scannerum = new Scanner (System.in);
                Scanner scannerdois = new Scanner (System.in);
                float cal;
                String drz;
                int tam; 
                    System.out.println("Digite o calibre do seu grafite:");
                        cal = scanner.nextFloat();
                        if (cal != lapiseira.calibre) {
                            System.out.println("ERRO! Calibre incompatível.");
                            break;
                        }
                    System.out.println("Digite o tamanho do seu grafite (em mm):");
                        tam = scannerum.nextInt();
                        } else {
                            System.out.println("Dureza inválida.");
                            break;
                        }

            } else if (com[0].equals("retirar")) {
                lapiseira.retirar();
            } else if (com[0].equals("escrever")) {
                System.out.println("Digite quantas folhas deseja escrever:");
                int folhas = scanner.nextInt();
                lapiseira.escrever(folhas);
            }
        }  
        scanner.close();
    }

}
