package agencia2;

abstract class Account {
    protected int id;
    protected float balance;
    protected String clientId;
    protected String type;
    
    public Account(int id, String clientId) {
    	this.id = id;
    	this.clientId = clientId;
    	this.type = (id % 2 == 0) ? "CC" : "CP";
	}

    public abstract void monthlyUpdate();

    public void withdraw(float value) {
    	if (value > 0) {
	    	if (value <= balance) {
	    		balance -= value;
	    	} else {
	    		throw new AccountException("FAIL: Saldo insuficiente");
	    	}
    	} else {
     		throw new AccountException("FAIL: Valor não pode ser menor ou igual a zero");
     	}
	}

    public void deposit(float value) {
    	if (value > 0) {
    		this.balance += value;
    	} else {
    		throw new AccountException("FAIL: Valor não pode ser menor ou igual a zero");
    	}
    }

    public void transfer(Account other, float value) {
    	if (value > 0) {
	    	if (value <= getBalance()) {
	    		this.balance -= value;
	    		other.balance += value;
	    	} else {
	    		throw new AccountException("FAIL: Saldo insuficiente");
	    	}
    	} else {
    		throw new AccountException("FAIL: Valor não pode ser menor ou igual a zero");
    	}
    }
    
    public String toString() {
    	return getId() + ":" + getClientId() + ":" + getBalance() + ":" + getType();
    }
    
    int getId() {
    	return this.id;
    }
    
    float getBalance() {
    	return this.balance;
    }
    
    String getClientId() {
    	return this.clientId;
    }
    
    String getType() {
    	return this.type;
    }
}
