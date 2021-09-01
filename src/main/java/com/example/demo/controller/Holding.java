package com.example.demo.controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Holding {

    @Getter @Setter
    String ticker;

    @Getter @Setter
    double price;

    @Getter @Setter
    int volume;

    @Getter @Setter
    int lastClose;

    @Getter @Setter
    String position;

    @Getter @Setter
    LocalDateTime date;

    @Getter @Setter
    String advice;

    @Getter @Setter
    double upperBand;

    @Getter @Setter
    double lowerBand;

    @Getter @Setter
    double pl;
}
