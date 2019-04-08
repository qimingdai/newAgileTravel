package agiletravel.dai.utils;

import lombok.Data;


@Data
public class Response<T> {
    private int success;
    private T content;

    public Response(int code, T data) {
        this.success = code;
        this.content = data;
    }

    public Response(){}


}
