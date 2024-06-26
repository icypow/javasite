package com.shop.site;
import com.shop.site.Entity.Client;
import com.shop.site.Service.ClientSVC;
import org.junit.jupiter.api.*;
import com.shop.site.Entity.*;
import com.shop.site.Service.*;


public class ClientTest {



    @Test
    public void testPassword(){
        ClientSVC cs;
        Client c;
        cs = new ClientSVC();
        c =  new Client("aboba", "12345");
        cs.save(c);
        Assertions.assertEquals(cs.findById(c.getClientId()).getPassword(), "12345");
        cs.changePassword(c, "12345", "54321");
        cs.update(c);
        Assertions.assertEquals(cs.findById(c.getClientId()).getPassword(), "54321");
        cs.delete(c);
        Assertions.assertNull(cs.findById(c.getClientId()));
    }

}
