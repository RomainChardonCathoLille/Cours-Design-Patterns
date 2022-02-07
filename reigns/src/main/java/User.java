public class User {
    public int min_rand_value = 15;
    public int max_rand_value = 35;
    
    public int min_value = 0;
    public int max_value = 50;

    public String name;
    public String king_queen;
    public int clerge;
    public int peuple;
    public int armee;
    public int finance;

    public User(String _name, int _king_queen){
        this.name = _name;

        if(_king_queen == 0) this.king_queen = "Roi";
        if(_king_queen == 1) this.king_queen = "Reine";

        this.clerge = (int)(Math.random()*(max_rand_value - min_rand_value +1)+ min_rand_value);
        this.peuple = (int)(Math.random()*(max_rand_value - min_rand_value +1)+ min_rand_value);
        this.armee = (int)(Math.random()*(max_rand_value - min_rand_value +1)+ min_rand_value);
        this.finance = (int)(Math.random()*(max_rand_value - min_rand_value +1)+ min_rand_value);
    }

    public String getUserDetails(){
        if(this.king_queen == "Reine") return "Longue vie à la Reine " + this.name;
        else return "Longue vie au Roi " + this.name;
    }

    private String getUnderScores(int n){
        String underscores = "";
        for(int i = 0; i < n; i++) underscores+="_";
        return underscores;
    }
    private String getHashtags(int n){
        String hashtags = "";
        for(int i = 0; i < n; i++) hashtags+="#";
        return hashtags;
    }

    public String getUsername(){
        return this.name;
    }

    public String toString(){
        String finalString = this.king_queen + " " + this.name + "\n";
        finalString += "[";
        finalString += getHashtags(this.clerge);
        finalString += getUnderScores(this.max_value - this.clerge);
        finalString += "] Clergé\n[";
        finalString += getHashtags(this.peuple);
        finalString += getUnderScores(this.max_value - this.peuple);
        finalString += "] Peuple\n[";
        finalString += getHashtags(this.armee);
        finalString += getUnderScores(this.max_value - this.armee);
        finalString += "] Armée\n[";
        finalString += getHashtags(this.finance);
        finalString += getUnderScores(this.max_value - this.finance);
        finalString += "] Finance";
        return finalString;
    }

    public Boolean jauges_ok(){
        if(this.clerge >= 50 || this.clerge <= 0) return false;
        if(this.peuple >= 50 || this.peuple <= 0) return false;
        if(this.finance >= 50 || this.finance <= 0) return false;
        if(this.armee >= 50 || this.armee <= 0) return false;

        return true;
    }

    public void appliquer_effet(Effet effet){
        this.finance += effet.effet_finance;
        this.armee += effet.effet_armee;
        this.peuple += effet.effet_peuple;
        this.clerge += effet.effet_clerge;
    }
}
