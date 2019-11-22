package com.pc.test.springcloud.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pc.test.springcloud.api.domain.TsysFile;


@RestController
public class FileController_Consumer
{
    
	private static final String REST_URL_PREFIX = "http://localhost:8001";
	//private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
    private DiscoveryClient client;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<TsysFile> list()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery()
	{
		List<String> list=client.getServices();
	    System.out.println("*****"+list);
	    List<ServiceInstance> instances=client.getInstances("microservicecloud-eureka-provider8002");
	    for(ServiceInstance element:instances) {
	    	System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
	    }
		return this.client;
	}

}
