package agencia2;

import java.util.Scanner;

public class Agencia2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAgency agency = new BankAgency();
        
        while(true){
            try {
                String line = scanner.nextLine();
                System.out.println("$" + line);
                String ui[] = line.split(" ");
                if(line.equals("end")) {
                    break;
                } else if(ui[0].equals("show")) {
                    System.out.println(agency);
                } else if(ui[0].equals("addCli")) {
                    agency.addClient(ui[1]);
                } else if(ui[0].equals("saque")) {
                    agency.withdraw(Integer.parseInt(ui[1]), Float.parseFloat(ui[2]));
                } else if(ui[0].equals("deposito")) {
                    agency.deposit(Integer.parseInt(ui[1]), Float.parseFloat(ui[2]));
                } else if(ui[0].equals("transf")) {
                    agency.transfer(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Float.parseFloat(ui[3]));
                } else if(ui[0].equals("update")) {
                    agency.monthlyUpdate();
                } else {
                    System.out.println("fail: comando invalido");
                }
            } catch (AccountException ae) {
                System.out.println(ae.getMessage());
            }
        }
        scanner.close();
    }
}
