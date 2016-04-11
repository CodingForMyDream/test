package com.qun.myAnnotation;

import com.qun.myAnnotation.FruitColor.Color;

public class Apple {
	
	@FruitName(fruitName = "Banana")
    private String appleName;
	
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;
	
	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
	
	@Override
	public String toString() {
		return this.appleColor + this.appleName;
	}
	
	public static void main(String[] args) {
		Apple apple = new Apple();
		apple.setAppleName("苹果");
		System.out.println(apple);
	}
}
