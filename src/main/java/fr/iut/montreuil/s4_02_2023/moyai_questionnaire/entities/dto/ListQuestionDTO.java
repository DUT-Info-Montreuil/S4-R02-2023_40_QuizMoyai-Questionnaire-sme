package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class ListQuestionDTO {

    private fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.StatsQuestionnaireDTO statsQuestionnaire ;
    private List<QuestionDTO> l ;


    public ListQuestionDTO(StatsQuestionnaireDTO statsQuestionnaire) {
        this.statsQuestionnaire = statsQuestionnaire;
        this.l =new ArrayList<QuestionDTO>();
    }

    public StatsQuestionnaireDTO getStatsQuestionnaire() {
        return statsQuestionnaire;
    }

    public void setStatsQuestionnaire(StatsQuestionnaireDTO statsQuestionnaire) {
        this.statsQuestionnaire = statsQuestionnaire;
    }

    public List<QuestionDTO> getL() {
        return l;
    }

    public void setL(List<QuestionDTO> l) {
        this.l = l;
    }

    public void add(QuestionDTO questionDTO) {
        this.l.add(questionDTO);
    }
}
