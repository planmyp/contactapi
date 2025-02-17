package com.planmypooja.contactapi.resource;

import com.planmypooja.contactapi.domain.HomeCardPoojaKitModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.planmypooja.contactapi.service.HomeCardPoojaKitService;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeCardPoojaKitController {
    @Autowired
    private HomeCardPoojaKitService homeCardPoojaKitService;

    @CrossOrigin(origins = "http://localhost:3000")  // Allow React frontend
    @GetMapping("/poojaKits")
    public List<HomeCardPoojaKitModel.PoojaKitCard> getCards() {
        return homeCardPoojaKitService.getCards();
    }
}
