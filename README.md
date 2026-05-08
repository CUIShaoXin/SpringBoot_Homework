第 1 套：初级（SpringBoot 入门 + HTTP 协议 + Tomcat）
一、业务场景
开发一个“图书服务入门接口”，用于完成 SpringBoot 项目的快速搭建，并提供最基础的 HTTP 查询和新增接口。

二、题目要求
1. 创建一个 SpringBoot Web 项目；
2. 在配置文件中完成以下配置：
  - 服务端口改为 8081
  - 访问路径前缀设置为 /api
3. 定义 BookController，完成以下接口：
  - GET /api/books/hello：返回字符串 "springboot ok"
  - GET /api/books/{id}：根据 id 返回一本图书信息
  - POST /api/books：接收图书名称、作者、价格，返回新增成功的信息
4. 要求接口返回结果能够通过 Apipost / Postman 正常访问；
5. 图书数据可先使用假数据模拟，不要求接数据库。

第 2 套：中级（请求参数绑定 + 响应结果 + 相关注解）
一、业务场景
开发一个“员工查询与新增接口”，要求后端能够接收不同类型的请求参数，并统一返回 JSON 结果。

二、题目要求
1. 定义员工实体 Emp，字段至少包含：
  - id
  - name
  - gender
  - entryDate
  - deptId
2. 定义统一返回结果类 Result；
3. 编写 EmpController，完成以下接口：
  - GET /emps：根据姓名、部门 id 进行条件查询，其中参数为可选参数
  - GET /emps/{id}：根据路径参数查询员工
  - POST /emps：接收 JSON 格式的员工数据并新增
  - GET /emps/date：接收日期参数，要求正确绑定日期类型
4. 参数绑定要求：
  - 至少使用到 @RequestParam
  - 使用 @PathVariable
  - 使用 @RequestBody
  - 日期参数使用合适的日期格式注解处理
5. 所有接口统一返回 Result 对象。
