package com.beyondh.breakfast.controllers;

import com.beyondh.breakfast.contract.IRoomService;
import com.beyondh.breakfast.model.common.ApiResponse;
import com.beyondh.breakfast.network.Model.RoomModel;
import com.beyondh.breakfast.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jliang on 7/31/2017.
 */
@RestController
@RequestMapping("/room")
public class RoomController extends BaseController {

    @Autowired
    private IRoomService roomService;

    @RequestMapping(value = "/getRoomsByRoomNumber", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<List<RoomModel>> GetAvailiableOrgsByUser(String roomNumber) {
        ApiResponse<List<RoomModel>> result = new ApiResponse<>();
        try {
            result.setData(roomService.GetRoomsByRoomNumber(roomNumber));
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception,result);
        }

        return result;
    }
}
