package com.manager.controllers.admin;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Answer;
import com.manager.entities.Question;
import com.manager.service.AnswerService;
import com.manager.service.EnumListService;
import com.manager.service.QuestionService;
import com.manager.service.TestService;

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
			RedirectAttributes redirectAttributes) 
	{
		question.setCreated_question(new Date());
		question.setModified_question(new Date());
		question.setEnumlist(enumListService.findById(2));
		
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
		
		answer1.setEnumlist(enumListService.findById(11));
		answer2.setEnumlist(enumListService.findById(11));
		answer3.setEnumlist(enumListService.findById(11));
		answer4.setEnumlist(enumListService.findById(11));
		
		if(correct.equals("Answer 1")) {
			answer1.setEnumlist(enumListService.findById(10));
		}
		if(correct.equals("Answer 2")) {
			answer2.setEnumlist(enumListService.findById(10));
		}
		if(correct.equals("Answer 3")) {
			answer3.setEnumlist(enumListService.findById(10));
		}
		if(correct.equals("Answer 4")) {
			answer4.setEnumlist(enumListService.findById(10));
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
	    		if (questionService.save(new Question(row.getCell(1).getStringCellValue(), question.getTest(), new Date(), new Date(), enumListService.findById(2)))) {
	    			System.out.print("\nSuccess");
	    		} else {
	    			System.out.print("\nFailed");
	    		}
	    	}else {
	    		System.out.print("\nAdd Câu trả lời: "+ row.getCell(1).getStringCellValue());
	    		if (answerService.save(new Answer( row.getCell(1).getStringCellValue(),
	    				new Date(),
	    				new Date(),
	    				questionService.findId(questionService.findIdLatest()),
	    				row.getCell(0).getBooleanCellValue()==false? enumListService.find(11) : enumListService.find(10)))) {
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
	
}
