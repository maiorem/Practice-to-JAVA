package emp;

import java.sql.Date;

// VO : 읽기전용 (getter)
// DTO : 읽기, 쓰기 (getter & setter)
public class Emp {

	private int empno;
	private String ename;
	private String job;
	private int sal;
	private int mgr;
	private Date hiredate;
	private int comm;
	private int deptno;
		
	public Emp() {
	
	}
	
	public Emp(int empno, String ename, String job, int sal, int mgr, Date hiredate, int comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.comm = comm;
		this.deptno = deptno;
	}

		
	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}


	public void setMgr(int mgr) {
		this.mgr = mgr;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public void setComm(int comm) {
		this.comm = comm;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}





	public int getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public int getSal() {
		return sal;
	}
	public int getMgr() {
		return mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public int getComm() {
		return comm;
	}
	public int getDeptno() {
		return deptno;
	}
	
	
	
	
	
}
