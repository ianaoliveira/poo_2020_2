package clinica_veterinaria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ServicoClinica {
	private int nextSerId = 0;
	private int nextAniId = 0;
	private int nextVenId = 0;
	private HashMap<Integer, Servico> rSer = new HashMap<Integer, Servico>();
	private HashMap<Integer, Animal> rAni = new HashMap<Integer, Animal>();
	private HashMap<String, Cliente> rCli = new HashMap<String, Cliente>();
	private HashMap<Integer, Venda> rVen = new HashMap<Integer, Venda>();
	
	public void addCliente(Cliente cliente) {
		Cliente c = rCli.get(cliente.getIdCliente());
		
		if (c == null) {
			rCli.put(cliente.getIdCliente(), cliente);
		} else {
			throw new RuntimeException("FAIL: Cliente " + cliente.getIdCliente() + " ja cadastrado.");
		}
	}
	
	public void addServico(String nome, String valor) {
		try {
			Servico ser = new Servico(nextSerId, nome, Float.parseFloat(valor));
			Servico s = getServico(nome);
			
			if (s == null) {
				rSer.put(ser.idServico, ser);
				nextSerId++;
			} else {
				throw new RuntimeException("FAIL: Serviço " + nome + " já cadastrado.");
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException("FAIL: O valor passado não é um número!");
		}
	}
	
	public void addAnimal(String idCliente, String nomeAnimal, String especie) {
		Cliente cli = getCliente(idCliente);
		
		if (cli != null) {
			Animal anim = new Animal(nextAniId, nomeAnimal, especie, cli);
			Animal a = rAni.get(anim.idAnimal);
			
			if (a == null) {
				boolean exist = false;
				
				for (Animal ani : cli.getAnimais().values()) {
					if (ani.nome.contains(nomeAnimal)) {
						exist = true;
						break;
					}
				}
				
				if (!exist) {
					cli.addAnimal(anim);
					rAni.put(anim.idAnimal, anim);
					
					nextAniId++;
				} else {
					throw new RuntimeException("FAIL: Cliente " + idCliente +" já possui um animal com nome " + nomeAnimal + ".");
				}
			} else {
				throw new RuntimeException("FAIL: Animal " + nomeAnimal + " já cadastrado.");
			}	
		} else {
			throw new RuntimeException("FAIL: Cliente " + idCliente + " não existe.");
		}
	}
	
	public void vender(String idCliente, String nomeAnimal, String idServico) {
		Cliente cli = getCliente(idCliente);
		
		if (cli != null) {
			Animal anim = getAnimal(nomeAnimal);
			
			if (anim != null) {
				Servico ser = getServico(idServico);
				
				if (ser != null) {
					rVen.put(nextVenId, new Venda(nomeAnimal, idCliente, idServico));
					nextVenId++;
				} else {
					throw new RuntimeException("FAIL: Serviço " + idServico + " não existe.");
				}
			} else {
				throw new RuntimeException("FAIL: Animal " + nomeAnimal + " não existe.");
			}	
		} else {
			throw new RuntimeException("FAIL: Cliente " + idCliente + " não existe.");
		}
	}
	
	public float saldo() {
		float valor = 0f;
		
		for (Venda v : rVen.values()) {
			Servico ser = getServico(v.idServico);
			valor += ser.valor;
		}
		
		return valor;
	}
	
	public ArrayList<Cliente> getAllCliente() {
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		
		for (Cliente c : rCli.values()) {
			list.add(c);
		}
		
		return list;
	}
	
	public ArrayList<Servico> getAllServico() {
		ArrayList<Servico> list = new ArrayList<Servico>();
		
		for (Servico c : rSer.values()) {
			list.add(c);
		}
		
		return list;
	}
	
	public ArrayList<Animal> getAllAnimal() {
		ArrayList<Animal> list = new ArrayList<Animal>();
		
		for (Animal c : rAni.values()) {
			list.add(c);
		}
		
		return list;
	}
	
	public Cliente getCliente(String idCliente) {
		return rCli.get(idCliente);
	}
	
	public Servico getServico(String idServico) {
		for (Servico ser : rSer.values()) {
			if (ser.nome.contains(idServico)) {
				return ser;
			}
		}
		
		return null;
	}
	
	public Animal getAnimal(String idAnimal) {
		for (Animal ani : rAni.values()) {
			if (ani.nome.contains(idAnimal)) {
				return ani;
			}
		}
		
		return null;
	}
	
	public String showAllCliente() {
		String list = "";
		
		for (Cliente c : getAllCliente()) {
			list += "\n cli " + c;
		}
		
		return list;
	}
	
	public String showAllServico() {
		String list = "";
		
		for (Servico s : getAllServico()) {
			list += "\n" + s;
		}
		
		return list;
	}
	
	public String showAllAnimal() {
		String list = "";
		
		for (Animal a : getAllAnimal()) {
			list += "\n" + a;
		}
		
		return list;
	}
	
	public String showAllVenda() {
		String list = "";
		
		for (Entry<Integer, Venda> v : rVen.entrySet()) {
			list += "\n" + "[" + v.getKey() + " " + v.getValue().idAnimal + " " + v.getValue().idCliente + " " + v.getValue().idServico + "]";
		}
		
		return list;
	}
	
	public String showCliente(String idCliente) {
		Cliente c = rCli.get(idCliente);
		String list = "";
		
		if (c != null) {
			HashMap<String, Animal> clienteAnimals = c.getAnimais();
			
			list += "\n cli " + c + " ";
			
			for (Animal a : clienteAnimals.values()) {
				list += a;
			}
			
			return list;
		}
		
		throw new RuntimeException("FAIL: Cliente " + idCliente + " não existe.");
	}
}
