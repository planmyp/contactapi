package com.planmypooja.contactapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class HomeCardPanditModel {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PanditCard {
        private String image;
        private String text;
        private String title;
        private String buttonText;
    }
}
