package topic;

import java.util.ArrayList;

public class TransporteAlternativo {
    public int lotMax;
    public ArrayList <Pass> cadeiras = new ArrayList <Pass> ();
    public int qtdPref;
    
        TransporteAlternativo (int lotMax, int qtdPref) {
            this.lotMax = lotMax;
            this.qtdPref = qtdPref;
            for (int i = 0; i < lotMax; i++) {
                cadeiras.add(null);
            }
            
        }

    public void inserir (Pass psg) {
        if (qtdCad() < lotMax) {
            if (psg.getIdade() > 60) {
                if (qtdCadPref() < qtdPref) {
                    for (int i = 0; i < qtdPref; i++) {
                        if (cadeiras.get(i) == null) {
                           cadeiras.set(i, psg); 
                           break;
                        }
                    }
                } else {
                    for (int i = qtdPref; i < lotMax; i++) {
                        if (cadeiras.get(i) == null) {
                           cadeiras.set(i, psg); 
                           break;
                        }
                    }
                }
            } else {
                if (qtdCadNorm() > 0) {
                    for (int i = qtdPref; i < lotMax; i++) {
                        if (cadeiras.get(i) == null) {
                           cadeiras.set(i, psg); 
                           break;
                        }
                    }
                } else {
                    for (int i = 0; i < qtdPref; i++) {
                        if (cadeiras.get(i) == null) {
                           cadeiras.set(i, psg); 
                           break;
                        }
                    }
                }
            }  
        } else {
            System.out.println("FAIL! A topic está lotada.");
        }
        
    }

    public int qtdCad () {
        int cont = 0;
        for (int i = 0; i < lotMax; i++) {
            Pass p = cadeiras.get(i); 

            if (p != null) {
                cont++;
            }
        }
        return cont;
    }

    public int qtdCadPref () {
        int cont = 0;
        for (int i = 0; i < lotMax; i++) {
            Pass p = cadeiras.get(i); 
            if (i < qtdPref) {
                if (p != null) {
                    cont++;
                }
            }     
        }
        return cont;
    }

    public int qtdCadNorm () {
        int cont = 0;
        for (int i = 0; i < lotMax; i++) {
            Pass p = cadeiras.get(i); 
            if (i >= qtdPref) {
                if (p == null) {
                    cont++;
                }
            }     
        }
        return cont;
    }

    public void retirar (String id) {
        boolean existe = false;
        for (int i = 0; i < lotMax; i++) {
            Pass p = cadeiras.get(i);
            if (p != null && p.getNome().equals(id)) {
                cadeiras.set(i, null);
                existe = true; 
                break;
            } 
        }
        if (!existe) {
            System.out.println("FAIL! Essa pessoa não existe.");
        }
    }
    

    public String toString () {
        String ordem = "";
        for (int i = 0; i < lotMax; i++) {
            Pass p = cadeiras.get(i);
            if (i < qtdPref) {
                ordem += "@ "; 
            } else {
                ordem += "= ";
            }
            ordem += p;
        }
        return "[ " + ordem + " ]";
    }
        
}