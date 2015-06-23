package theWest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class Console {

	//for each User object
//		Web.logIn(user)
//		if bInTown()
//			depositAllMoney()
//		if numCurrentJobs() > 1
//			quit
//		job = determineBestJob()
//		work(job, hours)
//		if getEnergy() < requiredEnergyForJobShift(hours)
//			goToSleep()
//		else
//			work(job, hours)
	
	
//		get jobs list from dropdown menu
//		sort jobs (by User.favoriteJobAttribute)
//		for each job (decreasing)
//			if job.user.favoriteJobAttribute is high enough
//				work(job, hours)
//				sleepIfEnergyLessThan(24)
//				work(job, hours)
//				break
		
//				
	
	//get list of job titles
	//make list of Job objects
	//rank jobs by attribute
	//for each job - (until the top 5 available jobs have been determined)
		//if not skip, set isAvailable and motivation and conditionalValue
	
	
	
	public static void main(String [] args){
		Player player;

		List<User> users = Initialize.listUsers();
		
		
		try {
			Thread.sleep(3600*3*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player = new Player();
		for (User u : users)
			try {
				player.updateUser(u);
			} catch (Exception e) {
				try {
					player.updateUser(u);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		player.quit();

		
		try {
			Thread.sleep(3600*3*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player = new Player();
		for (User u : users)
			try {
				player.updateUser(u);
			} catch (Exception e) {
				try {
					player.updateUser(u);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		player.quit();
		
		
//		
		
		try {
			Thread.sleep(3600*3*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player = new Player();
		for (User u : users)
			try {
				player.updateUser(u);
			} catch (Exception e) {
				try {
					player.updateUser(u);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		player.quit();

		
		try {
			Thread.sleep(3600*3*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player = new Player();
		for (User u : users)
			try {
				player.updateUser(u);
			} catch (Exception e) {
				try {
					player.updateUser(u);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		player.quit();
		
//		
		
//		
//		try {
//			Thread.sleep(14580000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		player = new Player();
//		
//		
//		for (User u : users)
//			player.updateUser(u);
//
//		player.quit();
		
		
		
//		
//
//		User u = new User("marriage", "mar");
//		player.web.logIn(u);
//		
//		player.web.cancelCurrentJob();
//		
//		
		
//		player.web.handleDailyBonusDialog();
		
		
		
//		Web web = new Web();
//
//		List<Job> allJobs = Initialize.listJobs();
////		
//		
//		
//		User u = new User("marriage", "mar");
//		web.logIn(u);
//		web.configureMiniMap();
//
//
//		List<Job> userJobs = web.listJobs_dropdown(allJobs);
//
//		
//		System.out.println("initial userJobs list:");
//		for (Job job : userJobs)
//			System.out.println(job.toString());
//		
//		web.bringBrowserToFront();
//		
//		int jobValueMask = Job.EXPERIENCE;
//
//		Job.sortJobs(userJobs, jobValueMask);
//		web.harvestTopJobDetails(userJobs, 6);
//		Job.setConditionalValues(userJobs, jobValueMask);
//		Job.sortJobs(userJobs, Job.CONDITIONAL);
//		
//
//		
//		System.out.println("finished investigation.  new userJobs list, sorted by conditional value:");
//		for (Job job : userJobs)
//			System.out.println(job.toString());
//		
//		Job bestJob = userJobs.get(0);	
//		System.out.println("Best Job found! " + bestJob.name);
//		
////		Job job = userJobs.get(27);
////
//		web.centerMapOnJob(bestJob);
////		web.investigateVisibleJobs(userJobs);
////
//		web.clickJobImage(bestJob);
//		web.workOpenJob();
////		
//		if (web.getNumCurrentJobs_inOpenJobPane() < 2)
//			web.goToSleep();
////		
//		web.closeAllWindows();
		
//		
//
////
////		for (Job j : allJobs)
////			System.out.println(j.toString());
//		
//		
//		List<Job> userJobs = web.listJobs_dropdown(allJobs);
//
//		int jobValueType = Job.EXPERIENCE;
////
//		web.investigateUserJobs(userJobs, jobValueType);
////		
////		
//		Job bestJob = Job.pickBestJob(userJobs, jobValueType);

		
//		
//		web.printLHNavCharacterPoint();
//		web.printLHNavDuelPoint();
//	
//		web.goToSleep();	// add something to make sure sleep has been selected	
		
//		web.bringBrowserToFront();
//		
//		Job j = new Job();
//		j.imageName = "fence";
//		web.selectJob(j);
		
//		web.test();
//		
//		if (web.isInTown()){
//			System.out.println("in town!!");
//			web.depositCashByIncrements(25);
//		}
//		else
//			System.out.println("not in town");
		
//		if (web.numCurrentJobs() > 1)
//			System.out.println("second job exists");
//		else
//			System.out.println("2nd job not found :(");
		
//		web.printAvailableJobTitles();
		
		
		
//		web.configureMiniMap();
		
//		web.printAllVisibleJobs();\
		
//		web.clickAJobIcon();
//		System.out.println(web.getEnergy());
//		System.out.println(web.getJobMotivation());
//		System.out.println(web.getLooseMoney());
//		System.out.println(web.getNumCurrentJobs());
		
//		job = web.determineBestJob();
	
		
		System.out.println("finished.");
	}
	
	
}
