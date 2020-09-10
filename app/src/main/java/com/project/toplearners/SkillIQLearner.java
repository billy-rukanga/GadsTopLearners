package com.project.toplearners;

public class SkillIQLearner {

    private String name;
    private int score;
    private String country;
    private String badgeUrl;

    public SkillIQLearner(String name, int score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getCountry(){
        return country;
    }

    public String getBadgeUrl(){
        return badgeUrl;
    }

}
