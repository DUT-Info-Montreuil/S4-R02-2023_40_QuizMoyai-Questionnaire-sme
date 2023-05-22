package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.LangueEnum;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.StatsQuestion;

public class QuestionDTO {
    private int id;
    private int num;
    private LangueEnum langue;
    private String libellé;
    private String réponse;
    private int difficulté;
    private String explication;
    private String déférence;
    private StatsQuestion statsQuestion;

    public QuestionDTO(int id, int num, LangueEnum langue, String libellé, String réponse, int difficulté, String explication, String déférence, StatsQuestion stats) {
        this.id = id;
        this.num = num;
        this.langue = langue;
        this.libellé = libellé;
        this.réponse = réponse;
        this.difficulté = difficulté;
        this.explication = explication;
        this.déférence = déférence;
        this.statsQuestion = stats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public LangueEnum getLangue() {
        return langue;
    }

    public void setLangue(LangueEnum langue) {
        this.langue = langue;
    }

    public String getLibellé() {
        return libellé;
    }

    public void setLibellé(String libellé) {
        this.libellé = libellé;
    }

    public String getRéponse() {
        return réponse;
    }

    public void setRéponse(String réponse) {
        this.réponse = réponse;
    }

    public int getDifficulté() {
        return difficulté;
    }

    public void setDifficulté(int difficulté) {
        this.difficulté = difficulté;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public String getDéférence() {
        return déférence;
    }

    public void setDéférence(String déférence) {
        this.déférence = déférence;
    }

    public StatsQuestion getStatsQuestion() {
        return statsQuestion;
    }

    public void setStatsQuestion(StatsQuestion statsQuestion) {
        this.statsQuestion = statsQuestion;
    }


}
