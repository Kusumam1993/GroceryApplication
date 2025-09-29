package utilities;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	//private WebDriver driver;
    private Actions actions;
    
	public void selectDropdownWithVisibleText(WebElement element, String userType)
	{
		Select object = new Select(element);
		object.selectByVisibleText(userType);
	}	
	 // Hover over an element
	public void hoverOverElement(WebElement element)
	{
        actions.moveToElement(element).perform();
    }
		
	// Right-click on element
    public void rightClick(WebElement element) 
    {
        actions.contextClick(element).perform();
    }
    
    // Double-click on element
    public void doubleClick(WebElement element)
    {
        actions.doubleClick(element).perform();
    }
    // Drag and Drop
    public void dragAndDrop(WebElement source, WebElement target)
    {
        actions.dragAndDrop(source, target).perform();
    }
    



}
