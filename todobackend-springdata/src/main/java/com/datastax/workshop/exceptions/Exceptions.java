package com.datastax.workshop.exceptions;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class Exceptions {

    private String rundate;
    private String errorcode;
    private String timestamp;
    private String eventtype;
    private String firmroeid;
    private String txnkey;
    private String quantity;
    private String price;

    
    public Exceptions() {}
    
    public Exceptions(String rundate, String errorcode, String timestamp, String eventtype, String firmroeid, String txnkey, String quantity, String price) {
        this.rundate = rundate;
        this.errorcode = errorcode;
        this.timestamp = timestamp;
        this.eventtype = eventtype;
        this.firmroeid = firmroeid;
        this.txnkey = txnkey;
        this.quantity = quantity;
        this.price = price;
    }
    
    
}

