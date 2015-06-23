package theWest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Job {

	public int wages;
	public int experience;
	public int luck;
	public int danger;
	public int difficulty;
	public int motivation;
	public int conditionalValue;
	
	public int isAvailable;
	
	public boolean bInvestigatedYet;
	
	public String name;
	public String comboBoxText;
	public String imageName;
	
	/** a list of the 'style' attributes of job div tiles visible on the current map */
	public List<String> tilesStyles;
	
	
	public Job(){}
	
	public Job(int wages, int experience, int luck, int danger, int difficulty, String imageName, String name){
		this.wages = wages;
		this.experience = experience;
		this.luck = luck;
		this.danger = danger;
		this.difficulty = difficulty;
		this.imageName = imageName;
		this.name = name;
		
		tilesStyles = new ArrayList<String>();
		
		motivation = -1;
		conditionalValue = -1;
		
		isAvailable = Job.IDK;
		bInvestigatedYet = false;
	}
	
	public String toString(){
		String ynAvailable = "No";
		
		if (isAvailable == Job.TRUE) ynAvailable = "Yes";
		if (isAvailable == Job.FALSE) ynAvailable = "No";
		if (isAvailable == Job.IDK) ynAvailable = "idk";
		
		return 	wages +", "+ experience +", "+ luck +", "+ danger +", "+ difficulty +", "+ conditionalValue +", "+
				imageName +", "+ name  +", "+ comboBoxText +
				". available? "+ ynAvailable + ".";		
	}


	public int compareTo(Job j2, int jobValueMask) {
		int value1 = this.getMaskedValue(jobValueMask);
		int value2 = j2.getMaskedValue(jobValueMask);
		return value1 - value2;
	}

	public int getMaskedValue(int jobValueMask){
		switch (jobValueMask){
			case Job.WAGES			: return wages;
			case Job.EXPERIENCE		: return experience;
			case Job.LUCK 			: return luck;
			case Job.DANGER 		: return danger;
			case Job.DIFFICULTY		: return difficulty;
			case Job.MOTIVATION 	: return motivation;
			case Job.CONDITIONAL 	: return conditionalValue;
		}
		System.out.println("ERROR getMaskedValue received a non-valid value mask!");
		return -1; 
		
	}
	
	//************************* static stuff: *************************************
	

	public static final int TRUE = 1;
	public static final int FALSE = 0;
	public static final int IDK = -1;


	
	public static final int WAGES = 1;
	public static final int EXPERIENCE = 2;
	public static final int LUCK = 3;
	public static final int DANGER = 4;

	/** wages and luck */
	public static final int WAGES_LUCK = 5;
	
	/** wages, experience, and luck */
	public static final int ALL_THREE = 6;
	
	
	public static final int DIFFICULTY = 7;
	public static final int MOTIVATION = 8;
	public static final int CONDITIONAL = 9;
	
	/** returns false if value is Job.IDK 
	 * 
	 * @param pseudoBool
	 * @return
	 */
	public static boolean b(int pseudoBool){
		if (pseudoBool == Job.TRUE)
			return true;
		if (pseudoBool == Job.FALSE)
			return false;
		if (pseudoBool == Job.IDK)
			return false;
		return false;
	}

	private static int condValueEqn(int x, int y) {return x*y;}

	public static int getConditionalValue(Job job, int jobValueMask){
//		switch (jobValueMask){
//			case Job.WAGES		: return Job.condValueEqn(job.wages,		job.motivation);
//			case Job.EXPERIENCE	: return Job.condValueEqn(job.experience, 	job.motivation);
//			case Job.LUCK 		: return Job.condValueEqn(job.luck, 		job.motivation);
//			case Job.DANGER 	: return Job.condValueEqn(job.danger, 		job.motivation);
//		}	
//		return -1;
		
		return Job.condValueEqn(job.getMaskedValue(jobValueMask), job.motivation);
	}

	public static Job findJobInList(String cbName, List<Job> allJobs) {
		String shorterCBName = null;
		for (Job j : allJobs){
			shorterCBName = cbName.replaceAll("\\.\\.[\\.]*", "").trim();
			if (j.name.indexOf(shorterCBName) != -1)				//minus 6 to clear the occasionall "...." in the dropdown box
				return j;		
		}
		System.out.println("error, no job found that matches combobox shortened name string: " + shorterCBName);
		return null;
	}


	/** 
	 *  update w/ job styles (refresh this list, per job) and availability.
	 * @param dropdownJobs
	 * @param readyJobTileStyles
	 * @param unreadyJobTileStyles
	 */
	public static void updateVisibleJobs(List<Job> dropdownJobs, List<String> readyJobTileStyles, List<String> unreadyJobTileStyles) {


//		System.out.println("using toString on readyJobImages list");
//		System.out.println("size: " + readyJobImages.size());
//		((ArrayList<String>) readyJobImages).toString();
//		System.out.println("using toString on unreadyJobImages list");
//		System.out.println("size: " + unreadyJobImages.size());
//		((ArrayList<String>) unreadyJobImages).toString();
//		
//		System.out.println("end of using toString on jobs images lists");


		//				sImage = Job.extractImageName(sStyle);
		//				if (sImage != null){
		
//		String sStyle;
		for (Job userJob : dropdownJobs) {
			
			userJob.tilesStyles = new ArrayList<String>();		//refresh w/ new view styles
			
			for (String style : readyJobTileStyles){
				if (userJob.imageName.equals( extractImageName(style) )){					
					userJob.isAvailable = Job.TRUE;
					userJob.tilesStyles.add(style);
				}				
			}

			for (String style : unreadyJobTileStyles){
				if (userJob.imageName.equals( extractImageName(style) )){					
					userJob.isAvailable = Job.FALSE;
					System.out.println("setting availability to false for job "+ userJob.name +" with style "+ style);
					break;
				}				
			}
		}
	}

	/** TODO */
	public static Job pickBestJob(List<Job> userJobs, int jobAttributeMask) {
		return null;
	}
	

	public static String extractImageName(String sStyle){

		Pattern styleImagePattern = Pattern.compile(".*images.jobs.mini.([\\w]*)\\.png.*");
		Matcher styleImageMatcher = styleImagePattern.matcher(sStyle);

		if (styleImageMatcher.find())
			return styleImageMatcher.group(1);
		else
			return null;
	}

	/** remove unavailable jobs from the input list */
	public static void cullJobs(List<Job> userJobs) {

		for (int i = userJobs.size()-1; i >= 0; i--) 
			if (userJobs.get(i).isAvailable == Job.FALSE){
				System.out.println("removing job "+ userJobs.get(i).name);
				userJobs.remove(i);
			}
		
//		for (Job j : userJobs)						//throws comodification error.  i guess you can't remove an item from a list you're iterating through like this.
//			if (j.isAvailable == Job.FALSE)
//				userJobs.remove(j);
	}

	/** must be sorted in decreasing order
	 * 
	 * @param userJobs
	 * @param numJobs
	 * @return
	 */
	public static boolean theTopJobsHaveAllBeenInvestigated(List<Job> userJobs, int numJobs) {

		int numJobsActual = 0;
		for (Job j : userJobs){
			if (j.bInvestigatedYet)
				numJobsActual++;
			if (numJobsActual >= numJobs)
				break;
			if (!j.bInvestigatedYet)
				break;
		}

		return (numJobsActual >= numJobs);
	}

	public static void setConditionalValues(List<Job> userJobs, int jobValueType) {
		for (Job j : userJobs)
			j.conditionalValue = Job.getConditionalValue(j, jobValueType);

	}

	/** by decreasing jobValueMask */
	public static void sortJobs(List<Job> userJobs, final int jobValueMask) {
		Collections.sort(
				userJobs, 
				Collections.reverseOrder(new Comparator<Job>(){
											public int compare(Job j1, Job j2) {
												return j1.compareTo(j2, jobValueMask);
											}
				}));
	}

	//	List<Foo> foos = ...;
//	Collections.sort(foos, new Comparator<Foo>() { ... });

	public static void main(String [] args){
		
		
//		
//		List<String> list = new ArrayList<String>();
//		
//		list.add("one1");
//		list.add("one2");
//		list.add("one3");
//		list.add("one4");
//		list.add("one5");
//		list.add("one6");
//		list.add("one7");
//		list.add("one8");
//		list.add("one9");
//		list.add("one10");
////		
////		for (String s : list){
////			if (s.equals("one5"))
////				list.remove(s);
////		}
//		
//		System.out.println(list.toString());
//		
//		for (int i = list.size()-1; i >= 0; i--) { //String s : list){
//			if (list.get(i).equals("one5"))
//				list.remove(i);
//		}
//
//		System.out.println("  ");
//		System.out.println(list.toString());
		
	}
	
}
