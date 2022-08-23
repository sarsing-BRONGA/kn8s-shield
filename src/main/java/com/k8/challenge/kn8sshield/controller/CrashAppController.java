package com.k8.challenge.kn8sshield.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CrashAppController {

    @PostMapping("/crashApp")
    public void crashApplicaiton() {
        try {
            int i = 0;
            List<String> list = new ArrayList<>();
            while (true) {
                System.out.println("i -->" + i + " size :" + list.size());
                list.add(new BigDecimal(i++).toPlainString());
                list.add(list.toString());
            }
        }catch (Error e) {
            System.exit(1);
        }
    }
}
