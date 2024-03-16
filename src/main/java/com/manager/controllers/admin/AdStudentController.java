package com.manager.controllers.admin;

import java.io.IOException;
import java.util.Date;

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
import com.manager.entities.EnumList;
import com.manager.entities.Question;
import com.manager.entities.Student;
import com.manager.entities.Test;
import com.manager.entities._Class;
import com.manager.service.ClassService;
import com.manager.service.EnumListService;
import com.manager.service.RoleService;
import com.manager.service.StudentService;

@Controller
@RequestMapping({ "admin" })
public class AdStudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private EnumListService enumListService;
	
	@Autowired
	private ClassService classService;
	// getList
	@RequestMapping(value = { "student" }, method = RequestMethod.GET)
	public String TableStudent(ModelMap modelMap) {
		modelMap.put("students", studentService.findAll());
		return "admin/table/student";
	}
	// Add
	@RequestMapping(value = { "addStudent" }, method = RequestMethod.GET)
	public String AddStudent() {
		return "admin/addForm/student";
	}
	
	//ADD BY EXCEL FILE
		@RequestMapping(value = "addStudentByExcel", method = RequestMethod.POST)
		public String addStudentByExcel(@ModelAttribute("class") _Class _class,
				RedirectAttributes redirectAttributes, 
				@RequestParam("file") MultipartFile file) throws IOException 
		{
			
			_Class oldClass = classService.findId(_class.getId_class());
			
		    XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		    XSSFSheet worksheet = workbook.getSheetAt(0);
		    
		    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		    	XSSFRow row = worksheet.getRow(i);
		    	double phoneStudent = row.getCell(3).getNumericCellValue();
		    	String formattedValue = String.format("%.0f", phoneStudent);
		    	if(studentService.save(new Student(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),null,row.getCell(2).getStringCellValue(),formattedValue, new Date(), new Date(), oldClass, roleService.findById(3), enumListService.find(4)))) {
		    		System.out.print("\nSuccess");
	    		} else {
	    			System.out.print("\nFailed");
	    		}
		    }
			return "redirect:/admin/editClass/"+ oldClass.getId_class();
		}	

	// Edit
	@RequestMapping(value = { "editStudent" }, method = RequestMethod.GET)
	public String EditStudent() {
		return "admin/editForm/student";
	}
}
