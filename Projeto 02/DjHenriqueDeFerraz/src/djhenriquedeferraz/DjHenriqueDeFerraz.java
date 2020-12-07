package djhenriquedeferraz;
/**
 *
 * @author Iana Oliveira
 */
import java.util.Scanner;
public class DjHenriqueDeFerraz {
    int fuel; 
    int maxFuel = 5;
    int resis = 3;
    int vida;
    boolean estaVivo;

    DjHenriqueDeFerraz (int fuel, int vida){
        this.fuel = fuel;
        this.maxFuel = fuel;
        this.resis = resis;
        this.vida = vida;
        this.estaVivo = true;
    }
    
    void andar() {
        if (fuel == 0) {
            System.out.println ("O pai tá off");
        }
        if (fuel > 0 && fuel <= maxFuel) {
            System.out.println("O pai tá on e de mota");
            fuel -= 1;
        }
    }
    
    void acidente() {
        if (resis > 0) {
            resis -= 1;
            System.out.println("Se continuar assim, já já eu morro.");
        } else if (vida > 0) {
            vida -= 1;
            System.out.println("Só eu que tô vendo essa luz?");
        } else {
            estaVivo = false;
            System.out.println("Não deu irmão.");
        }
    }
    
    void abastecer() {
        if (!estaVivo) {
            System.out.println("Não tem mais sentido fazer isso.");
        } 
        if (fuel < 5) {
            fuel += 1;
            System.out.println("randandandandan");
        } else {
            System.out.println("Já tô de tanque cheio.");
        }
    }
    
    void consertar () {
        if (!estaVivo) {
            System.out.println("Mas consertar para quê? Eu tô morto!");
        }
        if (resis < 3) {
            resis += 1;
            System.out.println("Novinho em folha!");
        } else {
            System.out.println("Isso não é necessário no momento.");
        }
    }

    public String toString () {
        return "DjHenrique de Ferraz = Gasolina: " + fuel + " Resistência: " + resis + " Vida: " + vida;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        DjHenriqueDeFerraz djhenriquedeferraz = new DjHenriqueDeFerraz (5,5);
        System.out.println("Digite o que o DJ Henrique de Ferraz deve fazer:");
        while (true) {
            String line = scanner.nextLine();
            String[] a = line.split(" ");
            if (a[0].equals("Fim")) {
                break;
            } else if (a[0].equals("Andar")) {
                djhenriquedeferraz.andar();
            } else if (a[0].equals("Acidente")) {
                djhenriquedeferraz.acidente();
            } else if (a[0].equals("Abastecer")) {
                djhenriquedeferraz.abastecer();
            } else if (a[0].equals("Consertar")) {
                djhenriquedeferraz.consertar();
            } else if (a[0].equals("Show")) {
                System.out.println(djhenriquedeferraz);
            } else {
                System.out.println("Comando inválido");
            }
        }
        scanner.close();

    }
}
