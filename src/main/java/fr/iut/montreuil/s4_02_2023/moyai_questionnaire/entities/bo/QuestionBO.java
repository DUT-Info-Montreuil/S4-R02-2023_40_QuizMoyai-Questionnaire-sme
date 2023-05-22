package fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo;

public class QuestionBO {

    private String id;
    private String num;
    private String langue;
    private String libellé;
    private String réponse;
    private String difficulté;
    private String explication;
    private String déférence;
    
    
	public QuestionBO(String id, String num, String langue, String libellé, String réponse, String difficulté,
			String explication, String déférence) {
		super();
		this.id = id;
		this.num = num;
		this.langue = langue;
		this.libellé = libellé;
		this.réponse = réponse;
		this.difficulté = difficulté;
		this.explication = explication;
		this.déférence = déférence;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
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
	public String getDifficulté() {
		return difficulté;
	}
	public void setDifficulté(String difficulté) {
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

	@Override
	public String toString() {
		return "QuestionBO [id=" + id + ", num=" + num + ", langue=" + langue + ", libellé=" + libellé + ", réponse="
				+ réponse + ", difficulté=" + difficulté + ", explication=" + explication + ", déférence=" + déférence
				+ "]";
	}
}
    
