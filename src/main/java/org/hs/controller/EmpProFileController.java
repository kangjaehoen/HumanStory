package org.hs.controller;

import java.util.List;

import org.hs.domain.EmpAttachVO;
import org.hs.service.EmpProFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class EmpProFileController {
	@Autowired
	private EmpProFileService service;
	
//	@GetMapping("/sideBar")
//	public void empProFile(@RequestParam("empNum") String empNum) {
//		log.info("컨트롤러 프로필 조회:"+empNum);
//		service.empProFile(empNum);
//	}
	
	@GetMapping(value = "/getEmpProfile",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public  ResponseEntity<List<EmpAttachVO>> getEmpProfile(String empNum){
		log.info("사용자 프로필 조회"+empNum);
		return new ResponseEntity<List<EmpAttachVO>>(service.empProFile(empNum),HttpStatus.OK);
	}
	
	@GetMapping("/emp/proFile")
	public void proFile() {
		log.info("프로필 페이지 등록 폼  이동");
		
	}
	
	@PostMapping("/emp/proFile")
	public void insertFroFile(EmpAttachVO vo) {
		log.info("컨트롤러 :"+vo);
		service.insertProFile(vo);
	}
	
}
