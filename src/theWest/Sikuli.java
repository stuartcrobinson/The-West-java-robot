package theWest;


public class Sikuli {
	

	public static void clickMinimapJobDot() {
		String clickBlueDot_mac = "open /Applications/Sikuli-IDE.app /Development/eclipseWorkspace/TheWest/src/sikuli_scripts/clickBlueDot_fixedSubregion_minimizeSikuli_mac.skl";
		String clickBlueDot_win = "";
		String command = null;
		
		try {
			Runtime r = Runtime.getRuntime();
//			System.out.println(System.getProperty("os.name"));
			if (System.getProperty("os.name").toLowerCase().indexOf("mac") != -1){
				command = clickBlueDot_mac;

				r.exec(command);
			}
			if (System.getProperty("os.name").toLowerCase().indexOf("win") != -1){
				command = clickBlueDot_win;
				Thread.sleep(5000);
				System.out.println("sleeping in Sikuli");

//				r.exec(command);
			}
			
			
//			
//			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
