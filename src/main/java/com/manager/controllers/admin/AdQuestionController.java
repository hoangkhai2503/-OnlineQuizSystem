package com.manager.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.helpers.FileHelper;
import com.manager.entities.Answer;
import com.manager.entities.Question;
import com.manager.service.AnswerService;
import com.manager.service.EnumListService;
import com.manager.service.QuestionService;
import com.manager.service.TestService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "admin" })
public class AdQuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private EnumListService enumListService;
	
	// getList
	@RequestMapping(value = { "question" }, method = RequestMethod.GET)
	public String TableQuestion(ModelMap modelMap) {
		modelMap.put("questions", questionService.findAll());
		modelMap.put("showAnswer", "No");
		return "admin/table/question";
	}
	
	// getList and show answer
		@RequestMapping(value = { "questionAndAnswer" }, method = RequestMethod.GET)
		public String questionAndAnswer(ModelMap modelMap) {
			modelMap.put("questions", questionService.findAll());
			modelMap.put("answers", answerService.findAll());
			modelMap.put("showAnswer", "Yes");
			return "admin/table/question";
		}
	
	// Add
	@RequestMapping(value = { "addQuestion" }, method = RequestMethod.GET)
	public String AddVariable(ModelMap modelMap) {
		Question question = new Question();
		modelMap.put("question", question);
		modelMap.put("tests", testService.findAll());
		return "admin/addForm/question";
	}
	@RequestMapping(value = "addQuestion", method = RequestMethod.POST)
	public String add(@ModelAttribute("question") Question question,
			@RequestParam("answer1") String nameAnswer1,
			@RequestParam("answer2") String nameAnswer2,
			@RequestParam("answer3") String nameAnswer3,
			@RequestParam("answer4") String nameAnswer4, 
			@RequestParam("correct") String correct,
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) 
	{
		question.setCreated_question(new Date());
		question.setModified_question(new Date());
		question.setEnumlist(enumListService.find(2));
		
		if (file != null && file.getSize() > 0) {
			try {
				File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
				String fileName = FileHelper.generateFileName(file.getOriginalFilename());
				Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				question.setImage_question(fileName);
				System.out.print("\nOk");
			} catch (Exception e) {
				e.printStackTrace();
				question.setImage_question(null);
				System.out.print("\nFailed1");
			}
		} else {
			question.setImage_question(null);
			System.out.print("\nFailed2");
		}
		
		if (questionService.save(question)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		Answer answer1 = new Answer();
		Answer answer2 = new Answer();
		Answer answer3 = new Answer();
		Answer answer4 = new Answer();
		
		answer1.setCreated_answer(new Date());
		answer1.setModified_answer(new Date());
		answer2.setCreated_answer(new Date());
		answer2.setModified_answer(new Date());
		answer3.setCreated_answer(new Date());
		answer3.setModified_answer(new Date());
		answer4.setCreated_answer(new Date());
		answer4.setModified_answer(new Date());
		
		answer1.setEnumlist(enumListService.find(11));
		answer2.setEnumlist(enumListService.find(11));
		answer3.setEnumlist(enumListService.find(11));
		answer4.setEnumlist(enumListService.find(11));
		
		if(correct.equals("Answer 1")) {
			answer1.setEnumlist(enumListService.find(10));
		}
		if(correct.equals("Answer 2")) {
			answer2.setEnumlist(enumListService.find(10));
		}
		if(correct.equals("Answer 3")) {
			answer3.setEnumlist(enumListService.find(10));
		}
		if(correct.equals("Answer 4")) {
			answer4.setEnumlist(enumListService.find(10));
		}
		
		answer1.setQuestion(questionService.findId(questionService.findIdLatest()));
		answer2.setQuestion(questionService.findId(questionService.findIdLatest()));
		answer3.setQuestion(questionService.findId(questionService.findIdLatest()));
		answer4.setQuestion(questionService.findId(questionService.findIdLatest()));
		
		answer1.setName_answer(nameAnswer1);
		answer2.setName_answer(nameAnswer2);
		answer3.setName_answer(nameAnswer3);
		answer4.setName_answer(nameAnswer4);
		
		if (answerService.save(answer1)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		if (answerService.save(answer2)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		if (answerService.save(answer3)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		if (answerService.save(answer4)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		return "redirect:/admin/question";
	}
	
	//ADD BY EXCEL FILE
	@RequestMapping(value = "addQuestionByExcel", method = RequestMethod.POST)
	public String addByExcel(@ModelAttribute("question") Question question,
			RedirectAttributes redirectAttributes, 
			@RequestParam("file") MultipartFile file) throws IOException 
	{
		Answer answer1 = new Answer();
		Answer answer2 = new Answer();
		Answer answer3 = new Answer();
		Answer answer4 = new Answer();
		
		
		
	    XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	    	XSSFRow row = worksheet.getRow(i);
	    	if((i-1)%5==0) {
	    		System.out.print("\nAdd Câu hỏi: "+ row.getCell(1).getStringCellValue());
	    		if (questionService.save(new Question(row.getCell(1).getStringCellValue(), question.getTest(), new Date(), new Date(), enumListService.find(2)))) {
	    			System.out.print("\nSuccess");
	    		} else {
	    			System.out.print("\nFailed");
	    		}
	    	}else {
	    		System.out.print("\nAdd Câu trả lời: "+ row.getCell(1).getStringCellValue());
	    		if (answerService.save(new Answer( row.getCell(1).getStringCellValue(), new Date(), new Date(), questionService.findId(questionService.findIdLatest()), row.getCell(0).getBooleanCellValue()==false? enumListService.find(11) : enumListService.find(10)))) {
	    			System.out.print("\nSuccess");
	    		} else {
	    			System.out.print("\nFailed");
	    		}
	    	}
	    }
		return "redirect:/admin/question";
	}	
	//SET QUESTION TO TEST
	@RequestMapping(value = { "setQuestion" }, method = RequestMethod.GET)
	public String SetQuestion(ModelMap modelMap) {
		Question question = new Question();
		modelMap.put("question", question);
		modelMap.put("questions", questionService.findAll());
		modelMap.put("tests", testService.findAll());
		return "admin/editForm/setQuestion";
	}
	@RequestMapping(value = "setQuestion", method = RequestMethod.POST)
	public String SetQuestion(@ModelAttribute("question") Question question,
			
			@RequestParam("select[]") List<String> listIdQuestion,
			RedirectAttributes redirectAttributes) 
	{
		for (String idQuestionString : listIdQuestion) {
			int idQuestion = Integer.parseInt(idQuestionString);
			if (questionService.save(new Question(idQuestion,
					questionService.findId(idQuestion).getName_question(), 
					question.getTest(), 
					questionService.findId(idQuestion).getCreated_question(),
					questionService.findId(idQuestion).getModified_question(),
					questionService.findId(idQuestion).getEnumlist()))) {
    			System.out.print("\nSuccess");
    		} else {
    			System.out.print("\nFailed");
    		}	
		}
		return "redirect:/admin/question";
	}
	
	//EDIT
	@RequestMapping(value = "editQuestion/{id_question}", method = RequestMethod.GET)
	public String editQuestion(@PathVariable("id_question") int id_question, ModelMap modelMap,RedirectAttributes redirectAttributes) {
		
		modelMap.put("question",questionService.findId(id_question));
		modelMap.put("tests", testService.findAll());
		List<Answer> answers = (List<Answer>) answerService.findByIdQuestion(id_question);
		int count = 1;
		Answer answer1 = new Answer();
		Answer answer2 = new Answer();
		Answer answer3 = new Answer();
		Answer answer4 = new Answer();
		for (Answer answer : answers) {
			if(count == 1) {
				answer1 = answer;
			}
			if(count == 2) {
				answer2 = answer;
			}
			if(count == 3) {
				answer3 = answer;
			}
			if(count == 4) {
				answer4 = answer;
			}
			count++;
		}
		modelMap.put("answer1",answer1);
		modelMap.put("answer2",answer2);
		modelMap.put("answer3",answer3);
		modelMap.put("answer4",answer4);
		if(answer1.getEnumlist().getName().equals("True")) {
			modelMap.put("status", "Answer 1");
		}
		if(answer2.getEnumlist().getName().equals("True")) {
			modelMap.put("status", "Answer 2");
		}
		if(answer3.getEnumlist().getName().equals("True")) {
			modelMap.put("status", "Answer 3");
		}
		if(answer4.getEnumlist().getName().equals("True")) {
			modelMap.put("status", "Answer 4");
		}
		
		return "admin/editForm/question";
	}
	
	@RequestMapping(value = "editQuestion", method = RequestMethod.POST)
	public String editQuestion(@ModelAttribute("question") Question _question,
			@ModelAttribute("answer") Answer _answer,
			@RequestParam("correct") String correct,
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) 
	{
		String[] nameAnswer = _answer.getName_answer().split(",");
		int id_question = _question.getId_question();
		Question question = questionService.findId(id_question);
		
		if (file != null && file.getSize() > 0) {
			try {
				File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
				String fileName = FileHelper.generateFileName(file.getOriginalFilename());
				Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				question.setImage_question(fileName);
				System.out.print("\nOk");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		question.setName_question(_question.getName_question());
		question.setModified_question(new Date());
		question.setTest(_question.getTest());
		if (questionService.save(question)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		List<Answer> answers = (List<Answer>) answerService.findByIdQuestion(id_question);
		int count = 1;
		Answer answer1 = new Answer();
		Answer answer2 = new Answer();
		Answer answer3 = new Answer();
		Answer answer4 = new Answer();
		for (Answer answer : answers) {
			if(count == 1) {
				answer1 = answer;
			}
			if(count == 2) {
				answer2 = answer;
			}
			if(count == 3) {
				answer3 = answer;
			}
			if(count == 4) {
				answer4 = answer;
			}
			count++;
		}
		
		answer1.setModified_answer(new Date());
		answer2.setModified_answer(new Date());
		answer3.setModified_answer(new Date());
		answer4.setModified_answer(new Date());
		answer1.setEnumlist(enumListService.find(11));
		answer2.setEnumlist(enumListService.find(11));
		answer3.setEnumlist(enumListService.find(11));
		answer4.setEnumlist(enumListService.find(11));
		
		if(correct.equals("Answer 1")) {
			answer1.setEnumlist(enumListService.find(10));
		}
		if(correct.equals("Answer 2")) {
			answer2.setEnumlist(enumListService.find(10));
		}
		if(correct.equals("Answer 3")) {
			answer3.setEnumlist(enumListService.find(10));
		}
		if(correct.equals("Answer 4")) {
			answer4.setEnumlist(enumListService.find(10));
		}
		
		answer1.setQuestion(questionService.findId(id_question));
		answer2.setQuestion(questionService.findId(id_question));
		answer3.setQuestion(questionService.findId(id_question));
		answer4.setQuestion(questionService.findId(id_question));
		
		answer1.setName_answer(nameAnswer[0]);
		answer2.setName_answer(nameAnswer[1]);
		answer3.setName_answer(nameAnswer[2]);	
		answer4.setName_answer(nameAnswer[3]);
		
		if (answerService.save(answer1)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		if (answerService.save(answer2)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		if (answerService.save(answer3)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		if (answerService.save(answer4)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		
		return "redirect:/admin/questionAndAnswer";
	}
	
}