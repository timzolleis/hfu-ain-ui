package trainingmanagement.control;

class SachbearbeiterLoeschenK {
	String loescheSachbearbeiter(String benutzername) {
		return Sachbearbeiter.gib(benutzername).loesche();
	}

}
