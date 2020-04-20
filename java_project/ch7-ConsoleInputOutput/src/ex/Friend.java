package ex;

public class Friend {

	String myName;
	
	Friend(String name) {
		myName=name;
	}
	
	// object 클래스의 toString() 메서드를 재구성한다 => 오버라이딩. (반드시 상속관계에 있어야 오버라이딩 할 수 있다)
	// 메서드의 선언부가 원본메서드의 선언부와 동일해야 한다.
	public String toString() { 
		return "제 이름은 "+this.myName+"입니다";
	}
	
	
	
//	@Override // 메서드의 추가적인 속성 부여.
//	public String toString() {
//		return "Friend [myName=" + myName + "]";
//	}

	
	
	
	public static void main(String[] args) {
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("박지성");
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
}
