package agencia2;

import java.util.ArrayList;

class Client {
    private String clientId;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    
    public Client(String clientId) {
    	setClientId(clientId);
    }
    
    public void addAccount(Account account) {
    	getAccounts().add(account);
    }
    
    public String toString() {
    	String acc = "";
    	
    	for (Account a : accounts) {
    		acc += a.getId() + ", ";
    	}
    	
    	acc = "[" + acc.substring(0, acc.length() - 2) + "]";
    	
    	return "- " + getClientId() + " " + acc;
    }
    
    String getClientId() {
    	return this.clientId;
    }
    
    void setClientId(String clientId) {
    	this.clientId = clientId;
    }
    
    ArrayList<Account> getAccounts() {
    	return this.accounts;
    }
    
    void setAccounts(ArrayList<Account> accounts) {
    	this.accounts = accounts;
    }
}
