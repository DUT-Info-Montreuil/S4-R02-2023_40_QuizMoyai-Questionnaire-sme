package fr.iut.montreuil.S4_R02_2023.moyai_questionnaire.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;



import java.io.File;
import java.io.IOException;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.ListQuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.bo.QuestionBO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.ListQuestionDTO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.QuestionDTO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.entities.dto.StatsQuestionnaireDTO;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.LangueEnum;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.modeles.QuestionnaireService;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.utils.FichierIntrouvableException;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.utils.FichierVideException;
import fr.iut.montreuil.s4_02_2023.moyai_questionnaire.utils.FormatInvalideException;



public class QuestionnaireTest {
	
	String nomFichierCsv = "questionsQuizz_V1.1.csv";
	String nomFichierCsvInexistant = "questionsQuizz_V22000.csv";
	String nomFichierCsvVide = "questionsQuizz_V1.1_vide.csv";
	String nomFicherFormatInvalide = "questionsQuizz_V1.1_invalide.csv";
	String nomFichierTxt = "questionsQuizz_V1.1.txt";
	private File getCSVFiles = new File("");
	private CSVReader csvReader;
	private String cheminFichierCsvCorrecte ;
	private String cheminFichierCsvIncorrecte ;
	private String cheminFichierCsvVide = getCSVFiles.getAbsolutePath() + "/src/test/java/fr/iut/montreuil/S4_R02_2023/moyai_questionnaire/resources/" + nomFichierCsvVide ;
	
	
	private QuestionBO Question1 =  new QuestionBO("1","1","fr","De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?","Tee","1",
    		"Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.", "https://fr.wikipedia.org/wiki/Matériel_de_golf");
	
	@Mock
	QuestionDTO question2;
	
	@Mock
	QuestionDTO question3;
	

	private QuestionnaireService questionnaireService = new QuestionnaireService() ;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		question2 = Mockito.mock(QuestionDTO.class);
		question3 = Mockito.mock(QuestionDTO.class);
	}

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
	} catch (FichierIntrouvableException e) {
		System.out.println("hello FichierIntrouvable");
		e.printStackTrace();
	} catch (FormatInvalideException e) {
		System.out.println("hello FormatInvalide");
		e.printStackTrace();
	}
        
		
	}
	 
	@Test
	public void chargerQuestionnaireFichierIntrouvableTest() throws CsvValidationException, IOException  {
		cheminFichierCsvIncorrecte = getCSVFiles.getAbsolutePath() + "/src/test/java/fr/iut/montreuil/S4_R02_2023/moyai_questionnaire/resources/" + nomFichierCsvInexistant ;
		final QuestionnaireService questionnaire = new QuestionnaireService();
		assertThrows(FichierIntrouvableException.class, new Executable() {
			@Override
			public void execute() throws Throwable {questionnaire.chargerQuestionnaire(cheminFichierCsvIncorrecte);}
		});
	}
	
		@Test
	public void chargerQuestionnaireFichierVideTest() throws CsvValidationException, IOException  {
		cheminFichierCsvCorrecte = getCSVFiles.getAbsolutePath() + "/src/test/java/fr/iut/montreuil/S4_R02_2023/moyai_questionnaire/resources/" + nomFichierCsv ;
		final QuestionnaireService questionnaire = new QuestionnaireService();
		assertThrows(FormatInvalideException.class, (new Executable() {
				@Override
				public void execute() throws Throwable {questionnaire.chargerQuestionnaire(cheminFichierCsvVide);}
		}));

//		assertThrows(FichierVide.class, () -> {Questionnaire.chargerQuestionnaire(cheminFichierCsvVide);});
	}

	@Test
	public void chargerQuestionnaireFichierFormatInvalideTest() throws CsvValidationException, IOException, FormatInvalideException, FichierIntrouvableException {
		cheminFichierCsvIncorrecte = getCSVFiles.getAbsolutePath() + "/src/test/java/fr/iut/montreuil/S4_R02_2023/moyai_questionnaire/resources/" + nomFicherFormatInvalide ;
		final QuestionnaireService questionnaire = new QuestionnaireService();
		assertThrows(FormatInvalideException.class, (new Executable() {
			@Override
			public void execute() throws Throwable {questionnaire.chargerQuestionnaire(cheminFichierCsvIncorrecte);}
		}));

	}
	
	@Test
	public void fournirStatsQuestionnaireNbFoisJouerTest() throws CsvValidationException, IOException  {
		question2.getStatsQuestion().setNbFois(1);
		question3.getStatsQuestion().setNbFois(2);
		
		StatsQuestionnaireDTO statQuestionnaire = Mockito.mock(StatsQuestionnaireDTO.class);
		
		ListQuestionDTO questionList = new ListQuestionDTO(statQuestionnaire);
		questionnaireService = new QuestionnaireService();
		questionList.add(question2);
		questionList.add(question3);
		questionnaireService = new QuestionnaireService();
		questionnaireService.setQuestionList(questionList);
		
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getNbfois(),  2);
		
		questionList.getL().remove(question3);
		questionnaireService.setQuestionList(questionList);
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getNbfois(),  1);
		
	}
	
	@Test
	public void fournirStatsQuestionnaireMeilleureQuestionTest() throws CsvValidationException, IOException  {
		question2.getStatsQuestion().setNbFois(20);
		question2.getStatsQuestion().setNbReussi(10);
		question3.getStatsQuestion().setNbFois(10);
		question3.getStatsQuestion().setNbReussi(3);
		
		StatsQuestionnaireDTO statQuestionnaire = Mockito.mock(StatsQuestionnaireDTO.class);
		ListQuestionDTO questionList = new ListQuestionDTO(statQuestionnaire);
		questionList.add(question2);
		questionList.add(question3);
		questionnaireService = new QuestionnaireService();
		questionnaireService.setQuestionList(questionList);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getMeilleurQuestion(),  question2);
		
		question3.getStatsQuestion().setNbReussi(5);
		question2.setDifficulté(3);
		question3.setDifficulté(4);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getMeilleurQuestion(),  question3);
		
		question2.setDifficulté(4);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getMeilleurQuestion(),  question2);
		
		question3.getStatsQuestion().setNbFois(20);
		question3.getStatsQuestion().setNbReussi(10);
		question2.setNum(3);
		question3.setNum(2);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getMeilleurQuestion(),  question3);
		
	}
	
	
	@Test
	public void fournirStatsQuestionnairePireQuestionTest() throws CsvValidationException, IOException  {
		question2.getStatsQuestion().setNbFois(20);
		question2.getStatsQuestion().setNbReussi(2);
		
		question3.getStatsQuestion().setNbFois(10);
		question3.getStatsQuestion().setNbReussi(6);
		
		StatsQuestionnaireDTO statQuestionnaire = Mockito.mock(StatsQuestionnaireDTO.class);
		ListQuestionDTO questionList = new ListQuestionDTO(statQuestionnaire);
		questionList.add(question2);
		questionList.add(question3);
		questionnaireService = new QuestionnaireService();
		questionnaireService.setQuestionList(questionList);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getPireQuestion(),  question2);
		
		question3.getStatsQuestion().setNbReussi(5);
		question2.setDifficulté(4);
		question3.setDifficulté(3);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getMeilleurQuestion(),  question3);
		
		question3.setDifficulté(4);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getMeilleurQuestion(),  question2);
		
		question3.getStatsQuestion().setNbFois(20);
		question3.getStatsQuestion().setNbReussi(2);
		question2.setNum(3);
		question3.setNum(2);
		
		Assertions.assertEquals(questionnaireService.getQuestionList().getStatsQuestionnaire().getMeilleurQuestion(),  question3);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}