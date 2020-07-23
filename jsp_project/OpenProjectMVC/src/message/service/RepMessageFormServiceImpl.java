package message.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import message.dao.MessageDao;
import service.Service;

public class RepMessageFormServiceImpl implements Service {
	
	MemberDao dao;

	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/WEB-INF/views/message/RepMessageForm.jsp";
	}

}
