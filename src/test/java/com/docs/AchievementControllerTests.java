//package com.docs;
//
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.JUnitRestDocumentation;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lexue.english.child.domain.mongodb.ProgressEntity;
//import com.lexue.english.child.protocol.common.Request;
//import com.lexue.english.child.protocol.type.RetCode;
//import com.lexue.english.child.repository.mongodb.ProgressRepository;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AchievementControllerTests {
//
//	@Rule
//	public JUnitRestDocumentation restDocumentation =
//			new JUnitRestDocumentation("target/generated-snippets");
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@Autowired
//	private WebApplicationContext context;
//
//	private MockMvc mockMvc;
//	@Autowired
//	private ProgressRepository repository;
//
//
//	@Before
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
//				.apply(documentationConfiguration(this.restDocumentation))
//				.alwaysDo(document("{method-name}/{step}/"))
//				.build();
//	}
//
//	@Test
//	public void test0_findAchievement() throws Exception {
//
//		ProgressEntity progress = repository.findOne(888888L);
//		progress.setArchievement("archievement");
//		repository.save(progress);
//
//		Request<Object> request2 = new Request<>();
//		request2.setDeviceId("5555555");
//		request2.setSessionId("666666666");
//
//		log.debug(objectMapper.writeValueAsString(request2));
//
//		this.mockMvc.perform(
//				post("/ce/1.0/ac/info")
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString(request2)))
//		.andExpect(status().isOk())
//		.andExpect(jsonPath("rc", is(RetCode.SUCCESS.ordinal())))
//		.andExpect(jsonPath("rep", is(notNullValue())))
//		.andExpect(jsonPath("rep.ac", is("archievement")))
//		.andDo(document("ac_info"));
//
//	}
//}
