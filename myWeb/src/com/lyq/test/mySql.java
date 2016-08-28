package com.lyq.test;
import java.sql.*;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class mySql
 */
@WebFilter("/mySql")
public class mySql implements Filter {

    /**
     * Default constructor. 
     */
    public mySql() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public static void main(String args[]) {
	    try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/stu","root","admin907");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

	      System.out.println("Success connect Mysql server!");
	      /*
	      int num=10;  
	      PreparedStatement Statement=connect.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");  
	      for(int i=0;i<num;i++)        //定义个100次的循环，往表里插入一百条信息。  
	      {  
	    	  Statement.setLong(1,i);  
	           Statement.setString(2,"chongshi"+i);  
	           Statement.setString(3,"bo"+i);  
	           Statement.setString(4,"124567890"+i);  
	           Statement.executeUpdate();  
	      }  */
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from student");
	                                                              //user 为你表的名称
	      while (rs.next()) {
	        System.out.println(rs.getString("name"));
	      }
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
	  }
}
