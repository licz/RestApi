package org.test.voyanta.utils.dto;

/**
 * Created by lich on 2015-04-03.
 */
public class PageDTO {
    private Integer number;
    private Long miliseconds;

    public Long getMiliseconds() {
        return miliseconds;
    }

    public void setMiliseconds(Long miliseconds) {
        this.miliseconds = miliseconds;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
