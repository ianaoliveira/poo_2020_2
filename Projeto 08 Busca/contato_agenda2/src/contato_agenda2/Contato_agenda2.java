package contato_agenda2;

import java.util.ArrayList;
import java.util.Scanner;

public class Contato_agenda2 {

    public static void main(String[] args) {
	Agenda agenda = new Agenda();

	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);
		
	System.out.println("\nLista de comandos: "
            + "\n" + "$add: Adiciona um novo Contato para Agenda ou adiciona um novo numero caso o nome ja exista"
            + "\n" + "$rm: Remove um Contato de Agenda com base no Nome"
            + "\n" + "$rmFone: Remove um Telefone do Contato com base no Indice"
            + "\n" + "$search: Lista os contatos da Agenda pelo nome ou fone com base no pattern de busca"
            + "\n" + "$show: Lista os dados da Agenda"
            + "\n" + "$end: Parar a aplicacao\n");

	while (true) {
            System.out.println("\nDeseja executar qual comando?");
            String command = scanner.next();
            
        if (command.equals("add")) {
            System.out.print("Insira o contato com seus telefones. Exemplo: ana tim:3130 viv:1234\n");
            String cont = scanner2.nextLine();
				
            String[] data = cont.split(" ");
            ArrayList<Fone> fones = new ArrayList<Fone>();
				
                for (int i = 1; i < data.length; i++) {
                fones.add(new Fone(data[i]));
                }
				
            agenda.addContato(data[0], fones);
	} else if (command.equals("rm")) {
            if (!agenda.getContatos().isEmpty()) {
		System.out.print("Insira o nome do contato: ");
		String name = scanner2.nextLine();
					
		agenda.rmContato(name);
		} else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando $add");
		}
		
            } else if (command.equals("rmFone")) {
		if (!agenda.getContatos().isEmpty()) {
                    System.out.print("Insira o nome do contato e o indice do fone a ser apagado. Exemplo: ana 0");
                        String cont = scanner2.nextLine();
                        String[] data = cont.split(" ");
                        Contato contato = agenda.getContato(data[0]);
                        contato.rmFone(Integer.parseInt(data[1]));
                } else {
                    System.out.print("\nCrie um Contato primeiro! Utilize o comando $add");
                }
            } else if (command.equals("search")) {
                    if (!agenda.getContatos().isEmpty()) {
			System.out.print("Insira o pattern de busca: ");
			String pattern = scanner2.nextLine();
					
                        ArrayList<Contato> searched = agenda.search(pattern);
					
                        for (Contato search : searched) {
                        System.out.print("- " + search + "\n");
                        }
                    } else {
			System.out.print("\nCrie um Contato primeiro! Utilize o comando $add");
                    }
            } else if (command.equals("show")) {
                System.out.print("\n"+agenda);
                System.out.print("\nAplicacao encerrada.");
                break;
            } else {
            	System.out.print("\nComando invalido.");
            }
        }
		
		scanner.close();
		scanner2.close();

	}

}
