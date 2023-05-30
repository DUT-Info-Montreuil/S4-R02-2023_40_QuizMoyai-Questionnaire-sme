package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto;

public class StatsQuestionnaireDTO {
    private QuestionDTO meilleurQuestion;
    private QuestionDTO pireQuestion;
    private int nbfois;

    public StatsQuestionnaireDTO(QuestionDTO meilleurQuestion, QuestionDTO pireQuestion, int nbfois) {
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
