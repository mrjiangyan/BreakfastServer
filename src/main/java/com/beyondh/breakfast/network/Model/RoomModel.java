package com.beyondh.breakfast.network.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jliang on 7/31/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomModel {

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    @JsonProperty("RoomNumber")
    private String roomNumber;

    @JsonProperty("RoomTypeId")
    private String roomTypeId;

    @JsonProperty("RoomTypeName")
    private String roomTypeName;
}
