package com.ruoyi.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/2/23 5:06 PM
 */
@Api(tags = "测试")
@RestController
@RequestMapping("/api/v2/health")
public class TestNewController {

    @GetMapping("/check")
    @ApiOperation("健康检查")
    public String health() {
        return "health!!！";
    }

    void test(){
        ExecutorService executor = new ThreadPoolExecutor(1, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());
    }

    public int trailingZeroes(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 1; i <= n; i++) {
            int tmp = i;
            int count = 0;
            while(tmp % 5 == 0){
                if(map.get(tmp) != null) {
                    count += map.get(tmp);
                    break;
                }
                count++;
                tmp /= 5;
            }
            if(i % 5 == 0) {
                max += count;
                map.put(i, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TestNewController t = new TestNewController();
        System.out.println(t.trailingZeroes(25));
    }
}
