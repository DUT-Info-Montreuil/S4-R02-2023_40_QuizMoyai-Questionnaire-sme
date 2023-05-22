package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.ListQuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.QuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.ListQuestionDTO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.QuestionDTO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.impl.IQuestionnaire;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FormatInvalide;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FichierIntrouvable;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FichierVide;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire implements IQuestionnaire {

    public ListQuestionDTO questionList;

    public Questionnaire() {
        this.questionList = new ListQuestionDTO(new StatsQuestionnaire(null, null, 0));
    }

    public ListQuestionDTO getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ListQuestionDTO questionList) {
        this.questionList = questionList;
    }

    public ListQuestionBO chargerQuestionnaire(String urlFicherCSV) throws FichierIntrouvable, FormatInvalide{
        List<QuestionBO> l = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(urlFicherCSV));
            String ligne = null;
            while ((ligne = br.readLine()) != null) {
                // Retourner la ligne dans un tableau
                String[] data = ligne.split(";");
                System.out.println(data.toString());
                System.out.println(data.length);
                if (data.length != 8) throw new FormatInvalide();
                QuestionBO q = new QuestionBO(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                // Afficher le contenu du tableau
                l.add(q);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new FichierIntrouvable();
        } catch (IOException e) {

        }
        return new ListQuestionBO(l);
    }
    public ListQuestionDTO transformData(ListQuestionBO l){
        ListQuestionDTO listQuestionDTO = new ListQuestionDTO(new StatsQuestionnaire(null, null, 0));
        for (QuestionBO line: l.getLines()) {
            LangueEnum langue;
            switch (line.getLangue()){
                case "fr":
                    langue = LangueEnum.fr;
                    break;
                case "en":
                    langue = LangueEnum.en;
                    break;
                case "nl":
                    langue = LangueEnum.nl;
                    break;
                case "es":
                    langue = LangueEnum.es;
                    break;
                case "it":
                    langue = LangueEnum.it;
                    break;
                default:
                    langue= null;
            }
            QuestionDTO questionDTO = new QuestionDTO(
                    Integer.parseInt(line.getId()),
                    Integer.parseInt(line.getNum()),
                    langue, line.getLibellé(), line.getRéponse(),
                    Integer.parseInt(line.getDifficulté()), line.getExplication(),
                    line.getDéférence(), new StatsQuestion(0,0, line.getLibellé())
                    );
                    listQuestionDTO.add(questionDTO);
        }

        return  listQuestionDTO;
    }
    @Override
    public StatsQuestionnaire fournirStatsQuestionnaire(int id) {

        return null;
    }


}
