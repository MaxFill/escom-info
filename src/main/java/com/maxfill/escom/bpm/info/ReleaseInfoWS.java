package com.maxfill.escom.bpm.info;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/release_info")
public class ReleaseInfoWS {

    @OnMessage
    public String onMessage(String message) {
        System.out.println("message=" + message);
        ActualRelease actualRelease = new ActualRelease();        
        return actualRelease.toJSON();
    }
    
}
