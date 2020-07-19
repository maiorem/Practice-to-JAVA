package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.NullServiceImpl;
import service.Service;

public class FrontController extends HttpServlet{
	
	private Map<String, Service> commands=new HashMap<String, Service>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// 1. commandsService.properties(외부 설정) => Properties 
		// /index=service.IndexServiceImpl
		// 2. 클래스 정보의 클래스들을 생성 -> 인스턴스 생성
		// 3. map에 사용자 요청 commands와 인스턴스를 저장
		
		// 1.외부 설정 파일의 내용을 메모리의 데이터로 이동
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		// 설정 파일의 웹경로
		String path="/WEB-INF/commandService.properties";
		// 설정 파일의 시스템 절대경로
		String configFile=config.getServletContext().getRealPath(path);
		
		try {
			fis=new FileInputStream(configFile);
			//프로퍼티 객체로 파일을 읽어온다.
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator itr=prop.keySet().iterator();
		
		while(itr.hasNext()) {
			//사용자 요청 uri
			String command=(String) itr.next(); 
			//사용자 요청의 처리를 위한 클래스이름, 정보
			String serviceClassName=prop.getProperty(command);
			try {
				//인스턴스 생성을 위한 Class 객체
				Class serviceClass=Class.forName(serviceClassName);
				//인스턴스 생성
				Service service=(Service) serviceClass.newInstance();
				
				commands.put(command, service);
				System.out.println(command+"="+service);
								
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//		while(itr.hasNext()) {
//			String command=(String) itr.next();
//			String serviceClassName=prop.getProperty(command);
//			System.out.println(command + "="+serviceClassName);
//		}
		
//		commands.put("/", new IndexServiceImpl());
//		commands.put("/index", new IndexServiceImpl());
//		commands.put("/greeting", new GreetingServiceImpl());
//		commands.put("/date", new DateServiceImpl());
//		commands.put("null", new NullServiceImpl());
	}



	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//2.사용자의 요청을 파악한다 : request 객체를 이용
		//req.getParameter(name);
		//req.getRequestURL();
		// req.getRequestURI(); (★★★★★) 
		//String type=req.getParameter("type");
		String type=null;
		String command=req.getRequestURI();
		System.out.println(command);
		System.out.println(command.indexOf(req.getContextPath()));
		
		if(command.indexOf(req.getContextPath())==0) {
			type=command.substring(req.getContextPath().length());
		}
		
		System.out.println("요청 파악 : " +type);
		
		//3.핵심처리 : 기능 수행
		//Object resultObj=null;
		//String page="/WEB-INF/views/simple_view.jsp";
		Service service=commands.get(type);
		
		if(service==null) {
			service=new NullServiceImpl();
		}
		
		
		// http://localhost:8080/fc/greeting
		// http://localhost:8080/fc/date
//		if(type.equals("/greeting")) {
//			service=new GreetingServiceImpl();
//		} else if(type.equals("/date")) {
//			service=new DateServiceImpl();
//		} else if(type.equals("/") || type.equals("/index")) { 
//			service=new IndexServiceImpl();
//		} else {
//			service=new NullServiceImpl();
//		}
		
		String page=service.getViewPage(req, resp);
		
		
		//System.out.println("핵심처리 결과 : "+resultObj);
		
		//4.결과 데이터를 속성에 저장 : view 페이지에 공유
		//req.setAttribute("result", resultObj);
		//System.out.println("속성에 저장");

		//5.포워딩
		RequestDispatcher dispatcher=req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
		
	}
	
	//1. Http의 요청을 받는다
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}

