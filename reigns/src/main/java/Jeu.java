import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    public List<Situation> situations = new ArrayList<Situation>();
    public User user;

    public Jeu(User _user){
        this.user = _user;
    }
    public void ajouterSituation(Situation _situation){
        this.situations.add(_situation);
    }

    Scanner my_scanner = new Scanner(System.in);

    public void jouer(){
        boolean jauges_ok = user.jauges_ok();
        int nb_tours = 0;

        while (jauges_ok){
            int listIndex = (int)(Math.random()*(situations.size()));
            Situation situation_actuelle = situations.get(listIndex);

            System.out.println(situation_actuelle.toString());
            String choix = my_scanner.nextLine();

            while(!choix.toUpperCase().contentEquals("G") && !choix.toUpperCase().contentEquals("D")){
                System.out.println("Choix incorrect !\n");
                System.out.println(situation_actuelle.toString());
                choix = my_scanner.nextLine();
            }

            situation_actuelle.choix(choix, user);
            System.out.println(user.toString());
            jauges_ok = user.jauges_ok();
            nb_tours++;
        }
        System.out.println(user.getUsername() + " a perdu ! Son règne a duré " + nb_tours + " tours !");
        System.exit(0);
    }
}
