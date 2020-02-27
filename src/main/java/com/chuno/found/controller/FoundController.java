package com.chuno.found.controller;

import com.chuno.found.dao.MyTest;
import com.chuno.found.dao.MyTestRepository;
import com.chuno.found.dto.FoundDto;
import com.chuno.found.dao.Found;
import com.chuno.found.dao.FoundRepository;

import com.chuno.found.dto.MyTestDto;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class FoundController {

    //JPASystemException

    @Autowired
    private FoundRepository foundRepository;

    @Autowired
    private MyTestRepository myTestRepository;


    @GetMapping("/")
    public List<Found> home(){
        System.out.println(this.foundRepository.findAll());

      //  List<Found> found = this.foundRepository.myTest("test", Sort.by("foundContent")); //Sort를 사용

//        List<Found> found = this.foundRepository.myTest("test", JpaSort.unsafe("LENGTH(foundContent)")); //JpaSort사용

      //    List<Found> found = this.foundRepository.myTest2("test", Sort.by("foundContent")); //Sort를 사용

   //     System.out.println("found id "+found.get(0).getCategoryName());

//        Optional<MyTest> mytest = this.myTestRepository.findById((long) 1);

        return this.foundRepository.findAll();
    }
    @GetMapping("/saveTest")
    public void test(){
        MyTestDto dto = new MyTestDto();
        Optional<Found> f = this.foundRepository.findById((long) 1);

//        dto.setFound(f);
 //       dto.setTestName("test");
//        this.myTestRepository.save();

    }

    @GetMapping("/find")
    public List<Found> getFoundAll(){

        List<Found> list = this.foundRepository.findAll();


        return list;
    }

    //WHERE found_id = ?
    @GetMapping("/find/{id}")
    public Optional<Found> getFoundById(@PathVariable Long id){

        Optional<Found> found = this.foundRepository.findById(id);

        return found;
    }


    @PostMapping("/find")
    public int savaFound(@RequestBody FoundDto dto){

        int result = 1;

        System.out.println(dto.toEntity());

        Found found = this.foundRepository.save(dto.toEntity());
        System.out.println("save found is  : "+ found);
        System.out.println("save found is  : "+ found.getCategoryName());

        return result;

    }

    //WHERE found_title = ?
    @GetMapping("/find/title/{title}")
    public List<Found> getFoundTitle(@RequestParam String title) {
        List<Found> founds = this.foundRepository.findByFoundTitle("test");
        if ("".equals(founds) || founds == null) {

        }

        return founds;
    }

    //WHERE mem_id = ?
    @GetMapping("/find3")
    public List<Found> getFoundAll3(){
        List<Found> founds =  this.foundRepository.findByMemId("test");
        return founds;
    }





    //실제 category 서버에서 값 가져오게 하자
    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable String id){

        RestTemplate restTemplate = new RestTemplate();
        //String url = "http://27.96.135.50:8080/get/"+category_name;
        String url = "http://49.50.167.142:8080/find/"+id;


        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", id);



        String json = jsonObject.toJSONString();// toJSONString()이라는 메소드를 이용해서 response 객체의 데이터를 문저열로 바꾸어 줍니다. System.out.println("만들어진 json 데이타 : "+json); //만들어진 데이터를 출력해 봅시다.
        String answer =    restTemplate.getForObject(url, String.class);

        return answer;
    }

    //실제 category  서버에 값 저장하게 하자
    //방법 1 post로 받아서 json에 넣어서 보내기.
    //방법 2 DTO 만들어서 보내기.
    @PostMapping("/category")
    public String saveCategory(FoundDto dto){

        RestTemplate restTemplate = new RestTemplate();
       // String url = "http://49.50.164.57:8080/lost_save";
        String url = "http://49.50.167.142:8080/find";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("category_name", "용희입니다.");



        String json = jsonObject.toJSONString();// toJSONString()이라는 메소드를 이용해서 response 객체의 데이터를 문저열로 바꾸어 줍니다. System.out.println("만들어진 json 데이타 : "+json); //만들어진 데이터를 출력해 봅시다.
        String answer =    restTemplate.postForObject(url, dto, String.class);

        return answer;
    }



    @GetMapping("/lost")
    public void getLost()  {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();


        String url = "http://49.50.167.142:8080/find";


        JSONObject test = new JSONObject();

        test.put("found_title", "홍길동");
        test.put("found_content", "홍길동");
        test.put("found_photo", "홍길동");
        test.put("mem_id", "홍길동");

        String json = test.toJSONString();// toJSONString()이라는 메소드를 이용해서 response 객체의 데이터를 문저열로 바꾸어 줍니다. System.out.println("만들어진 json 데이타 : "+json); //만들어진 데이터를 출력해 봅시다.


        String answer =    restTemplate.postForObject(url, json, String.class);

        System.out.println(answer);

        System.out.println("hi");

    }


    //http://49.50.164.57:8080/lost_save

    @PostMapping("/lost")
    public void saveLost()  {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://49.50.164.57:8080/lost_save";


        JSONObject test = new JSONObject();

        test.put("found_title", "홍길동");
        test.put("found_content", "홍길동");
        test.put("found_photo", "홍길동");
        test.put("mem_id", "홍길동");



        String json = test.toJSONString();// toJSONString()이라는 메소드를 이용해서 response 객체의 데이터를 문저열로 바꾸어 줍니다. System.out.println("만들어진 json 데이타 : "+json); //만들어진 데이터를 출력해 봅시다.
        String answer =    restTemplate.postForObject(url, json, String.class);

        System.out.println(answer);

        System.out.println("hi");

    }

}
