package clinica_veterinaria;

import java.util.Scanner;

public class ClinicaVeterinaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicoClinica sc = new ServicoClinica();
        
        while(true){
            try {
                String line = scanner.nextLine();
                System.out.println("$" + line);
                String ui[] = line.split(" ");
                
                if(line.equals("end")) {
                    break;
                } else if(ui[0].equals("nwcli")) {
                	String nome = "";
        			for (int i = 2; i < ui.length; i++) nome += ui[i] + " ";
        			
                   sc.addCliente(new Cliente(ui[1], nome));
                } else if(ui[0].equals("lacli")) {
                    System.out.println(sc.showAllCliente());
                } else if(ui[0].equals("nwani")) {
                	sc.addAnimal(ui[1], ui[2], ui[3]);
                } else if(ui[0].equals("lscli")) {
                    System.out.println(sc.showCliente(ui[1]));
                } else if(ui[0].equals("laani")) {
                    System.out.println(sc.showAllAnimal());
                } else if(ui[0].equals("nwser")) {
                	sc.addServico(ui[1], ui[2]);
                } else if(ui[0].equals("laser")) {
                    System.out.println(sc.showAllServico());
                } else if(ui[0].equals("nwven")) {
                    sc.vender(ui[1], ui[2], ui[3]);
                } else if(ui[0].equals("laven")) {
                    System.out.println(sc.showAllVenda());
                } else if(ui[0].equals("saldo")) {
                    System.out.println(sc.saldo());
                } else {
                    System.out.println("FAIL: Comando Inválido");
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
        scanner.close();
    }
}
