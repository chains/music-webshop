package com.chalmers.ctrl;

import com.chalmers.core.CD;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas Ekström, Mikael Andersson Ynghammar
 */
public class DBCDControlTest {

    CD t;
    DBCDControl instance;

    public DBCDControlTest() {
    }

    @Before
    public void setUp() {
        t = new CD(Long.valueOf(0), "SuperCD", 20, "Rock", "description", 10, 40, "Rammstein");
        instance = (DBCDControl) Database.getCDController();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create, find and destroy methods, of class DBCDControl.
     */
    @Test
    public void testCreateFindAndDestroy() {

        System.out.println("create");
        instance.create(t);
        System.out.println("findEntity");
        CD result = instance.findEntity(t.getId());
        assertEquals(t.getId(), result.getId());
        System.out.println("destroy");
        instance.destroy(t.getId());
        result = instance.findEntity(t.getId());
        assertNull(result);

    }
}
