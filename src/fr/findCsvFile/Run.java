package fr.findCsvFile;

import fr.findCsvFile.service.DiskFileExplorer;

public class Run {

	public static void main(String[] args) {
		String pathToExplore = "C:\\Users\\amounier\\Desktop\\Rigowork\\data\\data";
		DiskFileExplorer diskFileExplorer = new DiskFileExplorer(pathToExplore, true);
		Long start = System.currentTimeMillis();
		diskFileExplorer.list();
		System.out.println("----------");
		System.out.println("Analyse de " + pathToExplore + " en " + (System.currentTimeMillis() - start) + " mses");
		System.out.println(diskFileExplorer.dircount + " dossiers");
		System.out.println(diskFileExplorer.filecount + " fichiers");
	}

}
