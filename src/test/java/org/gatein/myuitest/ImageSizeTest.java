package org.gatein.myuitest;

import junit.framework.Assert;
import org.jboss.gatein.selenium.AbstractTestCase;
import static org.jboss.gatein.selenium.common.CommonHelper.*;
import org.testng.annotations.Test;

/**
 *
 * @author fkiss
 */
public class ImageSizeTest extends AbstractTestCase {
    
        private String dropDownMenu = "//select[@id='myList']";
        private String save = "//input[@name='save']";
        private String arrowDown = "//div[@class='ControlIcon ArrowDownIcon']";
        private String arrowDownEdit ="//a[@title='Edit']";
        private String inputSize ="//input[@name='size']";
        private String arrowDownView = "//a[@title='View']";
    
        @Test(groups={"epp5.0", "common"})
	public void imageSizeTest() throws Exception {
		System.out.println("--Start Image Size Test--");
		
		openPortal(true);
		
		signInAsRoot();
                
                select(dropDownMenu, "flickr");
                click(save);
                
                click(arrowDown);
                click(arrowDownEdit);
                
                type(inputSize, "300", true);
                click(save);
                
                click(arrowDown);
                click(arrowDownView);
                
                Assert.assertEquals("300",getHeight("//img[@class='primary_photo']"));
                
		signOut();
	}
}
