package agiletravel.dai.utils;

import java.util.Map;

public class MessageTemplate {
    private String touser;
    private String template_id;
//    private String page;
    private String form_id;
    private Map<String, Map> data;
//    private String emphasis_keyword;

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }



    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public void setData(Map<String, Map> data) {
        this.data = data;
    }

}
