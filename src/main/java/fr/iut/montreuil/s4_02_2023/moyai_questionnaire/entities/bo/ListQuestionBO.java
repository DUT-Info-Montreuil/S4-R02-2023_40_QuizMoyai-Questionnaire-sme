package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo;

import java.util.List;

public class ListQuestionBO {

    private List<QuestionBO> lines;

    public ListQuestionBO(List<QuestionBO> lines) {
        this.lines = lines;
    }

	public List<QuestionBO> getLines() {
		return lines;
	}

	public void setLines(List<QuestionBO> lines) {
		this.lines = lines;
	}
}
