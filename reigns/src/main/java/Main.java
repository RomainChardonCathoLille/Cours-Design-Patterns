import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String username;
        String queen_king;
        Scanner my_scanner = new Scanner(System.in);

        System.out.println("Création du personnage...");
        System.out.println("Entrez le nom du personnage:");
        username = my_scanner.nextLine();
        System.out.println("Faut-il vous appeller Roi ou Reine ? (0 pour Roi, 1 pour Reine)");
        queen_king = my_scanner.nextLine();

        User user = new User(username, Integer.parseInt(queen_king));
        System.out.println(user.getUserDetails());
        System.out.println(user.toString());

        Jeu jeu = new Jeu(user);
        jeu.ajouterSituation(new Situation(" [Main du roi] Le peuple souhaite libérer les prisonniers [G: oui, D: non]", new Effet(0,5,-5,0), new Effet(0,-7,0,0)));
        jeu.ajouterSituation(new Situation("[Paysan] Il n’y a plus à manger [G]: importer de la nourriture; [D]: ne rien faire]", new Effet(0,5,0,-5), new Effet(0,-5,0,0)));
        jeu.ajouterSituation(new Situation("[Prêtre] Les dieux sont en colère [G: faire un sacrifice; D: ne rien faire]", new Effet(5,-3,0,0), new Effet(-5,0,0,0)));
        jeu.ajouterSituation(new Situation("[Main du roi] Le Roi Baratheon rassemble son armée [G : le soutenir ; D : rester neutre]", new Effet(-3,0,3,-3), new Effet(0,3,0,0)));
        jeu.ajouterSituation(new Situation("[Paysan] Abondance de récoltes cette année [G: taxer énormément; D: taxer un tout petit peu]", new Effet(0,-5,0,10), new Effet(0,-3,0,1)));

        jeu.jouer();


    }
}
