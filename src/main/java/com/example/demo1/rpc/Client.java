//package com.example.demo1.rpc;
//
//import org.apache.catalina.Server;
//
//public class Client {
//
//    public static void main(String[] args) {
//        //调用一次远程服务
//        Server server = new Server("127.0.0.1",9999);
//        server.doConnect();
//        Object sendResponse = server.doRef("sendSms","这是一条短信信息",10001);
//        System.out.println(sendResponse);
//    }
//
//}