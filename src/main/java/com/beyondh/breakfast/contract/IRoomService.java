package com.beyondh.breakfast.contract;

import com.beyondh.breakfast.network.Model.RoomModel;

import java.util.List;

/**
 * Created by jliang on 7/31/2017.
 */
public interface IRoomService {
    List<RoomModel> GetRoomsByRoomNumber(String roomNumber);
}
