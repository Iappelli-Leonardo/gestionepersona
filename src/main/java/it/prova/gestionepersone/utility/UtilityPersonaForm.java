package it.prova.gestionepersone.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionepersone.model.Persona;


//nel nome della classe vi è Persona in quanto è una classe specifica
public class UtilityPersonaForm {

	public static Persona createPersonaFromParams(String nomeInputParam, String cognomeInputParam,
			String altezzaInputParam, String dataNascitaStringParam) {

		Persona result = new Persona(nomeInputParam, cognomeInputParam);

		if (NumberUtils.isCreatable(altezzaInputParam)) {
			result.setAltezza(Integer.parseInt(altezzaInputParam));
		}
		result.setDataNascita(parseDateArrivoFromString(dataNascitaStringParam));

		return result;
	}

	public static boolean validatePersonaBean(Persona personaToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(personaToBeValidated.getNome())
				|| StringUtils.isBlank(personaToBeValidated.getCognome())
				|| personaToBeValidated.getAltezza() == null 
				|| personaToBeValidated.getAltezza() < 1
				|| personaToBeValidated.getDataNascita() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataNascitaStringParam) {
		if (StringUtils.isBlank(dataNascitaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataNascitaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
