package com.example.e_commerce.Model;

public class Order {

    private int order_id, user_id;
    private String date, address, feedback;
    private double rate;
    private Order(Builder builder) {
        this.order_id = builder.order_id;
        this.user_id = builder.user_id;
        this.date = builder.date;
        this.address = builder.address;
        this.feedback = builder.feedback;
        this.rate = builder.rate;
    }

    // TODO: BUILDER DESIGN PATTERN
    public static class Builder {
        private int order_id, user_id;
        private String date, address, feedback;
        private double rate;

        public Builder(int user_id, String date, String address) {
            this.user_id = user_id;
            this.date = date;
            this.address = address;
        }

        public Builder order_id(int order_id) {
            this.order_id = order_id;
            return this;
        }

        public Builder feedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public Builder rate(double rate) {
            this.rate = rate;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
