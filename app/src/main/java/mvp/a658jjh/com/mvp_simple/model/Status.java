package mvp.a658jjh.com.mvp_simple.model;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright © 2017 Fly Việt Technology
 *
 * @author Thanh Thien
 *         Created on 11/29/2017
 */
public class Status {
    @SerializedName("code")
    int code;
    @SerializedName("message")
    String message;

    public Status() {
    }

    private int getCode() {
        return code;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    public String getMessage() {
        return message;
    }
}
