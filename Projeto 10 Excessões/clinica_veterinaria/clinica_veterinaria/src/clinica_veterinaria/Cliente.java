package clinica_veterinaria;

import java.util.HashMap;

public class Cliente {
	public String idCliente;
	public String nome;
	private HashMap<String, Animal> animais = new HashMap<String, Animal>();
	
	public Cliente(String idCliente, String nome) {
		this.idCliente = idCliente;
		this.nome = nome;
	}
	

	public void addAnimal(Animal animal) {
		animais.put(animal.nome, animal);
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String id) {
		this.idCliente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashMap<String, Animal> getAnimais() {
		return animais;
	}
	
	public String toString() {
		return getIdCliente() + ": " + getNome();
	}
	
}
