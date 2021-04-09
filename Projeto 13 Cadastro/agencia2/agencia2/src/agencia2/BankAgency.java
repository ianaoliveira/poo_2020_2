package agencia2;

import java.util.HashMap;

class BankAgency {
    private HashMap<String, Client> clients = new HashMap<String, Client>();
    private HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();
    private int nextAccountId = 0;

    private Account getAccount(int id) {
    	return accounts.get(id);
    }
    
    private Client getClient(String clientId) {
    	return clients.get(clientId);
    }
    
    public BankAgency() {}

    public void addClient(String clientId) {
    	if (getClient(clientId) == null) {
    		Client client = new Client(clientId);
    		int idCC = useNextAccountId();
    		int idCP = useNextAccountId();
    		
    		CheckingAccount cc = new CheckingAccount(idCC, clientId);
    		SavingsAccount cp = new SavingsAccount(idCP, clientId);
    		
    		this.accounts.put(idCC, cc);
    		this.accounts.put(idCP, cp);
    		
    		client.addAccount(cc);
    		client.addAccount(cp);
    		
    		clients.put(clientId, client);
    	} else {
    		throw new AccountException("FAIL: Já existe um cliente com esse id!");
    	}
    }
    
    public void withdraw(int idConta, float value) {
    	Account acc = getAccount(idConta);
    	
    	if (acc != null) {
    		acc.withdraw(value);
    	} else {
    		throw new AccountException("FAIL: Conta não encontrada!");
    	}
    }
    
    public void deposit(int idConta, float value) {
    	Account acc = getAccount(idConta);
    	
    	if (acc != null) {
    		acc.deposit(value);
    	} else {
    		throw new AccountException("FAIL: Conta não encontrada!");
    	}
    }
    
    public void transfer(int contaDe, int contaPara, float value) {
    	Account accDe = getAccount(contaDe);
    	Account accPara = getAccount(contaPara);
    	
    	if (accDe != null && accPara != null) {
    		accDe.transfer(accPara, value);
    	} else {
    		throw new AccountException("FAIL: Conta não encontrada!");
    	}
    }
    
    public void monthlyUpdate() {
    	for (Account ac: accounts.values()) {
    		ac.monthlyUpdate();
    	}
    }
    
    public int useNextAccountId() {
    	int id = this.nextAccountId;
    	this.nextAccountId++;
    	
    	return id;
    }
    
    public String toString() {
    	String clientsReturn = "Clients:\n";
    	String accountsReturn = "Accounts:\n";
    	
    	for (Client c : clients.values()) {
    		clientsReturn += c + "\n";
    	}
    	
    	for (Account ac: accounts.values()) {
    		accountsReturn += ac + "\n";
    	}
    	
    	return clientsReturn + accountsReturn;
    }
}
