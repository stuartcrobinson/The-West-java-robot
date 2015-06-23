package theWest;

public class Attribute {
		
		public static String Strength	= "strength";
		public static String Mobility	= "flexibility";
		public static String Dexterity	= "dexterity";
		public static String Charisma	= "charisma";

		public static String div_css(String s){
			return "#attribute_" + s;
		}

		public static String div_id(String s){
			return "attribute_" + s;
		}
}
