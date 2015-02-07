package log;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class LogicClass extends FieldsClass {
	protected static void view(String mess, int type) {
		if (WritingLog) {
			saveToFile(mess, type);
		} else if (frameON) {
			if (frame != null) {
				ta.append(mess);
			} else {
				InitiateFrame();
				ta.append("initialization process sucsesful\n");
				ta.append(mess);
			}
		} else {
			if (type == 1) {
				System.err.println(mess);
			}

			if (type == 0) {
				System.out.println(mess);
			}
		}

		dropBufer();
	}

	protected static void dropBufer() {
		sb.delete(0, sb.length());
	}

	protected static void InitiateFrame() {
		frame = new JFrame();
		ta = new JTextArea();
		sp = new JScrollPane(ta);
		frame.setVisible(true);
		frame.setBounds(300, 200, 650, 300);
		frame.setDefaultCloseOperation(3);
		frame.add(sp);
	}

	protected static void thisIsNull(StackTraceElement[] stElem) {
		view(new StringBuilder(
				"\nThis variable is NULL.\nline a call through the stack: ")
				.append(stElem[2]).toString(), 1);
	}

	protected static void thisIsMayBeNull(StackTraceElement[] stElem) {
		view(new StringBuilder(
				"\nThis Object maybe NULL.\nline a call through the stack: ")
				.append(stElem[2]).toString(), 1);
	}

	protected static void callCounter(int i) {
		sb.append("\nCall counter->" + i + ";");
	}

	protected static void notNullTypeOFF() {
		sb.append(": <NOT NULL>;");
	}

	protected static void notNullTypeON(int[] x) {
		sb.append(";\nType: " + x.getClass().getName()
				+ ": <ARRAY> : <NOT NULL>;");
	}

	protected static void stackPrint(StackTraceElement[] stElem) {
		Date time = new Date();
		sb.append("\n-----------------------------------------------------------------\n");
		if (isTime) {
			sb.append(time + ";\n");
		}
		sb.append(stElem[2].getClassName() + "." + stElem[2].getMethodName()
				+ ": Line-" + stElem[2].getLineNumber());
	}

	protected static void printObj(Object x, StackTraceElement[] stElem) {
		if ((stElem.length >= 3) && (x != null)) {
			stackPrint(stElem);
			if (typeOff)
				sb.append(";\nType: " + x.getClass().getName()
						+ ": <NOT NULL>;");
			if (!(typeOff))
				notNullTypeOFF();
			if (Counter)
				callCounter(callcounter++);
			if (Method)
				sb.append("\nMethod void printObj(Object x;");
			if (Value)
				sb.append("\nValue->" + x.toString());
			view(sb.toString(), 0);
		} else {
			thisIsMayBeNull(stElem);
		}
	}

	protected static void printArrObj(Object[] x, StackTraceElement[] stElem) {
		if ((stElem.length >= 3) && (x != null) && (x[0] != null)) {
			stackPrint(stElem);
			if (typeOff) {
				sb.append(";\nType: " + x.getClass().getName()
						+ ": <ARRAY> : <NOT! NULL>;");
			}
			if (!(typeOff)) {
				notNullTypeOFF();
			}
			if (Counter) {
				callCounter(callcounter++);
			}
			if (Method) {
				sb.append("\nMethod void printArrObj(Object[] x;");
			}
			if (Value) {
				int ind = 0;
				sb.append("\nValue-> ");
				for (int i = 0; i < x.length; ++i) {
					if (ind <= 6) {
						sb.append(x[i].toString() + ": ");
						++ind;
					} else {
						sb.append("\n");
						ind = 0;
						--i;
					}
				}
			}
			view(sb.toString(), 0);
		} else {
			thisIsMayBeNull(stElem);
		}
	}

	protected static void printArrObj(byte[] x, StackTraceElement[] stElem) {
		if ((stElem.length >= 3) && (x != null)) {
			stackPrint(stElem);
			if (typeOff) {
				sb.append(";\nType: " + x.getClass().getName()
						+ ": <ARRAY> : <NOT! NULL>;");
			}
			if (!(typeOff)) {
				notNullTypeOFF();
			}
			if (Counter) {
				callCounter(callcounter++);
			}
			if (Method) {
				sb.append("\nMethod void printArrObj(Object[] x;");
			}
			if (Value) {
				int ind = 0;
				sb.append("\nValue-> ");
				for (int i = 0; i < x.length; ++i) {
					if (ind <= 6) {
						sb.append(x[i] + ": ");
						++ind;
					} else {
						sb.append("\n");
						ind = 0;
						--i;
					}
				}
			}
			view(sb.toString(), 0);
		} else {
			thisIsMayBeNull(stElem);
		}
	}

	protected static void printArrObj(int[] x, StackTraceElement[] stElem) {
		if ((stElem.length >= 3) && (x != null)) {
			stackPrint(stElem);
			if (typeOff) {
				notNullTypeON(x);
			}
			if (!(typeOff)) {
				notNullTypeOFF();
			}
			if (Counter) {
				callCounter(callcounter++);
			}
			if (Method) {
				sb.append("\nMethod void printArrObj(int[] x;");
			}
			if (Value) {
				int ind = 0;
				sb.append("\nValue-> ");
				for (int i = 0; i < x.length; ++i) {
					if (ind <= 6) {
						sb.append(x[i] + ": ");
						++ind;
					} else {
						sb.append("\n");
						ind = 0;
						--i;
					}
				}
			}
			view(sb.toString(), 0);
		} else {
			thisIsMayBeNull(stElem);
		}
	}

	protected static void printArrObj(float[] x, StackTraceElement[] stElem) {
		if ((stElem.length >= 3) && (x != null)) {
			stackPrint(stElem);
			if (typeOff) {
				sb.append(";\nType: " + x.getClass().getName()
						+ ": <ARRAY> : <NOT NULL>;");
			}
			if (!(typeOff)) {
				notNullTypeOFF();
			}
			if (Counter) {
				callCounter(callcounter++);
			}
			if (Method) {
				sb.append("\nMethod void printArrObj(double[] x;");
			}
			if (Value) {
				int ind = 0;
				sb.append("\nValue-> ");
				for (int i = 0; i < x.length; ++i) {
					if (ind <= 6) {
						sb.append(x[i] + ": ");
						++ind;
					} else {
						sb.append("\n");
						ind = 0;
						--i;
					}
				}
			}
			view(sb.toString(), 0);
		} else {
			thisIsMayBeNull(stElem);
		}
	}

	protected static void printArrObj(double[] x, StackTraceElement[] stElem) {
		if ((stElem.length >= 3) && (x != null)) {
			stackPrint(stElem);
			if (typeOff) {
				sb.append(";\nType: " + x.getClass().getName()
						+ ": <ARRAY> : <NOT NULL>;");
			}
			if (!(typeOff)) {
				notNullTypeOFF();
			}
			if (Counter) {
				callCounter(callcounter++);
			}
			if (Method) {
				sb.append("\nMethod void printArrObj(double[] x;");
			}
			if (Value) {
				int ind = 0;
				sb.append("\nValue-> ");
				for (int i = 0; i < x.length; ++i) {
					if (ind <= 6) {
						sb.append(x[i] + ": ");
						++ind;
					} else {
						sb.append("\n");
						ind = 0;
						--i;
					}
				}
			}
			view(sb.toString(), 0);
		} else {
			thisIsMayBeNull(stElem);
		}
	}
}