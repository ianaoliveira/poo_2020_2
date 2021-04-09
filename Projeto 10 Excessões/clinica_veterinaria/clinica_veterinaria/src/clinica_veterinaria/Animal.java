package clinica_veterinaria;

public class Animal {
	public int idAnimal;
	public String nome;
	public String especie;
	public Cliente dono;
	
	public Animal(int idAnimal, String nome, String especie, Cliente dono) {
		this.idAnimal = idAnimal;
		this.nome = nome;
		this.especie = especie;
		this.dono = dono;
	}

	public String toString() {
		return "[" + this.idAnimal + ":" + this.nome + ":" + this.especie + "]";
	}
	
}
