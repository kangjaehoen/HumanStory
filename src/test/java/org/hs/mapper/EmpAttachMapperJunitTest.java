package org.hs.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.hs.domain.EmpAttachVO;
import org.hs.domain.EmployeeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class EmpAttachMapperJunitTest {
	private EmpProFileMapper mapper;
	
/*	@Test
	public void test() {
		log.info(mapper);
	}*/
	

	
}
