package com.tistory.seinenim.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController { //페이지에 관련된 컨트롤러는 모두 IndexController 사용
    @GetMapping("/")
    public String index(){
        //mustache 스타터 덕분에 문자열 반환시 앞의 경로와 뒤의 파일 확장자 자동 지정됨
        // src/main/resources/templates/index.mustache
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
