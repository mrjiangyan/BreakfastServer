package com.beyondh.breakfast.controllers;

import com.beyondh.breakfast.contract.IOrgService;
import com.beyondh.breakfast.model.auth.UserModel;
import com.beyondh.breakfast.model.common.ApiResponse;
import com.beyondh.breakfast.network.Model.OrgInfoModel;
import com.beyondh.breakfast.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jliang on 7/31/2017.
 */
@RestController
@RequestMapping("/org")
public class OrgController extends BaseController{

    @Autowired
    private IOrgService orgService;

    @RequestMapping(value = "/availiableOrgs", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<OrgInfoModel[]> GetAvailiableOrgsByUser() {
        ApiResponse<OrgInfoModel[]> result = new ApiResponse<>();
        try {
            result.setData(orgService.GetAvailiableOrgsByUser());
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception,result);
        }

        return result;
    }

    @RequestMapping(value = "/changeOrg", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<UserModel> ChangeOrg() {
        ApiResponse<UserModel> result = new ApiResponse<>();
        UserModel userModel =null;
        try {
            result.setData(orgService.ChangeOrg());
        } catch (Exception exception) {
            return ExceptionUtils.HandleException(exception,result);
        }

        return result;
    }
}
