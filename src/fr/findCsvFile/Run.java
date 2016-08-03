package fr.findCsvFile;

import java.io.File;
import java.io.FileNotFoundException;

import fr.findCsvFile.DAO.FindEmail;

public class Run {

	public static void main(String[] args) throws FileNotFoundException {
		String pathToExplore = "C:\\Users\\amounier\\Desktop\\Rigowork\\data\\data";
		
		FindEmail findEmail = new FindEmail(pathToExplore, true, "lea.bourbigot@gmail.com"); /* lila.sid@libertysurf.fr cette adresse email n'est présente dans aucun fichier csv du répertoire*/
		findEmail.run();
		
		Long start = System.currentTimeMillis();
		System.out.println("----------");
		System.out.println("Analyse de " + pathToExplore + " en " + (System.currentTimeMillis() - start) + " mses");
		System.out.println(findEmail.dircount + " dossiers");
		System.out.println(findEmail.filecount + " fichiers");
	}

}
