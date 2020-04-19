package com.guoge.starter;

public class HelloService {
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloGuoge(String name){
        return name +"-" + helloProperties.getPrefix();
    }
}
