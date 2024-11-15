package trainingmanagement.control;


class FortbildungZuordnenK {

	void belegeFortbildung(String sachbearbeiterName, String fortbildungName) {
		Fortbildung fortbildung = Fortbildung.gib(fortbildungName);
		Sachbearbeiter sachbearbeiter = Sachbearbeiter.gib(sachbearbeiterName);
		sachbearbeiter.belege(fortbildung);
	}

	void besteheFortbildung(String sachbearbeiterName, String fortbildungName) {
		Fortbildung fortbildung = Fortbildung.gib(fortbildungName);
		Sachbearbeiter sachbearbeiter = Sachbearbeiter.gib(sachbearbeiterName);
		sachbearbeiter.bestehe(fortbildung);
	}


}
