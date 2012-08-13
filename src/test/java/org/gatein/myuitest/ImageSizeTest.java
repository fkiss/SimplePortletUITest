package org.gatein.myuitest;

import junit.framework.Assert;
import org.jboss.gatein.selenium.AbstractTestCase;
import static org.jboss.gatein.selenium.applicationregistry.ApplicationRegistryHelper.autoImportApplications;
import static org.jboss.gatein.selenium.common.CommonHelper.*;
import static org.gatein.myuitest.MyCommonHelper.getHeight;
import static org.jboss.gatein.selenium.page.PageHelper.*;
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
                String simplePortletCategory = ELEMENT_EDIT_PAGE_CATEGORY_MENU.replace("${categoryLabel}", "SimplePortlet-1.0");
                String viewerPortlet = "//div[@id='SimplePortlet-1.0/local._SimplePortlet-1.0.Photo of the day']";
                String changerPortlet = "//div//*[@id='SimplePortlet-1.0/local._SimplePortlet-1.0.Photo Changer']";
                String siteMapPortlet = "//div[@id='UISiteMap']";
                String dragAndDropVerification = ELEMENT_EDIT_PAGE_COMPONENT_FIRST + PORTLET_LABEL.replace("${portletName}", "Photo of the day");
                
            
                System.out.println("--Start Image Size Test--");
		
		openPortal(true);
		
		signInAsRoot();
                
                goToApplicationRegistry();
                
                autoImportApplications();
                
                mouseOver(ELEMENT_LINK_SITE, true);
                mouseOverAndClick(ELEMENT_LINK_CLASSIC_PORTAL);
                
                goToEditPage();
                
                click(simplePortletCategory);
                
                dragAndDropToObject(changerPortlet, ELEMENT_EDIT_PAGE_PAGE, null);
                dragAndDropToObject(viewerPortlet, ELEMENT_EDIT_PAGE_PAGE, null);
                
                click("//a[@class='EdittedSaveButton']");
                
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
