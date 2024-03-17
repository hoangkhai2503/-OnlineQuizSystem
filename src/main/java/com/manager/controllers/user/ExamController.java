package com.manager.controllers.user;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.manager.entities.Answer;
import com.manager.entities.EnumList;
import com.manager.entities.Question;
import com.manager.entities.Test;
import com.manager.entities.TestDetail;
import com.manager.entities._Class;
import com.manager.service.AnswerService;
import com.manager.service.ClassService;
import com.manager.service.EnumListService;
import com.manager.service.QuestionService;
import com.manager.service.StudentService;
import com.manager.service.SubjectService;
import com.manager.service.TestDetailService;
import com.manager.service.TestService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@EnableScheduling
@RequestMapping({"user"})
public class ExamController {
	@Autowired
	private TestService testService;
	
	@Autowired
	private ClassService classService;

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private TestDetailService testDetailService;
	
	@Autowired
	private EnumListService enumListService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@RequestMapping(value = { "exam", "" }, method = RequestMethod.GET)
	
	public String exam(ModelMap modelMap) {
		modelMap.put("tests", testService.findAll());
		modelMap.put("classs", classService.findAll());
		modelMap.put("subjects", subjectService.findAll());
		
		return "user/home/exam";
	}
	
	//EDIT
	@RequestMapping(value = "detailExam/{id_test}", method = RequestMethod.GET)
	public String detailExam(@PathVariable("id_test") int id_test, ModelMap modelMap,RedirectAttributes redirectAttributes) {
		
		Test test =  testService.findId(id_test);
		modelMap.put("test", test);
		
		//Create TestDetail
		
		TestDetail testDetail = new TestDetail();
		List<TestDetail> testDetails = (List<TestDetail>) testDetailService.findAll();
		int exist1 = 0;
		int exist2 = 0;
		int testDetailIdStudent = 0;
		int testDetailIdTest = 0;
		for (TestDetail testDetailItem : testDetails) {
			
			if(testDetailItem.getTest().getId_test() == id_test) {
				exist1++;
				testDetailIdTest = testDetailItem.getTest().getId_test();
				if(testDetailItem.getStudent().getId_student() == 1) {
					testDetailIdStudent = testDetailItem.getStudent().getId_student();
					exist2++;
				}
			}
		}
		if(exist1 == 0 || exist2 == 0) {
			testDetail.setCreated_testdetail(new Date());
			testDetail.setModified_testdetail(new Date());
			testDetail.setEnumList(enumListService.find(12));
			testDetail.setStudent(studentService.findId(1));
			testDetail.setTest(testService.findId(id_test));
			testDetailService.save(testDetail);
			testDetail = testDetailService.findId(testDetailService.findIdLatest());
		}else {
			testDetail = testDetailService.findByIdStudentAndIdTest(testDetailIdStudent, testDetailIdTest);
		}
		
		LocalDateTime currentDateTime = LocalDateTime.now();        
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String nowTime = currentDateTime.format(formatter);

		LocalDateTime dateTime = LocalDateTime.parse(test.getStarttime_test(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String startTime = dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

		LocalDateTime dateTime2 = LocalDateTime.parse(test.getEndtime_test(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String endTime = dateTime2.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

		long nowTimeInSeconds = Long.parseLong(nowTime);
		long startTimeInSeconds = Long.parseLong(startTime);
		long endTimeInSeconds = Long.parseLong(endTime);
		System.out.print(testDetail.getEnumList().getName());
		if (testDetail.getEnumList().getId()!=1) {
		    if (nowTimeInSeconds >= startTimeInSeconds) {
		        testDetail.setEnumList(enumListService.find(2));
		        testDetailService.save(testDetail);
		        if (nowTimeInSeconds >= endTimeInSeconds) {
		            testDetail.setEnumList(enumListService.find(1));
		            testDetailService.save(testDetail);
		        }
		    }
		}
		if (nowTimeInSeconds >= startTimeInSeconds) {
		    test.setEnumlist(enumListService.find(2));
		    testService.save(test);
		    if (nowTimeInSeconds >= endTimeInSeconds) {
		    	test.setEnumlist(enumListService.find(1));
			    testService.save(test);    
		    }
		}
		modelMap.put("testDetail", testDetail);
        return "user/home/detailExam";
	}
	
	
	//EDIT
	@RequestMapping(value = "doExam/{id_test}/{id_testdetail}", method = RequestMethod.GET)
	public String doExam(@PathVariable("id_test") int id_test,@PathVariable("id_testdetail") int id_testdetail, ModelMap modelMap,RedirectAttributes redirectAttributes) {
	
		Test test = testService.findId(id_test);
		TestDetail testDetail = testDetailService.findId(id_testdetail);
		if(!"Done".equals(testDetail.getEnumList().getName())) {
			modelMap.put("test", test);
			modelMap.put("testDetail", testDetail);
			modelMap.put("questions", questionService.findAll());
			modelMap.put("answers", answerService.findAll());
			LocalDateTime currentDateTime = LocalDateTime.now();        
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String nowTime = currentDateTime.format(formatter);

			LocalDateTime dateTime2 = LocalDateTime.parse(test.getEndtime_test(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String endTime = dateTime2.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	        long secondsDifference = Duration.between(currentDateTime,dateTime2).getSeconds();            
	        System.out.println("\nRemaining seconds: " + secondsDifference);
	        //Thời gian để form tự sumit
		    modelMap.addAttribute("delayInSeconds", secondsDifference+1);
		    //Thời gian đồng hồ
		    modelMap.addAttribute("secondsRemaining", secondsDifference);
			return "user/home/doExam";
		}
		return "redirect:/user/detailExam/"+ test.getId_test();
	}
	
	@RequestMapping(value = "submitExam", method = RequestMethod.POST)
	public String submitExam(@RequestParam Map<String, String> formData,@ModelAttribute("test") Test test,@ModelAttribute("testDetail") TestDetail testDetail) {	
		
		int totalQuestion = 0;
		List<Question> questions = (List<Question>) questionService.findAll();
		for (Question question : questions) {
			if(question.getTest().getId_test() == test.getId_test()) {
				totalQuestion++;
			}
		}
		int answerCorrect = 0;
		int giamBuoc = 0;
		Answer answer = new Answer();
		
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            String questionId = entry.getKey().replace("question_", "");
            String answerId = entry.getValue();
//            System.out.println("Question ID: " + questionId + ", Answer ID: " + answerId);
            if(giamBuoc !=0 ) {
            	answer = answerService.findId(Integer.parseInt(answerId));
                if(answer.getEnumlist().getName().equals("True")) {
                    	answerCorrect++;
                 }
            }
            giamBuoc++;	
        }   
        System.out.print("\nKet luan: "+ answerCorrect+ "/"+ totalQuestion+ "\n");
        double result = (double) answerCorrect / totalQuestion * 10;
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedResult = df.format(result);
        formattedResult = formattedResult.replace(",", ".");
        double finalResult = Double.parseDouble(formattedResult);
        System.out.println("Result: " + finalResult);
        TestDetail _teTestDetail = testDetailService.findId(testDetail.getId_testdetail());
        _teTestDetail.setScore_testdetail(finalResult);
        _teTestDetail.setEnumList(enumListService.find(1));
        testDetailService.save(_teTestDetail);
        return "redirect:/user/detailExam/"+ test.getId_test();
	}
	


}