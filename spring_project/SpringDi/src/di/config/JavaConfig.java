package di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di.dao.MemberDao;
import di.service.ChangePasswordService;
import di.service.MemberRegisterService;

@Configuration
public class JavaConfig {

	@Bean(name = "dao")
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean("regSvc")
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwSvc() {
		return new ChangePasswordService(memberDao());
	}
	
}
