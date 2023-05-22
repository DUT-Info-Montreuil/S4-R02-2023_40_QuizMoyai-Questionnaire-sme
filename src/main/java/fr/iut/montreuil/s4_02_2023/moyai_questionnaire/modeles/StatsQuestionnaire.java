package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.QuestionDTO;

public class StatsQuestionnaire {
    private QuestionDTO meilleurQuestion;
    private QuestionDTO pireQuestion;
    private int nbfois;

    public StatsQuestionnaire(QuestionDTO meilleurQuestion, QuestionDTO pireQuestion, int nbfois) {
        this.meilleurQuestion = meilleurQuestion;
        this.pireQuestion = pireQuestion;
        this.nbfois = nbfois;
    }

    public QuestionDTO getMeilleurQuestion() {
        return meilleurQuestion;
    }

    public void setMeilleurQuestion(QuestionDTO meilleurQuestion) {
        this.meilleurQuestion = meilleurQuestion;
    }

    public QuestionDTO getPireQuestion() {
        return pireQuestion;
    }

    public void setPireQuestion(QuestionDTO pireQuestion) {
        this.pireQuestion = pireQuestion;
    }

    public int getNbfois() {
        return nbfois;
    }

    public void setNbfois(int nbfois) {
        this.nbfois = nbfois;
    }
}
