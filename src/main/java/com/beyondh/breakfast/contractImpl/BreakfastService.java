package com.beyondh.breakfast.contractImpl;

import com.beyondh.breakfast.contract.IBreakfastService;
import com.beyondh.breakfast.interceptor.RequestCallContext;
import com.beyondh.breakfast.network.Model.BreakfastInfoModel;
import com.beyondh.breakfast.network.Model.EatBreakfastModel;
import com.beyondh.breakfast.network.Model.HotelBreakfastSummaryModel;
import com.beyondh.breakfast.network.Model.PmsResultModel;
import com.beyondh.breakfast.network.PmsRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * Created by jliang on 7/24/2017.
 */
@Service
public class BreakfastService implements IBreakfastService {

    @Autowired
    private PmsRestClient pmsRestClient;

    @Autowired
    private RequestCallContext requestCallContext;

    @Override
    public HotelBreakfastSummaryModel GetHotelBreakfastSummary() {
        ParameterizedTypeReference<PmsResultModel<HotelBreakfastSummaryModel>> typeRef = new ParameterizedTypeReference<PmsResultModel<HotelBreakfastSummaryModel>>() { };
        PmsResultModel<HotelBreakfastSummaryModel> result = pmsRestClient.GetClient().exchange(requestCallContext.GetUser().getUrl()+"/API/Breakfast/GetCurrentBusinessDateBreakfastStatistics?isOnlySearchUsedCount=false", HttpMethod.GET, null, typeRef).getBody();
        if (result.getCode() != 0) {
            throw new IllegalArgumentException(result.getMessage());
        }

        return result.getContent();
    }

    @Override
    public Boolean EatBreakfast(EatBreakfastModel eatBreakfastModel) {
        ParameterizedTypeReference<PmsResultModel<Boolean>> typeRef = new ParameterizedTypeReference<PmsResultModel<Boolean>>() { };
        PmsResultModel<Boolean> result = pmsRestClient.GetClient().exchange(requestCallContext.GetUser().getUrl()+"/API/Breakfast/EatBreakfastWithRoomNo", HttpMethod.POST, new HttpEntity<EatBreakfastModel>(eatBreakfastModel), typeRef).getBody();
        if (result.getCode() != 0) {
            throw new IllegalArgumentException(result.getMessage());
        }

        return result.getContent();
    }

    @Override
    public BreakfastInfoModel GetBreakfastInfo(String roomNumber) {
        String queryUrl = String.format(requestCallContext.GetUser().getUrl()+"/API/Breakfast/GetBreakfastInfo?Number=%s&SearchType=RoomNumber", roomNumber);
        ParameterizedTypeReference<PmsResultModel<BreakfastInfoModel>> typeRef = new ParameterizedTypeReference<PmsResultModel<BreakfastInfoModel>>() { };
        PmsResultModel<BreakfastInfoModel> result = pmsRestClient.GetClient().exchange(queryUrl, HttpMethod.GET, null, typeRef).getBody();
        if (result.getCode() != 0) {
            throw new IllegalArgumentException(result.getMessage());
        }

        return result.getContent();
    }
}
