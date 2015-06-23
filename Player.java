package theWest;

import java.util.Arrays;
import java.util.List;

public class Player {
	
	
	Web web;
	
	public Player(){
		web = new Web();
	}

	public void updateUser(User u) throws Exception{
		
		System.out.println("****************************************************************");
		System.out.println("************            "  + u.name +  "            ************");
		System.out.println("****************************************************************");
		
		List<Job> allJobs = Initialize.listJobs();
		
		web.logIn(u);
		web.handleDailyBonusDialog();
		

		if (web.isSleeping()){

			web.depositToBankAndTown(25, 10);

			if (web.getEnergy() > 50){
				try { web.cancelCurrentJob(); } catch(Exception e){}
				try { web.cancelCurrentJob(); } catch(Exception e){}		//cancel both jobs in case the real job was far away -- in case the user was far away when automation signed him up for it
			}				
		}
		else {
		//if not asleep:
			if (web.getNumCurrentJobs_fromWorkPane() >= 2){
				System.out.println("already working two jobs.");
				return;
			}
			else if (web.getEnergy() < 24){
				web.goToSleep();
				return;
			}
		}


		web.configureMiniMap();
		
		
//		this has been fixed but not tested
//		FIXME error, couldn't find id, cssSelector skill_strength *
//		if (web.hasNewSkillPoints())
//			web.allotNewSkills(u);
		
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
		web.investigateVisibleJobs(Arrays.asList(bestJob));	//this sets the style  of the job image on the map so we know where to click on it, next
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

//*
//org.openqa.selenium.NoSuchElementException: Unable to locate element: {"method":"id","selector":"skill_strength"}
//System info: os.name: 'Windows XP', os.arch: 'x86', os.version: '5.1', java.version: '1.6.0_20'
//Driver info: driver.version: remote
//	at sun.reflect.GeneratedConstructorAccessor5.newInstance(Unknown Source)
//	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)
//	at java.lang.reflect.Constructor.newInstance(Unknown Source)
//	at org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:94)
//	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:327)
//	at org.openqa.selenium.firefox.FirefoxDriver.execute(FirefoxDriver.java:191)
//	at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:158)
//	at org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:171)
//	at org.openqa.selenium.By$1.findElement(By.java:66)
//	at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:154)
//	at theWest.Web.allotNewSkills(Web.java:908)
//	at theWest.Player.updateUser(Player.java:52)
//	at theWest.Console.runPlayerUpdateUser(Console.java:28)
//	at theWest.Console.main(Console.java:65)
//****************************************************************
//************            trip out west            ************
//****************************************************************
//org.openqa.selenium.support.ui.TimeoutException: Timed out after 4 seconds
//System info: os.name: 'Windows XP', os.arch: 'x86', os.version: '5.1', java.version: '1.6.0_20'
//Driver info: driver.version: support
//	at org.openqa.selenium.support.ui.WebDriverWait.throwTimeoutException(WebDriverWait.java:104)
//	at org.openqa.selenium.support.ui.WebDriverWait.until(WebDriverWait.java:92)
//	at theWest.Web.logIn(Web.java:652)
//	at theWest.Player.updateUser(Player.java:22)
//	at theWest.Console.runPlayerUpdateUser(Console.java:39)
//	at theWest.Console.main(Console.java:65)
//Caused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {"method":"id","selector":"menu_skill"}
//System info: os.name: 'Windows XP', os.arch: 'x86', os.version: '5.1', java.version: '1.6.0_20'
//Driver info: driver.version: remoteexception logging in to trip out west
//2.  failed to update trip out west
//
//	at sun.reflect.GeneratedConstructorAccessor5.newInstance(Unknown Source)
//	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)
//	at java.lang.reflect.Constructor.newInstance(Unknown Source)
//	at org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:94)
//	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:327)
//	at org.openqa.selenium.firefox.FirefoxDriver.execute(FirefoxDriver.java:191)
//	at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:158)
//	at org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:171)
//	at org.openqa.selenium.By$1.findElement(By.java:66)
//	at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:154)
//	at theWest.Web$3.apply(Web.java:56)
//	at theWest.Web$3.apply(Web.java:1)
//	at org.openqa.selenium.support.ui.WebDriverWait.until(WebDriverWait.java:75)
//	... 4 more
