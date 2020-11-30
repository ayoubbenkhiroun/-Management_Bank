import java.util.*;

public class Banque_locale_serveur {
	ArrayList<Account> all_accounts;

	public Banque_locale_serveur() {
		all_accounts = new ArrayList();
	}

	public void open_account(String name, String password) {
		if (verify(name, password) == null) {
			Account new_account = new Account(0, name, password);
			all_accounts.add(new_account);
			System.out.println("\t-- Le compte a été créé avec succès --");
		} else
			System.out.println("\t-- Le compte existe déjà !! --");
	}

	public Account verify(String name, String password) {
		int i = 0;
		Boolean test = false;
		Account new_account = null;
		while ((i < all_accounts.size()) && (!test)) {
			if ((all_accounts.get(i).name.equals(name))
					&& (all_accounts.get(i).password.equals(password))) {
				test = true;
				new_account = (Account) all_accounts.get(i);
			} else
				i++;
		}
		return new_account;
	}

	public int close_account(String name, String password) {
		int code_erreur = (-1);
		Account tempAcc = verify(name, password);
		if (tempAcc != null) {
			all_accounts.remove(tempAcc);
			code_erreur = 0;
			System.out.println("\t-- Le compte a été supprimé avec succès --");
		} else
			System.out.println("\t-- Le compte n'existe pas !! --");
		return (code_erreur);
	}

	public void deposit(String name, String password, float money) {

		Account new_account = verify(name, password);
		if (new_account != null) {
			new_account.balance = new_account.balance + money;
		}
	}

	public int withdraw(String name, String password, float amount) {
		int erreur_test = (-1);
		Account new_account = verify(name, password);
		if (new_account != null) {
			if (new_account.balance >= amount) {
				new_account.balance -= amount;
				erreur_test = 0;
			} else
				System.out
						.println("\t-- Votre demande est refusée, le solde de votre compte n'est pas suffisant !! --");

		} else
			System.out.println("\t-- Le compte n'existe pas !! --");
		return (erreur_test);
	}

	public float get_balance(String name, String password) {
		Account tempAcc = verify(name, password);
		if (tempAcc != null) {
			return (tempAcc.balance);
		} else {			
			return (-1);
		}
	}

	public void affiche_liste_comptes() {
		System.out.println(" _______________ _______________ _______________ ");
		System.out.println("|NAME\t\t|PASSWORD\t|BALANCE\t|");
		System.out.println("|_______________|_______________|_______________|");
		for (int i = 0; i < all_accounts.size(); i++) {
			System.out.println("|" + all_accounts.get(i).name + "\t\t|"
					+ all_accounts.get(i).password + "\t\t|"
					+ all_accounts.get(i).balance + "\t\t|");
		}
		System.out.println("|_______________|_______________|_______________|");
	}

}
