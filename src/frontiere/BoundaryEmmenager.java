package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous Ãªtes dÃ©jÃ  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("ÃŠtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
	                System.out.println("Bienvenue villageois " + nomVisiteur + " !");
	                question.setLength(0);
	                question.append("Quelle est votre force\n");
	                int force = Clavier.entrerEntier(question.toString());
	                controlEmmenager.ajouterGaulois(nomVisiteur, force);
	                break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
        StringBuilder question = new StringBuilder();
        System.out.println("Bienvenue druide " + nomVisiteur + " !");
        question.append("Quelle est votre force\n");
        int force = Clavier.entrerEntier(question.toString());
        int effetPotionMin = 5;
        int effetPotionMax = 0;
        question.setLength(0);
        while (effetPotionMin>effetPotionMax) {
            question.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
            effetPotionMin = Clavier.entrerEntier(question.toString());
            question.setLength(0);
            question.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
            effetPotionMax = Clavier.entrerEntier(question.toString());
            question.setLength(0);
            if (effetPotionMin>effetPotionMax) {
                System.out.println("Attention Druide,vous vous êtes trompé entre le minimum et le maximum");
            }
        }
        controlEmmenager.ajouterDuide(nomVisiteur, force, effetPotionMin, effetPotionMax);
    }
}
