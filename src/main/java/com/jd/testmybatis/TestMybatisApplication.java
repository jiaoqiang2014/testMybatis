package com.jd.testmybatis;

import com.jd.testmybatis.dao.CustomCodeTemplateMapper;
import com.jd.testmybatis.entity.CustomCodeTemplateInfo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@Slf4j
@MapperScan("com.jd.testmybatis.dao")
public class TestMybatisApplication implements ApplicationRunner {

    @Autowired
    CustomCodeTemplateMapper codeTemplateMapper;


    public static void main(String[] args) {
        SpringApplication.run(TestMybatisApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        CustomCodeTemplateInfo codeTemplateInfo = new CustomCodeTemplateInfo("1", "JQ");
//        log.info("start insert");
//        codeTemplateMapper.insertOne(codeTemplateInfo);
//
//        CustomCodeTemplateInfo codeTemplateInfo2 = new CustomCodeTemplateInfo("2", null);
//        codeTemplateMapper.insertOne(codeTemplateInfo2);

        List<CustomCodeTemplateInfo> customCodeTemplateInfos = codeTemplateMapper.selectAll();
        log.info("影响行数：" + customCodeTemplateInfos.size());

        HashMap<String, Object> map = new HashMap();
        map.put("id", 1);
        map.put("styleId", "2");
        map.put("name", "JQUPdate");
        codeTemplateMapper.updateCollectTemplateStyleInfo(map);
    }
}
