package com.datastax.workshop.exceptions;

import com.datastax.workshop.todo.Todo;
import org.springframework.boot.context.properties.bind.handler.IgnoreTopLevelConverterNotFoundBindHandler;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Table(value = ExceptionsEntity.TABLENAME)
public class ExceptionsEntity {

    public static final String TABLENAME = "exceptions";
    public static final String COLUMN_RUNDATEERRORCODE = "rundateerrorcode";
    public static final String COLUMN_EVENTTYPE = "eventtype";
    public static final String COLUMN_FIRMROEID = "firmroeid";
    public static final String COLUMN_TXNKEY = "txnkey";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_CREATEDTIMESTAMP = "createdtimestamp";
    public static final String COLUMN_URL = "url";



    @PrimaryKey
    @Column(COLUMN_RUNDATEERRORCODE)
    @CassandraType(type = Name.TEXT)
    private String rundateerrorcode;

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
    @CassandraType(type = Name.DOUBLE)
    private double quantity;

    @Column(COLUMN_PRICE)
    @CassandraType(type = Name.DOUBLE)
    private double price;

    @Column(COLUMN_CREATEDTIMESTAMP)
    @CassandraType(type = Name.TIMESTAMP)
    private Timestamp createdtimestamp;

    @Column(COLUMN_URL)
    @CassandraType(type = Name.TEXT)
    private String url;

    public ExceptionsEntity setUrl(HttpServletRequest req) {
        if (url == null) {
            String reqUrl = req.getRequestURL().toString();
            url = reqUrl.contains("gitpod") ? reqUrl.replaceAll("http", "https") : reqUrl;
        }
        return this;
    }

    public ExceptionsEntity(String rundateerrorcode, String eventtype, String firmroeid,
     String txnkey, double quantity, double price, Timestamp createdtimestamp, String url){
        this.rundateerrorcode = rundateerrorcode;
        this.eventtype = eventtype;
        this.firmroeid = firmroeid;
        this.txnkey = txnkey;
        this.quantity = quantity;
        this.price = price;
        this.createdtimestamp = createdtimestamp;
        this.url = url;
    }

}








