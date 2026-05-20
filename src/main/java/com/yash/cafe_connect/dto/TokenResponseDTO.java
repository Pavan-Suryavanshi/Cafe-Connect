package com.yash.cafe_connect.dto;

import java.time.LocalDate;

public class TokenResponseDTO {

    private Integer tokenNumber;
    private String userName;
    private String thaliType;
    private Double price;
    private Boolean paid;
    private LocalDate date;

    public TokenResponseDTO() {
    }

    public TokenResponseDTO(Integer tokenNumber,
                            String userName,
                            String thaliType,
                            Double price,
                            Boolean paid,
                            LocalDate date) {

        this.tokenNumber = tokenNumber;
        this.userName = userName;
        this.thaliType = thaliType;
        this.price = price;
        this.paid = paid;
        this.date = date;
    }

    public Integer getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(Integer tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getThaliType() {
        return thaliType;
    }

    public void setThaliType(String thaliType) {
        this.thaliType = thaliType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}