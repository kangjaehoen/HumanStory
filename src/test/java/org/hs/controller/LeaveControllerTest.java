package org.hs.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class LeaveControllerTest {
    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
//
//    @Test
//    public void testGetList() throws Exception {
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/leave/request"))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString());
//    }
//
//    @Test
//    public void testRegister() throws Exception {
//        log.info("레지스터 컨트롤러 테스트 작동 실행");
//        mockMvc.perform(MockMvcRequestBuilders.post("/leave/register")
//                .param("leaveType", "연차")
//                .param("leaveReason", "쉬려고")
//                .param("leaveDays", "3")
//                .param("empNum", "101")
//                .param("startDate", "24-01-01")
//                .param("endDate", "24-01-02")
//                .param("requestDate", "23-12-12")
//        );
//        log.info("testRegister 성공");
//    }
//
//    @Test
//    public void testGetLeaveOne() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/leave/getLeaveOne")
//                .param("leaveNum", "30"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("leave/getLeaveOne"))
//                .andExpect(model().attributeExists("leaveOne"));
//        log.info("testGetLeaveOne 성공");
//    }
//
//    @Test
//    public void testModifyLeave() throws Exception {
//        log.info("테스트");
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/leave/modify")
//                .param("leaveNum", "30")
//                .param("leaveType", "병가")
//                .param("leaveReason", "알고보니 아프네")
//                .param("leaveDays", "4")
//                .param("empNum", "101")
//                .param("startDate", "24-01-01")
//                .param("endDate", "24-01-04")
//                .param("requestDate", "23-12-20")
//        );
//        log.info("컨트롤러 modify 성공");
//    }
}
