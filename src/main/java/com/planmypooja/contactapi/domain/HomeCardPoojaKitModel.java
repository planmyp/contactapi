package com.planmypooja.contactapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class HomeCardPoojaKitModel {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PoojaKitCard {
        private String image;
        private String title;
        private String text;
        private String buttonText;
    }
}
