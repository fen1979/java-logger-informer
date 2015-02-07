package log;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class FieldsClass {
	protected static final int ERROR = 1;
	protected static final int STANDART = 0;
	protected static final int BACKSPACE = 6;
	protected static final String LOGGER_MENU = "\nUser Manual\n"
			+ "logger.LogOFF(false); - enable/disable the logger\n"
			+ "logger.FrameOn(false); - ON/Off Report Information Frame for Windows 32bit !!! and Switched view from Console to Frame Window\n"
			+ "logger.logToFile(false); - enable/disable writing to text file on HDD\n"
			+ "logger.logTime(true); - enable/disable printing to log: Time call\n"
			+ "logger.Type(true); - enable/disable printing to log: Type of the incoming object\n"
			+ "logger.Counter(true); - enable/disable printing to log: Counter of Calls\n"
			+ "logger.Method(true); - enable/disable printing name of the method, which is processed object\n"
			+ "logger.Value(true); - enable/disable printing Value of the incoming object\n";
	protected static boolean ONOFF_Logger = false;
	protected static boolean frameON = false;
	protected static boolean WritingLog = false;
	protected static boolean isTime = true;
	protected static boolean typeOff = true;
	protected static boolean Counter = true;
	protected static boolean Method = true;
	protected static boolean Value = true;

	protected static int callcounter = 1;
	protected static String about = "\n\nClass logger release ver. 1.25 ";
	protected static StringBuffer sb = new StringBuffer(about);
	protected static JFrame frame;
	protected static JTextArea ta;
	protected static JScrollPane sp;

	protected static void saveToFile(String mess, int type) {
		System.out.println("this method comming soon");
	}
}