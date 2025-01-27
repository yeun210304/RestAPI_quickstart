package com.helloworld.quickstart.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.helloworld.quickstart.dto.ItemDto;

@Mapper
public interface QuickMapper {

    ArrayList<ItemDto> findById(HashMap<String, String> paramMap);
}
