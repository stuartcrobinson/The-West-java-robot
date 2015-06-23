package theWest;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Web {

	WebDriver driver;
	public WebDriverWait wait4, wait20;	

	/** starts the browser */
	public Web(){
		driver = new FirefoxDriver();
		wait4 = new WebDriverWait(driver, 4);
		wait20 = new WebDriverWait(driver, 20);
	}

	private static ExpectedCondition<Boolean> cssExists(final String myCssSelector) {		
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return Boolean.valueOf(((RenderedWebElement) d.findElement(By.cssSelector(myCssSelector))).isDisplayed());
			}
		};
		return e;
	}
	private static ExpectedCondition<Boolean> xpathExists(final String myXpath) {		
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return Boolean.valueOf(((RenderedWebElement) d.findElement(By.xpath(myXpath))).isDisplayed());
			}
		};
		return e;
	}
	private static ExpectedCondition<Boolean> idExists(final String myId) {		
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return Boolean.valueOf(((RenderedWebElement) d.findElement(By.id(myId))).isDisplayed());
			}
		};
		return e;
	}
	private static ExpectedCondition<Boolean> classNameExists(final String myClassName) {		
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return Boolean.valueOf(((RenderedWebElement) d.findElement(By.className(myClassName))).isDisplayed());
			}
		};
		return e;
	}

	private static ExpectedCondition<Boolean> idNotExists(final String myId) {		
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					return Boolean.valueOf(!((RenderedWebElement) d.findElement(By.id(myId))).isDisplayed());	
				}
				catch(Exception e){
					return Boolean.valueOf(true);
				}
			}
		};
		return e;
	}

	public void printLHNavCharacterPoint() {

		RenderedWebElement rbe = (RenderedWebElement) driver.findElement(By.xpath(".//*[@id='menu_character']/a"));
		System.out.println("rbe location: " + rbe.getLocation());		
		FirefoxWebElement fwe = (FirefoxWebElement) rbe;		
		System.out.println("fwe location: " + fwe.getLocationOnScreenOnceScrolledIntoView());
	}

	public void printLHNavDuelPoint() {

		RenderedWebElement rbe = (RenderedWebElement) driver.findElement(By.xpath(".//*[@id='menu_duel']/a"));
		System.out.println("rbe location: " + rbe.getLocation());		
		FirefoxWebElement fwe = (FirefoxWebElement) rbe;		
		System.out.println("fwe location: " + fwe.getLocationOnScreenOnceScrolledIntoView());
	}


	//later, make this stuff work for any user of any town using this line in the main page source to get the user's town ID:
	//Character.set_home_town(946, 564, 2484);  (town ID is 2484, the last #)

	private void clickTownImage_GoToTown(){
		wait4.until(Web.cssExists(".imagemap_fingerboard"));
		((JavascriptExecutor) driver).executeScript("AjaxWindow.show('fingerboard',{town_id:2484},'2484');"); 
		wait4.until(Web.cssExists(".button_middle"));
	}
	private void clickTownImage_Bank(){
		wait4.until(Web.cssExists(".imagemap_fingerboard"));
		((JavascriptExecutor) driver).executeScript("AjaxWindow.show('building_bank',{town_id:2484},'2484');"); 
		wait4.until(Web.cssExists(".bank_title"));
	}

	private void clickTownImage_Hotel() {
		wait4.until(Web.cssExists(".imagemap_fingerboard"));
		((JavascriptExecutor) driver).executeScript("AjaxWindow.show('building_hotel',{town_id:2484},'2484');"); 
		wait4.until(Web.cssExists(".hotel_title"));		
	}


	void clickLHNav_Skills() {
		wait4.until(Web.cssExists("#menu_work a"));
		driver.findElement(By.cssSelector("#menu_skill a")).click();
		wait4.until(Web.idExists("window_skill_title"));
	}

	private void clickLHNav_Town(){
		wait4.until(Web.cssExists("#menu_town a"));
		driver.findElement(By.cssSelector("#menu_town a")).click();
		wait4.until(Web.classNameExists("imagemap_fingerboard"));
	}
	private void clickRHNav_Work(){
		wait4.until(Web.cssExists("#menu_work a"));
		driver.findElement(By.cssSelector("#menu_work a")).click();
		wait4.until(Web.idExists("window_work_title"));
	}

	public void closeAllWindows(){
		((JavascriptExecutor) driver).executeScript("AjaxWindow.closeAll();"); 
	}

	public void toggleMiniMap(){
		//javascript:WMinimap.toggle()
		//		((JavascriptExecutor) driver).executeScript("WMinimap.toggle(arguments[0] || event);"); //this doesn't work in mac :( 
		wait4.until(Web.idExists("footer_minimap_icon"));
		//
		((JavascriptExecutor) driver).executeScript("WMinimap.toggle();"); //this doesn't work in mac :( 

		//		javascript:WMinimap.toggle()
		//		((RenderedWebElement) driver.findElement(By.id("footer_minimap_icon"))).hover();
		//		driver.findElement(By.id("footer_minimap_icon")).click();
		//		driver.findElement(By.cssSelector("#footer_minimap_icon")).click();
		//		driver.findElement(By.cssSelector("#footer_minimap_icon")).click();
		//wait for combobox
		//<select onchange="WMinimap.update()" id="minimap_job_id" style="background-color: rgb(232, 218, 179); font-size: 9px; width: 160px;"><option value="0">-- Select job --</option><option value="29">Branding cattle</option><option value="35">Breaking in horses</option><option value="28">Build irrigation system</option><option value="43">Build railroad station</option><option value="47">Building a bridge</option><option value="49">Building coffins</option><option value="33">Carving out claims</option><option value="48">Catching horses</option><option value="55">Clearing the forest</option><option value="40">Coal mining</option><option value="22">Cowboy</option><option value="31">Demolishing the dam</option><option value="19">Digging graves</option><option value="45">Exploration</option><option value="27">Felling trees</option><option value="32">Gemstone search</option><option value="25">Granite mining</option><option value="16">Guarding the fort</option><option value="8">Harvesting fields</option><option value="20">Hunting turkey</option><option value="30">Installing a barbed w...</option><option value="21">Laying railroad tracks</option><option value="13">Milling grains</option><option value="12">Mow pasture</option><option value="92">Mucking out the stables</option><option value="86">Picking agaves</option><option value="15">Picking beans</option><option value="9">Picking berries</option><option value="14">Picking corn</option><option value="5">Picking cotton</option><option value="91">Picking oranges</option><option value="6">Picking sugar cane</option><option value="4">Picking tobacco</option><option value="87">Picking tomatoes</option><option value="41">Printing newspaper *T...</option><option value="18">Prospecting</option><option value="3">Putting up posters</option><option value="23">Repair fences</option><option value="42">River fishing</option><option value="24">Sawing wood</option><option value="2">Scare birds off the f...</option><option value="11">Selling newspaper *Th...</option><option value="37">Setting up telegraph ...</option><option value="93">Shining shoes</option><option value="88">Shoeing Horses</option><option value="26">Straightening the river</option><option value="7">Stream fishing</option><option value="17">Tanning deer skin</option><option value="1">Tending pigs</option><option value="10">Tending sheep</option><option value="36">Trading</option><option value="38">Well drilling</option></select>
	}

	public Point getFirefoxWebElementMidPoint(FirefoxWebElement fwe){



		Dimension d = fwe.getSize();

		Point topLeftPoint = fwe.getLocationOnScreenOnceScrolledIntoView();


		Point midpoint = new Point();

		midpoint.x = topLeftPoint.x + d.width/2;
		midpoint.y = topLeftPoint.y + d.height/2;

		return midpoint;
	}

	public void bringBrowserToFront(){		
		clickByRobot(driver.findElement(By.cssSelector("#menu_town a")), 0, 0);
		try{ Thread.sleep(1000);	}catch(Exception e){};
	}

	/** clicks at given offset from top left */
	public void clickByRobot(WebElement we, int x, int y){
		FirefoxWebElement fwe = (FirefoxWebElement) we;
		//		Point p = this.getFirefoxWebElementMidPoint(fwe);		
		Point p = fwe.getLocation();	//top left
		try {
			Robot r = new Robot();
			r.mouseMove(p.x + x, p.y + y);
			try{ Thread.sleep(200);	}catch(Exception e){};

			r.mousePress(InputEvent.BUTTON1_MASK);
			try{ Thread.sleep(200);	}catch(Exception e){};
			r.mouseRelease(InputEvent.BUTTON1_MASK);							
		} catch (AWTException e1) {	e1.printStackTrace();}
	}

	/** clicks midpoint */
	public void clickByRobot(WebElement we){
		FirefoxWebElement fwe = (FirefoxWebElement) we;
		Point p = this.getFirefoxWebElementMidPoint(fwe);		
		try {
			Robot r = new Robot();
			r.mouseMove(p.x, p.y);
			try{ Thread.sleep(200);	}catch(Exception e){};

			r.mousePress(InputEvent.BUTTON1_MASK);
			try{ Thread.sleep(200);	}catch(Exception e){};
			r.mouseRelease(InputEvent.BUTTON1_MASK);							
		} catch (AWTException e1) {	e1.printStackTrace();}
	}

	public void test(){

		wait4.until(Web.cssExists("#menu_town a"));
		this.clickByRobot( driver.findElement(By.cssSelector("#menu_town a")) );
		wait4.until(Web.classNameExists("imagemap_fingerboard"));

	}

	public void clickAJobIcon() {
		try{ Thread.sleep(1000);	}catch(Exception e){};

		//<div style="width: 106px; height: 54px; position: absolute; top: 0pt; left: 0pt; background-image: url(images/jobs/mini/rail.png);" class="tile"></div>

		List<WebElement> wes = driver.findElements(By.className("tile"));

		for (WebElement we : wes){
			System.out.println(we.getAttribute("style").toString());
			if (we.getAttribute("style").toString().indexOf("images/jobs/mini/sheeps") != -1){
				try{ Thread.sleep(1000);	}catch(Exception e){};

				this.clickByRobot(we);

				System.out.println("click!");
			}


		}

	}

	/** 
	 * open the job pane.  tries all images of the given job visible on the map until success.  
	 * @param job
	 * @return
	 */
	public boolean clickJobImage(Job job){

		//first, wait for minimap to disappear (wait for sikuli to click blue dot)
		
//		List<WebElement> wes = driver.findElements(By.className("tile"));

		List<WebElement> jobTiles;
		String xpath;
		for (String style : job.tilesStyles){
			
			//now ... what is css selector using only a style???
			//this xpath: //div[@class='tile']/div[@style='position: absolute;']
			//matches this html inner div:
			// <div class="tile"><div  style="position: absolute;">la la la la div</div></div><br>
			
			xpath = "//div[@id='map_move_container']/div[@class='tile']/div[@style='"+ style +"']";
			jobTiles = driver.findElements(By.xpath(xpath));
			
			for (WebElement jobTile : jobTiles){
				
				if ( ((RenderedWebElement) jobTile).isDisplayed() ){
					this.clickByRobot(jobTile);					
					try{ 
						wait4.until(Web.cssExists(".bars"));
						return true;
					}
					catch (Exception e){ System.out.println(job + " -- clicked but failed to open in time.  maybe there is another of these jobs on the map to click"); }	
				}
			}
			
			//deprecated
//			if (we.getAttribute("style").toString().indexOf(job.imageName) != -1){
//				//we.click();			//i think this brings it in to view // doesn't work cuz if you move the map just enough to see some jobs that were covered up, then you can't click on the job anyway, because you can't click on jobs that are on the edge of the map for some reason.
//				this.clickByRobot(we);
//				
//				try{ 
//					wait4.until(Web.cssExists(".bars"));
//					return true;
//				}
//				catch (Exception e){ System.out.println(job + " -- clicked but failed to open in time.  maybe there is another of these jobs on the map to click"); }
//			}			
		}
		System.out.println(job + " --job not found (or perhaps all attempts to click it failed). size of job's style list is "+ job.tilesStyles.size());
		
		return this.clickJobImage_independent(job);

	}

	private boolean clickJobImage_independent(Job job) {


		List<WebElement> allVisibleJobTiles;
		String xpath;
		//		for (String style : job.tilesStyles){

		//now ... what is css selector using only a style???
		//this xpath: //div[@class='tile']/div[@style='position: absolute;']
		//matches this html inner div:
		// <div class="tile"><div  style="position: absolute;">la la la la div</div></div><br>

		xpath = "//div[@id='map_move_container']/div[@class='tile']/div[@style]";
		allVisibleJobTiles = driver.findElements(By.xpath(xpath));

		for (WebElement jobTile : allVisibleJobTiles){
			if ( 	((RenderedWebElement) jobTile).isDisplayed() && 
					jobTile.getAttribute("style").toString().indexOf(job.imageName) != -1){
				this.clickByRobot(jobTile);					
				try{ 
					wait4.until(Web.cssExists(".bars"));
					return true;
				}
				catch (Exception e){ System.out.println(job + " -- (clickJobImage_independent) clicked but failed to open in time.  maybe there is another of these jobs on the map to click"); }	
			}
			
		}
		System.out.println(job + " -- (clickJobImage_independent) job not found (or perhaps all attempts to click it failed). size of job's style list is "+ job.tilesStyles.size());
		
		// TODO Auto-generated method stub
		return false;
	}

	private void click_button_middle() {
		driver.findElement(By.cssSelector(".button_middle")).click();
		
	}

	public boolean sleepWasSelected(){
		List<WebElement> images = driver.findElements(By.tagName("img"));	
		for (WebElement image : images)
			if (image.getAttribute("src").toString().indexOf("sleep") != -1)
				return true;
		return false;		
	}

	public boolean goToSleep(){
		this.clickLHNav_Town();
		this.clickTownImage_Hotel();


		//.town_2484_hotel_room_radio

		List<WebElement> wes = driver.findElements(By.cssSelector(".town_2484_hotel_room_radio"));

		wes.get((wes.size() - 1)).setSelected();


		this.click_button_middle();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean res;
		if (sleepWasSelected()){
			System.out.println("sent to sleep!");
			res = true;
		}
		else{
			System.out.println("sent to sleep!");
			res = false;

		}

		this.closeAllWindows();
		return res;
	}


	/** a 'job image' does not contain the file type (.png)
	 * 
	 * @param readyJobTileStyles
	 * @param unreadyJobTileStyles
	 */
	public void fillMapJobImageStyleLists(List<String> readyJobTileStyles, List<String> unreadyJobTileStyles) {

		String sStyle;
		
		String xpath = "//div[@id='map_move_container']/div[@class='tile']/div[@style]";
		List<WebElement> tiles = driver.findElements(By.xpath(xpath)); //driver.findElements(By.className("tile"));	
		for (WebElement tile : tiles) {
			try {
				sStyle = tile.getAttribute("style").toString();
				if (sStyle.indexOf("opacity") != -1){
					unreadyJobTileStyles.add(sStyle);
//					System.out.print("about to remove job for this tile: "+ sStyle);
				}
				else
					readyJobTileStyles.add(sStyle);
			} catch (Exception e) {}
		}

	}

	private List<String> listJobImages_map() {
		//			if (we.getAttribute("style").toString().indexOf("images/jobs/mini/sheeps") != -1){

		String sStyle;
		Pattern styleImagePattern = Pattern.compile(".*images.jobs.mini.([\\w]*)\\.png.*");
		Matcher styleImageMatcher;

		List<String> jobImages_map = new ArrayList<String>();

		List<WebElement> divs = driver.findElements(By.tagName("div"));	
		for (WebElement div : divs) {
			try {
				sStyle = div.getAttribute("style").toString();
				styleImageMatcher = styleImagePattern.matcher(sStyle);
				if (styleImageMatcher.find()){
					jobImages_map.add(styleImageMatcher.group(1));
				}
			} catch (Exception e) {}
		}

		return jobImages_map;

		//			void main(String[] args){
		//		    	
		//	            Pattern pattern = Pattern.compile("user=([-\\d]*)&sportID");	//.*user=-(\\d)&sportID.*");		//console.readLine("%nEnter your regex: "));
		//
		//	            Matcher matcher = pattern.matcher("profile.aspx?user=-63417&sportID=9&type=4");	//console.readLine("Enter input string to search: "));
		//
		//	            boolean found = false;
		//	            while (matcher.find()) {
		//	                System.out.println("I found the text "+matcher.group(1)+" starting at " +
		//	                   "index "+matcher.start()+" and ending at index "+ matcher.end()+".");
		//	                found = true;
		//	            }
		//	            if(!found){
		//	                System.out.println("No match found.");
		//	            }


	}

	private Select getCombo_Jobs(){
		
		
		return new Select( driver.findElement(By.id("minimap_job_id")));
	}
	
	private Select getCombo_workDuration() {
		return new Select( driver.findElement(By.name("job_task_time")));
	}

	/**CB = Combo box in the mini map */
	private List<String> listJobNames_dropdown(){
		try{ Thread.sleep(1000);	}catch(Exception e){};

		toggleMiniMap();
		wait4.until(Web.idExists("minimap_job_id"));

		Select jobsBox = getCombo_Jobs();

		ArrayList<String> res = new ArrayList<String>();
		for ( WebElement e : jobsBox.getOptions()){
			res.add(e.getText());			
		}
		toggleMiniMap();

		res.remove(0);	//remove the top option which is "Select Job" or something
		return res;
	}



	public void printJobNames_dropdown() {
		for (String s : this.listJobNames_dropdown()){
			System.out.println(s);
		}
	}

	public void printJobImages_map() {
		for (String s : this.listJobImages_map()){
			System.out.println(s);
		}
	}

	public List<Job> listJobs_dropdown(List<Job> allJobs) {

		List<String> jobNames_dropdown = listJobNames_dropdown();

		List<Job> jobs_dropdown = new ArrayList<Job>();

		Job j;

		for (String jobName_dropdown : jobNames_dropdown){
			j = Job.findJobInList(jobName_dropdown, allJobs);
			j.comboBoxText = jobName_dropdown;
			jobs_dropdown.add(j);			
		}

		return jobs_dropdown;
	}


	/** 
	 * determined by looking to see if the job image on the main map has an opacity value set
	 * @param j
	 * @return
	 */
	public boolean jobIsAvailable(Job j){
		return !this.bDivContainsOpacity(j.imageName);
	}

	private boolean bDivContainsOpacity(String sStyleContentFragment){
		List<WebElement> divs = driver.findElements(By.tagName("div"));	
		for (WebElement div : divs)
			try {
				if (div.getAttribute("style").toString().indexOf("opacity") != -1 &&
						div.getAttribute("style").toString().indexOf(sStyleContentFragment) != -1)
					return true;
			} catch (Exception e) {}		//thrown if div doesn't contain 'style' attribute, i guess
			return false;		
	}

	public int getLooseMoney(){
		//<div id="cash" style="-moz-user-select: none;">33</div>
		return Integer.parseInt(driver.findElement(By.id("cash")).getText());
	}

	/**
	 * requires job pane to be up.
	 * @return
	 */
	public int getJobMotivation(){
		//.job_motivation .bar_perc
		
		wait20.until(Web.cssExists(".job_motivation .bar_perc"));
		String sPctWPctSign = driver.findElement(By.cssSelector(".job_motivation .bar_perc")).getText();
		int pct = Integer.parseInt(sPctWPctSign.replace("%", ""));
		return pct;
	}

	public int getEnergy(){
		String s = driver.findElement(By.cssSelector("#energy_text")).getText();	
		return Integer.parseInt(s.substring(0, s.indexOf("/") - 1).trim());
	}

	public int getNumCurrentJobs_fromWorkPane(){

		clickRHNav_Work();
		List<WebElement> we = new ArrayList<WebElement>();

		try{
			wait4.until(Web.cssExists("#work_task_queue tr:nth-child(2) td"));
			we = driver.findElements(By.cssSelector("#work_task_queue tr:nth-child(2) td"));
		}catch(Exception e){}

		//		System.out.println("num inner web elements: "+ we.size());
		closeAllWindows();
		return  we.size();

	}


	public int getNumCurrentJobs_inOpenJobPane(){

		clickRHNav_Work();
		List<WebElement> we = new ArrayList<WebElement>();

		try{
			wait4.until(Web.cssExists(".task_queue div"));
			we = driver.findElements(By.cssSelector(".task_queue div"));
		}catch(Exception e){}

		//		System.out.println("num inner web elements: "+ we.size());
		closeAllWindows();
		return  we.size();

	}

	
	public void depositToBankAndTown(Integer increment, Integer pctGiveToTown){

		Integer amountToDonate = getLooseMoney()*pctGiveToTown / 100;
		
		if (getLooseMoney() < increment)	//DER BE DOUGH IN DA BANK?
			return;
		
		clickLHNav_Town();
		clickTownImage_Bank();

		//donate to town:
		driver.findElement(By.name("city_deposit_payin")).clear();
		driver.findElement(By.name("city_deposit_payin")).sendKeys(amountToDonate.toString());
		try{ Thread.sleep(500);	}catch(Exception e){};
		driver.findElement(By.cssSelector("#bank_2484_button_city_deposit .button_middle")).click();
		try{ Thread.sleep(1000);	}catch(Exception e){};

		
		
		for (int i=0; getLooseMoney() > increment && i < 10; i++){
			driver.findElement(By.name("deposit_payin")).clear();
			driver.findElement(By.name("deposit_payin")).sendKeys(increment.toString());
			driver.findElement(By.cssSelector("#bank_2484_button_deposit .button_middle")).click();
			try{ Thread.sleep(1000);	}catch(Exception e){};
		}
		closeAllWindows();

	}

	public boolean isInTown(){

		clickLHNav_Town();
		clickTownImage_GoToTown();

		String distanceToTown = driver.findElement(By.cssSelector(".way_time")).getText();

		System.out.println("distance: __" + distanceToTown + "__");

		closeAllWindows();

		if (distanceToTown.equals("00:00:00"))
			return true;
		else
			return false;

	}

	/** logs in and waits for page to load */
	public void logIn(User u){
		driver.get("http://www.the-west.net");
		driver.findElement(By.id("name")).sendKeys(u.name);
		driver.findElement(By.id("password")).sendKeys(u.pwd);
		driver.findElement(By.className("login_button")).click();
		wait4.until(Web.cssExists(".world_button_16"));
		driver.findElement(By.cssSelector(".world_button_16")).click();
		wait4.until(Web.idExists("menu_skill"));

		System.out.println("finished logging in?");
	}


	/**
	 * how?????
	 * go down list of jobs, start with top
	 * any way to see the jobs a user has access to right now??
	 * @return
	 */
	public Job determineBestJob() {

		//okay... the jobs lister works.  
		// now need to construct some object that holds all the jobs and their attributes.... blech


		return null;
	}

	/**
	 * clears all visual background noise from minimap w/out opening it (via javascript)
	 */
	public void configureMiniMap(){
		
		
		
		
		try {((JavascriptExecutor) driver).executeScript("WMinimap.toggleLayer('cities');");		} catch (Exception e) {e.printStackTrace();}
		try {((JavascriptExecutor) driver).executeScript("WMinimap.toggleLayer('own_town');");		} catch (Exception e) {e.printStackTrace();}
		try {((JavascriptExecutor) driver).executeScript("WMinimap.toggleLayer('forts');");			} catch (Exception e) {e.printStackTrace();}
		try {((JavascriptExecutor) driver).executeScript("WMinimap.toggleLayer('fort_allied');");	} catch (Exception e) {e.printStackTrace();}
		try {((JavascriptExecutor) driver).executeScript("WMinimap.toggleLayer('own_char');");		} catch (Exception e) {e.printStackTrace();}
		try {((JavascriptExecutor) driver).executeScript("WMinimap.toggleLayer('quests');");		} catch (Exception e) {e.printStackTrace();}
		try {((JavascriptExecutor) driver).executeScript("WMinimap.toggleBackgroundImages(this);");	} catch (Exception e) {} //this always throws exc. //e.printStackTrace();}

		this.toggleMiniMap();				//is this needed?
		
		try {
			//if pin is set to be pinned_on, then click the pin image to set it to off
			driver.findElement(By.className("minimap_e_pin_pinned_on")).click();
			wait4.until(Web.classNameExists("minimap_e_pin_pinned_off"));
		}catch (Exception e){}
		this.toggleMiniMap();				//is this needed?
		
		
//		<a title="" class="minimap_e_pin_pinned_on" id="minimap_e_pin" href="javascript:WMinimap.togglePin()"></a>

	}

	/** opens the job pane and fills out the object's motivation and condtionValue */
	public void investigateJob(Job j, int jobAttributeMask) {


	}

	/**
	 *  open the minimap, select job from dropdown, then 
	 * use sikuli to click on the light blue dot in the minimap<br><br>
	 * and tries to wait for map to re-load
	 */
	public void centerMapOnJob(Job j) {
		this.toggleMiniMap();
		wait20.until(Web.idExists("minimap_job_id"));
		this.getCombo_Jobs().selectByVisibleText(j.comboBoxText);
		Sikuli.clickMinimapJobDot();

		try{
			wait20.until(Web.idNotExists("minimap_job_id"));
		}catch(Exception e){
			System.out.println("minimap didn't disappear in 4 seconds, lets try  manually closing minimap");
//			Sikuli.clickMinimapJobDot();
			this.toggleMiniMap();
			wait20.until(Web.idNotExists("minimap_job_id"));
		}
		

		String xpath = "//div[@id='map_move_container']/div[@class='tile']/div[@style]";


		try{Thread.sleep(1500);}catch(Exception e){}
		
		
		wait20.until(Web.xpathExists(xpath));		//trying this instead of sleep --doesn't seem to work
		
		
//		try{Thread.sleep(3000);}catch(Exception e){}
		
		
	}

	/**
	 * scrape jobs' availability and motivation, modifying list userJobs until the top numJobs are available (removing the top nonavailables) <br>
	 * not sure if i'm handling pointers right.
	 * @param userJobs
	 * @param numJobs
	 */
	public void harvestTopJobDetails(List<Job> userJobs, int numJobs) {
		
		this.investigateVisibleJobs(userJobs);
		Job.cullJobs(userJobs);
		
		Job j;
		for (int i=0; !Job.theTopJobsHaveAllBeenInvestigated(userJobs, numJobs) && i<userJobs.size(); i++){
			j = userJobs.get(i);
			if (j.bInvestigatedYet) continue;						//already checked it out.
			System.out.println("investigating job " + j.name);
			this.centerMapOnJob(j);

			this.investigateVisibleJobs(userJobs);

			if (j.isAvailable == Job.TRUE){
				this.clickJobImage(j);
				j.motivation = this.getJobMotivation();
				j.bInvestigatedYet = true;
				this.closeAllWindows();
				System.out.println("   job "+ j.name +" updated. motivation: " + j.motivation +
													". conditionalValue: "+ j.conditionalValue);
			}
			else {
				System.out.println("job not available, about to be removed from list. (along with all other map-visible non-available jobs.");
				i--;	//leaves i the same (considering for loop's i++) since current value is disappearing.  don't want to miss the new value taking up this index
			}
			Job.cullJobs(userJobs);
		}
	}

	/** set jobs in list to available or not, based on visible jobs on the map */
	void investigateVisibleJobs(List<Job> userJobs) {

		List<String> readyJobTileStyles = new ArrayList<String>();
		List<String> unreadyJobTileStyles = new ArrayList<String>();
		
		this.fillMapJobImageStyleLists(readyJobTileStyles, unreadyJobTileStyles);
		
		
		Job.updateVisibleJobs(userJobs, readyJobTileStyles, unreadyJobTileStyles);

	}

	/** for two 2 hour shifts */
	public void workOpenJob() {
		Select cb = getCombo_workDuration();

		cb.selectByVisibleText("2 hours");
		this.click_button_middle();
		try{ Thread.sleep(1000);	}catch(Exception e){};
		this.click_button_middle();
		try{ Thread.sleep(1000);	}catch(Exception e){};
		
	}

	public void handleDailyBonusDialog() {
		
		String thumbImgSrc = "images/mr_daily_thumb.png";
		String okButtonImgSrc = "/img.php?type=button&subtype=normal&value=ok";
		
		String thumbManXpath = "//div[@style]/div/img[@src='"+ thumbImgSrc +"']";
		String okButtonXpath = "//div[@style]/div[@style]/div[@style]/img[@src='"+ okButtonImgSrc +"']";
		
		try{ 
			driver.findElement(By.xpath(thumbManXpath));
			System.out.println("Daily bonus dialog exists.");
			driver.findElement(By.xpath(okButtonXpath)).click();
		}catch (Exception e){
			System.out.println("no daily bonus dialog found.");
		}

		//<img src="images/mr_daily_thumb.png" style="position:absolute;left:2px;top:-26px;">
			
			//<div style="padding: 15px 15px 60px; position: relative; z-index: 10; text-align: left;" class="">
//			<h2 style="text-align: center; display: block; margin-bottom: 10px;">
//			<div style="text-align: left; margin-left: 190px;" class="">
//			Daily login bonus
//			</div>
//			</h2>
//			<div class="">
//			<img style="position: absolute; left: 2px; top: -26px;" src="images/mr_daily_thumb.png" class="">
//			<div style="margin-left: 190px;" class="">
//			For your activity you receive:
//				<div style="background: transparent url(/images/dailyplus.png) no-repeat scroll left center; font-size: 16pt; font-weight: bold; margin-top: 10px; margin-bottom: 10px; padding-left: 24px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous;" class="">
//		72 experience points
//		</div>
//		<strong class=""
//		>Get your bonus tomorrow as well!
//		</strong>
////		</div>
//		</div>
//		</div>
	
	//	<div style="background: transparent url(images/messagebox/messagebox_bg.png) repeat scroll 0% 0%; overflow: visible; position: absolute; width: 520px; height: 200px; margin-left: -260px; margin-top: -100px; top: 50%; left: 50%; color: rgb(0, 0, 0); -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; z-index: 900000;"><div style="padding: 15px 15px 60px; position: relative; z-index: 10; text-align: left;"><h2 style="text-align: center; display: block; margin-bottom: 10px;"><div style="text-align: left; margin-left: 190px;">Daily login bonus</div></h2><div><img style="position: absolute; left: 2px; top: -26px;" src="images/mr_daily_thumb.png"><div style="margin-left: 190px;">For your activity you receive:<div style="background: transparent url(/images/dailyplus.png) no-repeat scroll left center; font-size: 16pt; font-weight: bold; margin-top: 10px; margin-bottom: 10px; padding-left: 24px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous;">75 experience points</div><strong>Get your bonus tomorrow as well!</strong></div></div></div><div style="background: transparent url(images/messagebox/messagebox_bordertop.png) repeat-x scroll 0% 0%; width: 100%; height: 10px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; left: 0px; top: 0px; position: absolute;"></div><div style="background: transparent url(images/messagebox/messagebox_borderbottom.png) repeat-x scroll center bottom; width: 100%; height: 10px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; left: 0px; bottom: 0px; position: absolute;"></div><div style="background: transparent url(images/messagebox/messagebox_bordervertical.png) repeat-y scroll 0% 0%; width: 10px; height: 100%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; left: 0px; top: 0px; position: absolute;"></div><div style="background: transparent url(images/messagebox/messagebox_bordervertical.png) repeat-y scroll right center; width: 10px; height: 100%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; right: 0px; top: 0px; position: absolute;"></div><div style="background: transparent url(images/messagebox/messagebox_cornerstop.png) no-repeat scroll 0% 0%; width: 20px; height: 10px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; left: 0px; top: 0px; position: absolute;"></div><div style="background: transparent url(images/messagebox/messagebox_cornerstop.png) no-repeat scroll right top; width: 20px; height: 10px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; right: 0px; top: 0px; position: absolute;"></div><div style="background: transparent url(images/messagebox/messagebox_cornersbottom.png) no-repeat scroll left bottom; width: 20px; height: 10px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; left: 0px; bottom: 0px; position: absolute;"></div><div style="background: transparent url(images/messagebox/messagebox_cornersbottom.png) no-repeat scroll right bottom; width: 20px; height: 10px; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; right: 0px; bottom: 0px; position: absolute;"></div><div style="padding-bottom: 12px; position: absolute; bottom: 0px; left: 0px; text-align: center; width: 520px; z-index: 11;"><img src="/img.php?type=button&amp;subtype=normal&amp;value=ok" style="margin: 8px; cursor: pointer;"></div></div>
	// css for OK button: div:nth-child(10) img
		// button img src="/img.php?type=button&subtype=normal&value=ok"
		
//		img w that src, child of 3 divs with style attributes
		
		//thumb pic (img w/ source) -- child of div child of div with style
		
		

//		List<WebElement> jobTiles;
//		String xpath;
//		for (String style : job.tilesStyles){
//			
//			//now ... what is css selector using only a style???
//			//this xpath: //div[@class='tile']/div[@style='position: absolute;']
//			//matches this html inner div:
//			// <div class="tile"><div  style="position: absolute;">la la la la div</div></div><br>
//			
//			xpath = "//div[@id='map_move_container']/div[@class='tile']/div[@style='"+ style +"']";
//			jobTiles = driver.findElements(By.xpath(xpath));
	
	}

	public boolean isSleeping() {
		try {
			WebElement weCurrentTask =
				driver.findElement(By.id("current_task"));
			if (weCurrentTask.getText().matches(".*sleeping.*"))	//should say "You are sleeping."
				return true;
			else
				return false;
		}catch (Exception e){
			return false;
		}
	}

	public void cancelCurrentJob() {
		this.clickRHNav_Work();
		//<tbody><tr><td><div style="position: relative; height: 63px; width: 87px;"><img title="" src="images/jobs/sleep.png" style="position: absolute; left: 0px; top: 0px;" class=""><img title="" src="images/icons/cancel.png" style="position: absolute; top: 36px; left: 60px; cursor: pointer;" class=""></div></td></tr><tr class=""><td>07:57:37</td></tr></tbody>
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String cancelImgXpath = 
			//			"//div[@id='work_task_queue']/table/tbody/tr/td/div[@style]/img[@src='images/icons/cancel.png']";
			".//*[@id='work_task_queue']/table/tbody/tr[1]/td[1]/div/img[2]";		//this is from firefox XPath plugin.
		wait20.until(Web.xpathExists(cancelImgXpath));
		driver.findElement(By.xpath(cancelImgXpath)).click();
		this.closeAllWindows();
	}

	public boolean hasNewSkillPoints() {
		String skillsLinkXpath = 	".//*[@id='menu_skill']/a/span";

		String style = driver.findElement(By.xpath(skillsLinkXpath)).getAttribute("style");
		if (style.indexOf("opacity") != -1)
			return true;
		if (style.equals("display: none;"))
			return false;
		else
			System.out.println("ERROR in hasNewSkillPoints -- skill button style is neither 'display: none;' nor does it contain 'opacity'");
		return false;	

		//not flashing:
		//		<li id="menu_skill" style="-moz-user-select: none;"><a onclick="AjaxWindow.show('skill');" href="#"><span style="display: none;">Skills</span></a></li>

		//flashing:		
		//		<li id="menu_skill" style="-moz-user-select: none;"><a onclick="AjaxWindow.show('skill');" href="#"><span style="display: block; background-image: url(img.php?type=menu); background-position: 0pt -225px; visibility: visible; opacity: 0.00902819;"></span></a></li>

	}

	public void allotNewSkills(User u) {
		if (u.skill_1 == null)
			return;
		
		clickLHNav_Skills();

		System.out.println("Alotting new skill points to " + u.name);
		
		try{ Thread.sleep(1000);}
		catch(Exception e){};
		driver.findElement(By.id(Skill.div_id(u.skill_1))).click();


		try{ Thread.sleep(1000);}
		catch(Exception e){};
		driver.findElement(By.id(Skill.div_id(u.skill_2))).click();


		try{ Thread.sleep(1000);}
		catch(Exception e){};
		driver.findElement(By.id(Skill.div_id(u.skill_3))).click();


		try{ Thread.sleep(1000);}
		catch(Exception e){};
		driver.findElement(By.id(Attribute.div_id(u.attribute))).click();

		//click Confirm
		try{ Thread.sleep(1000);}
		catch(Exception e){};
		driver.findElement(By.cssSelector("#skill_reskill_confirm_button .button_middle")).click();

		//<img src="/img.php?type=button&amp;subtype=normal&amp;value=yes" style="margin: 8px; cursor: pointer;" class="">
		try{ Thread.sleep(2000);}
		catch(Exception e){};
		//click 'Yes' in confirmation dialog
		driver.findElement(By.xpath("html/body/div[4]/div/div[10]/img[1]")).click();
		
		try{ Thread.sleep(2000);}
		catch(Exception e){};


		closeAllWindows();

	}


	
}