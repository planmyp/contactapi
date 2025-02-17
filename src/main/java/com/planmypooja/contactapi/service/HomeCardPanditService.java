package com.planmypooja.contactapi.service;

import org.springframework.stereotype.Service;
import com.planmypooja.contactapi.domain.HomeCardPanditModel.PanditCard;
import java.util.List;

@Service
public class HomeCardPanditService {
    public List<PanditCard> getCards() {
        return List.of(
                new PanditCard("/photos/pandits/ambuj.jpg", "Pandit A", "Expert in Ganesh Pooja", "Book"),
                new PanditCard("/photos/pandits/pandit2.webp", "Pandit B", "Expert in Laxmi Pooja", "Book"),
                new PanditCard("/photos/pandits/abhi.png", "Pandit C", "Expert in Shiv Pooja", "Book"),
                new PanditCard("/photos/pandits/pandit4.jpg", "Pandit D", "Expert in Durga Pooja", "Book"),
                new PanditCard("/photos/pandits/pandit2.webp", "Pandit E", "Expert in Vastu", "Book"),
                new PanditCard("/photos/pandits/pandit3.webp", "Pandit F", "Expert in Wedding", "Book"),
                new PanditCard("/photos/pandits/anu.png", "Pandit F", "Expert in Wedding Ceremonies", "Book"),
                new PanditCard("/photos/pandits/ambuj.jpg", "Pandit F", "Expert in Wedding Ceremonies", "Book"),
                new PanditCard("/photos/pandits/pandit4.jpg", "Pandit F", "Expert in SundarKand", "Book")

        );
    }
}
