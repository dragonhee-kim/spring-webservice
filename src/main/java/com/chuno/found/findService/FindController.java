package com.chuno.found.findService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/find")
public class FindController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindController.class);
    @Autowired
    FindService findService;

    /*
    * 습득물 등록 API
    *
    * insertFind
    *
    *
    *
    * */
    @PostMapping("/item/insert")
    public @ResponseBody
    void insertFind( @RequestBody Find find){
        findService.insertFind(find);
    }


    /*
    * 습득물 조회 API
    *
    *
    * */
    @PostMapping("/item/get")
    public @ResponseBody
    List<Find> selectFindItem(@RequestBody Map<String, String> param){
        String category = param.get("category");

        return findService.selectFindItem(category);
    }

    @PostMapping("/item/list")
    public @ResponseBody
    List<Find> selectFindAllList(@RequestBody Map<String, Object> param){
        return findService.selectFindAllList();
    }


}
