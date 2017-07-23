package com.beyondh.breakfast.network.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jliang on 7/22/2017.
 */
public class EatBreakfastModel {
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBreakfastCount() {
        return breakfastCount;
    }

    public void setBreakfastCount(int breakfastCount) {
        this.breakfastCount = breakfastCount;
    }

    /// <summary>
    /// 房号
    /// </summary>
    @JsonProperty("RoomNumber")
    String roomNumber;

    /// 早餐份数
    /// </summary>
    @JsonProperty("BreakfastCount")
    int breakfastCount;

    @Override
    public String toString() {
        return "EatBreakfastModel{" +
                "roomNumber='" + roomNumber + '\'' +
                ", breakfastCount=" + breakfastCount +
                '}';
    }
}
