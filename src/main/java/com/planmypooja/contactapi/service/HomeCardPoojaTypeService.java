package com.planmypooja.contactapi.service;


import org.springframework.stereotype.Service;

//import javax.smartcardio.Card;
import com.planmypooja.contactapi.domain.HomeCardPoojaTypesModel.PoojaTypeCard;
import java.util.List;

@Service
public class HomeCardPoojaTypeService {
    public List<PoojaTypeCard> getCards() {
        return List.of(
                new PoojaTypeCard("/photos/ganeshPooja.png", "Ganesh Pooja", "Ganesh Pooja", "Book"),
                new PoojaTypeCard("/photos/lakshmiPooja.png", "Lakshmi Pooja", "Lakshmi Pooja", "Book"),
                new PoojaTypeCard("/photos/saraswatiPooja.png", "Saraswati Pooja", "Saraswati Pooja", "Book"),
                new PoojaTypeCard("/photos/grihPravesh.jpg", "Grih Pravesh", "Grih Pravesh", "Book"),
                new PoojaTypeCard("/photos/vivaahSanskar.jpg", "Vivah Sanskar", "Vivah Sanskar", "Book"),
                new PoojaTypeCard("/photos/pitrPooja.png", "Pitra Pooja", "Pitra Pooja", "Book"),
                new PoojaTypeCard("/photos/shivPooja.webp", "Shiv Pooja", "Shiv Pooja", "Book"),
                new PoojaTypeCard("/photos/durgaPooja.jpg", "Durga Pooja", "Durga Pooja", "Book"),
                new PoojaTypeCard("/photos/shaniPooja.webp", "Shani Pooja", "Shani Pooja", "Book")
        );
    }

}
