package theWest;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Sikuli {
	static String clickBlueDot_mac = "open /Applications/Sikuli-IDE.app /Development/eclipseWorkspace/TheWest/src/sikuli_scripts/clickBlueDot_fixedSubregion_minimizeSikuli_mac.skl";
	static String win_click_start = "\\Program Files\\Sikuli\\Sikuli-IDE.bat \\Documents and Settings\\Administrator\\workspace\\West\\src\\theWest\\sikuli_scripts\\clickStartMenu_WinXP_Desktop.skl";
	static String clickBlueDot_win = "\"C:\\Program Files\\Sikuli\\Sikuli-IDE.exe\" \"C:\\Documents and Settings\\Administrator\\workspace\\West\\src\\theWest\\sikuli_scripts\\clickBlueDot_winDesk.skl\"";

	public static void runCommandVerbose(String command){
		System.out.println("exececuting command: "+ command);
	    try {
	        String line;
	        Process p = Runtime.getRuntime().exec(command);
	        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        while ((line = input.readLine()) != null) 
	          System.out.println(line);
	        
	        input.close();
	      }
	      catch (Exception err) {
	        err.printStackTrace();
	      }
	}
	
	
	public static void clickMinimapJobDot() {
		String command = null;
		
		try {
			Runtime r = Runtime.getRuntime();
//			System.out.println(System.getProperty("os.name"));
			if (System.getProperty("os.name").toLowerCase().indexOf("mac") != -1){
				command = clickBlueDot_mac;
				Sikuli.runCommandVerbose(command);
			}
			if (System.getProperty("os.name").toLowerCase().indexOf("win") != -1){
				command = clickBlueDot_win;
				Sikuli.runCommandVerbose(command);
			}		
				} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public static void test() {

		//these work!
		//the .bat method opens a terminal window
//		"C:\Program Files\Sikuli\Sikuli-IDE.bat" "C:\Documents and Settings\Administrator\workspace\West\src\theWest\sikuli_scripts\clickBlueDot_winDesk.skl"
//		"C:\\Program Files\\Sikuli\\Sikuli-IDE.exe" "C:\\Documents and Settings\\Administrator\\workspace\\West\\src\\theWest\\sikuli_scripts\\clickBlueDot_winDesk.skl"

		String clickBlueDot_win_test = "\"C:\\Program Files\\Sikuli\\Sikuli-IDE.exe\" \"C:\\Documents and Settings\\Administrator\\workspace\\West\\src\\theWest\\sikuli_scripts\\clickBlueDot_winDesk.skl\"";

		String command = null;
		
		try {
			Runtime r = Runtime.getRuntime();
			System.out.println(System.getProperty("os.name"));
			if (System.getProperty("os.name").toLowerCase().indexOf("mac") != -1){
				command = clickBlueDot_mac;

				r.exec(command);
			}
			if (System.getProperty("os.name").toLowerCase().indexOf("win") != -1){
				System.out.println("doing win stuff");

				command = clickBlueDot_win_test;
				System.out.println("command: " + command);

//				Thread.sleep(5000);
//				System.out.println("sleeping in Sikuli");

//				r.exec(command);
				
			    try {
			        String line;
			        Process p = Runtime.getRuntime().exec(command);
			        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			        while ((line = input.readLine()) != null) 
			          System.out.println(line);
			        
			        input.close();
			      }
			      catch (Exception err) {
			        err.printStackTrace();
			      }
			}
			
			
//			
//			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	public static void main(String[] args){
//		
////		System.out.println(Sikuli.clickBlueDot_win2);
//		Sikuli.test();
//	}


}
