package com.planmypooja.contactapi.service;

import org.springframework.stereotype.Service;
import com.planmypooja.contactapi.domain.HomeCardPoojaKitModel.PoojaKitCard;
import java.util.List;

@Service
public class HomeCardPoojaKitService {
    public List<PoojaKitCard> getCards() {
        return List.of(
                new PoojaKitCard("/photos/poojaKits/aartiKit.jpg", "Aarti Kit", "Aarti Kit", "Buy Now"),
                new PoojaKitCard("/photos/poojaKits/navratriPoojaKit.jpg", "navratriPooja Kit", "navratri Kit", "Buy Now"),
                new PoojaKitCard("/photos/poojaKits/sundarkandPoojaKit.webp", "sundarkand Kit", "sundarkand Kit", "Buy Now"),
                new PoojaKitCard("/photos/poojaKits/vaastuPooja.jpg", "vaastuPooja Kit", "vaastuPooja Kit", "Buy Now"),
                new PoojaKitCard("/photos/poojaKits/ganeshPoojaKit.jpg", "Ganesh Pooja Kit", "GaneshPooja Kit", "Buy Now"),
                new PoojaKitCard("/photos/poojaKits/lakshmiPoojaKit.webp", "Lakshmi Pooja Kit", "LakshmiPooja Kit", "Buy Now"),
                new PoojaKitCard("/photos/poojaKits/shivratri.webp", "Shiv Pooja Kit", "ShivPooja Kit", "Buy Now"),
                new PoojaKitCard("/photos/poojaKits/meditationKit.jpg", "meditationKit Kit", "meditation Kit", "Buy Now"),
                 new PoojaKitCard("/photos/poojaKits/satyanarayanPooja.jpg", "Satyanarayan Kit", "Satyanarayan Kit", "Buy Now")
        );
    }
}
