package fr.findCsvFile.service;
import java.io.File;
import java.util.regex.*;

public class DiskFileExplorer {
 
    private String initialpath = "";
    private Boolean recursivePath = false;
    public int filecount = 0;
    public int dircount = 0;
 
/**
 * Constructeur
 * @param path chemin du r�pertoire
 * @param subFolder analyse des sous dossiers
 */
    public DiskFileExplorer(String path, Boolean subFolder) {
        super();
        this.initialpath = path;
        this.recursivePath = subFolder;
    }
 
    public void list() {
        this.listDirectory(this.initialpath);
    }
 
    private void listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    System.out.println("Dossier: " + files[i].getAbsolutePath());
                    this.dircount++;
                } else {
                	/* Dans ce cas l� on est bien en pr�sence d'un fichier */
                    System.out.println("  Fichier: " + files[i].getName());
                    this.filecount++;
                    /* On filtre les fichiers csv */
                    if(( files[i].getName() ).endsWith(".csv")==true) {
                    	System.out.println("un fichier csv !");
                    }
                }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }
    }    
}
