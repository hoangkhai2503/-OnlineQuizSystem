package com.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtos.DemoDTO;



@Service
public class DemoServiceImpl implements DemoService {

//	@Autowired
//	private DemoRepository demoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean save(DemoDTO demoDTO) {
//		try {
//			Demo demo = modelMapper.map(demoDTO, Demo.class);
//			demoRepository.save(demo);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
		return true;
	}

	@Override
	public boolean login(DemoDTO demoDTO) {
//		return demoRepository.login(demoDTO.getUsername(), demoDTO.getPassword()) != null;
		return true;
	}

	@Override
	public boolean login(String username, String password) {
//		return demoRepository.login(username, password) != null;
		return true;
	}

	@Override
	public List<DemoDTO> findAll() {
//		return modelMapper.map(demoRepository.findAll(), new TypeToken<List<DemoDTO>>() {
//		}.getType());
		return null;
	}

	@Override
	public List<DemoDTO> findByKeyword(String keyword) {
//		return modelMapper.map(demoRepository.findByKeyword(keyword), new TypeToken<List<DemoDTO>>() {
//		}.getType());
		return null;
	}
	
	@Override
	public DemoDTO find(int id) {
//		return modelMapper.map(demoRepository.findById(id).get(), DemoDTO.class);
		return null;
	}

}
