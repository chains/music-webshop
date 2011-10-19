/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.ShopUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas
 */
public class DBShopUserControlTest {

    ShopUser t;
    DBShopUserControl instance;

    public DBShopUserControlTest() {
    }

    @Before
    public void setUp() {
        t = new ShopUser(Long.valueOf(0), "blabla",
                "aa", "pass", "astreet", "acity",
                "acountry", false);
        instance = (DBShopUserControl) Database.getShopUserController();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create,find and destroy methods, of class DBShopUserControl.
     */
    @Test
    public void testCreateFindAndDestroy() {
        System.out.println("create");
        instance.create(t);
        System.out.println("findEntity");
        ShopUser result = instance.findEntity(t.getId());
        assertEquals(t.getId(), result.getId());
        System.out.println("destroy");
        instance.destroy(t.getId());
        result = instance.findEntity(t.getId());
        assertNull(result);
    }


}
