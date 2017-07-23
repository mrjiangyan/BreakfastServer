package com.beyondh.breakfast.network.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jliang on 7/20/2017.
 */
public class HotelBreakfastSummaryModel {

    public int getBreakfastTotalCount() {
        return breakfastTotalCount;
    }

    public void setBreakfastTotalCount(int breakfastTotalCount) {
        this.breakfastTotalCount = breakfastTotalCount;
    }

    public int getBreakfastUseCount() {
        return breakfastUseCount;
    }

    public void setBreakfastUseCount(int breakfastUseCount) {
        this.breakfastUseCount = breakfastUseCount;
    }

    public int getTotalAvailableBreakfastCount() {
        return totalAvailableBreakfastCount;
    }

    public void setTotalAvailableBreakfastCount(int totalAvailableBreakfastCount) {
        this.totalAvailableBreakfastCount = totalAvailableBreakfastCount;
    }

    /// <summary>
    /// 早餐总数量
    /// </summary>
    @JsonProperty("BreakfastTotalCount")
    private int breakfastTotalCount;

    /// <summary>
    /// 早餐使用数量
    /// </summary>
    @JsonProperty("BreakfastUseCount")
    private int breakfastUseCount;

    /// <summary>
    /// 总的可用早餐分数
    /// </summary>
    @JsonProperty("TotalAvailableBreakfastCount")
    private int totalAvailableBreakfastCount;
}
