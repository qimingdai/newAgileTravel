package agiletravel.dai.reconst.success;

public enum NoticeSuccess {
    INSERT_NOTICE_SUCCESS("发表通知成功"),
    DELETE_NOTICE_SUCCESS("删除通知成功")
    ;
    private String Data;

    public String getData() {
        return Data;
    }

    NoticeSuccess(String data) {
        Data = data;
    }
}
