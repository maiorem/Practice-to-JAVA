package test;

public class Service {

	//Dao dao=new Dao();
	//Service 클래스는 Dao 클래스에 의존한다.
	
	Dao dao;
	public void setDao(Dao dao) {
		this.dao=dao;
	}
	//의존성을 낮춤
	
	public void print() {
		dao.print();
	}
	
	
}
