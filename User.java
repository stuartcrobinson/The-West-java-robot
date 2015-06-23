package theWest;

import java.util.Date;
import java.util.Random;

public class User {

	public String name;
	public String pwd;
	public String skill_1;
	public String skill_2;
	public String skill_3;
	public String attribute;

	private int jobValueMask;

	public int town_id;

	public User(String n, String p, int jbvlumsk){
		name = n;
		pwd = p;
		jobValueMask = jbvlumsk;

	}
	public User(String n, String p, String s, String a,  int jobvaluemask){
		name = n;
		pwd = p;
		attribute = a;

		skill_1 = s;
		skill_2 = s;
		skill_3 = s;

		jobValueMask = jobvaluemask;

	}
	public User(String n, String p, String a, String s1, String s2, String s3, int jobvaluemask){
		name = n;
		pwd = p;
		attribute = a;

		skill_1 = s1;
		skill_2 = s2;
		skill_3 = s3;

		jobValueMask = jobvaluemask;
	}
	public int getJobValueMask() {

		if (jobValueMask == Job.ALL_THREE)
			return pickOneRandomly(Job.WAGES, Job.EXPERIENCE, Job.LUCK);
		if (jobValueMask == Job.WAGES_LUCK)
			return pickOneRandomly(Job.WAGES, Job.LUCK);
		if (jobValueMask == Job.WAGES)
			return Job.WAGES;
		if (jobValueMask == Job.EXPERIENCE)
			return Job.EXPERIENCE;
		if (jobValueMask == Job.LUCK)
			return Job.LUCK;

		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("error in getJobValueMask !!");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		return -1;


	}
	private int pickOneRandomly(int x1, int x2) {


		long seed = (new Date()).getTime();
		Random rand = new Random(seed);

		switch (rand.nextInt(1)) {
		case 0 : return x1;
		case 1 : return x2;
		}



		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("error in pickOneRandomly !!");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		return -1;
	}


	private int pickOneRandomly(int x1, int x2, int x3) {
		long seed = (new Date()).getTime();
		Random rand = new Random(seed);

		switch (rand.nextInt(2)) {
		case 0 : return x1;
		case 1 : return x2;
		case 2 : return x3;
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("error in pickOneRandomly !!");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		return -1;


	}

}
