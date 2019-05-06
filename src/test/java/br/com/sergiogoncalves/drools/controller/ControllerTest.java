package br.com.sergiogoncalves.drools.controller;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import static org.junit.Assert.*;

public class ControllerTest {

    private KieSession kSession;

    @Before
    public void setup() {
        Resource dt
                = ResourceFactory
                .newClassPathResource("com/baeldung/drools/rules/Discount.xls",
                        getClass());
      //  kSession = new DroolsBeanFactory().getKieSession(dt);
    }

    @Test
    public void getValorDeducao() {
    }
}