package com.itxg.controller;

import com.itxg.entity.Emp;
import com.itxg.result.Result;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {

    private static final List<Emp> empList = new ArrayList<>();

    static {
        empList.add(new Emp(1, "张三", "男", LocalDate.of(2023, 3, 1), 101));
        empList.add(new Emp(2, "李四", "女", LocalDate.of(2022, 7, 15), 102));
        empList.add(new Emp(3, "王五", "男", LocalDate.of(2024, 1, 10), 101));
        empList.add(new Emp(4, "赵六", "女", LocalDate.of(2021, 11, 20), 103));
    }

    /**
     * GET /emps
     * 根据姓名、部门id进行条件查询
     */
    @GetMapping
    public Result list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer deptId) {

        List<Emp> resultList = new ArrayList<>();

        for (Emp emp : empList) {
            boolean nameMatch = name == null || name.isEmpty() || emp.getName().contains(name);
            boolean deptMatch = deptId == null || emp.getDeptId().equals(deptId);

            if (nameMatch && deptMatch) {
                resultList.add(emp);
            }
        }

        return Result.success(resultList);
    }

    /**
     * GET /emps/date
     * 接收日期参数
     */
    @GetMapping("/date")
    public Result date(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryDate) {

        return Result.success("接收到的日期是：" + entryDate);
    }

    /**
     * GET /emps/{id}
     * 根据id查询员工
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {

        for (Emp emp : empList) {
            if (emp.getId().equals(id)) {
                return Result.success(emp);
            }
        }

        return Result.error("没有找到该员工");
    }

    /**
     * POST /emps
     * 接收JSON格式的员工数据并新增
     */
    @PostMapping
    public Result add(@RequestBody Emp emp) {

        empList.add(emp);

        return Result.success(emp);
    }
}