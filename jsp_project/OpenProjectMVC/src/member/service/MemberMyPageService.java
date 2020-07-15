package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class MemberMyPageService implements Service {

	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/views/member/mypage/mypage.jsp";
	}

}
