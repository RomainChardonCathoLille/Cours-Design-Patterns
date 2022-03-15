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

        while(!queen_king.contentEquals("0") && !queen_king.contentEquals("1")){
            System.out.printf("Choix incorrect !\n");
            System.out.println("Faut-il vous appeller Roi ou Reine ? (0 pour Roi, 1 pour Reine)");
            queen_king = my_scanner.nextLine();
        }

        User user = new User(username, Integer.parseInt(queen_king));
        System.out.println(user.getUserDetails());
        System.out.println(user.toString());

        Jeu jeu = new Jeu(user);
        jeu.ajouterSituation(new Situation("[Main du Roi] Le peuple souhaite libérer les prisoniers [G: OUI; D: NON]", new Effet(0, 5, -5, 0), new Effet(0,-7,0,0)));
        jeu.ajouterSituation(new Situation("[Paysan] Il n'y a plus rien à manger [G: Importer de la nourriture; D: Ne rien faire]", new Effet(0,5,0,-5), new Effet(0,-5,0,0)));
        jeu.ajouterSituation(new Situation("[Prêtre] Les Dieux song en colère [G: Faire un sacrifice; D: Ne rien faire]", new Effet(5,-3,0,0), new Effet(-5,0,0,0) ));
        jeu.ajouterSituation(new Situation("[Main du Roi] Le Roi Baratheon rassemble son armée [G: Le soutenir; D: Rester neutre]", new Effet(-3,0,3,-3), new Effet(0,3,0,0)));
        jeu.ajouterSituation(new Situation("[Paysan] Abondance de récoltes cette année [G: Taxer énormément; D: Taxer un tout petit peu]", new Effet(0,-5,0,10), new Effet(0,-3,0,1)));

        jeu.jouer();
    }
}
