package org.gatein.myuitest;

import org.jboss.gatein.selenium.AbstractTestCase;
import static org.jboss.gatein.selenium.common.CommonHelper.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author fkiss
 */
public class ImageChangeTest extends AbstractTestCase {
        
        private String save = "//input[@name='save']";
        private String dropDownMenu = "//select[@id='myList']";
        private String samplePage = "//a[text()='Sample-Ext Page Portal']";
    
        String flickr = "flickr";
        String ephoto = "ephoto";
        String natGeo = "National Geographic";
        String naturfoto = "naturfoto";
        String xkcd = "xkcd";
        
	@Test(groups={"epp5.0", "common"})
	public void imageChangeTest() throws Exception {
		System.out.println("--Start Image Change Test--");
		
		openPortal(true);
		
		signInAsRoot();
                pause(2000);
                
                dropDownMenuTest(flickr);
                
                dropDownMenuTest(ephoto);
                
                dropDownMenuTest(natGeo);
                
                dropDownMenuTest(naturfoto);
                
                dropDownMenuTest(xkcd); 
                
		signOut();
	}
        
        public void dropDownMenuTest(String website){
            
            mouseOver(ELEMENT_LINK_SITE, true);
            mouseOver(ELEMENT_LINK_CLASSIC_PORTAL, true);
            mouseOverAndClick(samplePage);
            
            select(dropDownMenu, website);
            pause(2000);
            click(save);
            
            mouseOver(ELEMENT_LINK_SITE, true);
            mouseOverAndClick(ELEMENT_LINK_CLASSIC_PORTAL);
            
            
            Assert.assertTrue(isTextAtElementEqual("//div[@class='website']", website));
            
            pause(2000); 
        }

}