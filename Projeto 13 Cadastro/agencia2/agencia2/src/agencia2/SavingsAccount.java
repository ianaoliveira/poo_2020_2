package agencia2;

class SavingsAccount extends Account {
	
    public SavingsAccount(int id, String idClient) {
    	super(id, idClient);
    }
    
    public void monthlyUpdate() {
    	this.balance *= 1.01;
    }
}
