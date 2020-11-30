import java.util.*;

public class Banque_locale {

	public static void main(String[] args) {		
			
		Banque_locale_serveur B_L_S = new Banque_locale_serveur();
		
		/** * Instance de la classe "Scanner" pour la lecture à partir de clavier ** */
		Scanner myScanner = new Scanner(System.in);
		
		int choix_utilisateur = 0;	
		String name = null;
		String password = null;

		while (true) {

			/** * Affichage du menu principal ** */
			afficher_menu();

			while ((choix_utilisateur != 1) && (choix_utilisateur != 2)
					&& (choix_utilisateur != 3) && (choix_utilisateur != 4)
					&& (choix_utilisateur != 5) && (choix_utilisateur != 6)) {

				System.out.println("Veuillez saisir un numéro entre 1 et 6 :");

				/***************************************************************
				 * * Gérer l'exception dans le cas de saisie de caractères non
				 * entiers
				 **************************************************************/
				try {
					choix_utilisateur = myScanner.nextInt();
				} catch (Exception e) {
					System.out.println("Attention: Mauvaise saisie !!");
					myScanner.nextLine();
				}
			}

			/**
			 * * Absorber la dernière entrée (\n) saisie par l'utilisateur pour
			 * vider le scanner **
			 */
			myScanner.nextLine();

			switch (choix_utilisateur) {

			case 1:
				System.out
						.println("\n\t*** Création d'un compte bancaire ***\n");

				System.out
						.println("Veuillez saisir le nom du nouveau client :");
				name = myScanner.nextLine();

				System.out
						.println("Veuillez saisir le mot de passe du nouveau client :");
				password = myScanner.nextLine();

				B_L_S.open_account(name, password);
				break;

			case 2:
				System.out.println("\n\t*** Modification d'un compte ***\n");

				char choixUpdateAccount = ' ';
				while ((choixUpdateAccount != 'd')
						&& (choixUpdateAccount != 'w')) {
					System.out.println("deposit or withdraw (d/w)?");
					choixUpdateAccount = myScanner.nextLine().charAt(0);
				}

				System.out.println("Veuillez saisir le nom du client :");
				name = myScanner.nextLine();

				System.out
						.println("Veuillez saisir le mot de passe du client :");
				password = myScanner.nextLine();

				System.out.println("Veuillez saisir le montant :");
				float money = myScanner.nextFloat();
				myScanner.nextLine();
				
				if (choixUpdateAccount == 'd') {
					B_L_S.deposit(name, password, money);
				} else {
					B_L_S.withdraw(name, password, money);
				}

				break;

			case 3:
				System.out.println("\n\t*** Consultation de solde ***\n");

				System.out.println("Veuillez saisir le nom du compte :");
				name = myScanner.nextLine();

				System.out
						.println("Veuillez saisir le mot de passe du compte :");
				password = myScanner.nextLine();
				float retour = B_L_S.get_balance(name, password);
				if (retour != -1) {
					System.out.println("\t-- Votre solde est : " + retour
							+ " dt --");
				} else {
					System.out.println("\t-- Le compte n'existe pas !! --");
				}
				break;

			case 4:
				System.out
						.println("\n\t*** Fermeture d'un compte bancaire ***\n");

				System.out
						.println("Veuillez saisir le nom du compte de client à fermer :");
				name = myScanner.nextLine();

				System.out
						.println("Veuillez saisir le mot de passe du compte de client à fermer:");
				password = myScanner.nextLine();

				B_L_S.close_account(name, password);
				break;

			case 5:
				/** * Affichage du tableau contenant les comptes créés ** */
				B_L_S.affiche_liste_comptes();
				break;

			default:
				System.out.println("\n\t*** Merci ***\n");
				System.exit(1);
				break;
			}

			choix_utilisateur = 0;

			System.out
					.println("\n\n\t =====================================================");

		}
	}

	public static void afficher_menu() {
		System.out
				.println("\n\t ____________________________________________________");
		System.out
				.println("\t|         Bienvenue sur le système de Banque         |");
		System.out
				.println("\t|____________________________________________________|");
		System.out
				.println("\t|                                                    |");
		System.out
				.println("\t|    1 - Ouvrir un nouveau compte bancaire.          |");
		System.out
				.println("\t|    2 - Modifier le solde d'un compte bancaire.     |");
		System.out
				.println("\t|    3 - Consulter le solde d'un compte bancaire.    |");
		System.out
				.println("\t|    4 - Fermer un compte bancaire.                  |");
		System.out
				.println("\t|    5 - Afficher tous les comptes bancaires.         |");
		System.out
				.println("\t|    6 - Quitter l'application.                      |");
		System.out
				.println("\t|____________________________________________________|");
	}
}