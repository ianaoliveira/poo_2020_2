package junkfood;

import java.util.Scanner;

public class Junkfood {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Maquina maquina = null;
        System.out.println("\nLista de comandos: "
				+ "\n" + "init _espirais _max_produtos: Cria uma nova maquina com as quantidade de espirais e produtos maximos passados por parametros"
				+ "\n" + "set _ind _nome _qtd _valor: Insere uma nova comida (com nome, quantidade e preco) na espiral indicada, informacoes passadas por parametros"
				+ "\n" + "limpar _ind: Remove uma comida da espiral inidicada por parametro"
				+ "\n" + "dinheiro _valor: Adiciona dinheiro na maquina (valor passado por parametro) para conseguir comprar as comidas"
				+ "\n" + "troco: Recebe o troco que estava na maquina"
				+ "\n" + "comprar _ind: Compra uma comida na espiral indicada por parametro"
				+ "\n" + "show: Mostra os dados da maquina (saldo do cliente e todas as comidas nas espirais)"
				+ "\n" + "end: Para a aplicacao\n");
         while (true) {
            String line = scanner.nextLine();
            String ui [] = line.split(" ");
            if (ui[0].equals("init")) {
                maquina = new Maquina(Integer.parseInt(ui[2]), Integer.parseInt(ui[1]));
            } else if (ui[0].equals("show")) {
                if (maquina == null) {
                    System.out.println("Não existe uma máquina.");
                } else {
                    System.out.println(maquina);
                }
            } else if (ui[0].equals("set")) {
                if (maquina == null) {
                    System.out.println("Não existe uma máquina.");
                } else {
                    maquina.alterarEspiral(Integer.parseInt(ui[1]), ui[2], Integer.parseInt(ui[3]), Float.parseFloat(ui[4]));
                }
            } else if (ui[0].equals("limpar")) {
                if (maquina == null) {
                    System.out.println("Não existe uma máquina.");
                } else {
                    maquina.limparEspiral(Integer.parseInt(ui[1]));
                    System.out.println("Espiral limpa.");   
                }
            } else if (ui[0].equals("dinheiro")) {
                 if (maquina == null) {
                    System.out.println("Não existe uma máquina.");
                } else { 
                    maquina.inserirDinheiro(Float.parseFloat(ui[1]));
                    System.out.println ("Saldo recebido.");
                }
            } else if (ui[0].equals("troco")) {
                if (maquina == null) {
                    System.out.println("Não existe uma máquina.");
                } else {
                    System.out.println("Você recebeu " + maquina.pedirTroco() + " de troco.");
                }
            } else if (ui[0].equals("comprar")) {
                if (maquina == null) {
                    System.out.println("Não existe uma máquina.");
                } else {
                    maquina.vender(Integer.parseInt(ui[1]));
                }
            } else if (ui[0].equals("sair")) {
                break;
            } else {
                System.out.println("COMANDO INVÁLIDO! Tente de novo");
            }
        }
        scanner.close();
    }

}
