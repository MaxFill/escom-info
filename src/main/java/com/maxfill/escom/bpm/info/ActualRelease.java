package com.maxfill.escom.bpm.info;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ActualRelease implements Serializable{
    private static final long serialVersionUID = 8047333907746200457L;
    
    public static final String RELEASE_VERSION = "1.01";
    public static final String RELEASE_NUMBER = "001";
    public static final String RELEASE_DATE = "2017-06-01";
    public static final String RELEASE_PAGE = "https://https://escom-archive.ru/#blogPage";

    private String number;
    private String date;
    private String page;
    private String version;

    public ActualRelease() {
        this.number = RELEASE_NUMBER;
        this.date = RELEASE_DATE;
        this.page = RELEASE_PAGE;
        this.version = RELEASE_VERSION;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }   
    
    public String toJSON(){
        ObjectMapper mapper = new ObjectMapper();
        String retVal = "";
        try {
            retVal = mapper.writeValueAsString(this);            
        } catch (IOException ex) {
            Logger.getLogger(ReleaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retVal;
    }
    
}
