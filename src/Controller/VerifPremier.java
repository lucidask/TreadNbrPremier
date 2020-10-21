package Controller;

public final class  VerifPremier {
    public static boolean verifPremier(Integer p){
        int i; // for looping
        if(p <= 3){
            return (p > 1);
        }else if( p % 2 == 0 || p % 3 == 0){
            return false;
        }
        i= 5;
        while ((i * i) <= p){
            if(p % i == 0 || p % (i+2) == 0){
                return false;
            }
            i+=6;
        }
        return true;
    }
}
