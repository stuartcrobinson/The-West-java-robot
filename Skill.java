package theWest;

public class Skill {
	
	public static String Construction		= "build";
	public static String Vigor				= "punch";
	public static String Toughness			= "tough";
	public static String Stamina			= "endurance";
	public static String Health_points		= "health";
	public static String Horseback_riding	= "ride";
	public static String Reflex				= "reflex";
	public static String Dodging			= "dodge";
	public static String Hiding				= "hide";
	public static String Swimming			= "swim";
	public static String Aim				= "aim";
	public static String Shooting			= "shot";
	public static String Setting_traps		= "pitfall";
	public static String Fine_motor_skills	= "finger_dexterity";
	public static String Repairing			= "repair";
	public static String Leadership			= "leadership";
	public static String Tactics			= "tactic";
	public static String Trading			= "trade";
	public static String Animal_instinct	= "animal";
	public static String Appearance			= "appearance";

	public static String div_css(String s){
		return "#skill_" + s;
	}

	public static String div_id(String s){
		return "skill_" + s;
	}
}
