package fr.iut.montreuil.S4_R02_2023.moyai_questionnaire.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;



import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.ListQuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.QuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.LangueEnum;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.Question;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.Questionnaire;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FichierIntrouvable;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.exceptions.FormatInvalide;



public class QuestionnaireTest {
	
	String nomFichierCsv = "questionsQuizz_V1.1.csv";
	String nomFichierCsvInexistant = "questionsQuizz_V22000.csv";
	String nomFichierCsvVide = "questionsQuizz_V1.1_vide.csv";
	String nomFichierTxt = "questionsQuizz_V1.1.txt";
	private File getCSVFiles = new File("");
	private CSVReader csvReader;
	private String cheminFichierCsvCorrecte;
	private String cheminFichierCsvIncorrecte ;
	private String cheminFichierCsvVide = getCSVFiles.getAbsolutePath() + "/src/test/java/fr/iut/montreuil/S4_R02_2023/moyai_questionnaire/resources/" + nomFichierCsvVide ;
	
	
	private QuestionBO Question1 =  new QuestionBO("1","1","fr","De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?","Tee","1",
    		"Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.", "https://fr.wikipedia.org/wiki/Matériel_de_golf");
	
	@Mock
	Question Question2;
	
	@Mock
	Question Question3;
	
	private Questionnaire questionnaireService = new Questionnaire() ;

	@Test
	public void chargerQuestionnaireEgaliterLigneUneTest() throws CsvValidationException, IOException  {
		cheminFichierCsvCorrecte = getCSVFiles.getAbsolutePath() + "/src/test/java/fr/iut/montreuil/S4_R02_2023/moyai_questionnaire/resources/" + nomFichierCsv;
        
       ListQuestionBO listQuestionBO;
	try {
		listQuestionBO = questionnaireService.chargerQuestionnaire(cheminFichierCsvCorrecte);
		Assertions.assertEquals(listQuestionBO.getLines().get(0).getDifficulté(),  Question1.getDifficulté());
		Assertions.assertEquals(listQuestionBO.getLines().get(0).getDéférence(),  Question1.getDéférence());
		Assertions.assertEquals(listQuestionBO.getLines().get(0).getExplication(),  Question1.getExplication());
		Assertions.assertEquals(listQuestionBO.getLines().get(0).getLangue(),  Question1.getLangue());
		Assertions.assertEquals(listQuestionBO.getLines().get(0).getLibellé(),  Question1.getLibellé());
		Assertions.assertEquals(listQuestionBO.getLines().get(0).getNum(),  Question1.getNum());
		Assertions.assertEquals(listQuestionBO.getLines().get(0).getRéponse(),  Question1.getRéponse());
	} catch (FichierIntrouvable e) {
		System.out.println("hello FichierIntrouvable");
		e.printStackTrace();
	} catch (FormatInvalide e) {
		System.out.println("hello FormatInvalide");
		e.printStackTrace();
	}
        
		
	}
	 
	@Test
	public void chargerQuestionnaireFichierIntrouvableTest() throws CsvValidationException, IOException  {
		cheminFichierCsvIncorrecte = getCSVFiles.getAbsolutePath() + "/src/test/java/fr/iut/montreuil/S4_R02_2023/moyai_questionnaire/resources/" + nomFichierCsvInexistant ;
		final Questionnaire questionnaire = new Questionnaire();
		assertThrows(FichierIntrouvable.class, new Executable() {
			@Override
			public void execute() throws Throwable {questionnaire.chargerQuestionnaire(cheminFichierCsvIncorrecte);}
		});
	}
	
	

}