package com.jd.testmybatis.dao;

import com.jd.testmybatis.entity.CustomCodeTemplateInfo;

import java.util.HashMap;
import java.util.List;

public interface CustomCodeTemplateMapper {

    int insertOne(CustomCodeTemplateInfo codeTemplateInfo);
    List selectAll();
    int updateCollectTemplateStyleInfo(HashMap<String, Object> map);
}