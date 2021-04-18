import java.io.*;

public class Main {
	public static void main(String args[]) {
		String command = "ls";
		command = "touch user_01.xml";
		try {
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
