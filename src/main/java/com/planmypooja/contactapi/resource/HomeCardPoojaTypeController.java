package com.planmypooja.contactapi.resource;

import com.planmypooja.contactapi.domain.HomeCardPoojaTypesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.planmypooja.contactapi.service.HomeCardPoojaTypeService;

import java.util.List;

@RestController
//@RequestMapping("/api")
@RequestMapping("/home")

public class HomeCardPoojaTypeController {
    @Autowired
    private HomeCardPoojaTypeService homeCardPoojaTypeService;

    @CrossOrigin(origins = "http://localhost:3000")  // Allow React frontend
    @GetMapping("/poojaTypes")
    public List<HomeCardPoojaTypesModel.PoojaTypeCard> getCards() {
        return homeCardPoojaTypeService.getCards();
    }
}
