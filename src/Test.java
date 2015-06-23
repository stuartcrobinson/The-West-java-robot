import edu.mit.csail.uid.SikuliScript;
public class Test {
	public static void t1() throws Exception{
		SikuliScript si = new SikuliScript();
		String img = 
			"C:\\Documents and Settings\\Stuart\\My Documents\\sikuliStuff\\test1.sikuli\\1272563063578.png";
		si.doubleClick(img, 0);
	}	
	public static void main(String [] args){
		try{ t1(); }catch (Exception e){e.printStackTrace();}
	}	
}
