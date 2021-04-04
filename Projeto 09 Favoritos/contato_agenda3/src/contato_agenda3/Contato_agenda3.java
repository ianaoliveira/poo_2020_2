package contato_agenda3;

import java.util.ArrayList;
import java.util.Scanner;

public class Contato_agenda3 {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
        Agenda agenda = new Agenda();

        System.out.println("\nLista de comandos: " +
				            "\n" + "add: Adiciona um novo Contato para Agenda ou adiciona um novo numero caso o nome ja exista" +
				            "\n" + "rm: Remove um Contato de Agenda com base no Nome" +
				            "\n" + "rmFone: Remove um Telefone do Contato com base no Indice" +
				            "\n" + "star: Adiciona o Contato escolhido aos favoritos" +
				            "\n" + "unstar: Remove o Contato escolhido dos favoritos" +
				            "\n" + "starred: Lista os contatos favoritos da Agenda" +
				            "\n" + "search: Lista os contatos da Agenda pelo nome ou fone com base no pattern de busca" +
				            "\n" + "show: Lista os dados da Agenda" +
				            "\n" + "end: Parar a aplicacao\n");

        while (true) {
            System.out.println("\nDeseja executar qual comando?");
            String line = scanner.nextLine();
            String ui [] = line.split(" ");

            if (ui[0].equals("add")) {
                ArrayList<Fone> fones = new ArrayList <Fone>();

                for (int i = 2; i < ui.length; i++) {
                    fones.add(new Fone(ui[i]));
                }
                
                agenda.addContato(ui[1], fones);
            } else if (ui[0].equals("rm")) {
                if (!agenda.getContatos().isEmpty()) {
                    agenda.rmContato(ui[1]);
                } else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando add");
                }
            } else if (ui[0].equals("rmFone")) {
                if (!agenda.getContatos().isEmpty()) {
                    agenda.getContato(ui[1]).rmFone(Integer.parseInt(ui[2]));
                } else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando add");
                }
            } else if (ui[0].equals("search")) {
                if (!agenda.getContatos().isEmpty()) {
                    ArrayList<Contato> searched = agenda.search(ui[1]);

                    for (Contato search: searched) {
                        System.out.print(search + "\n");
                    }
                } else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando add");
                }
            } else if (ui[0].equals("show")) {
                System.out.print("\n" + agenda);
            } else if (ui[0].equals("star")) {
            	if (!agenda.getContatos().isEmpty()) {
                    agenda.getContato(ui[1]).setStar(true);
                } else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando add");
                }
            } else if (ui[0].equals("unstar")) {
            	if (!agenda.getContatos().isEmpty()) {
            		agenda.getContato(ui[1]).setStar(false);
                } else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando add");
                }
            } else if (ui[0].equals("starred")) {
            	if (!agenda.getContatos().isEmpty()) {
            		ArrayList<Contato> starred = agenda.getStarred();
            		
            		for (Contato s : starred) {
            			System.out.println("\n" + s);
            		}
                } else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando add");
                }
            } else if (ui[0].equals("end")) {
                System.out.print("\nAplicacao encerrada.");
                break;
            } else {
                System.out.print("\nComando invalido.");
            }
        }

        scanner.close();
    }

}