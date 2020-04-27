package ex;

public class PersonalNumberStorageImpl extends PersonalNumberStorage implements PersonalNumber {

	PersonalNumberInfo[] perArr;
	int numOfPerInfo;
	
	PersonalNumberStorageImpl(int num) {
		perArr = new PersonalNumberInfo[num];
		numOfPerInfo=0;
	}
	
	
	@Override
	public void addPersonalInfo(String perNum, String name) {
		perArr[numOfPerInfo] = new PersonalNumberInfo(name, perNum);
		numOfPerInfo++;
	}

	@Override
	public String searchName(String perNum) {
		for(int i=0; i<numOfPerInfo; i++) {
			if (perArr[i].getNumber().equals(perNum)) {
				return perArr[i].getName();
			}
		}
		return null;
	}

}
