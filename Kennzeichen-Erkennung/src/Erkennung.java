
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Erkennung {

	public static void main(String[] args) {
	

		FileR fi = null;
		int counter = 1;
		HashSet<String> nrt = new HashSet<String>();

		if (args.length == 0) {
			System.out.println("Welcome to the LicenseTemplateReader of Herbst Lukas (hl). \r\n"
					+ "Please give me as first argument the filename which should be processed.");
		} else {
			fi = new FileR(args[0].toString());

			String regularExpression = "[A-Z]+-[A-Z\\d]+";
			String lines = "";

			try {
				lines = fi.readLines();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Pattern pattern = Pattern.compile(regularExpression);
			Matcher matcher = pattern.matcher(lines);

			while (matcher.find()) {
				nrt.add(lines.substring(matcher.start(), matcher.end()));
			}

			ArrayList<String> licencePlates = new ArrayList<String>(nrt);
			Collections.sort(licencePlates);

			for(String lp : licencePlates) {
                System.out.println(counter + " " + lp);
                counter++;
            }
		}
	}

}
