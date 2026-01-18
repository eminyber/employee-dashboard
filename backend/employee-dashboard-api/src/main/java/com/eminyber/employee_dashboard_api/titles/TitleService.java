package com.eminyber.employee_dashboard_api.titles;

import org.springframework.stereotype.Service;

@Service
public class TitleService {

    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository){
        this.titleRepository = titleRepository;
    }
}