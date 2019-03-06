package agiletravel.dai.utils;

public class Response<T> {
    private int code;
    private T data;

    public Response(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Response() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }
}
