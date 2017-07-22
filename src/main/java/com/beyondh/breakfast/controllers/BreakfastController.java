package com.beyondh.breakfast.controllers;

import com.beyondh.breakfast.model.BreakfastInfoModel;
import com.beyondh.breakfast.service.BreakfastService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BeyondHost on 7/18/2017.
 */
@RestController
@RequestMapping("/breakfast")
public class BreakfastController extends BaseController {

    @Autowired
    private BreakfastService breakfastService;

    @RequestMapping(value ="/mybreakfast",method = RequestMethod.GET)
    @ResponseBody
    public BreakfastInfoModel GetBreakfastInfo(String roomNumber)
    {
        BreakfastInfoModel breakfastInfoModel = breakfastService.GetBreakfastInfo(roomNumber);
        return breakfastInfoModel;
    }
}
