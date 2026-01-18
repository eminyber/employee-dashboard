package com.eminyber.employee_dashboard_api.titles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/titles")
public class TitleController {

    private final TitleService titleService;

    public TitleController(TitleService titleService){
        this.titleService = titleService;
    }

    @GetMapping
    public String getTitleMessage() {
        return "Hello from title controller";
    }
}