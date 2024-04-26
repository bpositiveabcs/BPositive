package bpos.networking.rpc;

import java.io.Serializable;

public class Response implements Serializable {
    private ResponseType type;
    private Object data;
    private Object data2;
    private Object data3;

    private Response(){};

    public ResponseType type(){
        return type;
    }

    public Object data(){
        return data;
    }
    public Object data3(){
        return data3;
    }
    public Object data2(){
        return data2;
    }

    private void type(ResponseType type){
        this.type=type;
    }

    private void data(Object data){
        this.data=data;
    }
    private void data2(Object data2){
        this.data2=data2;
    }
    private void data3(Object data3){
        this.data3=data3;
    }

    @Override
    public String toString(){
        return "Response{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }


    public static class Builder{
        private Response response=new Response();

        public Builder type(ResponseType type) {
            response.type(type);
            return this;
        }

        public Builder data(Object data) {
            response.data(data);
            return this;
        }
        public Builder data2(Object data2) {
            response.data2(data2);
            return this;
        }
        public Builder data3(Object data3) {
            response.data3(data3);
            return this;
        }

        public Response build() {
            return response;
        }
    }

}