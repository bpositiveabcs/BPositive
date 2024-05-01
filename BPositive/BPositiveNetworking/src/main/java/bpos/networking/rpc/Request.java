package bpos.networking.rpc;

import java.io.Serializable;

public class Request implements Serializable {
    private RequestType type;
    private Object data;
    private Object data2;

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    private Request(){}

    public RequestType type(){
        return type;
    }

    public Object data(){
        return data;
    }
    public Object data2(){
        return data2;
    }


    @Override
    public String toString() {
        return "Request{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }


    public static class Builder {
        private Request request = new Request();

        public Builder type(RequestType type) {
            request.type(type);
            return this;
        }

        public Builder data(Object data) {
            request.data(data);
            return this;
        }
        public Builder data2(Object data2) {
            request.data2(data2);
            return this;
        }


        public Request build() {
            return request;
        }
    }

    private void data(Object data) {
        this.data = data;
    }
    private void data2(Object data2) {
        this.data2 = data2;
    }

    private void type(RequestType type) {
        this.type = type;
    }

}