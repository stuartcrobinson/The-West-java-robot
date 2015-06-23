package theWest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class Console {
	
	public static long oneHour = 3600000;
	public static List<User> users;

	public static void sleepMinutes(long minutes){
		try {	Thread.sleep(60*minutes*1000);}
		catch (InterruptedException e) {e.printStackTrace();}
	}
	public static void sleepHours(long hours){
		try {	Thread.sleep(3600*hours*1000);}
		catch (InterruptedException e) {e.printStackTrace();}
	}
	

	private static void runPlayerUpdateUser() {
		Player player = new Player();
		for (User u : users) {
			try {
				
				player.updateUser(u);
				
			} catch (Exception e)  {

				
//				sleepMinutes(1);

				System.out.println("1.  failed to update " + u.name); e.printStackTrace();
				try{ player.quit(); } catch(Exception ee){}		
				player = new Player();
				try {

					player.updateUser(u);

				} catch (Exception e1) {
					System.out.println("2.  failed to update " + u.name); e1.printStackTrace();
					try{ player.quit(); } catch(Exception ee){}		
					player = new Player();
//					sleepMinutes(1);
				}

//				sleepMinutes(5);
			}
		}
		player.quit();		
	}


	

	public static void main(String [] args){		
		users = Initialize.listUsers();

		//		sleepMinutes(1);	
		//		runPlayerUpdateUser();		
//		sleepHours(3);		

		try {

			while (true){
				runPlayerUpdateUser();
				sleepHours(1);	
				sleepMinutes(20);
			}	
		}
		catch (Exception e){
			System.out.println("1.  failed in console ");

			while (true){
				runPlayerUpdateUser();
				sleepHours(1);		
				sleepMinutes(20);
			}	
		}

		//		System.out.println("finished.");
	}
}
