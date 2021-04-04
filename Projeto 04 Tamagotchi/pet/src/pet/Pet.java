package pet;
import java.util.Scanner;

public class Pet {
    
    private int energiaMax, fomeMax, limpMax;
    private int energia, fome, limp; 
    private int diam = 0; 
    private int idade = 0;
    private boolean vivo = true;

    public Pet (int energiaMax, int fomeMax, int limpMax) {
    
    this.energiaMax = energiaMax;
    this.fomeMax = fomeMax; 
    this.limpMax = limpMax; 
    
    this.energia = energiaMax; 
    this.fome = fomeMax;
    this.limp = limpMax; 
    
    this.diam = 0; 
    this.idade = 0; 
    this.vivo = true;
    }

    void setFome (int value) {
        this.fome = value; 
        
        if (this.fome <= 0) {
            this.fome = 0;
            this.vivo = false;
            System.out.println("O Tamagotchi morreu de fome.");
        }
        if (this.fome > fomeMax) {
            this.fome = fomeMax;
            System.out.println("O Tamagotchi já comeu o suficiente.");
        }
    }
    
    int getFome(){
        return this.fome;
    }
    
    void setEnergia (int value) {
        this.energia = value;

        if (this.energia <= 0) {
            this.fome = 0;
            this.vivo = false; 
            System.out.println("O Tamagotchi morreu por falta de energia.");
        } 
        if (this.energia > energiaMax) {
            this.energia = energiaMax;
            System.out.println("O Tamagotchi já está com a energia máxima.");
        }
    }
    
    int getEnergia () {
        return this.energia;
    }

    void setLimp (int value) {
        this.limp = value; 

        if (this.limp <= 0) {
            this.limp = 0;
            this.vivo = false; 
            System.out.println("O Tamagotchi morreu por falta de higiene.");
        }
        if (this.limp > limpMax) {
            this.limp = limpMax;
            System.out.println("Seu Tamagotchi já está com a limpeza máxima.");
        }
    }

    int getLimp () {
        return this.limp;
    }

    boolean Vivo() {
        if (!vivo) {
            System.out.println("Não é possível interagir com um Tamagotchi morto.");
            return false;
        }
        return true; 
    }

    void jogar () {
        if (!this.Vivo()) {
            System.out.println("Não é possível brincar com um Tamagotchi morto.");
        } else {
            setEnergia(energia - 2);
            setFome(fome - 1);
            setLimp(limp - 2);
            this.idade += 1;
            this.diam += 3;
        }
    }

    void banho () {
        if (!this.Vivo()) {
            System.out.println("Não é possível dar banho em um Tamagotchi morto.");
        } else {
           setEnergia(energia - 1);
           setFome(fome - 1);
           setLimp(limp + 3);
           this.idade += 1;
        }
    }

    void comer () {
        if(!this.Vivo()) {
            System.out.println("Não é possível alimentar um Tamagotchi morto.");
        } else {
            setEnergia (energia - 1);
            setFome(fome + 3);
            setLimp(limp - 1);
            this.idade += 1;
        }
    } 

    void dormir () {
        if (!this.Vivo()) {
            System.out.println("Não é possível que um Tamagotchi morto durma.");
        } 
        if (this.energia < this.energiaMax) {
            setEnergia(energia + 3);
            setFome(fome - 1);
            setLimp(limp - 1); 
            this.idade += 2;
        } else {
            System.out.println("O Tamagotchi não precisa dormir.");
        }
    }
    
     public String toString(){
        return "Sua energia é: " + energia + "/" + energiaMax + " Sua fome é: " + fome + "/" + fomeMax +  " Sua limpeza é: " + limp + "/" + limpMax + " Seus diamantes " + diam + " Sua idade:" ; 
    }
}

class Interacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Pet HarryStyles = new Pet(0, 0, 0);
        System.out.println("Digite o que seu Tamagotchi tem que fazer:");
        System.out.println("DIGITE jogar PARA JOGAR | DIGITE banho PARA DAR BANHO | DIGITE comer PARA COMER | DIGITE dormir PARA DORMIR | DIGITE sair PARA SAIR | DIGITER mostrar PARA MOSTRAR OS ATRIBUTOS DO SEU PET");
        System.out.println("Lembre-se, caso alguma das necessidades do Tamagotchi chegar a zero, seu pet morre.");
        while (true) {
            String line = scanner.nextLine();
            String ui [] = line.split(" ");
            if (ui[0].equals("jogar")) {
                HarryStyles.jogar();
            } else if (ui[0].equals("banho")) {
                HarryStyles.banho();
            } else if (ui[0].equals("comer")) {
                HarryStyles.comer();
            } else if (ui[0].equals("dormir")) {
                HarryStyles.dormir();
            }  else if (ui[0].equals("show")) {
                System.out.println(HarryStyles);
            } else if (ui[0].equals("sair")) {
                break;
            } else {
                System.out.println("COMANDO INVÁLIDO! Tente de novo");
                System.out.println("DIGITE jogar PARA JOGAR | DIGITE banho PARA DAR BANHO | DIGITE comer PARA COMER | DIGITE dormir PARA DORMIR | DIGITE sair PARA SAIR | DIGITER mostrar PARA MOSTRAR OS ATRIBUTOS DO SEU PET");
            }
        }
        scanner.close();
    }
}
