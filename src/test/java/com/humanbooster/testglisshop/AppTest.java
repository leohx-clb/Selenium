package com.humanbooster.testglisshop;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		// On récupére le système d'explotation
		String os = System.getProperty("os.name")
				.toLowerCase()
				.split(" ")[0];
		// générer le chemin du fichier du driver
		String pathMarionette = Paths.get(".").toAbsolutePath().normalize().toString()+"/lib/chromedriver-"+os;
		
		// enregistre le chemin dans une propriété qui est webdriver.chrome.driver
		// Firefox : webdriver.gecko.driver
		System.setProperty("webdriver.chrome.driver", pathMarionette);

		// options pour mettre le navigateur en pleine écran
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// on créé l'objet ChromeDriver
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	
	/*
	 * Question 1
	 */
	
	  @Test
	  public void testUntitledUn() throws Exception {
		  //ouvre le navigateur internet
		  
	    driver.get("https://www.glisshop.com/ski/ski-nu/");
	    Thread.sleep(1000);
	    System.out.println("ouvre le site");

	    driver.findElement(By.id("tarteaucitronPersonalize2")).click();
	    Thread.sleep(2000);
	    System.out.println("eneleve le msg cookie");
	    
	    List<WebElement> labels = driver.findElements(By.className("checkbox_label"));

	   for (WebElement label : labels) {
		   String at = label.getText();
		   //System.out.println(at);
		   if (at.contains("Atomic")) {
			   label.click();
			   break;			
		}
	   }
	   Thread.sleep(1000);
	   // Atomic selectioner
	   
	   WebElement divBtn = driver.findElement(By.id("sticky-wrapper"));
	   divBtn.findElement(By.tagName("button")).click();
	   Thread.sleep(1000);
	   
	   WebElement divList = driver.findElement(By.className("product-list-1"));
	   List<WebElement> items = driver.findElements(By.className("product-list"));
	   Thread.sleep(1000);
	   assertTrue(items.size() > 0);
	   
	   //sleep pour observer
	   //Thread.sleep(10000);
	  }
	  
	  
	  
	  /*
	   * Question 2 
	   */
		
	  @Test
	  public void testUntitledDeux() throws Exception {
		  //ouvre le navigateur internet
		  
	    driver.get("https://www.glisshop.com/identification/");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("tarteaucitronPersonalize2")).click();
	    Thread.sleep(2000);

	    WebElement email = driver.findElement(By.id("block2-login"));
        email.sendKeys("nchevalier@formateur-humanbooster.com");
        Thread.sleep(1000);
        
        WebElement psw = driver.findElement(By.id("block2-password"));
        psw.sendKeys("humanB@63");
        Thread.sleep(1000);
	    
        List<WebElement> btns = driver.findElements(By.tagName("button"));
        for (WebElement btn : btns) {
        	String btnString = btn.getText();
        	//System.out.println("btn text : "+btnString);
        	if (btnString.contains("CONNEXION")) {
        		btn.click();
        		break;
			}			
		}
        Thread.sleep(1000);
        
        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        boolean test = false;
        for (WebElement h1 : h1s) {
        	String resultH1 = h1.getText().toLowerCase();
			if (resultH1.contains("Bienvenue".toLowerCase())) {
				//System.out.println(resultH1);
				test = true;
				break;
			}
		}
        assertTrue(test);
        
	    
	    //Thread.sleep(10000);

	  }
	  
	  //https://www.glisshop.com/ski/salomon/qst-922230536
	  /*
	   * Question 3
	   */
	
		
	  @Test
	  public void testUntitledTrois() throws Exception {
		  //ouvre le navigateur internet
		  
	    driver.get("https://www.glisshop.com/ski/salomon/qst-922230536");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("tarteaucitronPersonalize2")).click();
	    Thread.sleep(2000);
	    
	    WebElement divBtn = driver.findElement(By.className("add-to-cart-actions"));
	    Thread.sleep(1000);
	    
	    driver.findElement(By.className("NostoOverlayClosePermanently")).click();
	    Thread.sleep(1000);
	    
	    divBtn.findElement(By.className("btn_l1_quaternary")).click();
	    Thread.sleep(1000);
	    
	    WebElement modal = driver.findElement(By.className("modal-footer"));
	    modal.findElement(By.tagName("a")).click();
	    
	    
	    List<WebElement> productLabbels = driver.findElements(By.className("product-label"));
	    boolean test = false;
	    for (WebElement label : productLabbels) {
	    	System.out.println(label.getText().toLowerCase());
	    	String textLabel = label.getText();
	    	if (textLabel.contains("Qst 92 - 153")) {
	    		//System.out.println("CHECK");
	    		test = true;
			}
			
		}
	    assertTrue(test);
	    //Qst 92 - 153
	    
	    //Thread.sleep(10000);

	  }	  
	  
	  /*
	   * Question 4
	   */
	
	  @Test
	  public void testUntitledQuatre() throws Exception {
		  //ouvre le navigateur internet
		  
	    driver.get("https://www.glisshop.com/boots-snowboard/burton/moto-boa-black19538894?refSrc=18250874&nosto=productpage-nosto-2");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("tarteaucitronPersonalize2")).click();
	    Thread.sleep(2000);
	    	    
	    //scroll pour avori la vision
	    WebElement scrollZone = driver.findElement(By.className("product_animation"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollZone);
        Thread.sleep(1000);
	    
        List<WebElement> divParents = driver.findElements(By.className("axis-value-selector-container"));
        WebElement divParent = divParents.get(1);
        List<WebElement> spans = divParent.findElements(By.tagName("span"));
        
        for (WebElement span : spans) {
        	String spanString = span.getText();
        	//System.out.println(spanString);
        	if (spanString.contains("8")) {
        		//System.out.println("CHECK CLICK");
        		span.click();
        		break;
			}
			
		}
        Thread.sleep(1000);
        	    
	    driver.findElement(By.className("add-to-cart-actions")).click();
	    Thread.sleep(1000);

	    WebElement modal = driver.findElement(By.className("modal-footer"));
	    modal.findElement(By.tagName("a")).click();
	    Thread.sleep(1000);
	    
	    List<WebElement> productLabbels = driver.findElements(By.className("product-label"));
	    boolean test = false;
	    for (WebElement label : productLabbels) {
	    	//System.out.println(label.getText().toLowerCase());
	    	String textLabel = label.getText();
	    	if (textLabel.contains("8")) {
	    		//System.out.println("CHECK");
	    		test = true;
			}
			
		}
	    
	    assertTrue(test);
	    
	    //Thread.sleep(10000);

	  }	
	  
	  
	  // https://www.glisshop.com/pack-selector-snowboard.html
	  	  
	  /*
	   * Question 5
	   */
		
	  @Test
	  public void testUntitledCinq() throws Exception {
		  //ouvre le navigateur internet
		  
	    driver.get("https://www.glisshop.com/pack-selector-snowboard.html");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("tarteaucitronPersonalize2")).click();
	    Thread.sleep(2000);
	    
	    // scrolle class blue-background
	    WebElement scrollZone = driver.findElement(By.className("blue-background"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollZone);
        Thread.sleep(1000);
        
        // partie planche
        WebElement listArticl = driver.findElement(By.className("col-md-9"));
        List<WebElement> articles = listArticl.findElements(By.className("product-item"));
        WebElement article = articles.get(0);
        WebElement prix = article.findElement(By.className("price-value".toString()));

        Double prixPlanche = Double.parseDouble(prix.getText().replace(",", ".").replace("€", ""));
        System.out.println(prixPlanche);
        article.click();
        Thread.sleep(1000);
        
	    driver.findElement(By.className("add-to-cart_block")).click();
	    Thread.sleep(2000);
	    
	    // scrolle class blue-background
	    scrollZone = driver.findElement(By.className("blue-background"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollZone);
        Thread.sleep(1000);
	    
	    // partie fixation
        listArticl = driver.findElement(By.className("col-md-9"));
        articles = listArticl.findElements(By.className("product-item"));
        article = articles.get(2);
        List<WebElement> zonePrix = article.findElements(By.className("price-value"));
        prix = zonePrix.get(1);
        Thread.sleep(1000);

        Double prixFixation = Double.parseDouble(prix.getText().replace(",", ".").replace("€", ""));
        System.out.println(prixFixation);
        Thread.sleep(1000);
        article.click();
        Thread.sleep(2000);
        
	    // scrolle class blue-background
	    scrollZone = driver.findElement(By.className("product_animations"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollZone);
        Thread.sleep(2000);
        
	    driver.findElement(By.className("add-to-pack-actions")).click();
	    Thread.sleep(1000);
	    
	    WebElement total = driver.findElement(By.className("price-old-value"));
	    
        Double prixTotal = Double.parseDouble(total.getText().replace(",", ".").replace("€", ""));
        System.out.println(prixTotal);
        Thread.sleep(1000);    
        
        Double prixCalculer = prixFixation+prixPlanche;
        Thread.sleep(1000); 
        boolean test = false;
        //System.out.println("calculer : "+prixCalculer);
        //System.out.println("total : " +prixTotal);
        
        if (prixTotal.equals(prixCalculer)) {
			test = true;
        	//System.out.println("VALIDER");
		}
        Thread.sleep(1000); 
        
        assertTrue(test);

	  }	
	
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
}
