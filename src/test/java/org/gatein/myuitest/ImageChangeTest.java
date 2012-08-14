package org.gatein.myuitest;

import org.jboss.gatein.selenium.AbstractTestCase;
import static org.jboss.gatein.selenium.common.CommonHelper.*;
import static org.jboss.gatein.selenium.page.PageHelper.*;
import static org.jboss.gatein.selenium.applicationregistry.ApplicationRegistryHelper.autoImportApplications;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author fkiss
 */
public class ImageChangeTest extends AbstractTestCase {
        
        private String save = "//input[@name='save']";
        private String dropDownMenu = "//select[@id='myList']";
        //private String samplePage = "//a[text()='Sample-Ext Page Portal']";
        
        private boolean flag;      
    
        private String flickr = "flickr";
        private String ephoto = "ephoto";
        private String natGeo = "National Geographic";
        private String naturfoto = "naturfoto";
        private String xkcd = "xkcd";
        
        private String simplePortletCategory = ELEMENT_EDIT_PAGE_CATEGORY_MENU.replace("${categoryLabel}", "SimplePortlet-1.0");
        private String viewerPortlet = "//div[@id='SimplePortlet-1.0/local._SimplePortlet-1.0.Photo of the day']";
        private String changerPortlet = "//div//*[@id='SimplePortlet-1.0/local._SimplePortlet-1.0.Photo Changer']";
        
	@Test(groups={"epp5.0", "common"})
	public void imageChangeTest() throws Exception {
		System.out.println("--Start Image Change Test--");
		
		openPortal(true);
		
		signInAsRoot();
                
                goToApplicationRegistry();
                
                autoImportApplications();
                
                mouseOver(ELEMENT_LINK_SITE, true);
                mouseOverAndClick(ELEMENT_LINK_CLASSIC_PORTAL);
                
                insertPortlet(viewerPortlet);
                
                flag = true;
                
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
            mouseOverAndClick(ELEMENT_LINK_SITE_MAP);
            
            if(flag){
                insertPortlet(changerPortlet);
                flag = false;
            }
            
            select(dropDownMenu, website);
            click(save);
            
            mouseOver(ELEMENT_LINK_SITE, true);
            mouseOverAndClick(ELEMENT_LINK_CLASSIC_PORTAL);
            
            
            Assert.assertTrue(isTextAtElementEqual("//div[@class='website']", website));
        }
        
        public void insertPortlet(String portlet){
            goToEditPage();
                
            click(simplePortletCategory);
                
            dragAndDropToObject(portlet, ELEMENT_EDIT_PAGE_PAGE, null);
            
            click("//a[@class='EdittedSaveButton']");   
        }

}