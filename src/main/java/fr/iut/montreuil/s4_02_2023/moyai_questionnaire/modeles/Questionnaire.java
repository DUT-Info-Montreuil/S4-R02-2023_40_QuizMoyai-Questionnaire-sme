package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.ListQuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.QuestionBO;
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
        List<QuestionBO> l = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(urlFicherCSV));
            String ligne = null;
            while ((ligne = br.readLine()) != null) {
                // Retourner la ligne dans un tableau
                String[] data = ligne.split(";");
                if (data.length != 8) throw new FormatInvalide();
                QuestionBO q = new QuestionBO(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                // Afficher le contenu du tableau
                System.out.println(q.toString());
                l.add(q);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new FichierIntrouvable();
        } catch (IOException e) {

        }
        return new ListQuestionBO(l);
    }


}
