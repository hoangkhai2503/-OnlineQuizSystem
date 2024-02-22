//package com.manager.controllers.admin;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.MimeTypeUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dtos.DemoDTO;
//import com.service.DemoService;
//
//
//
//@RestController
//@RequestMapping("api/demo")
//public class DemoController {
//
//	@Autowired
//	private DemoService demoService;
//
//	@PostMapping(value = "login", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> login(@RequestBody DemoDTO demoDTO) {
//		try {
//			return new ResponseEntity<Object>(new Object() {
//				public boolean status = demoService.login(demoDTO);
//			}, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@PostMapping(value = "create", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> create(@RequestBody DemoDTO demoDTO) {
//		try {
//			return new ResponseEntity<Object>(new Object() {
//				public boolean status = demoService.save(demoDTO);
//			}, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@PutMapping(value = "update", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> update(@RequestBody DemoDTO demoDTO) {
//		try {
//			return new ResponseEntity<Object>(new Object() {
//				public boolean status = demoService.save(demoDTO);
//			}, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<DemoDTO>> findAll() {
//		try {
//			return new ResponseEntity<List<DemoDTO>>(demoService.findAll(), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<List<DemoDTO>>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@GetMapping(value = "searchByKeyword/{keyword}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<DemoDTO>> searchByKeyword(@PathVariable("keyword") String keyword) {
//		try {
//			return new ResponseEntity<List<DemoDTO>>(demoService.findByKeyword(keyword), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<List<DemoDTO>>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@GetMapping(value = "find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<DemoDTO> find(@PathVariable("id") int id) {
//		try {
//			return new ResponseEntity<DemoDTO>(demoService.find(id), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<DemoDTO>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//}
