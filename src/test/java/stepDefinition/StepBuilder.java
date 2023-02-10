package stepDefinition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class StepBuilder {

	static String projectPath = System.getProperty("user.dir");

	static int countInternationalPlayrs = 0;

	static int countWicketKeepers = 0;

	private static Logger logger = Logger.getLogger("MyLog");

	public static void init() {
		FileHandler fh;

		try {
			fh = new FileHandler(
					"C:/Users/bunny/eclipse-workspace/RestAssuredDemoProject/test-output/Log Files/MyLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info("Logger Initialized !!!");

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int countInternationalPlayers() throws FileNotFoundException, IOException, ParseException {

		// parsing file "JSONExample.json"
		Object obj = new JSONParser()
				.parse(new FileReader(projectPath + "\\src\\test\\resources\\JSON Files\\RCB.json"));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting firstName and lastName
		String name = (String) jo.get("name");
		String location = (String) jo.get("location");

		System.out.println(name);
		System.out.println(location);

		// getting players
		JSONArray ja = (JSONArray) jo.get("players");

		// iterating players
		Iterator itr2 = ja.iterator();
		System.out.println("#####################################");
		logger.info("####################################");
		while (itr2.hasNext()) {
			Iterator itr1 = ((Map) itr2.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = (Entry) itr1.next();
				if (pair.getKey().toString().equalsIgnoreCase("country")) {
					logger.info(pair.getKey() + " : " + pair.getValue());
					System.out.println(pair.getKey() + " : " + pair.getValue());
					if (!(pair.getValue().toString().equalsIgnoreCase("India"))) {
						countInternationalPlayrs++;
					}
				}

			}
		}
		System.out.println("#####################################");
		logger.info("####################################");
		logger.info("countInternationalPlayrs : " + countInternationalPlayrs);
		return countInternationalPlayrs;

	}

	void displayPlayersDetails(int countInternationalPlayrs) {
		if (countInternationalPlayrs == 4) {
			System.out.println("There are 4 International Players has been selected for the match.");
			logger.info("There are 4 International Players has been selected for the match.");
			Assert.assertEquals("Count Matched for International Players", 4, countInternationalPlayrs);
		} else {
			System.out.println("Invalid Team Format for the match");
			logger.info("Invalid Team Format for the match");
		}
	}

	int countWicketKeeper() throws FileNotFoundException, IOException, ParseException {
		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
		// parsing file "JSONExample.json"
		Object obj = new JSONParser().parse(new FileReader(filePath + "\\src\\test\\resources\\JSON Files\\RCB.json"));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting players
		JSONArray ja = (JSONArray) jo.get("players");

		// iterating players
		Iterator itr2 = ja.iterator();

		while (itr2.hasNext()) {
			Iterator itr1 = ((Map) itr2.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = (Entry) itr1.next();
				if (pair.getKey().toString().equalsIgnoreCase("role")) {
					System.out.println("#####################################");
					System.out.println(pair.getKey() + " : " + pair.getValue());
					if ((pair.getValue().toString().equals("Wicket-keeper"))) {
						countWicketKeepers++;
					}
				}

			}
		}
		return countWicketKeepers;

	}

	void displayWicketKeeperDetails(int countInternationalPlayrs) {
		if (countWicketKeepers >= 1) {
			System.out.println("A single wicket keeper has been selected for this match.");
			Assert.assertEquals("Count Matched for International Players", 1, countWicketKeepers);
		} else {
			System.out.println("No such wicket keeper has been selected for this match");
		}
	}

	void close() {
		System.out.println("Program Ended !!!");
		logger.info("Program Ended !!!");
	}
}
