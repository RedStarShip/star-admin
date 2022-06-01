package com.star.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminDTO {
    @JsonProperty("name")
    private String username;
    private String avatar;

    public AdminDTO(String name, String avatar) {
        this.username = name;
        this.avatar = avatar;
    }

    public AdminDTO() {
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


}
