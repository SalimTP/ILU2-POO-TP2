package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis désolé " + nomVendeur 
					+ "mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println("Je suis désolé " + nomVendeur 
					+ " vous ne faites pas partie du village.");
		} 
		else {
			System.out.println("Bonjour " + nomVendeur + "je vais regarder si je peux vous trouver étal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur 
						+ "je n'ai plus d'étal qui ne soit pas déjà occupé");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
        //TODO a completer
        StringBuilder question = new StringBuilder(); 
        System.out.println("C'est parfait il me reste un étal pour vous !\n");
        System.out.println("Il me faudrait quelques renseignements :\n");            
        System.out.println("Quel produit souhaitez-vous vendre ?\n");
        String produit = scan.nextLine();    
        question.append("Combien souhaitez-vous en vendre ?\n");
        int nbProduit = Clavier.entrerEntier (question.toString());
        int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
        if(numeroEtal!=-1){
            System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal numéro " + numeroEtal);
        }
    

    }
}
