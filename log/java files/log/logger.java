package log;


public class logger extends LogicClass {
	public logger() {
	}

	public logger(boolean Writing, boolean typeOff, boolean ValueOff,
			boolean counterOff, boolean Counter, boolean Method, boolean Frameon) {
		FieldsClass.WritingLog = Writing;
		FieldsClass.typeOff = typeOff;
		FieldsClass.Counter = Counter;
		FieldsClass.Method = Method;
		FieldsClass.Value = ValueOff;
		FieldsClass.frameON = Frameon;
	}

	public static void logOFF(boolean onOff) {
		FieldsClass.ONOFF_Logger = onOff;
	}

	public static void logToFrame(boolean FrameOn) {
		FieldsClass.frameON = FrameOn;
	}

	public static void Menu() {
		if (frameON)
			view("\nUser Manual\nlogger.LogOFF(false); - enable/disable the logger\nlogger.FrameOn(false); - ON/Off Report Information Frame for Windows 32bit !!! and Switched view from Console to Frame Window\nlogger.logToFile(false); - enable/disable writing to text file on HDD\nlogger.logTime(true); - enable/disable printing to log: Time call\nlogger.Type(true); - enable/disable printing to log: Type of the incoming object\nlogger.Counter(true); - enable/disable printing to log: Counter of Calls\nlogger.Method(true); - enable/disable printing name of the method, which is processed object\nlogger.Value(true); - enable/disable printing Value of the incoming object\n",
					0);
		else
			view("\nUser Manual\nlogger.LogOFF(false); - enable/disable the logger\nlogger.FrameOn(false); - ON/Off Report Information Frame for Windows 32bit !!! and Switched view from Console to Frame Window\nlogger.logToFile(false); - enable/disable writing to text file on HDD\nlogger.logTime(true); - enable/disable printing to log: Time call\nlogger.Type(true); - enable/disable printing to log: Type of the incoming object\nlogger.Counter(true); - enable/disable printing to log: Counter of Calls\nlogger.Method(true); - enable/disable printing name of the method, which is processed object\nlogger.Value(true); - enable/disable printing Value of the incoming object\n",
					0);
	}

	public static void logToFile(boolean off) {
		FieldsClass.WritingLog = off;
	}

	public static void logTime(boolean off) {
		FieldsClass.isTime = off;
	}

	public static void Type(boolean off) {
		FieldsClass.typeOff = off;
	}

	public static void Method(boolean Method) {
		FieldsClass.Method = Method;
	}

	public static void Counter(boolean counter) {
		FieldsClass.Counter = counter;
	}

	public static void Value(boolean value) {
		FieldsClass.Value = value;
	}

	public static void log(Object x) {
		if (ONOFF_Logger)
			return;
		try {
			StackTraceElement[] STelem = Thread.currentThread().getStackTrace();
			if (x != null) {
				if (!(x.getClass().isArray())) {
					printObj(x, STelem);
					return;
				}
				if ((x.getClass().getName().equals("[B"))
						|| (x.getClass().getName().equals("[Bjava.lang.Byte"))) {
					byte[] xArray = (byte[]) x;
					printArrObj(xArray, STelem);
					return;
				}
				if ((x.getClass().getName().equals("[I"))
						|| (x.getClass().getName()
								.equals("[Ljava.lang.Integer"))) {
					int[] xArray = (int[]) x;
					printArrObj(xArray, STelem);
					return;
				}
				if ((x.getClass().getName().equals("[D"))
						|| (x.getClass().getName().equals("[Ljava.lang.Double"))) {
					double[] xArray = (double[]) x;
					printArrObj(xArray, STelem);
					return;
				}
				if ((x.getClass().getName().equals("[F"))
						|| (x.getClass().getName().equals("[Fjava.lang.Float"))) {
					float[] xArray = (float[]) x;
					printArrObj(xArray, STelem);
					return;
				}
				Object[] xArray = (Object[]) x;
				printArrObj(xArray, STelem);

				return;
			}
			thisIsNull(STelem);
		} catch (Throwable e) {
			System.out.println(" catch off log(object x)");
			e.printStackTrace();
		}
	}
}