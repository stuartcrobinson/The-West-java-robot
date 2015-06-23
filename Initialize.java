package theWest;

import java.util.ArrayList;

public class Initialize {
	
	public static ArrayList<User> listUsers(){

		ArrayList<User> users = new ArrayList<User>();
		
//		users.add(new User("jellybean wine", "jellybean wine", null, null));
		
		
		users.add(new User("call to crash", 		"cal",		Skill.Construction,	 Attribute.Strength,	Job.EXPERIENCE));
		users.add(new User("marriage", 				"mar",		Skill.Construction,  Attribute.Strength,	Job.EXPERIENCE));
		users.add(new User("goodnight john", 		"goo",		Skill.Repairing, 	 Attribute.Dexterity, 	Job.EXPERIENCE));
		users.add(new User("caterpillar tree", 		"cat",		Skill.Swimming, 	 Attribute.Mobility, 	Job.EXPERIENCE));
		users.add(new User("smile when you kiss", 	"smi",		Skill.Setting_traps, Attribute.Dexterity, 	Job.EXPERIENCE));
		users.add(new User("honeymoon", 			"hon",		Skill.Leadership, 	 Attribute.Charisma,	Job.EXPERIENCE));
		users.add(new User("one two three", 		"one",		Skill.Trading, 		 Attribute.Charisma, 	Job.WAGES));
		users.add(new User("rubber band", 			"rubb3r",	Skill.Vigor, 		 Attribute.Strength, 	Job.EXPERIENCE)); //hit v hit
		users.add(new User("trip out west", 		"tri",		Skill.Vigor, 		 Attribute.Strength, 	Job.EXPERIENCE));	//hit v hit
		users.add(new User("three saddest words", 	"thr",		Skill.Shooting, 	 Attribute.Dexterity,	Job.EXPERIENCE)); //shoot v shoot
		 
		users.add(new User("scott avett", 	 "scott",	Job.EXPERIENCE)); 		
		users.add(new User("seth avett", 	 "setha",	Job.EXPERIENCE)); 		
		users.add(new User("bob avett", 	 "bobav",	Job.EXPERIENCE)); 		
		users.add(new User("joe kwon avett", "joekw",	Job.EXPERIENCE)); 		
		users.add(new User("breadfoot", 	 "bread",	Job.EXPERIENCE)); 
		
		users.add(new User("jellybean wine", "jellybean wine",	Job.WAGES_LUCK)); 
		users.add(new User("tall grass",	 "tall grass", 		Job.WAGES_LUCK)); 
//		users.add(new User("culculpraline",	 "swimming", 		Job.WAGES_LUCK)); 
		users.add(new User("suzy marie",	 "suzy marie", 		Job.WAGES_LUCK)); 
		users.add(new User("25 daniels",	 "25 daniels",		Job.WAGES_LUCK));
		
		
		return users;
	}
	
	
	public static ArrayList<Job> listJobs(){
		
		ArrayList<Job> jobs = new ArrayList<Job>();
		
		jobs.add(new Job(3, 2, 3, 2, 0, "shoes", "Shining shoes"));
		jobs.add(new Job(1, 3, 1, 20, 0, "scarecrow", "Scare birds off the field"));
		jobs.add(new Job(2, 3, 0, 10, 0, "wanted", "Putting up posters"));
		jobs.add(new Job(6, 1, 2, 2, 0, "tabacco", "Picking tobacco"));
		jobs.add(new Job(0, 0, 0, 0, 0, "construction", "Construction"));
		jobs.add(new Job(3, 1, 0, 1, 1, "swine", "Tending pigs"));
		jobs.add(new Job(1, 4, 0, 3, 1, "cotton", "Picking cotton"));
		jobs.add(new Job(1, 0, 6, 2, 2, "angle", "Stream fishing"));
		jobs.add(new Job(5, 2, 4, 1, 3, "sugar", "Picking sugar cane"));
		jobs.add(new Job(4, 5, 2, 6, 7, "muck_out", "Mucking out the stables"));
		jobs.add(new Job(6, 1, 2, 1, 8, "newspaper", "Selling newspaper *The Western Star*"));
		jobs.add(new Job(2, 6, 2, 4, 10, "cereal", "Harvesting fields"));
		jobs.add(new Job(3, 5, 0, 2, 11, "sheeps", "Tending sheep"));
		jobs.add(new Job(2, 6, 5, 6, 15, "berry", "Picking berries"));
		jobs.add(new Job(5, 7, 3, 3, 21, "cut", "Mow pasture"));
		jobs.add(new Job(4, 7, 8, 5, 22, "corn", "Picking corn"));
		jobs.add(new Job(9, 7, 4, 5, 22, "beans", "Picking beans"));
		jobs.add(new Job(11, 7, 0, 5, 24, "grinding", "Milling grains"));
		jobs.add(new Job(3, 9, 2, 7, 24, "fort_guard", "Guarding the fort"));
		jobs.add(new Job(11, 3, 5, 7, 30, "digging", "Prospecting"));
		jobs.add(new Job(7, 11, 5, 6, 35, "fence", "Repair fences"));
		jobs.add(new Job(5, 17, 0, 11, 38, "cow", "Cowboy"));
		jobs.add(new Job(12, 15, 5, 18, 39, "tanning", "Tanning deer skin"));
		jobs.add(new Job(3, 14, 7, 21, 42, "turkey", "Hunting turkey"));
		jobs.add(new Job(13, 12, 7, 11, 42, "tomato", "Picking tomatoes"));
		jobs.add(new Job(10, 18, 5, 10, 44, "rail", "Laying railroad tracks"));
		jobs.add(new Job(7, 13, 15, 6, 44, "irrigation", "Build irrigation system"));
		jobs.add(new Job(18, 5, 2, 21, 47, "wood", "Felling trees"));
		jobs.add(new Job(8, 25, 0, 35, 49, "brand", "Branding cattle"));
		jobs.add(new Job(17, 8, 9, 33, 52, "stone", "Granite mining"));
		jobs.add(new Job(4, 18, 9, 41, 53, "dam", "Demolishing the dam"));
		jobs.add(new Job(31, 4, 4, 29, 56, "claim", "Carving out claims"));
		jobs.add(new Job(17, 13, 6, 0, 57, "wire", "Installing a barbed wire fence"));
		jobs.add(new Job(23, 12, 6, 32, 63, "saw", "Sawing wood"));
		jobs.add(new Job(14, 25, 10, 21, 66, "orange", "Picking oranges"));
		jobs.add(new Job(13, 32, 10, 52, 71, "break_in", "Breaking in horses"));
		jobs.add(new Job(21, 25, 3, 14, 74, "mast", "Setting up telegraph poles"));
		jobs.add(new Job(25, 7, 8, 4, 74, "gems", "Gemstone search"));
		jobs.add(new Job(16, 12, 22, 9, 75, "grave", "Digging graves"));
		jobs.add(new Job(30, 20, 5, 7, 82, "print", "Printing newspaper *The Western Star*"));
		jobs.add(new Job(15, 3, 25, 12, 84, "trade", "Trading"));
		jobs.add(new Job(8, 22, 15, 12, 84, "straighten", "Straightening the river"));
		jobs.add(new Job(30, 14, 0, 13, 85, "coal", "Coal mining"));
		jobs.add(new Job(6, 23, 23, 38, 90, "fishing", "River fishing"));
		jobs.add(new Job(14, 28, 9, 23, 92, "horseshoe", "Shoeing Horses"));
		jobs.add(new Job(9, 33, 23, 19, 102, "spring", "Well drilling"));
		jobs.add(new Job(17, 33, 18, 53, 107, "bridge", "Building a bridge"));
		jobs.add(new Job(1, 45, 22, 37, 111, "explore", "Exploration"));
		jobs.add(new Job(12, 47, 7, 15, 112, "trainstation", "Build railroad station"));
		jobs.add(new Job(42, 8, 15, 20, 118, "coffin", "Building coffins"));
		jobs.add(new Job(32, 17, 6, 21, 119, "beaver", "Beaver hunt"));
		jobs.add(new Job(5, 23, 42, 11, 133, "chuck_wagon", "Repairing a covered wagon"));
		jobs.add(new Job(29, 45, 0, 42, 134, "springe", "Catching horses"));
		jobs.add(new Job(23, 45, 0, 52, 137, "float", "Rafting wood"));
		jobs.add(new Job(15, 43, 26, 45, 140, "coyote", "Hunt coyotes"));
		jobs.add(new Job(23, 12, 64, 93, 144, "dynamite", "Transport ammunition"));
		jobs.add(new Job(25, 42, 12, 27, 152, "agave", "Picking agaves"));
		jobs.add(new Job(42, 43, 6, 18, 163, "windmeel", "Building wind mills"));
		jobs.add(new Job(52, 32, 15, 29, 176, "iron", "Iron mining"));
		jobs.add(new Job(24, 62, 0, 72, 178, "buffalo", "Hunting buffalo"));
		jobs.add(new Job(62, 8, 9, 16, 178, "clearing", "Clearing the forest"));
		jobs.add(new Job(76, 8, 0, 32, 193, "silver", "Silver mining"));
		jobs.add(new Job(21, 63, 15, 67, 207, "wolf", "Hunting wolves"));
		jobs.add(new Job(10, 60, 30, 33, 212, "track", "Protecting the track of settlers"));
		jobs.add(new Job(28, 61, 17, 24, 220, "ranch", "Constructing a ranch house"));
		jobs.add(new Job(25, 35, 38, 4, 221, "guard", "Prison guard"));
		jobs.add(new Job(11, 14, 63, 34, 223, "indians", "Trading with Indians"));
		jobs.add(new Job(33, 71, 17, 35, 224, "fort", "Construct manor-house"));
		jobs.add(new Job(15, 45, 51, 44, 225, "ponyexpress", "Pony-Express"));
		jobs.add(new Job(15, 41, 65, 45, 228, "fire", "Fire fighter"));
		jobs.add(new Job(5, 61, 52, 77, 235, "bible", "Evangelizing"));
		jobs.add(new Job(64, 34, 18, 43, 237, "ox", "Stealing Horses"));
		jobs.add(new Job(15, 35, 72, 82, 257, "weapons", "Selling guns to Indians"));
		jobs.add(new Job(14, 14, 90, 34, 265, "dead", "Grave robber"));
		jobs.add(new Job(25, 78, 35, 71, 280, "grizzly", "Hunting grizzly bears"));
		jobs.add(new Job(20, 20, 83, 24, 293, "treasure_hunting", "Treasure hunt"));
		jobs.add(new Job(83, 25, 20, 7, 294, "oil", "Drilling for oil"));
		jobs.add(new Job(55, 76, 17, 35, 298, "army", "Serving in the army"));
		jobs.add(new Job(65, 50, 52, 67, 315, "quackery", "Charlatan"));
		jobs.add(new Job(92, 52, 23, 65, 331, "mercenary", "Mercenary work"));
		jobs.add(new Job(82, 35, 15, 14, 347, "ship", "Steering a paddle steamer"));
		jobs.add(new Job(33, 68, 76, 44, 366, "peace", "Peace negotiations"));
		jobs.add(new Job(48, 50, 74, 66, 371, "steal", "Robbing settlers"));
		jobs.add(new Job(28, 75, 85, 83, 384, "bandits", "Chasing bandits"));
		jobs.add(new Job(34, 77, 45, 43, 403, "diligence_guard", "Guarding the stage coach"));
		jobs.add(new Job(62, 45, 83, 56, 410, "smuggle", "Smuggling"));
		jobs.add(new Job(78, 27, 78, 86, 421, "aggression", "Ambush"));
		jobs.add(new Job(92, 32, 79, 72, 425, "bounty", "Bounty hunter"));
		jobs.add(new Job(23, 69, 85, 44, 437, "captured", "Transporting prisoners"));
		jobs.add(new Job(43, 73, 95, 67, 475, "diligence_aggression", "Ambush stagecoach"));
		jobs.add(new Job(67, 87, 92, 96, 505, "train", "Robbing trains"));
		jobs.add(new Job(80, 34, 81, 26, 517, "burglary", "Burglary"));
		
		return jobs;
		
	}
	
	
}
