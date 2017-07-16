package backupVisitors.util;

public interface StdoutDisplayInterface {
	public static void writeToStdout(String s)
	{
		
		System.out.println("From :: -Standard Output  :----"+ s.toString());
		
	}
}
