public class Effet {
    public int effet_clerge;
    public int effet_peuple;
    public int effet_armee;
    public int effet_finance;

    public Effet(int _effet_clerge, int _effet_peuple, int _effet_armee, int _effet_finance){
        this.effet_clerge = _effet_clerge;
        this.effet_peuple = _effet_peuple;
        this.effet_armee = _effet_armee;
        this.effet_finance = _effet_finance;
    }

    public String toString(){
        String s = "";
        if(this.effet_finance != 0) s+="jauge finance: " + this.effet_finance + ";";
        if(this.effet_armee != 0) s+="jauge armée: " + this.effet_armee + ";";
        if(this.effet_peuple != 0) s+="jauge peuple: " + this.effet_peuple + ";";
        if(this.effet_clerge != 0) s+="jauge clergé: " + this.effet_clerge + ";";
        return s;
    }
}
