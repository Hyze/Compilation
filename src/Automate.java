import com.sun.org.apache.xpath.internal.SourceTree;

public class Automate{
    static boolean automate(String s){
        int etat = 1;
        for(int i=0; i<s.length(); i++){
            System.out.println("--"+ etat+" "+s.charAt(i));
            switch(s.charAt(i)){
                case 'a' :
                    if(etat == 1 || etat ==2 || etat == 4){
                        etat = 2;
                        break;
                    }else{return false;}
                case 'b' :
                    if(etat == 2){
                        etat = 3;
                        break;
                    }else{return false;}
                case 'c' :
                    if (etat == 3){
                        etat = 4;
                        break;
                    }else{return false;}
                default :
                System.out.println("Hors caractere d'entrée : " +s.charAt(i));
                return false;
            }
        }
        System.out.println("--" + etat);
        return(etat == 2)||(etat ==4);
    }

    public static void main(String [] args){
        boolean res;
        if (args.length == 0){
            System.out.println("chaines attendues");
            for(int i = 0; i<args.length; i++){
                System.out.println("Chaine testee : "+args[i]);
                res=automate(args[i]);
                System.out.println("Résultat : "+res);
            }
        }
    }
}