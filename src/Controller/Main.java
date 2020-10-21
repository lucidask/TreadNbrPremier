package Controller;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Scanner scr= new Scanner(System.in);
        int b1,b2;
        System.out.print("Borne Inferieure: ");
        b1=scr.nextInt();
        System.out.print("Borne Superieure: ");
        b2=scr.nextInt();
        int c=(b2-b1)+1;
        int k=(int) Math.ceil(c*0.1);//total thread
        int q= (int) Math.ceil((double) c/(double)k);//qte element into interval

        Compteur[] tabComp= new Compteur[k];
        Thread[] tabThead= new Thread[k];

        for (int i=0;i<c;i+=q){
            if((i+q)-c>0&&(i+q)-c<q) {
                tabComp[i / q] = new Compteur(b1 + i, b1 + c-1 );
                tabThead[i / q] = new Thread(tabComp[i / q]);
                tabThead[i / q].start();
                tabThead[i / q].join();
            }else {
                tabComp[i / q] = new Compteur(b1 + i, b1 + i + q - 1);
                tabThead[i / q] = new Thread(tabComp[i / q]);
                tabThead[i / q].start();
                tabThead[i / q].join();
            }
        }
    }
}
