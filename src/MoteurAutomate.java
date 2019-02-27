import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MoteurAutomate {
    private String Commentaire ;
    private char Meta;
    private ArrayList<String> VocEntrée;
    private ArrayList<String> VocSortie;
    private int Etat;
    private int EtatInit;
    private ArrayList EtatAcceptant;
    private ArrayList<ArrayList> Transitions;



    public MoteurAutomate(){
        this.VocEntrée = new ArrayList<>();
        this.VocSortie = new ArrayList<>();
        this.EtatAcceptant = new ArrayList();
        this.Transitions = new ArrayList<ArrayList>();
        Meta='#';
        EtatInit=0;

    }

    public void constructAutomate(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader fis = new BufferedReader(new FileReader(file));
        String str = "";
        String contenu ="";
        while ((str = fis.readLine()) != null){
            if(str.startsWith("C")){
                this.Commentaire =str.split("'")[1];

            }
                if(str.startsWith("V")){
                    String precoupe = str.split(" ")[1];
                    precoupe = precoupe.replace("\"","");
                    String [] Char = precoupe.split("(?!^)");
                    for (String s: Char) {
                        this.VocEntrée.add(s);
                    }
                }
            if(str.startsWith("O")){
                String precoupe = str.split(" ")[1];
                precoupe = precoupe.replace("\"","");
                String [] Char = precoupe.split("(?!^)");
                for (String s: Char) {
                    this.VocSortie.add(s);
                }
            }
            if(str.startsWith("E")){
                this.Etat =Integer.parseInt( str.split(" ")[1]);

            }
            if(str.startsWith("I")){
                this.EtatInit =Integer.parseInt( str.split(" ")[1]);

            }
            if(str.startsWith("F")){
                String [] tab = str.split(" ");
                for (String s: tab) {
                    if(!s.equals("F"))
                    this.EtatAcceptant.add(s);
                }
            }
            if(str.startsWith("T")){
                str = str.replace("\"","");
                str = str.replace("\'","");
                str = str.replace("T","");
                String[] tab = str.split(" ");
                ArrayList<String> tab2 = new ArrayList<String>();
                int indice =0;
                for (String t :tab) {
                    if(!t.equals("")){
                        tab2.add((t);

                    }
                }

                Transitions.add(tab2);
            }






        }



        fis.close();
    }


    public String affiche( ArrayList tab ){
        String str ="[";
        for (int i=0;i<tab.size();i++){
            if(i==0){
                str += (String) tab.get(i);
            }else {
                str = str + "," + (String) tab.get(i);
            }
        }
        str += "]";

        return str;
    }

    public String transition(ArrayList tab ){
        String str = "[";
        String substring ="[";
        int compteur =0;
        for (int i =0;i<Transitions.size();i++){
            for (Object s :Transitions.get(i)) {
                if(compteur==0){
                    substring += s;
                }
                else{
                    substring+=","+s;
                }
                compteur++;
            }
            substring+="]";

            if(i==0){
                str+=substring;
            }else {
                str+=","+substring;
            }
            substring="[";
            compteur=0;
        }
        str+="]";
        return str;
    }


    public void fonctionne(){
        System.out.println("Mot d'entrée : "+affiche(VocEntrée));
        int EtatTemp=EtatInit;
        boolean continuer = true;
        String motRetour="";
        ArrayList temp ;
        int indice =0;
            for (int i = 0; i < Transitions.size(); i++) {
                      temp = Transitions.get(i);
                      for (int j=0;j<temp.size();i++){
                          if(Integer.parseInt((String) temp.get(i)) == EtatTemp){

                          }
                      }
            }

        System.out.println(motRetour);
    }




    public static void main(String[] args) throws IOException {
    MoteurAutomate automate = new MoteurAutomate();
    automate.constructAutomate("testMoteur/T6.descr");
       System.out.println(automate);
       automate.fonctionne();
    }



    public String toString(){
        return "Commentaire : "+Commentaire +"\n"+
                "Meta : "+Meta+"\n"+
                "Vocabulaire d'entrée : " + affiche(VocEntrée)+"\n" +
                "Vocaublaire sortie : " + affiche(VocSortie) + "\n"+
                "Nombre d'etat : "+Etat +"\n"+
                "Etat initial  : "+ EtatInit+ "\n"+
                "Etat Acceptant : " + affiche(EtatAcceptant) + "\n"+
                "Transition : " + transition(Transitions)+"\n";
    }
}


