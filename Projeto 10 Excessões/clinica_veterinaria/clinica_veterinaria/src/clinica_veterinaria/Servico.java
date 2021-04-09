package clinica_veterinaria;

public class Servico {
	public int idServico;
	public String nome;
	public float valor;
	
	public Servico(int idServico, String nome, float valor) {
		this.idServico = idServico;
		this.nome = nome;
		this.valor = valor;
	}
	
	public String toString() {
		return "[" + this.nome + " " + this.valor + "]";
	}
	
}
