package com.beyondh.breakfast.contract;

import com.beyondh.breakfast.network.Model.BreakfastInfoModel;
import com.beyondh.breakfast.network.Model.EatBreakfastModel;
import com.beyondh.breakfast.network.Model.HotelBreakfastSummaryModel;

/**
 * Created by jliang on 7/24/2017.
 */
public interface  IBreakfastService {

    /**
     *
     * 查询早餐汇总数据信息 如酒店早餐总份数，剩余份数等
     * @return
     */
    HotelBreakfastSummaryModel GetHotelBreakfastSummary();

    /**
     * 吃早餐
     * @param eatBreakfastModel 吃早餐详情
     * @return
     */
    Boolean EatBreakfast(EatBreakfastModel eatBreakfastModel);

    /**
     * 根据房号获取某一房间早餐信息
     * @param roomNumber
     * @return
     */
    BreakfastInfoModel GetBreakfastInfo(String roomNumber);
}
