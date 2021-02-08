package com.datastax.workshop.exceptions;

import java.sql.Timestamp;
import java.text.DateFormat;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = ExceptionsEntity.TABLENAME)
public class ExceptionsEntity {

    public static String TABLENAME = "exceptions";
    public static String COLUMN_RUNDATE = "rundate";
    public static String COLUMN_ERRORCODE = "errorcode";
    public static String COLUMN_TIMESTAMP = "timestamp";
    public static String COLUMN_EVENTTYPE = "eventtype";
    public static String COLUMN_FIRMROEID = "firmroeid";
    public static String COLUMN_TXNKEY = "txnkey";
    public static String COLUMN_QUANTITY = "quantity";
    public static String COLUMN_PRICE = "price";


    @PrimaryKey
    @Column(COLUMN_RUNDATE)
    @CassandraType(type = Name.TEXT)
    private String rundate;

    @PrimaryKey
    @Column(COLUMN_ERRORCODE)
    @CassandraType(type = Name.TEXT)
    private String errorcode;

    @Column(COLUMN_TIMESTAMP)
    @CassandraType(type = Name.TEXT)
    private String timestamp;

    @Column(COLUMN_EVENTTYPE)
    @CassandraType(type = Name.TEXT)
    private String eventtype;

    @Column(COLUMN_FIRMROEID)
    @CassandraType(type = Name.TEXT)
    private String firmroeid;

    @Column(COLUMN_TXNKEY)
    @CassandraType(type = Name.TEXT)
    private String txnkey;

    @Column(COLUMN_QUANTITY)
    @CassandraType(type = Name.TEXT)
    private String quantity;

    @Column(COLUMN_PRICE)
    @CassandraType(type = Name.TEXT)
    private String price;


    public ExceptionsEntity(String rundate, String errorcode, String timestamp, String eventtype, String firmroeid,
     String txnkey, String quantity, String price){
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








