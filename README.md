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
