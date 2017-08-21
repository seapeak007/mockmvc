package com.docs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MockController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
//@SpringBootTest  //这个不能跟WebMvcTest同时存在，只能选择一个，创建API文档采用WebMvcTest
public class MockmvcApplicationTests {

	@Autowired
	MockMvc mockMvc ;

	@Test
	public void contextLoads() throws Exception {

		String name ="7" ;
		this.mockMvc.perform(get("/").param("name",name)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("hello "+name)))
				.andDo(document("home"));
	}

}
