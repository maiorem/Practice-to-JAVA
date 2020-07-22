package message.dao;

public class MessageDao {
	
	private MessageDao() {}
	private static MessageDao dao=new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}
	

	
	
}
