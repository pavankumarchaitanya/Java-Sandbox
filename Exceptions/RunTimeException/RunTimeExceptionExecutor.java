
public class RunTimeExceptionExecutor {

	public static void main(String[] args) {
		methodOne();
	}
	
	
	public static void methodOne()
	{
		try{
		int i = 1/0;
		}catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
