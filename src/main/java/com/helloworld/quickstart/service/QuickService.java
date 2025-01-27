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

    public boolean registerItem(ItemDto itemDto) {
        //TODO: DB insert

        log.info("service ...");
        
        return true;
    }

    public ArrayList<ItemDto> getItemById(String id) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return quickMapper.findById(paramMap);
    }
}
