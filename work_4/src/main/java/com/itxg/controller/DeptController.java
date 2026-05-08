package com.itxg.controller;

import com.itxg.entity.Dept;
import com.itxg.result.Result;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/depts")
public class DeptController {

    private static final List<Dept> deptList = new ArrayList<>();

    private static final AtomicInteger idGenerator = new AtomicInteger(3);

    static {
        deptList.add(new Dept(1, "研发部", LocalDateTime.now(), LocalDateTime.now(), null));
        deptList.add(new Dept(2, "市场部", LocalDateTime.now(), LocalDateTime.now(), null));
        deptList.add(new Dept(3, "财务部", LocalDateTime.now(), LocalDateTime.now(), null));
    }

    /**
     * 查询所有部门
     * GET /depts
     */
    @GetMapping
    public Result list() {
        return Result.success(deptList);
    }

    /**
     * 新增部门
     * POST /depts
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {

        dept.setId(idGenerator.incrementAndGet());
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptList.add(dept);

        return Result.success(dept);
    }

    /**
     * 修改部门
     * PUT /depts
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {

        for (Dept oldDept : deptList) {
            if (oldDept.getId().equals(dept.getId())) {

                oldDept.setName(dept.getName());
                oldDept.setLogo(dept.getLogo());
                oldDept.setUpdateTime(LocalDateTime.now());

                return Result.success(oldDept);
            }
        }

        return Result.error("部门不存在");
    }

    /**
     * 删除部门
     * DELETE /depts/{id}
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {

        Iterator<Dept> iterator = deptList.iterator();

        while (iterator.hasNext()) {
            Dept dept = iterator.next();

            if (dept.getId().equals(id)) {
                iterator.remove();
                return Result.success("删除成功");
            }
        }

        return Result.error("部门不存在");
    }
}