
package junkfood;

public class Espiral {
    String nome; 
    int quant; 
    float preco;

    public Espiral (String nome, int quant, float preco) {
        this.nome = nome; 
        this.quant = quant; 
        this.preco = preco; 
    }

    public String toString () {
        return "[ " + nome + " : " + quant + " U : " + preco + " RS]";
    }
}


