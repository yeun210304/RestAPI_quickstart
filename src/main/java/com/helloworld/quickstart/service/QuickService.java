package com.helloworld.quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
// import com.helloworld.quickstart.mapper.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuickService {
    // @Autowired
    // private QuickMapper quickMapper;

    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {
        // HashMap<String, String> paramMap = new HashMap<>();
        
        // paramMap.put("id", itemDto.getId());
        // paramMap.put("name", itemDto.getName());

        // int resCnt = quickMapper.registerItem(paramMap);

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        log.info("insert info : " + itemDto.toString());
        
        return true;
    }

    public ItemDto getItemById(String id) {
        // HashMap<String, String> paramMap = new HashMap<>();
        // paramMap.put("id", id);
        // return quickMapper.findById(paramMap);

        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();

        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
        
    }
}
