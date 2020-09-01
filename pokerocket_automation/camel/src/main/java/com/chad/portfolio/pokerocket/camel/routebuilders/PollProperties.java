package com.chad.portfolio.pokerocket.camel.routebuilders;

public class PollProperties {

    private Integer pollPeriod;
    private Integer pollDelay;
    private Integer pollRepeatCount;

    public Integer getPollPeriod() {
        return pollPeriod;
    }

    public void setPollPeriod(Integer pollPeriod) {
        this.pollPeriod = pollPeriod;
    }

    public Integer getPollDelay() {
        return pollDelay;
    }

    public void setPollDelay(Integer pollDelay) {
        this.pollDelay = pollDelay;
    }

    public Integer getPollRepeatCount() {
        return pollRepeatCount;
    }

    public void setPollRepeatCount(Integer pollRepeatCount) {
        this.pollRepeatCount = pollRepeatCount;
    }

    public PollProperties pollPeriod(Integer pollPeriod) {
        this.pollPeriod = pollPeriod;
        return this;
    }

    public PollProperties pollDelay(Integer pollDelay) {
        this.pollDelay = pollDelay;
        return this;
    }

    public PollProperties pollRepeatCount(Integer pollRepeatCount) {
        this.pollRepeatCount = pollRepeatCount;
        return this;
    }

}
