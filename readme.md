- **接口说明**
  - 提交接口：
       - 第一步：先提交report，接口为post:   /reportInsert所需参数为：
         ``` 
         Date date;//日期
         String opName;//操作员
         ```
         插入完成返回统一的json数据：status为成功与否的标志,
         此json中的exception的值为插入成功时report的id，在进行图片上传时需要回传
         ```
         {"status":1,"msg":"report保存成功，可以进行图片上传！"
            ,"exception":"1","timestamp":"2019-02-17 10:18:55"}
         ```
         
       - 第二步：返回数据成功后进行图片上传，接口为post：/multiUpload
         所需参数为：
         ```
         @RequestParam("multipartFile") MultipartFile[] multipartFiles;
         int reportId;
          List<String> measurementValue;
         ```此接口返回的数据也是通用json，status为成功与否的标志
  - 用户接口
    - 登陆
      - 接口为post：/login
      参数为：
      ```
          String userName;//用户名
          String passWord;//密码
          String uniqueCode;//唯一设备值
      ```
      返回值为json：
      ```
      {"status":1,"msg":"成功"
              ,"exception":"1","timestamp":"2019-02-17 10:18:55"}
      ```
    - 注册
      - 接口post：/register
      参数为：
      ```
       String userName;//用户名
                String passWord;//密码
                String uniqueCode;//唯一设备值
      ```
       返回值为json：
            ```
            {"status":1,"msg":"成功"
                    ,"exception":"1","timestamp":"2019-02-17 10:18:55"}
            ```