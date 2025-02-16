package com.planmypooja.contactapi.service;


import org.springframework.stereotype.Service;

//import javax.smartcardio.Card;
import com.planmypooja.contactapi.domain.HomeCardPoojaTypesModel.PoojaTypeCard;
import java.util.List;

@Service
public class HomeCardPoojaTypeService {
    public List<PoojaTypeCard> getCards() {
        return List.of(
                new PoojaTypeCard("/photos/ganeshPooja.png", "Ganesh Pooja", "Ganesh Pooja", "Book Now"),
                new PoojaTypeCard("/photos/lakshmiPooja.png", "Lakshmi Pooja", "Lakshmi Pooja", "Book Now"),
                new PoojaTypeCard("/photos/saraswatiPooja.png", "Saraswati Pooja", "Saraswati Pooja", "Book Now")
//                new PoojaTypeCard("https://via.placeholder.com/150", "Card 4", "This is card 4", "Learn More"),
//                new PoojaTypeCard("https://via.placeholder.com/150", "Card 5", "This is card 5", "Learn More"),
//                new PoojaTypeCard("https://via.placeholder.com/150", "Card 6", "This is card 6", "Learn More"),
//                new PoojaTypeCard("https://via.placeholder.com/150", "Card 7", "This is card 7", "Learn More"),
//                new PoojaTypeCard("https://via.placeholder.com/150", "Card 8", "This is card 8", "Learn More"),
//                new PoojaTypeCard("https://via.placeholder.com/150", "Card 9", "This is card 9", "Learn More")
        );
    }

}
