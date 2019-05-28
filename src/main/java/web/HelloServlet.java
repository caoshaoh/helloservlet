package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	/**
	 * 当容器(比如tomcat)收到请求之后,会帮我们解析请求数据包
	 * 并且将解析到的数据存放到request对象里面,(开发人员只需要
	 * 调用request对象的方法就可以获得请求数据包中的数据),同时,
	 * 容器还会创建response对象(开发人员只需要将处理结果存放到
	 * response对象上,容器会用我们创建响应数据包并发送).
	 * 接下来,容器会调用service,并且将request对象和response对象
	 * 作为方法的参数传进来
	 */
		public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			/*
			 * 这行代码要添加到所有的getParameter方法的最前面
			 * 作用是告诉服务器,针对post请求,使用哪种字符集来进行解码
			 */
			request.setCharacterEncoding("utf-8");
			/*
			 * 读取请求参数值
			 * 请求参数名不能写错,否则会获得null值.
			 */
			String name=request.getParameter("name");
			System.out.println("name:"+name);
			int age=Integer.parseInt(request.getParameter("age"));
			/*
			 * 设置content-type消息头,告诉
			 * 浏览器,服务器返回的数据类型
			 * charset=utf-8在这儿有两个作用
			 * 作用1:out.println方法会使用utf-8来编码
			 * 作用2:content-type消息头的值会包含->??
			 * 字符集的设置,浏览器会按照utf-8来解码.
			 */
			response.setContentType("text/html;charset=utf-8");
			/*
			 * 通过response对象获得输出流
			 */
			PrintWriter out=response.getWriter();
			/*
			 * 将数据存放到response对象上.
			 * 容器会从response对象上获取数据,然后
			 * 创建响应数据包,然后将响应数据包
			 * 发送给浏览器
			 * out.println()方法,默认情况下会使用iso-8859-1来编码.
			 * 
			 */
			out.println("<h1>你好 "+name+"</h1>");
			out.println("<h1>age:"+age+"</h1>");
			
			out.close();
		}
}
