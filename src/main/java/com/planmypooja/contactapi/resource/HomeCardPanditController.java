package com.planmypooja.contactapi.resource;

import com.planmypooja.contactapi.domain.HomeCardPanditModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.planmypooja.contactapi.service.HomeCardPanditService;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeCardPanditController {
    @Autowired
    private HomeCardPanditService homeCardPanditService;

    @CrossOrigin(origins = "http://localhost:3000")  // Allow React frontend
    @GetMapping("/pandits")
    public List<HomeCardPanditModel.PanditCard> getCards() {
        return homeCardPanditService.getCards();
    }
}
