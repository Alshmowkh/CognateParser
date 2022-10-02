/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognateparser.dataset;

import cognateparser.transliteration.Transliterator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bakee
 */
public class Collectors {

    void translateBerkeleyLexicon() {

        String oldF = "F:\\Master\\Thesis\\Tools\\Parsers\\Berkeley_Parser\\ALshmowkh_Berkeley\\berkelyLexicon.txt";
        String newF = "F:\\Master\\Thesis\\Tools\\Parsers\\Berkeley_Parser\\ALshmowkh_Berkeley\\berkelyLexiconTransed.txt";
        String feature;
        String line, transed;
        List list = new ArrayList();
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader(oldF));
            FileWriter fw;
            fw = new FileWriter(newF);
            while ((line = br.readLine()) != null) {
                transed = Transliterator.translitrate(line.split(" ")[1]);
                line = line + " " + transed + System.lineSeparator();
                fw.write(line);
            }
            br.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Collectors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Collectors cls = new Collectors();
        cls.translateBerkeleyLexicon();
    }

}
