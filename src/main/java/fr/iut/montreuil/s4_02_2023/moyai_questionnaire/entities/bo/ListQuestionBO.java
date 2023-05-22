package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo;

import java.util.List;

public class ListQuestionBO {

    private List<List<String>> lines;

    public ListQuestionBO(List<List<String>> lines) {
        this.lines = lines;
    }
}
