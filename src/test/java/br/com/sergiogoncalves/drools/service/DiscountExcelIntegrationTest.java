package br.com.sergiogoncalves.drools.service;

import br.com.sergiogoncalves.drools.config.DroolsBeanFactory;
import br.com.sergiogoncalves.drools.model.Customer;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DiscountExcelIntegrationTest {

    private KieSession kSession;

    @Before
    public void setup() {
        Resource resource = ResourceFactory.newClassPathResource("static/Discount.xls", getClass());
        kSession = new DroolsBeanFactory().getKieSession(resource);
    }

    @Test
    public void giveIndvidualLongStanding_whenFireRule_thenCorrectDiscount() throws Exception {
        Customer customer = new Customer(Customer.CustomerType.INDIVIDUAL, 5);
        kSession.insert(customer);

        kSession.fireAllRules();

        Assert.assertEquals(customer.getDiscount(), 15);
    }

    @Test
    public void giveIndvidualRecent_whenFireRule_thenCorrectDiscount() throws Exception {

        Customer customer = new Customer(Customer.CustomerType.INDIVIDUAL, 1);
        kSession.insert(customer);

        kSession.fireAllRules();

        Assert.assertEquals(customer.getDiscount(), 5);
    }

    @Test
    public void giveBusinessAny_whenFireRule_thenCorrectDiscount() throws Exception {
        Customer customer = new Customer(Customer.CustomerType.BUSINESS, 0);
        kSession.insert(customer);

        kSession.fireAllRules();

        Assert.assertEquals(customer.getDiscount(), 20);
    }

}
