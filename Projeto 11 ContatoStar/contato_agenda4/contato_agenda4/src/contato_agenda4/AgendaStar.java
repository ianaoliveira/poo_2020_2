package contato_agenda4;

import java.util.ArrayList;

public class AgendaStar extends Agenda {
	
    public void star(String name, boolean value) {
    	Contato contato = this.getContato(name);
    	
    	if (contato != null) {
    		if (contato instanceof ContactStar) {
    			((ContactStar) contato).setStar(value);
    		} else {
    			throw new RuntimeException("FAIL: Contato " + name + " não é do tipo ContatoStar");	
    		}
    	} else {
    		throw new RuntimeException("FAIL: Contato " + name + " não existe");
    	}
    }

    public ArrayList<Contato> getStarred() {
        ArrayList<Contato> starred = new ArrayList<Contato>();
        
        for (Contato contato: getContatos()) {
            if (contato instanceof ContactStar && ((ContactStar) contato).getStar()) {
                starred.add(contato);
            }
        }
        
        return starred;
    }
}
