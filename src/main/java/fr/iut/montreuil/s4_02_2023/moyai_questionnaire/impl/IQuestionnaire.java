package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.impl;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.ListQuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.StatsQuestionnaireDTO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.utils.FichierIntrouvableException;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.utils.FormatInvalideException;

public interface IQuestionnaire {
    public ListQuestionBO chargerQuestionnaire(String urlFicherCSV) throws FichierIntrouvableException, FormatInvalideException;
    public StatsQuestionnaireDTO fournirStatsQuestionnaire(int id);

}
