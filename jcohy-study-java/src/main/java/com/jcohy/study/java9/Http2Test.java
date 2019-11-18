//package com.jcohy.study.java9;
//
//import jdk.incubator.http.HttpClient;
//import jdk.incubator.http.HttpRequest;
//import jdk.incubator.http.HttpResponse;
//
//import java.io.IOException;
//import java.net.URI;
//
///**
// * Copyright: Copyright (c) 2019 www.xuanwuai.cn
// *
// * @author jiac
// * @version v1.0.0
// * @Description: TODO 请添加该类的功能描述
// * @date 2019/10/31 15:12
// * <p>
// * Modification History:
// * Date         Author          Version            Description
// * ----------------------------------------------------------------------------------*
// * 2019/10/31      jiac           v1.0.0               修改原因
// */
//
//
//public class Http2Test {
//    public void test1() throws IOException, InterruptedException {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest req = HttpRequest.newBuilder(URI.create("http://www.atguigu.com")) .GET() .build();
//        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandler.asString());
//        System.out.println(response.statusCode());
//        System.out.println(response.version().name());
//        System.out.println(response.body());
//    }
//}
