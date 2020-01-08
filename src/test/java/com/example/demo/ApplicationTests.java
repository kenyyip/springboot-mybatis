package com.example.demo;

import com.keny.Application;
import com.keny.entity.Dossiers;
import com.keny.service.DossiersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private DossiersService dossiersService;

	@Test
	public void contextLoads() {
		System.out.println("___________________hello world!");
	}

    @Test
    public void add() {
        System.out.println("+++++++++++++++++add()+++++++++++++++++++");
        Dossiers record = new Dossiers();
        record.setId(UUID.randomUUID().toString());
        record.setName("admin");
        record.setEmail("kenyyip@163.com");
        record.setPhone("15999552982");
        record.setSex(1);
        record.setAddress("广东省深圳市");
        dossiersService.addSelective(record);
    }

}
