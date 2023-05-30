package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto;

public class StatsQuestionDTO {
    private int nbFois;
    private int nbReussi;
    private String libelle;
    private float pourcentage;

    public StatsQuestionDTO(int nbFois, int nbReussi, String libelle) {
        this.nbFois = nbFois;
        this.nbReussi = nbReussi;
        this.libelle = libelle;
        this.pourcentage = nbFois/nbReussi;
    }

    public int getNbFois() {
        return nbFois;
    }

    public void setNbFois(int nbFois) {
        this.nbFois = nbFois;
    }

    public int getNbReussi() {
        return nbReussi;
    }

    public void setNbReussi(int nbReussi) {
        this.nbReussi = nbReussi;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }
}
