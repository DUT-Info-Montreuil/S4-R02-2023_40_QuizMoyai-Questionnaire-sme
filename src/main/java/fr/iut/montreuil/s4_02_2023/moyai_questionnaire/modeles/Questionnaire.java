package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.ListQuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FormatInvalide;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FichierIntrouvable;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FichierVide;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {

    public List<Question> questionList;

    public Questionnaire() {
        this.questionList = new ArrayList<Question>();
    }

//    public Questionnaire fournirListQuestionnaire(String urlFichierCSV) {
//        return ;
//    }
    public ListQuestionBO chargerQuestionnaire(String urlFicherCSV) throws FichierIntrouvable, FormatInvalide{
        List<List<String>> l = new ArrayList<>();
        File provFile = new File("");
        try {
            System.out.println(provFile.getAbsoluteFile()+"\\src\\main\\java\\fr\\iut\\montreuil\\s4_02_2023\\moyai_questionnaire\\resources\\"+urlFicherCSV);
            BufferedReader br = new BufferedReader(new FileReader(provFile.getAbsoluteFile()+"\\src\\main\\java\\fr\\iut\\montreuil\\s4_02_2023\\moyai_questionnaire\\resources\\"+urlFicherCSV));
            String ligne = null;
            while ((ligne = br.readLine()) != null) {
                // Retourner la ligne dans un tableau
                String[] data = ligne.split(";");
                if (data.length != 8) throw new FormatInvalide();
                ArrayList<String>  stringArrayList = new ArrayList<String>();
                // Afficher le contenu du tableau
                for (String val : data) {
                    stringArrayList.add(val);
                    System.out.println(val);
                }
                System.out.println(stringArrayList);
                l.add(stringArrayList);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new FichierIntrouvable();
        } catch (IOException e) {

        }
        return new ListQuestionBO(l);
    }


}
