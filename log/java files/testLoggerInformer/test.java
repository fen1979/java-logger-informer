package testLoggerInformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import log.logger;

public class test{

	public static void main(String[] args) {
		/*======== user manual for work witch informer ============*/
		//logger.Menu();

		/*======== all methods of this logger-informer class application for test ========*/

		//logger.logOFF(true);      //default 	off (false)
		//logger.logToFrame(true);  //default 	off (false)			
		//logger.logToFile(true);   //default 	off (false)
		//logger.logTime(false);    //default 	on (true)
		//logger.Type(false);       //default 	on (true)
		//logger.Counter(false);    //default 	on (true)
		//logger.Method(false);     //default 	on (true) // optional setting
		//logger.Value(false);      //default 	on (true)

		/*======== fields and another objects for test logger-informer in work   ===============  */
		
		String[] str = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
		logger.log(str[7]);
		logger.log(str);
/*
		byte[] numb = {1,2,4,5,5,2,3};		
		logger.log(numb);
		logger.log(numb[5]);

		int[] num = {1,2,4};		
		logger.log(num);
		logger.log(num[2]);

		Integer[] num1 = {1,2,4};
		logger.log(num1);
		logger.log(num1[0]);

		double[] doublenum = {1.23,2.1,4.5,3.05};
		logger.log(doublenum);
		logger.log(doublenum[0]);

		Double[] doublenum1 = {1.23,2.1,4.5,3.05};
		logger.log(doublenum1);
		logger.log(doublenum1[3]);
*/
		float[] floatnum = {1,2,3,4,5,6,7,8,9,0};		
		logger.log(floatnum); 
		logger.log(floatnum[0]);
		 
		try{	

			String e = null;
			logger.log(e);

			Throwable e1 = null;
			logger.log(e1);

		}catch(Throwable e){
			e.printStackTrace();
			logger.log(e);
		}

		//=========== Collection test for informer ================
		//------ set collection fields
		Set<Integer> Iset;
		Iset = new HashSet<Integer>();		
		//Iset = new LinkedHashSet<Integer>();
		//Iset = new TreeSet<Integer>();
		//----- logger test for Collection
		for(int i=0;i<7;i++)
			Iset.add(1+i);
		//logger.log(Iset);

		//------ list collection fields
		List<Integer> IList;
		IList = new ArrayList<Integer>();
		//IList = new Vector<Integer>();
		//IList = new LinkedList<Integer>();
		//----- logger test for Collection
		for(int i=0;i<7;i++)
			IList.add(1+i);
		//logger.log(IList);

		PriorityQueue<Integer> PQ;
		PQ = new PriorityQueue<Integer>();
		//----- logger test for Collection
		for(int i=0;i<7;i++)
			PQ.add(1+i);
		//logger.log(PQ);	

		// -----Map Interface 
		Map<Integer, StringBuffer> map;
		map = new HashMap<Integer,StringBuffer>();		
		StringBuffer test = null;
		//map = new LinkedHashMap<Integer,StringBuffer>();
		//map = new TreeMap<Integer,StringBuffer>();
		//map = new Hashtable<Integer,StringBuffer>();
		//----- logger test for Map		
		for(int i=0;i<7;i++)
			map.put(1+i,test);
		//logger.log(map);


	}
}
