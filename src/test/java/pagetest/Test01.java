package pagetest;

import com.github.pagehelper.PageInfo;
import com.pojo.Employee;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author 张志强
 * @creat 2022/4/18-16:41
 * @Titile :Test01
 * @ProjectName ssm
 * @Description :TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//在测试类上声明该注解, 就可以使用@Autowired获取Spring MVC的上下文
@ContextConfiguration(locations = {"classpath:Application.xml","file:src/main/webapp/WEB-INF/spring-mvc-servlet.xml"})
public class Test01 {

   @Autowired
   WebApplicationContext context;

  private MockMvc mockMvc;

  @Before
  public void init(){ mockMvc = MockMvcBuilders.webAppContextSetup(context).build();}


  @Test
  public void test01() throws Exception {

      MvcResult pg = mockMvc.perform(MockMvcRequestBuilders.get("/").param("pg", "5")).andReturn();
      MockHttpServletRequest request = pg.getRequest();
      PageInfo<Employee> pageInfo = (PageInfo<Employee>) request.getAttribute("page");
      System.out.println("当前页码: " + pageInfo.getPageNum());
      System.out.println("当前页大小: " + pageInfo.getPageSize());
      System.out.println("总页数: " + pageInfo.getPages());
      System.out.println("总记录数: " + pageInfo.getTotal());
      System.out.print("导航条页码: ");
      for (int navigatePageNum : pageInfo.getNavigatepageNums()) {
          System.out.print(navigatePageNum + " ");
      }
      System.out.println();
      //打印员工数据
      pageInfo.getList().forEach(employee -> System.out.println(employee));
  }
}
