package trainingmanagement.control;

class FortbildungszuordnungenAnzeigenK {
	
	   String[] gibBestandeneFortbildungenNamen(String benutzername) {
		   return new ExampleSelectTrainingMappingC().getCompletedTrainingNames(benutzername);
	    }
	    
	    String[] gibBelegteFortbildungenNamen(String benutzername) {
			   return new ExampleSelectTrainingMappingC().gibBelegteFortbildungenNamen(benutzername);
	    }

}
