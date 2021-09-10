package models;

public class Response {
    private String description;
    private Boolean success;
    private Object object;

    public Response(String description, Boolean success, Object object) {
        this.description = description;
        this.success = success;
        this.object = object;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Response{" +
                "description='" + description + '\'' +
                ", success=" + success +
                ", object=" + object +
                '}';
    }
}
