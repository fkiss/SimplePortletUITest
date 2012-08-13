/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatein.myuitest;

import org.jboss.gatein.selenium.common.CommonHelper;
import org.openqa.selenium.StaleElementReferenceException;

/**
 *
 * @author fkiss
 */
public class MyCommonHelper extends CommonHelper {
        
    public static String getHeight(String xpath) {
        try {
            return waitForAndGetElement(xpath).getAttribute("height");
        } catch (StaleElementReferenceException e) {
            checkCycling(e, 5);
            pause(1000);
            return getHeight(xpath);
        } finally {
            loopCount = 0;
        }
    }
}
