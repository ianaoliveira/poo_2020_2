package contato_agenda2;

import java.util.ArrayList;
import java.util.Comparator;

public class Contato {
    private String name = "";
    private ArrayList<Fone> fones = new ArrayList<Fone>();
    public Contato(String name) {
		setName(name);
	}
	
    public boolean addFone (String id, String number) {
        if (Fone.validate(number)) {
            Fone f = new Fone(id, number);
		fones.add(f);
                    return true;
		} else {
                System.out.print("\nInsira um Número do Telefone valido!");
                    return false;
		}
	}
	
    public boolean rmFone (int index) {
	int size = fones.size();
            if (size > 0) {
                if(index >= fones.size()){
                    System.out.print("\nEsse Indice nao existe na lista de Telefones!");
		} else {
                    fones.remove(index);
                    return true;
			}
		} else {
                    System.out.print("\nInsira um Telefone primeiro!");
		}
		
		return false;
	}

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
	
    public String getAllData() {
	String fonesOrder = "";
	for (Fone fone : fones)
            fonesOrder += fone.getId()+":"+fone.getNumber()+" ";
		return name + fonesOrder;
	}
	
    private String getFones() {
	String fonesOrder = "";
		
            for (int i = 0; i < fones.size(); i++) {
		Fone fone = fones.get(i);

		fonesOrder += " ["+i+":"+fone.getId()+":"+fone.getNumber()+"]";
		}
		
        return fonesOrder;
	}
	
    public static Comparator<Contato> nameComparator = new Comparator<Contato>() {
	public int compare(Contato c1, Contato c2) {
            String name1 = c1.getName().toLowerCase();
            String name2 = c2.getName().toLowerCase();

		return name1.compareTo(name2);
	    }
	};

	@Override
	public String toString() {
            String fonesOrder = getFones();
		
            return name + fonesOrder;
	}
	
}

