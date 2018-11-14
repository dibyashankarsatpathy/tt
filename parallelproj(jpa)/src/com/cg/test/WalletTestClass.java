package com.cg.test;

import org.junit.Assert;
import org.junit.Test;

import com.cg.exception.WalletException;
import com.cg.service.WalletServiceImpl;

public class WalletTestClass {
	
	@Test
    public void testName_1() throws WalletException{
    
        String name="Dibya";
        WalletServiceImpl service=new WalletServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    @Test
    public void testName_2() throws WalletException{
    
        String name="rey";
        WalletServiceImpl service=new WalletServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    
    
    @Test
    public void testMobile_1() throws WalletException{
    
        String mobNo="DSS558";
        WalletServiceImpl service=new WalletServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void testMobile_2() throws WalletException{
    
        String mobNo="9439439653";
        WalletServiceImpl service=new WalletServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(true,result);
    }


}
