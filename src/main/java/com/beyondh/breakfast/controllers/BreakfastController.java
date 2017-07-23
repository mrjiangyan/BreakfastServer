package com.beyondh.breakfast.controllers;

import com.beyondh.breakfast.contract.IBreakfastService;
import com.beyondh.breakfast.model.common.ApiResponse;
import com.beyondh.breakfast.network.Model.BreakfastInfoModel;
import com.beyondh.breakfast.network.Model.EatBreakfastModel;
import com.beyondh.breakfast.network.Model.HotelBreakfastSummaryModel;
import com.beyondh.breakfast.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by BeyondHost on 7/18/2017.
 */
@RestController
@RequestMapping("/breakfast")
public class BreakfastController extends BaseController {

    @Autowired
    private IBreakfastService breakfastService;


    @RequestMapping(value = "/get/summary", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<HotelBreakfastSummaryModel> GetSummaryInfo() {
        ApiResponse<HotelBreakfastSummaryModel> result = new ApiResponse<>();
        try {
            result.setData(breakfastService.GetHotelBreakfastSummary());
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception,result);
        }

        return result;
    }

    @RequestMapping(value = "/eat", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse<Boolean> Eat(@RequestBody EatBreakfastModel eatBreakfastModel){
        ApiResponse<Boolean> result = new ApiResponse<Boolean>();
        try {
            result.setData(breakfastService.EatBreakfast(eatBreakfastModel));
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception,result);
        }

        return result;
    }

    @RequestMapping(value ="/mybreakfast",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<BreakfastInfoModel> GetBreakfastInfo(String roomNumber)
    {
        ApiResponse<BreakfastInfoModel> result = new ApiResponse<BreakfastInfoModel>();
        try {
            result.setData(breakfastService.GetBreakfastInfo(roomNumber));
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception,result);
        }

        return result;
    }
}
