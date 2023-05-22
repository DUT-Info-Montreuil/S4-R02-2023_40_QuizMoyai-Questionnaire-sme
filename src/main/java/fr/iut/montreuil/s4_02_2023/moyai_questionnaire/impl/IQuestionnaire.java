package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.impl;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.ListQuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.StatsQuestionnaire;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FichierIntrouvable;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FormatInvalide;

public interface IQuestionnaire {
    public ListQuestionBO chargerQuestionnaire(String urlFicherCSV) throws FichierIntrouvable, FormatInvalide;
    public StatsQuestionnaire fournirStatsQuestionnaire(int id);

}
