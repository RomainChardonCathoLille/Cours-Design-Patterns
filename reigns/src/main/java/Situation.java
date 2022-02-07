import java.util.Locale;

public class Situation {
    public String situation;
    public Effet effet_gauche;
    public Effet effet_droite;

    public Situation(String _situation, Effet _effet_g, Effet _effet_d){
        this.situation = _situation;
        this.effet_gauche = _effet_g;
        this.effet_droite = _effet_d;
    }

    public String toString(){
        return this.situation + "\nEffet G: " + effet_gauche.toString() + "\nEffet D: " + effet_droite.toString();
    }

    public void choix(String choix, User utilisateur){
        if(choix.toUpperCase() == "G"){
            utilisateur.appliquer_effet(this.effet_gauche);
        } else {
            utilisateur.appliquer_effet(this.effet_droite);
        }
    }
}
