# 测试API


<a name="overview"></a>
## 概览
测试API


### URI scheme
*域名* : localhost:8090  
*基础路径* : /


### 标签

* my-controller : My Controller
* test-controller : Test Controller




<a name="paths"></a>
## 资源

<a name="my-controller_resource"></a>
### My-controller
My Controller


<a name="getusersbyidusingget"></a>
#### 根据id查询用户
```
GET /v1/users/{userId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**userId**  <br>*必填*|userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[userVo](#uservo)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/users/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "age" : 0,
  "userId" : "string",
  "userName" : "string"
}
```


<a name="test-controller_resource"></a>
### Test-controller
Test Controller


<a name="echousingget"></a>
#### echo
```
GET /echo/{str}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**str**  <br>*必填*|str|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/echo/string
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```




<a name="definitions"></a>
## 定义

<a name="uservo"></a>
### userVo

|名称|说明|类型|
|---|---|---|
|**age**  <br>*可选*|用户年纪  <br>**样例** : `0`|integer (int32)|
|**userId**  <br>*可选*|用户id  <br>**样例** : `"string"`|string|
|**userName**  <br>*可选*|用户名  <br>**样例** : `"string"`|string|





