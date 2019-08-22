package com.example.calorietrackerapp;

public class Food {

    private Integer foodId;

    private String foodCatogory;

    private int foodCalorie;

    private String servingUnit;

    private int fat;

    private String foodName;

    private Double servingAmount;

    public Food() {


    }

    public Food(Integer foodId) {
        this.foodId = foodId;
    }

    public Food (Integer foodId, String foodCatogory, int foodCalorie, String servingUnit, int fat, Double servingAmount) {
        this.foodId = foodId;
        this.foodCatogory = foodCatogory;
        this.foodCalorie = foodCalorie;
        this.servingUnit = servingUnit;
        this.fat = fat;
        this.servingAmount = servingAmount;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodCatogory() {
        return foodCatogory;
    }

    public void setFoodCatogory(String foodCatogory) {
        this.foodCatogory = foodCatogory;
    }

    public int getFoodCalorie() {
        return foodCalorie;
    }

    public void setFoodCalorie(int foodCalorie) {
        this.foodCalorie = foodCalorie;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getServingAmount() {
        return servingAmount;
    }

    public void setServingAmount(Double servingAmount) {
        this.servingAmount = servingAmount;
    }

}
