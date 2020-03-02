package com.chuno.found.lostService;

import com.chuno.found.findService.Find;
import com.chuno.found.findService.FindController;
import com.chuno.found.findService.FindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/lost")
public class LostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LostController.class);
    @Autowired
    LostService lostService;

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
    void insertFind( @RequestBody Lost lost){
        lostService.insertLost(lost);
    }


    /*
     * 습득물 조회 API
     *
     *
     * */
    @PostMapping("/item/get")
    public @ResponseBody
    List<Lost> selectFindItem(@RequestBody Map<String, String> param){
        String category = param.get("category");

        return lostService.selectLostListByCaetgory(category);
    }

    @PostMapping("/item/listall")
    public @ResponseBody
    List<Lost> selectFindAllList(@RequestBody Map<String, Object> param){
        return lostService.selectLostAllList();
    }

    @PostMapping("/item/list")
    public @ResponseBody
    List<Lost> selectFindListByCategory(@RequestBody Map<String, Object> param){
        LOGGER.debug("param  "+param);
        LOGGER.debug("category  "+param.get("category"));

        return lostService.selectLostListByCaetgory((String) param.get("category"));
    }


}
