package contato_agenda4;

import java.util.ArrayList;

public class ContactStar extends Contato {
	private boolean star;
	
    public ContactStar(String name, boolean star) {
    	super(name);
        this.star = star;
    }
    
    public ContactStar(String name, ArrayList<Fone> fones, boolean star) {
    	super(name);
        this.star = star;
    }

    public void setStar(boolean value) {
    	this.star = value;
    	this.prefix = value ? "@" : "-";
    }
    
    public boolean getStar() {
    	return this.star;
    }

}
