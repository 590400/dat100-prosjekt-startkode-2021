package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for � lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene.
 * N�r programmet er ferdig settes denne til 13, men under utvikling / testing
 * kan det v�re praktisk � ha denne mindre.
 * 
 */

public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {

		samling = new Kort[MAKS_KORT];
		antall = 0;

	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke v�re full.
	 * Kortene ligger sammenhengende fra starten av tabellen. Kan f� tilgang til
	 * antallet ved � bruke metoden getAntallKort(). Metoden er f�rst og fremst ment
	 * � brukes i testklasser. Om man trenger kortene utenfor, anbefales metoden
	 * getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {

		return samling;

	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {

		return antall;
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {

		if (antall == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		if (antall <= MAKS_KORT) {
			samling[antall] = kort;
			antall++;

		}
	}

	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil v�re sortert
	 * slik at de normalt m� stokkes f�r bruk.
	 */
	public void leggTilAlle() {

		// Husk: bruk Regler.MAKS_KORT_FARGE for � f� antall kort per farge
		int j = 0;
		for (Kortfarge f : Kortfarge.values()) {

			for (int i = 0; i < Regler.MAKS_KORT_FARGE; i++) {
				samling[i + 3 * j] = new Kort(f, i + 1);
				antall++;
			}
			j++;
		}

	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {

		samling = new Kort[MAKS_KORT];
		antall = 0;
	}

	/**
	 * Ser p� siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga
	 *         er tom, returneres null.
	 */
	public Kort seSiste() {

		// TODO - START

		if (antall == 0)
			return null;

		else
			return samling[antall - 1];

		// TODO - END

	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres null.
	 */
	public Kort taSiste() {

		// TODO - START

		if (antall == 0)
			return null;

		else {
			for (int i = MAKS_KORT - 1; i >= 0; i--) {
				if (samling[i] != null) {

					Kort tmp = samling[i];
					samling[i] = null;
					antall--;
					return tmp;
				}

			}
			return null;
		}

		// TODO - END
	}

	/**
	 * Unders�ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {


		
		for (int i = 0; i < samling.length; i++) {
			if (kort == null);
			else if (samling[i]== null);
			else if (kort.lik(samling[i])) {
				return true;
			}
			

		}return false;
	}

	/**
	 * Fjernar et kort fr� samlinga. Dersom kortet ikke finnest i samlinga, skjer
	 * ingenting med samilingen
	 * 
	 * @param kort kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *             ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */

	public boolean fjern(Kort kort) {

		if (kort == null)
			return false;

		for (int i = 0; i < MAKS_KORT; i++) {
			if (kort == samling[i]) {
				samling[i] = null;
				antall--;
				return true;
			}

		}
		return false;
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkef�lge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {

		Kort[] tmp = new Kort[antall];
		int j = 0;
		for (int i = 0; i < samling.length; i++) {

			if (samling[i] != null)
				tmp[j] = samling[i];
			j++;

		}
		return tmp;
	}

}