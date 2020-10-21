package Controller;


import java.util.ArrayList;
import java.util.List;

public class Compteur implements Runnable{

    private List<Integer> listePremier;
    private int borneInf;
    private int borneSup;
    
    public Compteur(int borneInf, int borneSup) {
        this.borneInf = borneInf;
        this.borneSup = borneSup;
        listePremier = new ArrayList<>();
    }
    public void Recherche(){
        for (int i = borneInf; i<=borneSup; i++){
            if (VerifPremier.verifPremier(i)){
                listePremier.add(i);
                System.out.println( "Nombre premier "+i);
            }
        }
    }

    @Override
    public void run() {
        Recherche();
        System.out.println("De ["+borneInf+","+borneSup+"] "
                +" il y a "+listePremier.size()+
                (listePremier.size()<=1 ? " nombre premier trouvé ":" nombres premiers trouvés "));
    }
}
