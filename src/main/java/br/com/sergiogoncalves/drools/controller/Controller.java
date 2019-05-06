package br.com.sergiogoncalves.drools.controller;


import br.com.sergiogoncalves.drools.model.ModuloBaseIRPF;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.math.BigDecimal;

public class Controller {

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();

        Resource dt = ResourceFactory.newClassPathResource("static/Calculo.xls");

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        KieRepository kieRepository = kieServices.getRepository();

        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();

        KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);

        KieSession kieSession = kieContainer.newKieSession();


        /*------------------------------------------------------------------*/

        //Customer customer = new Customer(CustomerType.BUSINESS, 2);
        //kieSession.insert(customer);

        ModuloBaseIRPF moduloBaseIRPF = new ModuloBaseIRPF();

        moduloBaseIRPF.setDeducao(3751.06D);
        moduloBaseIRPF.setAliquota(22.5F);
        moduloBaseIRPF.setDeducao(0D);

        kieSession.insert(moduloBaseIRPF);

        kieSession.fireAllRules();


        System.out.println(moduloBaseIRPF.getDeducao());

    }

    public Integer getValorDeducao(){

        return null;
    }
}
