/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calango;

public class Calango {

    int energia; //atributo -> estado
    int maxEnergia;
    int nPatas;
    boolean estaVivo;
    boolean temRabo;
    boolean evoluir;
    int quant_comida;
    String level;

    //parametros
    Calango(int energia, int nPatas){
        this.energia = energia;
        this.maxEnergia = energia;
        this.nPatas = nPatas;
        this.estaVivo = true;
        this.temRabo = true;
        this.evoluir = true;
    }

    void comer () {
        int chance = (int) (Math.random()*10);
        if (chance > 6) {
            quant_comida += 1;
            System.out.println("Hora do rango!");
            
        } else {
            System.out.println("Hoje não é meu dia de sorte!");
        }
    }
            

    void evoluir () {
        if (quant_comida == 15 && level != "camaleao") {
            evoluir = true;
            level = "camaleao";
            System.out.println("Parabéns! Você acabou de evoluir e se tornar um camaleão!");
        } else if (quant_comida == 30 && level != "dragao") {
            evoluir = true; 
            level = "dragao";
            System.out.println("Parabéns! Você acabou de evoluir e se tornar um dragão!");  
        } else if (quant_comida > 16) {
            evoluir = false;
            level = "maximo";
            System.out.println("Você já está no nível máximo.");
        } else {
            evoluir = false;
        }

    }


    void correr(){ //métodos -> comportamento
        if(nPatas < 2){
            System.out.println("Estou temporariamente impossibilitado");
            return;
        }
        if(energia > 0){
            System.out.println("Dando uma carreira");
            energia -= 1;
        } else{
            System.out.println("Estou muito cansado");
        }
        comer(); 
        evoluir();
    }
    
    void brigar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Arri egua, perdi uma pata");
        } else if (temRabo) {
            temRabo = false;
            System.out.println("Me levaram até o rabo!");
        } else {
            estaVivo = false;
            System.out.println("Adeus mundo cruel!");
        }
    }

    void regenerar(){
        if (!estaVivo) {
            System.out.println("Nem morto eu tenho descanso?");
        }
        
        if (nPatas < 4) {
            nPatas += 1;
            System.out.println("Se Deus me odeia porque eu sempre venço? Nasceu uma pata!");
        } else if (!temRabo) {
	    temRabo = false;
	    System.out.println("Tô de rabo novo!");
	} else {
	    System.out.println("Já tenho 4 patinhas!");
	}
    }

    void descansar(int turnos){
        System.out.println("O pai tá off!");
        energia += turnos;

        if(energia > maxEnergia)
            energia = maxEnergia;
    }
    //metodo que informa como o meu objeto deve ser convertido para Texto
    public String toString() {
    	return "Calango : energia:" + energia + " patas:" + nPatas + " rabo:" + temRabo + " nível:" + level;
    }

    public static void main(String[] args) { 
        //tipo nome_da_referencia;
        Calango deadpool = new Calango(10, 4);
        System.out.println(deadpool);

        for(int i = 0; i < 150; i++)
            deadpool.correr();
        
        System.out.println(deadpool);

    }
}
