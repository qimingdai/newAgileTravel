package agiletravel.dai.reconst.success;

public enum DiarySuccess {
    RELEASE_DIARY_SUCCESS("发表游记成功"),
    DELETE_DIARY_SUCCESS("删除游记成功")
    ;
    private String data;

    DiarySuccess(String data) {
        this.data = data;
    }
}
