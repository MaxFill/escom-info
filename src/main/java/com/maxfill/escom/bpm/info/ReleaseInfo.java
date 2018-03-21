package com.maxfill.escom.bpm.info;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.commons.lang3.StringUtils;

@WebService(serviceName = "ReleaseInfo")
public class ReleaseInfo {

    @WebMethod(operationName = "getReleaseInfo")
    public String getReleaseInfo(@WebParam(name = "licenceNumber") String licenceNumber) {
        if (StringUtils.isBlank(licenceNumber)){
            throw new NullPointerException("ERROR: licenceNumber is null!");
        }        
        ActualRelease actualRelease = new ActualRelease();        
        return actualRelease.toJSON();
    }
}