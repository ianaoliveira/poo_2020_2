package agencia2;

class CheckingAccount extends Account {

    public CheckingAccount(int id, String idClient) {
    	super(id, idClient);
    }

    public void monthlyUpdate() {
    	this.balance -= 20;
    }
}
