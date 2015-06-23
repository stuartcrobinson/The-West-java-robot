package theWest;

import java.util.List;

public class Player {
	
	
	Web web;
	
	public Player(){
		web = new Web();
	}

	public void updateUser(User u){
		
		System.out.println("****************************************************************");
		System.out.println("************            "  + u.name +  "            ************");
		System.out.println("****************************************************************");
		
		List<Job> allJobs = Initialize.listJobs();
		
		web.logIn(u);
		web.handleDailyBonusDialog();
		
		
		if (web.getEnergy() < 24){
			web.goToSleep();
			return;
		}

		if (web.getNumCurrentJobs_fromWorkPane() >= 2){
			System.out.println("already working two jobs.");
			return;
		}
		
		
		web.configureMiniMap();

		if (web.isSleeping()){
		
			web.depositToBankAndTown(25, 10);
			
			if (web.getEnergy() > 75)
				web.cancelCurrentJob();
		}
		
		if (web.hasNewSkillPoints())
			web.allotNewSkills(u);
		
		List<Job> userJobs = web.listJobs_dropdown(allJobs);

		
		System.out.println("initial userJobs list:");
		for (Job job : userJobs)
			System.out.println(job.toString());
		
		web.bringBrowserToFront();
		
		int jobValueMask = u.getJobValueMask();

		Job.sortJobs(userJobs, jobValueMask);
		web.harvestTopJobDetails(userJobs, 3);
		Job.setConditionalValues(userJobs, jobValueMask);
		Job.sortJobs(userJobs, Job.CONDITIONAL);
		

		
		System.out.println("finished investigation.  new userJobs list, sorted by conditional value:");
		for (Job job : userJobs)
			System.out.println(job.toString());
		
		Job bestJob = userJobs.get(0);	
		System.out.println("Best Job found! " + bestJob.name);
		
//		Job job = userJobs.get(27);
//
		web.centerMapOnJob(bestJob);
//		web.investigateVisibleJobs(userJobs);
//
		web.clickJobImage(bestJob);
		web.workOpenJob();
//		
		if (web.getNumCurrentJobs_inOpenJobPane() < 2)
			web.goToSleep();
//		
	}

	public void quit() {

		web.driver.close();
		
	}
	
	
	
	
}
