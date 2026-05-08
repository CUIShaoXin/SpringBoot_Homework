package com.itxg.controller;

import com.itxg.config.AppProperties;
import com.itxg.entity.Emp;
import com.itxg.exception.EmpNotFoundException;
import com.itxg.exception.ParamInvalidException;
import com.itxg.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private AppProperties appProperties;


    private static final List<Emp> empList = new ArrayList<>();

    static {
        empList.add(new Emp(1, "张三", "男", 101));
        empList.add(new Emp(2, "李四", "女", 102));
        empList.add(new Emp(3, "王五", "男", 101));
        empList.add(new Emp(4, "赵六", "女", 103));
        empList.add(new Emp(5, "孙七", "男", 102));
        empList.add(new Emp(6, "周八", "女", 101));
        empList.add(new Emp(7, "吴九", "男", 103));
    }

    /**
     * 员工分页查询
     * GET /emps/page?page=1&pageSize=5
     */
    @GetMapping("/emps/page")
    public Result page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false) Integer pageSize) {

        if (page == null || page <= 0) {
            throw new ParamInvalidException("页码必须大于0");
        }

        if (pageSize == null) {
            pageSize = appProperties.getDefaultPageSize();
        }

        if (pageSize <= 0) {
            throw new ParamInvalidException("页大小必须大于0");
        }

        int start = (page - 1) * pageSize;

        if (start >= empList.size()) {
            throw new EmpNotFoundException("员工数据不存在");
        }

        int end = Math.min(start + pageSize, empList.size());

        List<Emp> pageData = empList.subList(start, end);

        return Result.success(pageData);
    }
}