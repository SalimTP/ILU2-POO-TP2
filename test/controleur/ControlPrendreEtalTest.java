package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlVerifierIdentite.verifierIdentite("Bonemine");
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlVerifierIdentite.verifierIdentite("Bonemine");
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlVerifierIdentite.verifierIdentite("Bonemine");
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
	}

	

	@Test
	void testVerifierIdentite() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlVerifierIdentite.verifierIdentite("Bonemine");	
	}

}
