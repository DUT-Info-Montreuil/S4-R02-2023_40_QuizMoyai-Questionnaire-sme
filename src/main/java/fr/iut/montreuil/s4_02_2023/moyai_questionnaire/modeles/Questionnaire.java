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
        return null;
    }


}
