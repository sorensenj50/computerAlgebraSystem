import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Scanner;



public class LatexManager {

    public static Path getLatexDirectory() {
        return Path.of(System.getProperty("user.home"), "Documents", "latexFiles");
    }

    public static Path createFile(String filename) {
        Path latexFilesDir = getLatexDirectory();
        return latexFilesDir.resolve(filename);
    }

    public static void writeToFile(String filename, String content) {
        Path file = createFile(filename);

        try {
            Files.write(file, Collections.singleton(content));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void convertToPDF(String filename) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec("pdflatex " + filename);
            Scanner scanner = new Scanner(p.getInputStream());
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (Exception e) {
            System.out.printf(e.getLocalizedMessage());
        }
    }

    public static void openFile(String filepath) throws IOException {
        File file = new File(filepath);

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();

        if(file.exists()) {
            System.out.println("File Exists");
            desktop.open(file);
        }
    }

    static public void fromTemplate() {
        String templateDoc =

        """
        \\documentclass{article}
        \\usepackage[utf8]{inputenc}
                                
        \\title{New Project}
        \\author{John Sorensen}
        \\date{February 2022 (test 4)}
                                
        \\begin{document}
                                
        \\maketitle
                                
        \\section{Introduction}
                                
        \\end{document}
        
        """;

        createFile("/Users/johnsorensen/Documents/latexFiles/test.tex");
        writeToFile("test.tex", templateDoc);

//        try {
//            openFile("/Users/johnsorensen/Documents/latexFiles/test.tex");
//        } catch(Exception e) {
//            System.out.printf(e.getLocalizedMessage());
//        }

        convertToPDF("/Users/johnsorensen/Documents/latexFiles/test.tex");

        try {
            openFile("/Users/johnsorensen/IdeaProjects/cas/src/test.pdf");
        } catch(Exception e) {
            System.out.printf(e.getLocalizedMessage());
        }
    }
}
