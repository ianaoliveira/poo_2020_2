package topic;

import java.util.Scanner;

public class Topic {

    public static void main(String[] args) {
    System.out.println ("LISTA DE COMANDOS: init: Cria uma nova topic com a lotação máxima e a quantidade de assentos preferenciais passados por parametros | inserir: Insere um novo passageiro, com as informacoes nome e idade passadas por parametros | remover: Remove um passageiro a partir do seu nome e idade. | show: Mostra a situação da Topic | end: Para a aplicacao");
    Scanner scanner = new Scanner (System.in);
    TransporteAlternativo topic = null;				
        while (true) {
            String line = scanner.nextLine();
            String ui [] = line.split(" ");
            if (ui[0].equals("init")) {
                topic = new TransporteAlternativo(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("show")) {
                if (topic == null) {
                    System.out.println("Não existe nenhuma topic.");
                } else {
                    System.out.println(topic);
                }
            } else if (ui[0].equals("inserir")) {
                if (topic == null) {
                    System.out.println("Não existe uma topic.");
                } else {
                    topic.inserir(new Pass(ui[1], Integer.parseInt(ui[2])));
                }
            } else if (ui[0].equals("retirar")) {
                 if (topic == null) {
                    System.out.println("Não existe uma topic.");
                } else { 
                    topic.retirar(ui[1]);
                }
            } else if (ui[0].equals("end")) {
                break;
            } else {
                System.out.println("COMANDO INVÁLIDO! Tente de novo");
            }
        };
    }
}
