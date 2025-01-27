package com.helloworld.quickstart.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.mapper.QuickMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuickService {

    @Autowired
    private QuickMapper quickMapper;

    public int registerItem(ItemDto itemDto) {
        HashMap<String, String> paramMap = new HashMap<>();
        
        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        int resCnt = quickMapper.registerItem(paramMap);

        log.info("insert info : " + itemDto.toString() + " insert count : {}", resCnt);
        
        return resCnt;
    }

    public ArrayList<ItemDto> getItemById(String id) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return quickMapper.findById(paramMap);
    }
}
