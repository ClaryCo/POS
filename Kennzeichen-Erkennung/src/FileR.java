
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileR {
	private File file;
	private BufferedReader buff = null;

	public FileR(String location) {

		file = new File(location);

		try {
			buff = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String readLines() throws IOException {
		String s = "";

		String line = buff.readLine();
		while (line != null) {
			s += line;
			line = buff.readLine();
		}

		return s;
	}
}