package fr.findCsvFile.DAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.*;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Workbook;

public class FindEmail {
 
    private String initialpath = "";
    private Boolean recursivePath = false;
    public int filecount = 0;
    public int dircount = 0;
    public final static char SEPARATOR = ';';
    private String email = "";
 
/**
 * Constructeur
 * @param path chemin du répertoire
 * @param subFolder analyse des sous dossiers
 */
    public FindEmail(String path, Boolean subFolder, String email) {
        super();
        this.initialpath = path;
        this.recursivePath = subFolder;
        this.email = email;
    }
 
    public void run() throws FileNotFoundException {
        this.findIt(this.initialpath);
    }
 
    private void findIt(String dir) throws FileNotFoundException {
    	
    	File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    System.out.println("Dossier: " + files[i].getAbsolutePath());
                    this.dircount++;
                } else {
                	/* Dans ce cas là on est bien en présence d'un fichier */
//                  System.out.println("  Fichier: " + files[i].getName());
                    this.filecount++;
                    /* On filtre les fichiers csv */
                    if(( files[i].getName() ).endsWith(".csv")==true) {
                    	
                    	FileReader fr = new FileReader(files[i]);
                    	CSVReader csvReader = new CSVReader(fr,SEPARATOR);
                    	String[] nextLine = null;
                    	try {
							while ((nextLine = csvReader.readNext()) != null) {
								int size = nextLine.length;

								
								// ligne vide
								if (size == 0) {
								    continue;
								}
								
								String debut = nextLine[0].trim();
								if (debut.length() == 0 && size == 1) {
								    continue;
								}
	
								// ligne de commentaire
								if (debut.startsWith("#")) {
								    continue;
								}
								
								
								if(nextLine[4].equals(this.email)) {
									System.out.println("Here is "+this.email);
								}
								
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.findIt(files[i].getAbsolutePath());
                }
            }
            }
        }    
    }
}
