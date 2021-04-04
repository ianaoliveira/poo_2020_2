
package junkfood;

import java.util.ArrayList;

public class Maquina {
    
    private ArrayList <Espiral> espirais = new ArrayList <Espiral> ();
    private float saldoC;
    private float lucro; 
    private int maxP;
    private int qtdEspirais;

    public Maquina (int maxP, int qtdEspirais) {
        this.maxP = maxP;
        this.qtdEspirais = qtdEspirais;
        for (int i = 0; i < qtdEspirais; i++) {
            espirais.add(new Espiral("empty", 0, 0.0f));
        } 
    }
    
    public boolean alterarEspiral(int index, String nome, int quant, float preco) {
        if (index < 0 || index >= qtdEspirais) {
            System.out.print("ESSE INDICE NÂO EXISTE!");
            return false;
        } else if (quant > maxP || quant < 0) {
            System.out.print("LIMITE EXCEDIDO!");
            return false;
        } else {
            espirais.set(index, new Espiral (nome, quant, preco));
            return true;
        }
    }

    public void limparEspiral (int index) {
        if (index < 0 || index >= qtdEspirais) {
            System.out.print("ESSE INDICE NÂO EXISTE!");
        } else {
            espirais.set(index, new Espiral("empty", 0, 0.0f));
        }
    }

    public boolean inserirDinheiro (float valor) {
        if (valor > 0) {
            saldoC += valor;
            return true;
        } else {
            return false;
        }
    }

    public float pedirTroco () {
        float saldo = saldoC;
        saldoC = 0;
        return saldo;     
    }

    public boolean vender (int index) {
        if (index < 0 || index >= qtdEspirais) {
            System.out.print("ESSE INDICE NÂO EXISTE!");
        } else {
            Espiral espiral = espirais.get(index);
            if (saldoC < espiral.preco) {
                System.out.print("Sem dinheiro, sem produto.");
            } else if (espiral.quant <= 0) {
                System.out.print("Desculpe, este produto acabou.");
            } else {
                saldoC -= espiral.preco;
                espiral.quant -= 1;
                System.out.print("Você comprou um " + espiral.nome + " Obrigada!");
                return true;
            }
        }
        return false;    
    }
    public float getSaldo () {
        return saldoC;
    }

    public String toString () {
        String retorno = "";
        for (int i = 0; i < espirais.size(); i++) {
            retorno += i + " " + espirais.get(i) + "\n";
        }         
        return "Saldo:" + saldoC + "\n" + retorno;
    }

}
