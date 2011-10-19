    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.music_webshop;

import com.chalmers.beans.ShoppingCartModelBean;
import com.chalmers.core.CD;
import java.util.ArrayList;
import com.chalmers.core.OrderItem;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Nicklasson
 */
public class ShoppingCartTest {
    
    private List<OrderItem> productlist;
    private OrderItem item1;
    private OrderItem item2;
    private CD cd1;
    private CD cd2;
    private ShoppingCartModelBean cart;
    
    public ShoppingCartTest() {
    }
    
    
    @Test
    public void testShoppingCart(){
        
        cart = new ShoppingCartModelBean();
        
        // Creating dummy shoppinglist
        productlist = new ArrayList<OrderItem>();
        productlist.add(item1);
        productlist.add(item2);
        
        cart.setCart(productlist);
        
        // Test total cost, should be 80 (20+20+100 in price)
        assertTrue(cart.getTotal()==160);
        
        // Test to see that there are 4 items in total in the cart
        assertTrue(cart.getCartCount()==4);
        
        // Test to see that there are 3 items left after removing one
        cart.removeOneProduct(cd1);
        assertTrue(cart.getCartCount()==3);
        
        // Test to see that all CD1 cd's are removed after doing removeProduct
        // Should be only one left now, the Metallica CD
        cart.removeProduct(cd1);
        assertTrue(cart.getCartCount()==1);
        assertTrue(cart.getCart().get(0).getProduct().getArtist().equals("Metallica"));
        
        // Test toString method
        assertTrue(cart.getCart().get(0).getProduct().toString().equals("Artist: Metallica - Album: CoolCD Genre: Pop Price: 100.0"));
        
        
        
        // Lastly, test to see that cart is empty when it's emptied
        cart.emptyCart();
        List<OrderItem> testlist;
        testlist = cart.getCart();
        assertTrue(testlist.isEmpty());
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
        cd1 = new CD(Long.valueOf(0), "SuperCD", 20 , "Rock", "description", 10, 40, "Rammstein");
        cd2 = new CD(Long.valueOf(1), "CoolCD", 100 , "Pop", "description", 10, 40, "Metallica");
        
        item1 = new OrderItem(3, cd1);
        item2 = new OrderItem(1, cd2);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
