# 总结

### 请求数据格式 

    1、application/json 
        请求参数格式为request payload
        
    2、application/x-www-form-urlencoded
        请求参数格式为form data

### @RequestBody注解使用
    @RequestBody用于将请求参数转换为javabean对象。
    注意：请求参数必须为json格式的字符串，可以使用JSON.stringify(jsonDataObj)转换。
    
### 参数校验异常类
    #MethodArgumentNotValidException
       使用@requestBody注解参数校验时触发该异常。
    
    #BindException
        请求参数为json对象时，不需要使用@RequestBody注解，直接将json对象转换为VO对象进行参数校验，如果校验失败，触发该异常。
    
    #ConstraintViolationException
        使用@requestParm注解参数校验时触发该异常。