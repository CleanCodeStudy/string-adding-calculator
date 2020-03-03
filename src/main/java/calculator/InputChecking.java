package calculator;

public class InputChecking {

	public static boolean isBlank(String value)
	{
		if(value == null|| value.isEmpty())
		{
			return true;
		}
		return false;
	}

	public static boolean checkSinglularity(String inputValue){
		return inputValue.length()==1;
	}

}