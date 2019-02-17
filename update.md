- 提交接口更新：接口为post:   /reportInsert所需参数为：
     ``` 
             Date date;//日期
             String opName;//操作员
             @RequestParam("multipartFile") MultipartFile[] multipartFiles;
             List<String> measurementValue;
     ```
   返回值为json：status为成功与否标志1成功0失败
    ```
               {"status":1,"msg":"report保存成功，可以进行图片上传！"
                  ,"exception":"1","timestamp":"2019-02-17 10:18:55"}
    ```
- 