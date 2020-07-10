<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isMultipart=ServletFileUpload.isMultipartContent(request);
	
	if(isMultipart) {
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=upload.parseRequest(request);
		Iterator<FileItem> iter=items.iterator();
		while(iter.hasNext()) {
			
			FileItem item=iter.next();
			
			//isFormField() : text value를 가지는 input 확인
			if(item.isFormField()) { //type=file 이외의 input 
				//파라미터 이름	
				String paramName=item.getFieldName();
				//파라미터의 값
				String paramValue=item.getString("utf-8");
				System.out.println(paramName+" = "+paramValue);
			} else { //type=file
				//파라미터 이름
				String paramName=item.getFieldName();
				//파일 이름
				String fileName=item.getName();
				//파일의 사이즈
				long file_size=item.getSize();
				//파일의 타입
				String contentType=item.getContentType();
				//임시메모리 저장 여부
				boolean isInMemory=item.isInMemory();
				System.out.println("필드 이름 : "+paramName);
				System.out.println("파일 이름 : "+fileName);
				System.out.println("파일의 사이즈 : "+file_size);
				System.out.println("파일의 타입 : "+contentType);	
				
				//서버 내부의 경로
				//String uri="/file";
				String uri=request.getSession().getServletContext().getInitParameter("uploadPath");
				
				//시스템의 실제 경로(절대경로)
				String realPath=request.getSession().getServletContext().getRealPath(uri);
				//System.out.println(realPath);
				
				String newFileName=System.nanoTime()+"_"+fileName;
				
				//서버의 저장소에 실제 저장
				File saveFile=new File(realPath, newFileName);
				item.write(saveFile);
				System.out.println("저장 완료");
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>