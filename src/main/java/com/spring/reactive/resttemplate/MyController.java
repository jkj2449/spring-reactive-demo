package com.spring.reactive.resttemplate;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class MyController {
    AsyncRestTemplate rt = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(
            new NioEventLoopGroup(1)
    ));

    @GetMapping("/rest")
    public DeferredResult<String> rest() {
        DeferredResult<String> dr = new DeferredResult<>();

        ListenableFuture<ResponseEntity<String>> lf = rt.getForEntity("http://localhost:8081/service", String.class);

        lf.addCallback(
                s -> dr.setResult(s.getBody() + "/work")
                ,e -> dr.setErrorResult(e.getMessage()));

        return dr;
    }
}
