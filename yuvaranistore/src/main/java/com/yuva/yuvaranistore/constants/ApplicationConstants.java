package com.yuva.yuvaranistore.constants;

public class ApplicationConstants {

    private ApplicationConstants() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    public static final String JWT_SECRET_KEY = "JWT_SECRET";
    public static final String JWT_SECRET_DEFAULT_VALUE = "9f5ac5a00f81b2240c021ac314358d609ffb6f181a004107a4dfda8418d6446d8c28dc2b";
    public static final String JWT_HEADER = "Authorization";

    public static final String  ORDER_STATUS_CONFIRMED = "CONFIRMED";
    public static final String  ORDER_STATUS_CREATED = "CREATED";
    public static final String  ORDER_STATUS_CANCELLED = "CANCELLED";
}