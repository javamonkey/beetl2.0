## Beetl2.7 中文文档

Beetl作者：李家智 &lt;[xiandafu@126.com](mailto:xiandafu@126.com)&gt;

### 1. 什么是Beetl

Beetl目前版本是2.7.3,相对于其他java模板引擎，具有功能齐全，语法直观,性能超高，以及编写的模板容易维护等特点。使得开发和维护模板有很好的体验。是新一代的模板引擎。总得来说，它的特性如下：

-   功能完备：作为主流模板引擎，Beetl具有相当多的功能和其他模板引擎不具备的功能。适用于*各种应用场景*，从对响应速度有很高要求的大网站到功能繁多的CMS管理系统都适合。Beetl本身还具有很多独特功能来完成模板编写和维护，这是其他模板引擎所不具有的。
-   非常简单：类似Javascript语法和习俗，只要半小时就能通过半学半猜完全掌握用法。拒绝其他模板引擎那种非人性化的语法和习俗。同时也能支持html 标签，使得开发CMS系统比较容易
-   超高的性能：Beetl 远超过主流java模板引擎性能(引擎性能5-6倍与freemaker，2倍于JSP。参考附录），而且消耗较低的CPU。
-   易于整合：Beetl能很容易的与各种web框架整合，如Spring MVC，JFinal，Struts，Nutz，Jodd，Servlet等。
-   支持模板单独开发和测试，即在MVC架构中，即使没有M和C部分，也能开发和测试模板。
-   扩展和个性化：Beetl支持自定义方法，格式化函数，虚拟属性，标签，和HTML标签. 同时Beetl也支持自定义占位符和控制语句起始符号也支持使用者完全可以打造适合自己的工具包。

>   #### 关于性能
>
>   通过与主流模板引擎Freemarker，Vecloity以及JSP对比，Beetl6倍于Freemarker，2倍于JSP。这是因为宏观上，通过了优化的渲染引擎，IO的二进制输出，字节码属性访问增强，微观上，通过一维数组保存上下文Context,静态文本合并处理，通过重复使用字节数组来防止java频繁的创建和销毁数组，还使用模板缓存，运行时优化等方法。详情参考附录

>#### 独特功能
>
>Beetl有些功能是发展了10多年的模板引擎所不具备的，这些功能非常利于模板的开发和维护，如下
>
>1.  自定义占位符和控制语句起始符号，这有利于减小模板语法对模板的倾入性，比如在html模板中，如果定义控制语句符号是`<!--:`和` -->`,那么，大部分模板文件都能通过浏览器打开。有的使用者仅仅采用了单个符号`@` （或者单个符号“`～`”）以及回车换号作为控制语句起始符号，这又能提高开发效率
>2.  可单独测试的模板。无需真正的控制层和模型层，Beetl的模板就可以单独开发和测试
>3.  同时支持较为松散的MVC和严格的MVC，如果在模板语言里嵌入计算表达式，复杂条件表达式，以及函数调用有干涉业务逻辑嫌疑，你可以禁止使用这些语法。
>4.  强大的安全输出，通过安全输出符号！，能在模板变量，变量属性引用，for循环，占位符输出，try-catch中等各个地方提供安全输出，保证渲染正常。
>5.  模板变量：运行将模板的某一部分输出像js那样赋值给一个变量，稍后再处理。利用模板变量能完成非常复杂的页面布局（简单的布局可使用include,layout标签函数) 6. 类型推测，能在运行的时候推测模板变量类型，从而优化性能，也可以通过注解的方法显示的说明模板变量属性（这是非必须的，但有助于IDE自动提示功能） 7. 可插拔的设计，错误信息提示，模板引擎缓存机制，模板资源管理，本地调用的安全管理器,严格MVC限制，模板引擎本身都有默认的实现，但又完全可以自定义以适合特定需求 8. 增强的语法，如for-elsefor, select-case，安全输出符号!,省略的三元表达式 等，这些语法特别适合模板开发 9. 局部渲染技术，结合现在js的ajax技术。 10. 性能超高,具有最快的模板解释引擎，同时，又有较低的CPU消耗。5-6倍于国内使用的Freemaker。适合各类模板应用，如代码生成工具，CMS系统，普通网站，超高访问量的门户系统，和富客户端JS框架整合的后台管理应用

>   #### 小白如何开始
>
>   -   需要通读基本用法，大部分都是讲解语法，而语法跟js很接近，所以可以快速预览，但Beetl是针对模板设计， 所以像安全输出，标签和html标签，全局变量，临时变量和共享变量，布局技术，以及直接调用java代码等还需要认真读一遍。
>   -   如果从事web开发，还需要阅读web集成里的第一节“web提供的全局变量”，如果web里还使用ajax技术，可以阅读“整合ajax的局部渲染技术”。
>   -   包含有spring,jfinal,jodd,struts 等demo可以作为参考学习用 [http://ibeetl.com/community/?/article/4](http://ibeetl.com/community/?/article/4)
>   -   任何问题，都可以在ibeetl.com 社区上提问。目前答复率是100%，提问需要详细说明自己的期望，出错信息，附上代码或者图片

>   #### 联系作者
>
>   作者：闲.大赋 （李家智）等（参考附录查看代码贡献者)
>
>   QQ技术交流群：219324263
>
>   邮件：[xiandafu@126.com](mailto:xiandafu@126.com)
>
>   Beetl社区：[ibeetl.com](http://ibeetl.com)
>
>   源码主页：https://github.com/javamonkey/beetl2.0
>
>   在线体验和代码分享 [http://ibeetl.com:8080/beetlonline/](http://ibeetl.com:8080/beetlonline/)



### 2. 基本用法

#### 2.1. 安装

如果使用maven，请使用如下坐标

```xml
<dependency>
	<groupId>com.ibeetl</groupId>
	<artifactId>beetl</artifactId>
	<version>2.7.0</version>
</dependency>
```

如果非maven工程，直接下载[http://git.oschina.net/xiandafu/beetl2.0/attach_files](http://git.oschina.net/xiandafu/beetl2.0/attach_files)

#### 2.2. 从GroupTemplate开始

```java
StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
Configuration cfg = Configuration.defaultConfiguration();
GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
Template t = gt.getTemplate("hello,${name}");
t.binding("name", "beetl");
String str = t.render();
System.out.println(str);
```

Beetl的核心是GroupTemplate，创建GroupTemplate需要俩个参数，一个是模板资源加载器，一个是配置类，模板资源加载器Beetl内置了6种，分别是

-   StringTemplateResourceLoader：字符串模板加载器，用于加载字符串模板，如本例所示
-   FileResourceLoader：文件模板加载器，需要一个根目录作为参数构造，传入getTemplate方法的String是模板文件相对于Root目录的相对路径
-   ClasspathResourceLoader：文件模板加载器，模板文件位于Classpath里
-   WebAppResourceLoader：用于webapp集成，假定模板根目录就是WebRoot目录，参考web集成章
-   MapResourceLoader : 可以动态存入模板
-   CompositeResourceLoader 混合使用多种加载方式

代码第5行将变量name传入模板里，其值是“Beetl”。 代码第6行是渲染模板，得到输出，template提供了多种获得渲染输出的方法，如下

-   tempalte.render() 返回渲染结果，如本例所示
-   template.renderTo(Writer) 渲染结果输出到Writer里
-   template.renderTo(OutputStream ) 渲染结果输出到OutputStream里

>   1.  关于如何使用模板资源加载器，请参考下一节
>   2.  如何对模板进行配置，请参考下一节



#### 2.3. 模板基础配置

Beetl提供不但功能齐全，而且还有很多独特功能，通过简单的配置文件，就可以定义众多的功能，默认情况下，Configuration类总是会先加载默认的配置文件（位于/org/beetl/core/beetl-default.properties，作为新手，**通常只需要关注3,4,5,6行定界符的配置，以及12行模板字符集的配置就可以了**，其他配置会在后面章节陆续提到）下，其内容片断如下：

```properties
#默认配置
ENGINE=org.beetl.core.engine.FastRuntimeEngine
DELIMITER_PLACEHOLDER_START=${
DELIMITER_PLACEHOLDER_END=}
DELIMITER_STATEMENT_START=<%
DELIMITER_STATEMENT_END=%>
DIRECT_BYTE_OUTPUT = FALSE
HTML_TAG_SUPPORT = true
HTML_TAG_FLAG = #
HTML_TAG_BINDING_ATTRIBUTE = var
NATIVE_CALL = TRUE
TEMPLATE_CHARSET = UTF-8
ERROR_HANDLER = org.beetl.core.ConsoleErrorHandler
NATIVE_SECUARTY_MANAGER= org.beetl.core.DefaultNativeSecurityManager
MVC_STRICT = FALSE

#资源配置，resource后的属性只限于特定ResourceLoader
RESOURCE_LOADER=org.beetl.core.resource.ClasspathResourceLoader
#classpath 根路径
RESOURCE.root= /
#是否检测文件变化
RESOURCE.autoCheck= true
#自定义脚本方法文件的Root目录和后缀
RESOURCE.functionRoot = functions
RESOURCE.functionSuffix = html
#自定义标签文件Root目录和后缀
RESOURCE.tagRoot = htmltag
RESOURCE.tagSuffix = tag
#####  扩展 ##############
## 内置的方法
FN.date = org.beetl.ext.fn.DateFunction
......
##内置的功能包
FNP.strutil = org.beetl.ext.fn.StringUtil
......
##内置的默认格式化函数
FTC.java.util.Date = org.beetl.ext.format.DateFormat
.....
## 标签类
TAG.include= org.beetl.ext.tag.IncludeTag
```

第2行配置引擎实现类，默认即可.

第3,4行指定了占位符号，默认是`${` `}`，也可以指定为其他占位符。

第5,6行指定了语句的定界符号，默认是`<%` `%>`，也可以指定为其他定界符号

第7行指定IO输出模式，默认是FALSE,即通常的字符输出，在考虑高性能情况下，可以设置成`true`。详细请参考高级用法

第8,9行指定了支持HTML标签，且符号为#,默认配置下，模板引擎识别`<#tag ></#tag>`这样的类似html标签，并能调用相应的标签函数或者模板文件。你也可以指定别的符号，如**bg:** 则识别`<bg:`

第10行 指定如果标签属性有`var`，则认为是需要绑定变量给模板的标签函数

第11行指定允许本地Class直接调用

第12行指定模板字符集是**UTF-8**

第13行指定异常的解析类，默认是**ConsoleErrorHandler**，他将在render发生异常的时候在后台打印出错误信息（`System.out`)。

第14行指定了本地Class调用的安全策略

第15行配置了是否进行严格MVC，通常情况下，此处设置为false.

第18行指定了默认使用的模板资源加载器

第20到22行配置了模板资源加载器的一些属性，如设置根路径为/,即Classpath的顶级路径，并且总是检测模板是否更改

第23行配置了自定义的方法所在的目录以及文件名后缀。beetl既支持通过java类定义方法，也支持通过模板文件来定义方法

第26行配置了自定义的html标签所在的目录以及文件名后缀。beetl既支持通过java类定义标签，也支持通过模板文件来定义标签

第31行注册了一个`date`方法，其实现类是`org.beetl.ext.fn.DateFunction`

第34行注册了一个方法包`strutil`，其实现类`org.beetl.ext.fn.StringUtil`，此类的每个`public`方法都将注册为beetl的方法

第37行注册了一个日期格式化函数

第40行注册了一个`include`标签函数

>   模板开发者可以创建一个beetl.properties的配置文件，此时，该配置文件将覆盖默认的配置文件属性，比如，你的定界符考虑是`<!--:` 和 `-->` ,则在**beetl.properties**加入一行即可,并将此配置文件放入Classpath根目录下即可。 Configuration.defaultConfiguration()总是先加载系统默认的，然后再加载Beetl.properties的配置属性，如果有重复，用后者代替前者的配置
>
>   ```properties
>   #自定义配置
>   DELIMITER_STATEMENT_START=<!--:
>   DELIMITER_STATEMENT_END=-->
>   ```

>   2.4.0 新功能:beetl 支持通过模板本生来完成函数，即模板函数，或者通过模板来实现HTML标签（而不用写java代码），可以beetl.properties为这种应用设置的不同的语句定界符来跟常规模板做区分，如下
>
>   ```properties
>   FUNCTION_TAG_LIMITER=<%;%>
>   ```
>
>   分号分割开，如果配置文件没有FUNCTION_TAG_LIMITER=，则模板函数，html标签使用同**DELIMITER_STATEMENT_START**，**DELIMITER_STATEMENT_END**



#### 2.4. 模板资源加载器

资源加载器是根据String值获取Resource实例的工场类，同时资源加载器还要负责响应模板引擎询问模板是否变化的调用。对于新手来说，无需考虑模板资源加载器如何实现，只需要根据自己场景选择系统提供的三类模板资源加载器即可

##### 2.4.1. 字符串模板加载器

在创建GroupTemplate过程中，如果传入的是StringTemplateResourceLoader，则允许通过调用gt.getTemplate(String template)来获取模板实例对象，如2.1所示

##### 2.4.2. 文件资源模板加载器

更通常情况下，模板资源是以文件形式管理的，集中放在某一个文件目录下（如webapp的模板根目录就可能是WEB-INF/template里），因此，可以使用FileResourceLoader来加载模板实例，如下代码：

```java
String root = System.getProperty("user.dir")+File.separator+"template";
FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
Configuration cfg = Configuration.defaultConfiguration();
GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
Template t = gt.getTemplate("/s01/hello.txt");
String str = t.render();
System.out.println(str);
```

第1行代码指定了模板根目录，即位于项目工程下的template目录 第2行构造了一个资源加载器，并指定字符集为UTF-8 (也可不指定，因为配置文件默认就是UTF-8); 第5行通过模板的相对路径/s01/hello.txt来加载模板

##### 2.4.3. Classpath资源模板加载器

还有种常情况下，模板资源是打包到jar文件或者同Class放在一起，因此，可以使用ClasspathResourceLoader来加载模板实例，如下代码：

```java
ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("org/beetl/sample/s01/");
Configuration cfg = Configuration.defaultConfiguration();
GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
Template t = gt.getTemplate("/hello.txt");
String str = t.render();
System.out.println(str);
```

第1行代码指定了模板根目录，即搜索模板的时候从根目录开始，如果new ClasspathResourceLoader("template/"),则表示搜索template下的模板。此处用空构造函数，表示搜索路径是根路径，且字符集默认字符集UTF-8.

第4行通过模板的相对路径org/beetl/sample/s01/hello.txt来加载模板

##### 2.4.4. WebApp资源模板加载器

WebAppResourceLoader 是用于web应用的资源模板加载器，默认根路径是WebRoot目录。也可以通过制定root属性来设置相对于WebRoot的的模板根路径，从安全角考虑，建议放到WEB-INF目录下

如下是Jfinal集成 里初始化GroupTemplate的方法

```java
Configuration cfg = Configuration.defaultConfiguration();
WebAppResourceLoader resourceLoader = new WebAppResourceLoader();
groupTemplate = new GroupTemplate(resourceLoader, cfg);
```

>   WebAppResourceLoader 假定 beetl.jar 是位于 WEB-INF/lib 目录下，因此，可以通过WebAppResourceLoader类的路径来推断出WebRoot路径从而指定模板根路径。所有线上环境一般都是如此，如果是开发环境或者其他环境不符合此假设，你需要调用resourceLoader.setRoot() 来指定模板更路径

##### 2.4.5. 自定义资源模板加载器

有时候模板可能来自文件系统不同目录，或者模板一部分来自某个文件系统，另外一部分来自数据库，还有的情况模板可能是加密混淆的模板，此时需要自定义资源加载，继承ResouceLoader才能实现模板功能，这部分请参考高级部分



#### 2.5. 定界符与占位符号

Beetl模板语言类似JS语言和习俗，只需要将Beetl语言放入定界符号里即可，如默认的是<% %> ,占位符用于静态文本里嵌入占位符用于输出，如下是正确例子

```javascript
<%
var a = 2;
var b = 3;
var result = a+b;
%>
hello 2+3=${result}
```

**千万不要**在定界符里使用占位符号，因为占位符仅仅嵌在静态文本里，如下例子是**错误**例子

```javascript
<%
var a = "hi";
var c = ${a}+"beetl"; //应该是var c = a+"beetl"
%>
```

每次有人问我如上例子为啥不能运行的时候，我总是有点憎恶velocity 带来的这种非人性语法

定界符和占位符 通常还有别的选择，如下定界符

-   @ 和回车换行 (此时,模板配置DELIMITER_STATEMENT_END= 或者 DELIMITER_STATEMENT_END=null 都可以)
-   \#: 和回车换行
-   &lt;!\-\-: 和 \-\-&gt;
-   &lt;!\-\-# 和 \-\-&gt;
-   &lt;? 和 ?&gt;

占位符\-\-#{ }\-\#\#

你也可以与团队达成一致意见来选择团队喜爱择定界符号和占位符号。

定界符号里是表达式，如果表达式跟定界符或者占位符有冲突，可以在用 “\” 符号，如

```javascript
@for(user in users){
email is ${user.name}\@163.com
@}
${[1,2,3]} //输出一个json列表
${ {key:1,value:2 \}  } //输出一个json map，} 需要加上\
```



#### 2.6. 注释

Beetl语法类似js语法，所以注释上也同js一样： 单行注释采用//

多行注视采用/**/

````javascript
<%
/*此处是一个定义变量*/
var a = 3; //定义一个变量.

/* 以下内容都将被注释
%>

<% */ %>
````

第2行是一个多行注释

第3行是一个单行注释

第5行到第8行采用的是多行注释，因此里面有内容也是注释，模板将不予处理



#### 2.7. 临时变量定义

在模板中定义的变量成为临时变量，这类似js中采用var 定义的变量，如下例子

```javascript
<%
var a = 3;
var b = 3,c = "abc",d=true,e=null;
var f = [1,2,3];
var g = {key1:a,key2:c};
var i = a+b;
%>
```



#### 2.8. 全局变量定义

全局变量是通过template.binding传入的变量,这些变量能在模板的任何一个地方，包括子模板都能访问到。如java代码里

```javascript
template.binding("list",service.getUserList());

//在模板里
<%
for(user in list){
%>
hello,${user.name};
<%}%>
```



#### 2.9. 共享变量

共享变量指在所有模板中都可以引用的变量，可过groupTemplate.setSharedVars(Map<String, Object> sharedVars)传入的变量,这些变量能在 **所有模板** 的任何一个地方

```java
//.....
GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
Map<String,Object> shared = new HashMap<String,Object>();
shared.put("name", "beetl");
gt.setSharedVars(shared);
Template t = gt.getTemplate("/org/beetl/sample/s0208/t1.txt");
String str = t.render();
System.out.println(str);
t = gt.getTemplate("/org/beetl/sample/s0208/t2.txt");
str = t.render();
System.out.println(str);
```

```javascript
//t1.txt
hi,${name}
//t2.txt
hello,${name}
```



#### 2.10. 模板变量

模板变量是一种特殊的变量，即可以将模板中任何一段的输出赋值到该变量，并允许稍后在其他地方使用，如下代码

```javascript
<%
var content = {
        var c = "1234";
        print(c);
%>
模板其他内容：

<%}; %>
```

第2行定义了一个模板变量content = { …} ; 此变量跟临时变量一样，可以在其他地方使用，最常见的用户是用于复杂的布局。请参考高级用法布局



#### 2.11. 引用属性

属性引用是模板中的重要一部分，beetl支持属性同javascript的支持方式一样，如下

1.  Beetl支持通过”.”号来访问对象的的属性，如果javascript一样。如果User对象有个getName()方法，那么在模板中，可以通过${xxx.name}来访问
2.  如果模板变量是数组或者List类，这可以通过[] 来访问，如${userList[0]}
3.  如果模板变量是Map类，这可以通过[]来访问，如${map[“name”]},如果key值是字符串类型，也可以使用${map.name}.但不建议这么使用，因为会让模板阅读者误以为是一个Pojo对象
4.  Beetl也支持Generic Get方式，即如果对象有一个public Object get(String key)方法，可以通过”.”号或者[]来访问，譬如 ${activityRecord.name}或者${activityRecord[“name”] }都将调用activityRecord的 get(String key)方法。如果对象既有具体属性，又有Generic get（这种模型设计方式是不值得鼓励），则以具体属性优先级高.
5.  Beetl也可以通过[]来引用属性，如${user[“name”]} 相当于${user.name}.这跟javascript保持一致。但建议不这么做，因为容易让阅读模板的人误认为这是一个Map类型
6.  Beetl 还可以定位额外的对象属性，而无需更改java对象，这叫着虚拟属性，如，对于所有集合，数组，都有共同的虚拟熟悉size.虚拟属性是“.~”+虚拟1属性名

```javascript
template.binding("list",service.getUserList());
template.binding("pageMap",service.getPage());

//在模板里
总共 ${list.~size}
<%
for(user in list){
%>
hello,${user.name};
<%}%>

当前页${pageMap['page']},总共${pageMap["total"]}

```



#### 2.12. 属性赋值

Beetl2.7.0 开始支持对象赋值，如：

```javascript
<%
var user = ....
user.name="joelli";
user.friends[0] = getNewUser();
user.map["name"] = "joelli";
%>
```



#### 2.13. 算数表达式

Beetl支持类似javascript的算术表达式和条件表达式，如+ - * / % 以及（），以及自增++，自减--

```javascript
<%
var a = 1;
var b = "hi";
var c = a++;
var d = a+100.232;
var e = (d+12)*a;
var f = 122228833330322.1112h
%>
```

Beetl里定义的临时变量类型默认对应的java是Int型或者double类型，对于模板常用情况说，已经够了.如果需要定义长精度类型（对应java的BigDecimal），则需要在数字末尾加上h以表示这是长精度BigDecimal，其后的计算和输出以及逻辑表达式都将按照长精度类型来考虑。



#### 2.14. 逻辑表达式

Beetl支持类似Javascript,java的条件表达式 如\>，\<，==，!=，\>= , \<= 以及 !, 还有&&和 || ，还有三元表达式等，如下例子

```javascript
<%
var a = 1;
var b=="good";
var c = null;

if(a!=1&&b=="good"&&c==null){
        ......
}
%>
```

三元表达式如果只考虑true条件对应的值的话，可以做简化,如下俩行效果是一样的。

```javascript
<%
 var  a = 1 ;
%>
${a==1?"ok":''}
${a==1?"ok"}
```



#### 2.15. 循环语句

Beetl支持丰富的循环方式，如for-in,for(exp;exp;exp)，以及while循环，以及循环控制语句break;continue; 另外，如果没有进入for循环体，还可以执行elsefor指定的语句。

##### 2.15.1. for-in

for-in循环支持遍历集合对象，对于List和数组来说以及Iterator，对象就是集合对象，对于Map来说，对象就是Map.entry,如下俩个例子

```javascript
<%
for(user in userList){
        print(userLP.index);
        print(user.name);
}
%>
```

第三行代码userLP是Beetl隐含定义的变量，能在循环体内使用。其命名规范是item名称后加上LP，他提供了当前循环的信息，如

-   **userLP.index **当前的索引，从1开始
-   **userLP.size **集合的长度
-   **userLP.first** 是否是第一个
-   **userLP.last** 是否是最后一个
-   **userLP.even** 索引是否是偶数
-   **userLP.odd** 索引是否是奇数

>   如何记住后缀是LP，有俩个诀窍，英语棒的是Loop的缩写，拼音好的是老婆的拼音缩写，这可以让程序员每次写到这的时候都会想想老婆（不管有没有，哈哈）

如下是Map使用例子

```javascript
<%
for(entry in map){
        var key = entry.key;
        var value = entry.value;
        print(value.name);
}
%>
```

##### 2.15.2. for(exp;exp;exp)

对于渲染逻辑更为常见的是经典的for循环语句，如下例子

```javascript
<%
var a = [1,2,3];
for(var i=0;i<a.~size;i++){
        print(a[i]);
}
%>
```

##### 2.15.3. while

对于渲染逻辑同样常见的有的while循环语句，如下例子

```javascript
<%
var i = 0;
while(i<5){
        print(i);
        i++;
}
%>
```

##### 2.15.4. elsefor

不同于通常程序语言，如果没有进入循环体，则不需额外的处理，模板渲染逻辑更常见情况是如果没有进入循环体，还需要做点什么，因此，对于for循环来说，还有elsefor 用来表达如果循环体没有进入，则执行elsefor 后的语句

```javascript
<%
var list = [];
for(item in list){

}elsefor{
        print("未有记录");
}
%>
```



#### 2.16. 条件语句

##### 2.16.1. if else

同js一样，支持if else,如下例子

```javascript
<%
var a =true;
var b = 1;
if(a&&b==1){

}else if(a){

}else{

}
%>
```

##### 2.16.2. switch-case

同js一样，支持switch-case,如下例子

```javascript
<%
var b = 1;
switch(b){
        case 0:
                print("it's 0");
                break;
        case 1:
                print("it's 1");
                break;
        default:
                print("error");
}
%>
```

>   switch变量可以支持任何类型，而不像js那样只能是整形

##### 2.16.3. select-case

select-case 是switch case的增强版。他允许case 里有逻辑表达式，同时，也不需要每个case都break一下，默认遇到合乎条件的case执行后就退出。

```javascript
<%
var b = 1;
select(b){
        case 0,1:
                print("it's small int");
        case 2,3:
                print("it's big int");
        default:
                print("error");
}
%>
```

select 后也不需要一个变量，这样case 后的逻辑表达式将决定执行哪个case.其格式是

```javascript
<%
select {
        case boolExp,orBoolExp2:
                doSomething();
}
%>
```

```javascript
<%
var b = 1;
select{
        case b<1,b>10:
                print("it's out of range");
                break;
        case b==1:
                print("it's 1");
                break;
        default:
                print("error");
}
%>
```



#### 2.17. try-catch

通常模板渲染逻辑很少用到try-catch 但考虑到渲染逻辑复杂性，以及模板也有不可控的地方，所以提供try catch，在渲染失败的时候仍然能保证输出正常

```javascript
<%
try{
        callOtherSystemView()
}catch(error){
        print("暂时无数据");
}
%>
```

error代表了一个异常，你可以通过error.message 来获取可能的错误信息

也可以省略catch部分，这样出现异常，不做任何操作



#### 2.18. 虚拟属性

虚拟属性也是对象的属性，但是虚拟的，非模型对象的真实属性，这样的好处是当模板需要额外的用于显示的属性的时候但又不想更改模型，便可以采用这种办法 如beetl内置的虚拟属性.~size 针对了数组以及集合类型。

```javascript
${user.gender}
${user.~genderShowName}
```

~genderShowName 是虚拟属性，其内部实现根据boolean变量gender来显示性别

如何完成虚拟属性，请参考高级用法



#### 2.19. 函数调用

Beetl内置了少量实用函数，可以在Beetl任何地方调用。如下例子是调用date 函数，不传参数情况下，返回当前日期

```javascript
<%
var date = date();
var len = strutil.length("cbd");
println("len="+len);
%>
```

注意函数名支持namespace方式，因此代码第3行调用的函数是strutil.length

>定义beetl的方法非常容易，有三种方法
>
>-   实现Function类的call方法，并添加到配置文件里，或者显示的通过代码注册registerFunction(name,yourFunction)
>-   可以直接调用registerFunctionPackage(namespace,yourJavaObject),这时候yourJavaObject里的所有public方法都将注册为Beetl方法，方法名是namespace+"."+方法名
>-   可以直接写模板文件并且以html作为后缀，放到root/functions目录下，这样此模板文件自动注册为一个函数，其函数名是该模板文件名。
>
>详情请参考高级用法

Beetl内置函数请参考附录，以下列出了常用的函数

-   **date** 返回一个java.util.Date类型的变量，如 date() 返回一个当前时间(对应java的java.util.Date); ${date( "2011-1-1" , "yyyy-MM-dd" )} 返回指定日期
-   **print** 打印一个对象 print(user.name);
-   **println** 打印一个对象以及回车换行符号，回车换号符号使用的是模板本身的，而不是本地系统的.如果仅仅打印一个换行符，则直接调用println() 即可
-   **nvl** 函数nvl，如果对象为null，则返回第二个参数，否则，返回自己 nvl(user,"不存在")
-   **isEmpty** 判断变量或者表达式是否为空，变量不存在，变量为null，变量是空字符串，变量是空集合，变量是空数组，此函数都将返回true
-   **isNotEmpty** 同上，判断对象是否不为空
-   **has** 变量名为参数，判断是否存在此全局变量，如 has(userList),类似于1.x版本的exist("userList"),但不需要输入引号了
-   **assert** 如果表达式为false，则抛出异常
-   **trunc** 截取数字，保留指定的小数位，如trunc(12.456,2) 输出是12.45
-   **decode** 一个简化的if else 结构，如 decode(a,1,"a=1",2,"a=2","不知道了")},如果a是1，这decode输出"a=1",如果a是2，则输出"a==2", 如果是其他值，则输出"不知道了"
-   **debug** 在控制台输出debug指定的对象以及所在模板文件以及模板中的行数，如debug(1),则输出1 [在3行@/org/beetl/core/lab/hello.txt],也可以输出多个，如debug("hi",a),则输出hi,a=123,[在3行@/org/beetl/core/lab/hello.txt]
-   **parseInt** 将数字或者字符解析为整形 如 parseInt("123");
-   **parseLong** 将数字或者字符解析为长整形，parseInt(123.12);
-   **parseDouble** 将数字或者字符解析为浮点类型 如parseDouble("1.23")
-   **range** 接收三个参数，初始值，结束值，还有步增（可以不需要，则默认为1），返回一个Iterator，常用于循环中，如for(var i in range(1,5)) {print(i)},将依次打印1234.
-   **flush** 强制io输出。
-   **json**，将对象转成json字符串，如 var data = json(userList) 可以跟一个序列化规则 如,var data = json(userList,"[*].id:i"),具体参考 [https://git.oschina.net/xiandafu/beetl-json](https://git.oschina.net/xiandafu/beetl-json)
-   **pageCtx** ，仅仅在web开发中，设置一个变量，然后可以在页面渲染过程中，调用此api获取，如pageCtx("title","用户添加页面")，在其后任何地方，可以pageCtx("title") 获取该变量
-   **type.new** 创建一个对象实例，如 var user = type.new("com.xx.User"); 如果配置了IMPORT_PACKAGE，则可以省略包名，type.new("User")
-   **type.name** 返回一个实例的名字，var userClassName = type.name(user),返回"User"



#### 2.20. 安全输出

安全输出是任何一个模板引擎必须重视的问题，否则，将极大困扰模板开发者。Beetl中，如果要输出的模板变量为null，则beetl将不做输出，这点不同于JSP，JSP输出null，也不同于Feemarker，如果没有用!,它会报错.

模板中还有俩种情况会导致模板输出异常

-   有时候模板变量并不存在（譬如子模板里）
-   模板变量为null，但输出的是此变量的一个属性，如${user.wife.name}

针对前俩种种情况，可以在变量引用后加上！以提醒beetl这是一个安全输出的变量。

如${user.wife.name! },即使user不存在，或者user为null，或者user.wife为null，或者user.wife.name为null beetl都不将输出

可以在!后增加一个常量（字符串，数字类型等），或者另外一个变量，方法，本地调用，作为默认输出，譬如：

${user.wife.name!”单身”}，如果user为null，或者user.wife为null，或者user.wife.name为null，输出”单身”

譬如

${user.birthday!@System.constants.DefaultBir}， 表示如果user为null，或者user. birthday为null，输出System.constants.DefaultBir

还有一种情况很少发生，但也有可能，输出模板变量发生的任何异常，如变量内部抛出的一个异常

这需要使用格式${!(变量)},这样，在变量引用发生任何异常情况下，都不作输出，譬如

${!(user.name)},，beetl将会调用user.getName()方法，如果发生异常，beetl将会忽略此异常，继续渲染

值得注意的是，在变量后加上!不仅仅可以应用于占位符输出(但主要是应用于占位符输出)，也可以用于表达式中，如：

```javascript
<%
var k = user.name!'N/A'+user.age!;
%>
<%
${k}
%>
```

如果user为null，则k值将为N/A

在有些模板里，可能整个模板都需要安全输出，也可能模板的部分需要安全输出，使用者不必为每一个表达式使用！，可以使用beetl的安全指示符号来完成安全输出 如：

```javascript
<%
DIRECTIVE SAFE_OUTPUT_OPEN;
%>
${user.wife.name}
模板其他内容，均能安全输出……
<%
//关闭安全输出。
DIRECTIVE SAFE_OUTPUT_CLOSE;
%>
```

Beetl不建议每一个页面都使用DIRECTIVE SAFE_OUTPUT_OPEN，这样，如果如果真有不期望的错误，不容易及时发现，其次，安全输出意味着beetl会有额外的代码检测值是否存在或者是否为null，性能会略差点。所以建议及时关闭安全输出（这不是必须的，但页面所有地方是安全输出，可能不容易发现错误）

在for-in 循环中 ，也可以为集合变量增加安全输出指示符号，这样，如果集合变量为null，也可以不进入循环体，如：

```javascript
<%
var list = null;
for(item in list!){

}eslefor{
        print("no data");
}
%>
```

##### 2.20.1. 变量是否存在

```javascript
<%
if(has(flag)){
        print("flag变量存在，可以访问")
}
%>
```

如果需要判断变量是否存在，如果存在，还有其他判断条件，通常都这么写

```javascript
<%
if(has(flag)||flag==0){
        //code
}
%>
```

如果flag不存在，或者flag存在，但值是0，都将执行if语句

但是，有更为简便的方法是直接用安全输出，如

```javascript
<%
if(flag!0==0){
        //code
}
%>
```

flag!0 取值是这样的，如果flag不存在，则为0，如果存在，则取值flag的值，类似三元表达式 has(flag)?falg:0

##### 2.20.2. 安全输出表达式

安全输出表达式可以包括

-   字符串常量,如 ${user.count!"无结果"}
-   boolean常量 ${user.count!false}
-   数字常量，仅限于正数，因为如果是负数，则类似减号，容易误用，因此，如果需要表示负数，请用括号，如${user.count!(-1)}
-   class直接调用，如${user.count!@User.DEFAULT_NUM}
-   方法调用，如 ${user.count!getDefault() }
-   属性引用，如 ${user.count!user.maxCount }
-   任何表达式，需要用括号



#### 2.21. 格式化

几乎所有的模板语言都支持格式化，Beetl也不列外，如下例子Beetl提供的内置日期格式

```javascript
<% var date = date(); %>
Today is ${date,dateFormat="yyyy-MM-dd"}.
Today is ${date,dateFormat}
salary is ${salary,numberFormat="##.##"}
```

格式化函数只需要一个字符串作为参数放在=号后面，如果没有为格式化函数输入参数，则使用默认值，dateFormat格式化函数默认值是local

Beetl也允许为指定的java class设定格式化函数，譬如已经内置了对java.util.Date,java.sql.Date 设置了了格式化函数，因此上面的例子可以简化为

```javascript
${date,“yyyy-MM-dd”}
```

Beetl针对日期和数字类型提供的默认的格式化函数，在org/beetl/core/beetl-default.properties里，注册了

```properties
##内置的格式化函数
FT.dateFormat =  org.beetl.ext.format.DateFormat
FT.numberFormat =  org.beetl.ext.format.NumberFormat
##内置的默认格式化函数
FTC.java.util.Date = org.beetl.ext.format.DateFormat
FTC.java.sql.Date = org.beetl.ext.format.DateFormat
FTC.java.sql.Time = org.beetl.ext.format.DateFormat
FTC.java.sql.Timestamp = org.beetl.ext.format.DateFormat
FTC.java.lang.Short = org.beetl.ext.format.NumberFormat
FTC.java.lang.Long = org.beetl.ext.format.NumberFormat
FTC.java.lang.Integer = org.beetl.ext.format.NumberFormat
FTC.java.lang.Float = org.beetl.ext.format.NumberFormat
FTC.java.lang.Double = org.beetl.ext.format.NumberFormat
FTC.java.math.BigInteger = org.beetl.ext.format.NumberFormat
FTC.java.math.BigDecimal = org.beetl.ext.format.NumberFormat
FTC.java.util.concurrent.atomic.AtomicLong = org.beetl.ext.format.NumberFormat
FTC.java.util.concurrent.atomic.AtomicInteger = org.beetl.ext.format.NumberFormat
```



#### 2.22. 标签函数

所谓标签函数，即允许处理模板文件里的一块内容，功能等于同jsp tag。如Beetl内置的layout标签

index.html

```javascript
<%
layout("/inc/layout.html",{title:'主题'}){
%>
Hello,this is main part
<%} %>
```

layout.html

```javascript
title is ${title}
body content ${layoutContent}
footer
```

第1行变量title来自于layout标签函数的参数

第2行layoutContent 是layout标签体{}渲染后的结果

关于layout标签，参考高级主题布局

Beetl内置了另外一个标签是include,允许 include 另外一个模板文件

```javascript
<%
include("/inc/header.html"){}
%>
```

在标签中，{} 内容将依据标签的实现而执行，layout标签将执行{}中的内容，而include标签则忽略标签体内容。

关于如何实现标签函数，请参考高级主题,如下是一个简单的的标签函数：

```java
public class CompressTag extends Tag{
        @Override
        public void render(){
                BodyContent  content = getBodyContent();
                String content = content.getBody();
                String zip = compress(conent);
                ctx.byteWriter.write(zip);
        }
}
```



#### 2.23. HTML标签

Beetl 也支持HTML tag形式的标签， 区分beetl的html tag 与 标准html tag。如设定HTML_TAG_FLAG=#，则如下html tag将被beetl解析

```xml
<#footer style=”simple”/>
<#richeditor id=”rid” path="${ctxPath}/upload" name=”rname”  maxlength=”${maxlength}”> ${html} …其他模板内容   </#richdeitor>
<#html:input  id=’aaaa’ />
```

如对于标签footer,Beetl默认会寻找WebRoot/htmltag/footer.tag(可以通过配置文件修改路径和后缀) ,内容如下:

```javascript
<%if(style==’simple’){%>
 请联系我 ${session.user.name}
<%}else{%>
请联系我 ${session.user.name},phone:${session.user.phone}
<%}%>
```

如下还包含了自定义html标签一些一些规则

-   可以在自定义标签里引用标签体的内容，标签体可以是普通文本，beetl模板，以及嵌套的自定义标签等。如上<#richeditor 标签体里，可用“tagBody”来引用
-   HTML自定义标签 的属性值均为字符串 如<#input value=”123” />,在input.tag文件里 变量value的类型是字符串
-   可以在属性标签里引用beetl变量，如<#input value=”${user.age}” />，此时在input.tag里，value的类型取决于user.age
-   在属性里引用beetl变量，不支持格式化，如<#input value=”${user.date,‘yyyy-MM-dd’ }” />,如果需要格式化，需要在input.tag文件里自行格式化
-   在标签属性里传json变量需要谨慎，因为json包含了"}",容易与占位符混合导致解析出错，因此得使用"\"符号，如<#input value=”${ {*age*:25} }” />
-   html tag 属性名将作为 其对应模板的变量名。
-   默认机制下，全局变量都将传给html tag对应的模板文件，这个跟include一样。当然，这机制也可以改变，对于标签来说，通常是作为一个组件存在，也不一定需要完全传送所有全局变量，而只传送（request,session,这样变量），因此需要重新继承org.beetl.ext.tag.HTMLTagSupportWrapper.并重载callHtmlTag方法。并注册为htmltag标签。具体请参考https://github.com/javamonkey/beetl2.0/blob/master/beetl-core/src/test/java/org/beetl/core/tag/HtmlTagTest.java

如果采用模板来写html标签功能不够强大，beetl支持写标签函数（参考上一节）来实现html标签，标签函数args[0]表示标签名，这通常没有什么用处，args[1] 则是标签的属性，参数是个map，key是html tag的属性，value是其属性值，如下用java完成的html 标签用于输出属性值

```java
public class SimpleHtmlTag extends Tag{
        @Override
        public void render(){
                String tagName = (String) this.args[0];
                Map attrs = (Map) args[1];
                String value = (String) attrs.get("attr");
                try{
                        this.ctx.byteWriter.writeString(value);
                }catch (IOException e){

                }
        }
}
```

如果注册gt.registerTag("simpleTag", SimpleHtmlTag.class); 则如下模板输出了attr属性值abc

```xml
<#simpleTag attr="abc"></#simpleTag>
```

>   HTML_TAG_FLAG默认为#用来区别是否是beetl的html tag，你也可以设置成其他符号，比如 "my:",这样，\<my:table\>\</my:table\> 其实是一个指向table.tag的标签实现



#### 2.24. 绑定变量的HTML标签

对于html标签（参考上一节），Beetl还 支持将标签实现类（java代码）里的对象作为临时变量，被标签体引用。此时需要实现GeneralVarTagBinding (此类是Tag的子类） 该类提供另外3个个方法 - void binds(Object… array) 子类在render方法里调用此类以实现变量绑定，绑定顺序同在模板中申明的顺序 - void bind(String name, Object value) 子类在render方法里调用此类以实现变量绑定，name是模板中申明的变量名，用此方法绑定不如binds更灵活，不再推荐 - Object getAttributeValue 获得标签的属性 - Map getAttributes 获得标签的所有属性

```java
public class TagSample extends GeneralVarTagBinding{
        @Override
        public void render(){
                int limit = Integer.parseInt((String) this.getAttributeValue("limit"));
                for (int i = 0; i < limit; i++){
                        this.binds(i)
                        this.doBodyRender();
                }
        }
}
//在某处注册一下标签TagSample
//gt.registerTag("tag", TagSample.class);
```

如上例子，render方法将循环渲染标签体limit次，且每次都将value赋值为i。我们再看看模板如何写的

```xml
<#tag limit="3";value>
	${value}
</#tag>
```

类似于常规html标签，需要在标签的最后的属性定义后面加上分号 ";" 此分号表示这个是一个需要在标签运行时需要绑定变量的标签。后跟上要绑定的变量列表，如上例只绑定了一个value变量，如果需要绑定多个变量，则用逗号分开，如var1,var2 上。如果后面没有变量列表，只有分号，则默认绑定到标签名同名的变量上. 如果标签有namesapce，则默认绑定订的变量名不包含namespace

注意，由于标签使用因为太长可能换行或者是文本格式化导致换行，目前beetl只允许在属性之间换行，否则，将报标签解析错误。

默认情况下，如果标签属性出现了var(可以通过配置文件改成其他属性名)，也认为是绑定变量的标签，如上面的例子也可以这么写

```xml
<#tag limit="3" var="value">
	${value}
</#tag>
```

var属性的值可以是个以逗号分开的变量名列表，如var="total,customer,index"



#### 2.25. 直接调用java方法和属性

可以通过符号@来表明后面表达式调用是java风格，可以调用对象的方法，属性

```javascript
${@user.getMaxFriend(“lucy”)}
${@user.maxFriend[0].getName()}
${@com.xxxx.constants.Order.getMaxNum()}
${@com.xxxx.User$Gender.MAN}
<%
var max = @com.xxxx.constants.Order.MAX_NUM;
var c =1;
var d = @user.getAge(c);
%>
```

可以调用instance的public方法和属性，也可以调用静态类的属性和方法 ,需要加一个 @指示此调用是直接调用class，其后的表达式是java风格的。

>   -   GroupTemplate可以配置为不允许直接调用Class，具体请参考配置文件.
>   -   也可以通过安全管理器配置到底哪些类Beetl不允许调用，具体请参考高级用法。默认情况，java.lang.Runtime,和 java.lang.Process不允许在模板里调用。你自己的安全管理器也许可以配置为不能直接访问DAO类（避免了以前jsp可以访问任意代码带来的危害）
>   -   请按照java规范写类名和方法名，属性名。这样便于beetl识别到底调用的是哪个类，哪个方法。否则会抛出错误
>   -   可以省略包名，只用类名。beetl将搜索包路径找到合适的类（需要设置配置“IMPORT_PACKAGE=包名.;包名.”，包名后需要跟一个“.”, 或者调用Configuration.addPkg)方法具体请参考附件配置文件说明
>   -   内部类（包括枚举）访问同java一样，如User类有个内部枚举类Gender，访问是User$Gender
>   -   表达式是java风格，但参数仍然是beetl表达式，比如 @user.sayHello(user.name).这里user.sayHello是java调用，user.name 仍然是beetl表达式



#### 2.26. 严格MVC控制

如果在配置文件中设置了严格MVC，则以下语法将不在模板文件里允许，否则将报出STRICK_MVC 错误

-   定义变量，为变量赋值,如var a = 12是非法的
-   算术表达式 如${user.age+12}是非法的
-   除了只允许布尔以外，不允许逻辑表达式和方法调用 如if(user.gender==1)是非法的
-   方法调用，如${subString(string,1)}是非法的
-   Class方法和属性调用，如${@user.getName()}是非法的
-   严格的MVC，非常有助于逻辑与视图的分离，特别当逻辑与视图是由俩个团队来完成的。如果你嗜好严格MVC，可以调用groupTemplate.enableStrict()

>   通过重载AntlrProgramBuilder，可以按照自己的方法控制到底哪些语法是不允许在模板引擎中出现的，但这已经超出了Beetl模板的基础使用



#### 2.27. 指令

指令格式为： DIRECTIVE 指令名 指令参数（可选） Beetl目前支持安全输出指令，分别是

-   DIRECTIVE SAFE_OUTPUT_OPEN ; 打开安全输出功能，此指令后的所有表达式都具有安全输出功能，
-   DIRECTIVE SAFE_OUTPUT_CLOSE ; 关闭安全输出功能。详情参考安全输出
-   DIRECTIVE DYNAMIC varName1,varName2 …指示后面的变量是动态类型，Beetl应该考虑为Object. 也可以省略后面的变量名，则表示模板里所有变量都是Object

```javascript
<% DIRECTIVE DYNAMIC idList;
for(value in idList) .....
```

DYNAMIC 通常用在组件模板里，因为组件模板可以接收任何类型的对象。如列表控件，可以接收任何含有id和 value属性的对象。

>   1.  注意 DYNAMIC 后的变量名也允许用引号，这主要是兼容Beetl1.x版本
>   2.  Beetl1.x 指令都是大写，当前版本也允许小写，如 directive dynamic idList



#### 2.28. 类型声明

Beetl 本质上还是强类型的模板引擎，即模板每个变量类型是特定的，在模板运行过程中，beetl 会根据全局变量自动推测出模板中各种变量和表达式类型。 也可以通过类型申明来说明beetl全局变量的类型，如下格式

```javascript
<%
/**
*@type (List<User> idList,User user)
*/
for(value in idList) .....
```

类型申明必须放到多行注释里，格式是@type( … ),里面的申明类似java方法的参数申明。正如你看到的类型申明是在注释里，也就表明了这在Beetl模板引擎中不是必须的，或者你只需要申明一部分即可，之所以提供可选的类型说明，是因为

-   提高一点性能
-   最重要的是，提高了模板的可维护性。可以让模板维护者知道变量类型，也可以让未来的ide插件根据类型声明来提供属性提示，重构等高级功能

需要注意的是，如果在类型声明里提供的是类名，而不是类全路径，这样必须在配置文件里申明类的搜索路径(（需要设置配置IMPORT_PACKAGE=包名.;包名.，或者调用Configuration.addPkg))，默认的搜索路径有java.util. 和 java.lang.



#### 2.29. 错误处理

Beetl能较为详细的显示错误原因，包括错误行数，错误符号，错误内容附近的模板内容，以及错误原因，如果有异常，还包括异常和异常信息。 默认情况下，仅仅在控制台显示，如下代码：

```javascript
<%
var a = 1;
var b = a/0;
%>
```

运行此模板后，错误提示如下

```javascript
>>DIV_ZERO_ERROR:0 位于3行 资源:/org/beetl/sample/s0125/error1.txt
1|<%
2|var a = 1;
3|var b = a/0;
4|%>
```

```javascript
<%
var a = 1;
var b = a
var c = a+2;
%>
```

运行此模板后

```javascript
>>缺少符号(PARSER_MISS_ERROR):缺少输入 ';' 在 'var' 位于4行 资源:/org/beetl/sample/s0125/error2.txt
1|<%
2|var a = 1;
3|var b = a
4|var c = a+2;
5|%>
```

>   1.  默认的错误处理器仅仅像后台打印错误，并没有抛出异常，如果需要在render错误时候抛出异常到控制层，则可以使用org.beetl.core.ReThrowConsoleErrorHandler。不仅打印异常，还抛出BeetlException
>   2.  可以自定义异常处理器，比如把错误输出到 作为渲染结果一部分输出，或者输出更美观的html内容等，具体参考高级用法
>   3.  可以在配置文件不设置异常，这样Beetl引擎将不处理异常，用户可以在外部来处理（可以在外部调用ErrorHandler子类来显示异常）



#### 2.30. Beetl小工具

BeetlKit 提供了一些便利的方法让你立刻能使用Beetl模板引擎。提供了如下方法

-   `public static String render(String template, Map<String, Object> paras)` 渲染模板，使用paras参数，渲染结果作为字符串返回
-   `public static void renderTo(String template, Writer writer, Map<String, Object> paras)` 渲染模板，使用paras参数，渲染结果作为字符串返回
-   `public static void execute(String script, Map<String, Object> paras)` 执行某个脚本
-   `public static Map execute(String script, Map<String, Object> paras, String[] locals)` 执行某个脚本，将locals指定的变量名和模板执行后相应值放入到返回的Map里
-   `public static Map executeAndReturnRootScopeVars(String script)` 执行某个脚本，返回所有顶级scope的所有变量和值
-   `public static String testTemplate(String template, String initValue)` 渲染模板template，其变量来源于intValue脚本运行的结果，其所有顶级Scope的变量都将作为template的变量
-   `public static String testTemplate(String template, String initValue)` 渲染模板template，其变量来源于intValue脚本运行的结果，其所有顶级Scope的变量都将作为template的变量

```java
String template = "var a=1,c=2+1;";
Map result = executeAndReturnRootScopeVars(template);
System.out.println(result);
//输出结果是{c=3, a=1}
```

>   BeetlKit　不要用于线上系统。仅仅作为体验Beetl功能而提供的，如果需要在线上使用这些功能，请参考该类源码自行扩展



#### 2.31. 琐碎功能

-   对齐:我发现别的模板语言要是做到对齐，非常困难,使用Beetl你完全不用担心，比如velocty，stringtemlate，freemarker例子都出现了不对齐的情况，影响了美观，Beetl完全无需担心输出对齐
-   Escape:可以使用\ 做escape 符号，如\$monkey\$ 将作为一个普通的文本，输出为$monkey$.再如为了在后加上美元符号（占位符恰好又是美元符号）可以用这俩种方式hello,it’s $money$\$, 或者Hello,it’s $money+"\$"$ 。如果要输出\符号本生，则需要用俩个\\,这点与javascript，java 语义一致.





### 3. 高级功能

#### 3.1. 配置GroupTemplate

Beetl建议通过配置文件配置配置GroupTemplate，主要考虑到未来可能IDE插件会支持Beetl模板，模板的属性，和函数等如果能通过配置文件获取，将有助于IDE插件识别。 配置GroupTemplate有俩种方法

-   配置文件： 默认配置在/org/beetl/core/beetl-default.properties 里，Beetl首先加载此配置文件，然后再加载classpath里的beetl.properties,并用后者覆盖前者。配置文件通过Configuration类加载，因此加载完成后，也可以通过此类API来修改配置信息
-   通过调用GroupTemplate提供的方法来注册函数，格式化函数，标签函数等

配置文件分为三部分，第一部分是基本配置，在第一节讲到过。第二部分是资源类配置，可以在指定资源加载类，以及资源加载器的属性，如下

```properties
RESOURCE_LOADER=org.beetl.core.resource.ClasspathResourceLoader
#资源配置，resource后的属性只限于特定ResourceLoader
#classpath 根路径
RESOURCE.root= /
#是否检测文件变化
RESOURCE.autouCheck= true
```

第1行指定了类加载器

第4行指定了模板根目录的路径，此处/ 表示位于classpath 根路径下

第6行是否自动检测模板变化，默认为true，开发环境下自动检测模板是否更改。关于如何如何自定义ResouceLoader，请参考下一章

配置文件第三部分是扩展部分，如方法，格式化函数等

```properties
#####  扩展 ##############
## 内置的方法
FN.date = org.beetl.ext.fn.DateFunction
FN.nvl = org.beetl.ext.fn.NVLFunction
.................
##内置的功能包
FNP.strutil = org.beetl.ext.fn.StringUtil

##内置的格式化函数
FT.dateFormat =  org.beetl.ext.format.DateFormat
FT.numberFormat =  org.beetl.ext.format.NumberFormat
.................

##内置的默认格式化函数
FTC.java.util.Date = org.beetl.ext.format.DateFormat
FTC.java.sql.Date = org.beetl.ext.format.DateFormat

## 标签类
TAG.include= org.beetl.ext.tag.IncludeTag
TAG.includeFileTemplate= org.beetl.ext.tag.IncludeTag
TAG.layout= org.beetl.ext.tag.LayoutTag
TAG.htmltag= org.beetl.ext.tag.HTMLTagSupportWrapper

```

FN前缀表示Function，FNP前缀表示FunctionPackage，FT表示format函数，FTC表示类的默认Format函数，TAG表示标签类。Beetl强烈建议通过配置文件加载扩展。以便随后IDE插件能识别这些注册函数



#### 3.2. 自定义方法

##### 3.2.1. 实现Function

```java
public class Print implements Function{
        public String call(Object[] paras, Context ctx){
                Object o = paras[0];
                if (o != null){
                        try{
                                ctx.byteWriter.write(o.toString());
                        }catch (IOException e){
                                throw new RuntimeException(e);
                        }
                }
                return "";
        }
}
```

call方法有俩个参数，第一个是数组，这是由模板传入的，对应着模板的参数，第二个是Context，包含了模板的上下文，主要提供了如下属性

-   byteWriter 输出流
-   template 模板本身
-   gt GroupTemplate
-   globalVar 该模板对应的全局变量
-   byteOutputMode 模板的输出模式，是字节还是字符
-   safeOutput 模板当前是否处于安全输出模式
-   其他属性建议不熟悉的开发人员不要乱动

>   1.  call方法要求返回一个Object，如果无返回，返回null即可
>   2.  为了便于类型判断，call方法最好返回一个具体的类，如date函数返回的就是java.util.Date
>   3.  call方法里的任何异常应该抛出成Runtime异常

##### 3.2.2. 使用普通的java类

尽管实现Function对于模板引擎来说，是效率最高的方式，但考虑到很多系统只有util类，这些类里的方法仍然可以注册为模板函数。其规则很简单，就是该类的所有public方法。如果需还要Context 变量，则需要在方法最后一个参数加上Context即可，如

```java
public class util{
	public String print(Object a, Context ctx){
		//balabala...
	}
}
```

注意

>   1.  从beetl效率角度来讲，采用普通类效率不如实现Function调用
>   2.  采用的普通java类尽量少同名方法。这样效率更低。beetl调用到第一个适合的同名方法。而不像java那样找到最匹配的
>   3.  方法名支持可变数组作为参数
>   4.  方法名最后一个参数如果是Context，则beetl会传入这个参数。

##### 3.2.3. 使用模板文件作为方法

可以不用写java代码，模板文件也能作为一个方法。默认情况下，需要将模板文件放到Root的functions目录下，且扩展名为.html(可以配置文件属性来修改此俩默认值) 方法参数分别是para0,para1…..

如下root/functions/page.fn

```javascript
<%
//para0,para1 由函数调用传入
var current = para0,total = para1,style=para2!'simple'
%>
当前页面 ${current},总共${total}
```

则在模板中

```javascript
<%
page(current,total);
%>
```

允许使用return 表达式返回一个变量给调用者，如模板文件functions\now.html

```javascript
<%
return date();
%>
```

在任何模板里都可以调用：

```javascript
hello time is ${now(),'yyyy-MM-dd'}
```

也可以在functions建立子目录，这样function则具有namespace，其值就是文件夹名



#### 3.3. 自定义格式化函数

需要实现Format接口

```java
public class DateFormat implements Format{
        public Object format(Object data, String pattern){
                if (data == null)
                        return null;
                if (Date.class.isAssignableFrom(data.getClass())){
                        SimpleDateFormat sdf = null;
                        if (pattern == null){
                                sdf = new SimpleDateFormat();
                        }else{
                                sdf = new SimpleDateFormat(pattern);
                        }
                        return sdf.format((Date) data);
                }else{
                        throw new RuntimeException("Arg Error:Type should be Date");
                }
        }
}
```

data 参数表示需要格式化的对象，pattern表示格式化模式，开发时候需要考虑pattern为null的情况

也可以实现ContextFormat 类抽象方法，从而得到Context，获取外的格式化信息。

```java
public abstract Object format(Object data,String pattern,Context ctx);
```



#### 3.4. 自定义标签

标签形式有俩种，一种是标签函数，第二种是html tag。第二种实际上在语法解析的时候会转化成第一种，其实现是HTMLTagSupportWrapper，此类将会寻找root/htmltag目录下同名的标签文件作为模板来执行。类似普通模板一样，在此就不详细说了

##### 3.4.1. 标签函数

标签函数类似jsp2.0的实现方式，需要实现Tag类的render方法即可

```java
public class DeleteTag extends Tag{
        @Override
        public void render(){
                // do nothing,just ignore body
                ctx.byteWriter.write("被删除了，付费可以看")
        }
}
```

如上一个最简单的Tag，将忽略tag体，并输出内容

```java
public class XianDeDantengTag extends Tag{
        @Override
        public void render(){
                doBodyRender();
        }
}
```

此类将调用父类方法doBodyRender，渲染tag body体

```java
public class CompressTag extends Tag{
        @Override
        public void render(){
                BodyContent  content = getBodyContent();
                String content = content.getBody();
                String zip = compress(conent);
                ctx.byteWriter.write(zip);
        }
}
```

此类将调用父类方法getBodyContent ，获得tag body后压缩输出

tag类提供了如下属性和方法供使用

-   args 传入标签的参数
-   gt GroupTemplate
-   ctx Context
-   bw 当前的输出流
-   bs 标签体对应的语法树，不熟悉勿动



#### 3.5. 自定义虚拟属性

可以为特定类注册一个虚拟属性，也可以为一些类注册虚拟属性

-   public void registerVirtualAttributeClass(Class cls, VirtualClassAttribute virtual) 实现VirtualClassAttribute方法可以为特定类注册一个需要属性，如下代码：

    ```java
    gt.registerVirtualAttributeClass(User.class, new VirtualClassAttribute() {
            @Override
            public String eval(Object o, String attributeName, Context ctx){
                    User user = (User) o;
                    if(attributeName.equals("ageDescritpion")){
                            if (user.getAge() < 10){
                                    return "young";
                            }else{
                                    return "old";
                            }
                    }
            }
    });
    ```

    User类的所有虚拟属性将执行eval方法，此方法根据年纪属性来输出对应的描述。

-   public void registerVirtualAttributeEval(VirtualAttributeEval e) 为一些类注册需要属性，VirtualAttributeEval.isSupport方法将判断是否应用虚拟属性到此类

    如下是虚拟属性类的定义

    ```java
    public interface VirtualClassAttribute{
            public Object eval(Object o, String attributeName, Context ctx);
    }

    public interface VirtualAttributeEval extends VirtualClassAttribute{
            public boolean isSupport(Class c, String attributeName);
    }
    ```



#### 3.6. 使用额外的资源加载器

某些情况下，模板来源不止一处，GroupTemplate配置了一个默认的资源加载器，如果通过gt.getTemplate(key),将调用默认的ResourceLoader，获取模板内容，然后转化为beetl脚本放入到缓存里。你也可以传入额外的资源管理器加载模板，通过调用gt.getTemplate(key,otherLoader)来完成;

```java
GroupTemplate gt = new GroupTemplate(conf,fileLoader)
//自定义，参考下一节
MapResourceLoader dbLoader = new MapResourceLoader(getData());
Template t = gt.getTemplate("db:1", dbLoader);

private Map getData(){
        Map data = new HashMap();
        data.put("db:1", "${a}");
        return data;
}
```

对于更复杂的模板资源来源，也可以自定义一个资源加载来完成，参考下一节



#### 3.7. 自定义资源加载器

如果模板资源来自其他地方，如数据库，或者混合了数据库和物理文件，或者模板是加密的，则需要自定义一个资源加载器。资源加载器需要实现ResourceLoader类。如下：

```java
public interface ResourceLoader{

        /**
         * 根据key获取Resource
         *
         * @param key
         * @return
         */
        public Resource getResource(String key);

        /** 检测模板是否更改，每次渲染模板前，都需要调用此方法，所以此方法不能占用太多时间，否则会影响渲染功能
         * @param key
         * @return
         */
        public boolean isModified(Resource key);

        /**
         * 关闭ResouceLoader，通常是GroupTemplate关闭的时候也关闭对应的ResourceLoader
         */
        public void close();

        /** 一些初始化方法
         * @param gt
         */
        public void init(GroupTemplate gt);

        /**  用于include，layout等根据相对路径计算资源实际的位置.
         * @param resource 当前资源
         * @param key
         * @return
         */
        public String getResourceId(Resource resource, String key);
}
```

如下是一个简单的内存ResourceLoader

```java
public class MapResourceLoader implements ResourceLoader{
        Map data;

        public MapResourceLoader(Map data){
                this.data = data;
        }

        @Override
        public Resource getResource(String key){
                String content = (String) data.get(key);
                if (content == null)
                        return null;
                return new StringTemplateResource(content, this);
        }

        @Override
        public boolean isModified(Resource key){
                return false;
        }

        @Override
        public boolean exist(String key){
                return data.contain(key);
        }

        @Override
        public void close(){

        }

        @Override
        public void init(GroupTemplate gt){

        }

        @Override
        public String getResourceId(Resource resource, String id){
                //不需要计算相对路径
                return id;
        }
}
```

init方法可以初始化GroupTemplate，比如读取配置文件的root属性，autoCheck属性，字符集属性，以及加载functions目录下的所有模板方法 如FileResourceLoader 的 init方法

```java
@Override
public void init(GroupTemplate gt){
        Map<String, String> resourceMap = gt.getConf().getResourceMap();
        if (this.root == null){
                this.root = resourceMap.get("root");
        }
        if (this.charset == null){
                this.charset = resourceMap.get("charset");
        }
        if (this.functionSuffix == null){
                this.functionSuffix = resourceMap.get("functionSuffix");
        }

        this.autoCheck = Boolean.parseBoolean(resourceMap.get("autoCheck"));

        File root = new File(this.root, this.functionRoot);
        this.gt = gt;
        if (root.exists()){
                readFuntionFile(root, "", "/".concat(functionRoot).concat("/"));
        }
}
```

readFuntionFile 方法将读取functions下的所有模板，并注册为方法

```java
protected void readFuntionFile(File funtionRoot, String ns, String path){
        String expected = ".".concat(this.functionSuffix);
        File[] files = funtionRoot.listFiles();
        for (File f : files){
                if (f.isDirectory()){
                        //读取子目录
                        readFuntionFile(f, f.getName().concat("."), path.concat(f.getName()).concat("/"));
                } else if (f.getName().endsWith(functionSuffix)){
                        String resourceId = path + f.getName();
                        String fileName = f.getName();
                        fileName = fileName.substring(0, (fileName.length() - functionSuffix.length() - 1));
                        String functionName = ns.concat(fileName);
                        FileFunctionWrapper fun = new FileFunctionWrapper(resourceId);
                        gt.registerFunction(functionName, fun);
                }
        }
}
```

Resource类需要实现OpenReader方法，以及isModified方法。对于模板内容存储在数据库中，openReader返回一个Clob，isModified 则需要根据改模板内容对应的lastUpdate（通常数据库应该这么设计）来判断模板是否更改

```java
public abstract class Resource{

        /**
         * 打开一个新的Reader
         *
         * @return
         */
        public abstract Reader openReader();

        /**
         * 检测资源是否改变
         *
         * @return
         */
        public abstract boolean isModified();
```

参考例子可以参考beetl自带的ResourceLoader



#### 3.8. 使用CompositeResourceLoader

组合加载器，可以包含多个已有的ResourceLoader，如下代码创建一个包含俩个文件和内存的ResourceLoader

```java
FileResourceLoader fileLoader1 = new FileResourceLoader(path1);
FileResourceLoader fileLoader2 = new FileResourceLoader(path2);
Map data = getData();
// 根据id加载
MapResourceLoader mapLoader = new MapResourceLoader(data);

CompositeResourceLoader loader = new CompositeResourceLoader();
loader.addResourceLoader(new StartsWithMatcher("http:").withoutPrefix(), fileLoader2);
loader.addResourceLoader(new StartsWithMatcher("db:"), mapLoader);
loader.addResourceLoader(new AllowAllMatcher(), fileLoader1);

GroupTemplate gt = new GroupTemplate(loader, conf);
Template t = gt.getTemplate("/xxx.html");
```

如上例子，groupTemplate从CompositeResourceLoader里加载/xxx.html，由于http:和db:前缀都不匹配，因此，将实际采用fileLoader1加载path1+/xxx.html，如下是xxx.html文件内容

```javascript
<%
include("/xxx2.html"){}
include("http:/xxx.html"){}
%>
```

第2行仍然是由fileLoader1加载，但第3行以http:前缀开头，因此将fileLoader2加载path2+/xxx.html.xxx.html内容如下

```javascript
<%
include("db:1"){}
%>
```

因为以db:开头，因此会采用MapResourceLoader加载，内容是key为db:1对模板



#### 3.9. 自定义错误处理器

错误处理器需要实现ErrorHandler接口的processExcption(BeetlException beeExceptionos, Writer writer);

-   beeExceptionos，模板各种异常
-   writer 模板使用的输出流。系统自带的并未采用此Writer，而是直接输出到控制台

自定义错误处理可能是有多个原因，比如

1.  想将错误输出到页面而不是控制台

2.  错误输出美化一下，而不是自带的格式

3.  错误输出的内容做调整，如不输出错误行的模板内容，而仅仅是错误提示

4.  错误输出到日志系统里

5.  不仅仅输出日志，还抛出异常。默认自带的不会抛出异常，ReThrowConsoleErrorHandler 继承了ConsoleErrorHandler方法，打印异常后抛出

    ```java
    public class ReThrowConsoleErrorHandler extends ConsoleErrorHandler{
            @Override
            public void processExcption(BeetlException ex, Writer writer){
                    super.processExcption(ex, writer);
                    throw ex;
            }
    }
    ```

beetl 提供 ErrorInfo类来wrap BeetlException，转化为较为详细的提示信息，他具有如下信息

-   type 一个简单的中文描述
-   errorCode 内部使用的错误类型标识
-   errorTokenText 错误发生的节点文本
-   errorTokenLine 错误行
-   msg 错误消息，有可能没有，因为有时候errorCode描述的已经很清楚了
-   cause 错误的root 异常，也可能没有。

BeetlException 也包含了一个关键信息就是 resourceId，即出错所在的模板文件



#### 3.10. 自定义安全管理器

所有模板的本地调用都需要通过安全管理器校验，默认需要实现NativeSecurityManager 的public boolean permit(String resourceId, Class c, Object target, String method) 方法

如下是默认管理器的实现方法

```java
public class DefaultNativeSecurityManager implements NativeSecurityManager{

        @Override
        public boolean permit(String resourceId, Class c, Object target, String method){
                if (c.isArray()){
                        //允许调用，但实际上会在在其后调用中报错。不归此处管理
                        return true;
                }
                String name = c.getSimpleName();
                String pkg = c.getPackage().getName();
                if (pkg.startsWith("java.lang")){
                        if (name.equals("Runtime") || name.equals("Process") || name.equals("ProcessBuilder")
                                        || name.equals("System")){
                                return false;
                        }
                }
                return true;
        }
}
```



#### 3.11. 注册全局共享变量

`groupTemplate.setSharedVars(Map<String, Object> sharedVars)`



#### 3.12. 布局

布局可以通过Beetl提供的include,layout 以及模板变量来完成。模板变量能完成复杂的布局

-   采用layout include

    ```javascript
    <%
     //content.html内容如下：
     layout("/inc/layout.html"){%>
     this is 正文
     ..........
     <%}%>
    ```

    如上一个子页面将使用layout布局页面，layout 页面内容如下

    ```javascript
    <%include("/inc/header.html"){} %>
    this is content:${layoutContent}
    this is footer:
    ```

    layoutContent 是默认变量，也可以改成其他名字，具体请参考layout标签函数

    全局变量总是能被布局用的页面所使用，如果布局页面需要临时变量，则需要显示的传入，如：

    ```javascript
    <%
    var user= model.user;
    include("/inc/header.html",{title:'这是一个测试页面',user:user}){} 
    %>
    ```

    这样，title和user成为全局变量，能被header.html 及其子页面引用到

-   继承布局：采用模板变量和include

    ```javascript
    <%
            var jsPart = {
    %>
    web页面js部分

    <%};%>

    <%
            var htmlPart = {
    %>
    web页面html部分

    <%};
    include("/inc/layout.html",{jsSection:jsPart,htmlSection:htmlPart}){}
    %>
    ```

    layout.html页面如下：

    ```xml
    <body>
    <head>
    ${jsSection}
    </head>
    <body>
    .......
    ${htmlSection}
    </body>
    ```



#### 3.13. 性能优化

Beetl性能已经很快了，有些策略能更好提高性能

-   使用二进制输出，此策略可以使模板在语法分析的时候将静态文本转化为二进制，省去了运行时刻编码时间，这是主要性能提高方式。但需要注意，此时需要提供一个二进制输出流，而不是字符流，否则性能反而下降
-   使用FastRuntimeEngine，默认配置。 此引擎能对语法树做很多优化，从而提高运行性能，如生成字节码来访问属性而不是传统的反射访问。关于引擎，可能在新的版本推出更好的引擎，请随时关注。
-   通过@type 来申明全局变量类型，这不能提高运行性能，但有助于模板维护
-   自定义ResourceLoader的isModified必须尽快返回，因此每次渲染模板的时候都会调用此方法

为什么Beetl性能这么好…………(待续)



#### 3.14. 分布式缓存模板

Beetl模板引擎模板在同一个虚拟机里缓存Beetl 脚本。也可以将缓存脚本到其他地方，只要实现Cache接口，并设置ProgramCacheFactory.cache即可，这样GroupTemplate将从你提供的Cache中存取Beetl脚本

>   此功能未被很好测试



#### 3.15. 定制输出

占位符输出允许定制。如所有日期类型都按照某个格式化输出，而不需要显示的使用格式化输出，或者为了防止跨脚本站点攻击，需要对类型为String的值做检查等，不必使用格式化函数，可以直接对占位符输出进行定制，代码如下

```java
PlaceholderST.output = new PlaceholderST.Output(){
        @Override
        public void write(Context ctx, Object value) throws IOException {
                //定制输出
                ctx.byteWriter.writeString("ok"+value!=null?value.toString:"");
        }
};
```

如果PlaceholderST静态变量output 不为null，将使用output 来输出



#### 3.16. 定制模板引擎

Beetl在线体验（[http://ibeetl.com:8080/beetlonline/](http://ibeetl.com:8080/beetlonline/)）面临一个挑战，允许用户输入任何脚本做练习或者分享代码。但又需要防止用户输入恶意的代码，如

```javascript
<%
for(var i=0;i<10000000;i++){
        //其他代码
}
%>
```

此时，需要定制模板引擎，遇到for循环的时候，应该限制循环次数，譬如，在线体验限制最多循5次，这是通过定义替换GeneralForStatement类来完成的，这个类对应了for(exp;exp;exp) ，我们需要改成如下样子：

```java
class RestrictForStatement extends GeneralForStatement{
        public RestrictForStatement(GeneralForStatement gf){
                super(gf.varAssignSeq, gf.expInit, gf.condtion, gf.expUpdate, gf.forPart, gf.elseforPart, gf.token);
        }

        public void execute(Context ctx){
                if (expInit != null){
                        for (Expression exp : expInit){
                                exp.evaluate(ctx);
                        }
                }
                if (varAssignSeq != null){
                        varAssignSeq.execute(ctx);
                }

                boolean hasLooped = false;
                int i = 0;
                for (; i < 5; i++){
                        boolean bool = (Boolean) condtion.evaluate(ctx);
                        if (bool){
                                hasLooped = true;
                                forPart.execute(ctx);
                                switch (ctx.gotoFlag){
                                        case IGoto.NORMAL:
                                                break;
                                        case IGoto.CONTINUE:
                                                ctx.gotoFlag = IGoto.NORMAL;
                                                continue;
                                        case IGoto.RETURN:
                                                return;
                                        case IGoto.BREAK:
                                                ctx.gotoFlag = IGoto.NORMAL;
                                                return;
                                }
                        }else{
                                break;
                        }
                        if (this.expUpdate != null){
                                for (Expression exp : expUpdate){
                                        exp.evaluate(ctx);
                                }
                        }
                }

                if (i >= 5){
                        try{
                                ctx.byteWriter.writeString("--Too may Data in loop，Ignore the left Data  for Online Engine--");
                                ctx.byteWriter.flush(); 
                        } catch (IOException e){
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }
        }

        @Override
        public void infer(InferContext inferCtx){
                super.infer(inferCtx);
        }

}
```

尽管上面代码很复杂，但实际上是改写了原来的GeneralForStatement，将原来的24行while(true) 替换成for (; i < 5; i++) 用来控制最大循环，并且62行检测如果循环退出后，i等于5，则提示Too Many Data in Loop.

现在需要将此类替换原有的GeneralForStatement，

```java
public class OnlineTemplateEngine extends DefaultTemplateEngine{
        public Program createProgram(Resource resource, Reader reader, Map<Integer, String> textMap, String cr,GroupTemplate gt){
                Program program = super.createProgram(resource, reader, textMap, cr, gt);
                modifyStatemetn(resource,program,gt);
                return program;
        }
        private void modifyStatemetn(Resource resource,Program program,GroupTemplate gt){
                Statement[] sts = program.metaData.statements;
                StatementParser parser = new StatementParser(sts, gt, resource.getId());
                parser.addListener(WhileStatement.class, new RestrictLoopNodeListener());
                parser.addListener(GeneralForStatement.class, new RestrictLoopNodeListener());
                parser.parse();
        }
}
```

继承FastRuntimeEngine有所不同，因为改引擎会copy出一个脚本做分析优化，因此，俩个脚本都需要做修改

```java
public class OnlineTemplateEngine extends FastRuntimeEngine{
        public Program createProgram(Resource resource, Reader reader, Map<Integer, String> textMap, String cr,GroupTemplate gt){
                FilterProgram program = (FilterProgram)super.createProgram(resource, reader, textMap, cr, gt);
                modifyStatemetn(resource,program,gt);
                modifyStatemetn(resource,program.getCopy(),gt);
                return program;
        }
}
```

-   StatementParser 是关键类，他允许对模板的Program进行解析，并替换其中的Statement。parser.addListener 方法接受俩个参数，第一个是需要找的类，第二个是执行的监听器。
-   可以参考在线体验的源码：http://git.oschina.net/xiandafu/beetlonline/blob/master/src/org/bee/tl/online/OnlineTemplateEngine.java

```java
class RestrictLoopNodeListener implements Listener{
        @Override
        public Object onEvent(Event e){
                Stack stack = (Stack) e.getEventTaget();
                Object o = stack.peek();
                if (o instanceof GeneralForStatement){
                        GeneralForStatement gf = (GeneralForStatement) o;
                        RestrictForStatement rf = new RestrictForStatement(gf);
                        return rf;
                }else{
                        return null;
                }
        }
}
```

该监听器返回一个新的RestrictForStatement 类，用来替换来的GeneralForStatement。如果返回null，则不需替换。这通常发生在你仅仅通过修改该类的某些属性就可以的场景

完成这些代码后，在配置文件中申明使用新的引擎

```properties
ENGINE=org.bee.tl.online.OnlineTemplateEngine
```

这样就完成了模板引擎定制。



#### 3.17. 直接运行Beetl脚本

Beetl模板本质上会转化为Beetl脚本来执行，这点跟jsp转为servlet来执行类似。GroupTemplate提供方法可以直接执行Beetl脚本

-   public Map runScript(String key, Map<String, Object> paras) throws ScriptEvalError
-   public Map runScript(String key, Map<String, Object> paras, Writer w) throws ScriptEvalError
-   public Map runScript(String key, Map<String, Object> paras, Writer w, ResourceLoader loader) throws ScriptEvalError

key为资源名，paras为脚本的全局变量，w可选参数，如果执行脚本有输出，则输出到w里,loader参数可选，如果指定，则使用此laoder加载脚本

执行脚本完毕后，返回到Map里的值可能包含如下：

-   模板的**顶级**的临时变量,key为临时变量名
-   return 值将返回到map里 ，key为return

如下脚本（此时就不需要脚本定界符了）

```javascript
var a = 1;
var b = date();
var c = '2';
return a+1;
```

调用runScript后，map里将返回key分别为a,b,c，return。 值分别为1，当前日期，字符串'2，以及3。



### 4. Web集成

#### 4.1. Web提供的全局变量

Web集成模块向模板提供web标准的变量，做如下说明

-   request 中的所有attribute.在模板中可以直接通过attribute name 来引用，如在controller层 request.setAttribute("user",user),则在模板中可以直接用${user.name} .
-   session 提供了session会话，模板通过session["name"],或者session.name 引用session里的变量
-   request 标准的HTTPSerlvetRequest,可以在模板里引用request属性（getter），如${request.requestURL}。
-   parameter 用户读取用户提交的参数。如${parameter.userId} (仅仅2.2.7以上版本支持)
-   ctxPath Web应用ContextPath
-   servlet 是WebVariable的实例，包含了HTTPSession,HTTPSerlvetRequest,HTTPSerlvetResponse.三个属性，模板中可以通过request.response,session 来引用，如 ${serlvet.request.requestURL};
-   所有的GroupTemplate的共享变量
-   pageCtx是一个内置方法 ，仅仅在web开发中，用于设置一个变量，然后可以在页面渲染过程中，调用此api获取，如pageCtx("title","用户添加页面")，在其后任何地方，可以pageCtx("title") 获取该变量。(仅仅2.2.7以上版本支持)

你可以在模板任何地方访问这些变量

如果你需要扩展更多属性，你也可以配置beetl.properties配置文件的WEBAPP_EXT属性，实现WebRenderExt接口，在渲染模板之前增加自己的扩展，如:

```properties
RESOURCE.root=/WEB-INF/views
WEBAPP_EXT = com.park.oss.util.GlobalExt
```

```java
public class GlobalExt implements WebRenderExt{
        static long version = System.currentTimeMillis();
        @Override
        public void modify(Template template, GroupTemplate arg1, HttpServletRequest arg2, HttpServletResponse arg3) {
                //js,css 的版本编号
                template.binding("sysVersion",version);
        }
}
```

这样，每次在模板里都可以访问变量sysVersion了，不需要再controller里设置，或者通过servlet filter来设置



#### 4.2. 集成技术开发指南

Beetl默认提供了WebRender用于帮助web集成开发，所有内置的集成均基于此方法。如果你认为Beetl内置的各个web框架集成功能不够，你可以继承此类，或者参考此类源码重新写，其代码如下

```java
package org.beetl.ext.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;

/**
 *  通常web渲染的类，将request变量赋值给模板，同时赋值的还有session,request,ctxPath
 *  其他框架可以继承此类做更多的定制
 * @author joelli
 *
 */
public class WebRender{
	GroupTemplate gt = null;

	public WebRender(GroupTemplate gt){
		this.gt = gt;
	}

	/**
	 * @param key 模板资源id
	 * @param request
	 * @param response
	 * @param args 其他参数，将会传给modifyTemplate方法
	 */
	public void render(String key, HttpServletRequest request, HttpServletResponse response, Object... args){
		Writer writer = null;
		OutputStream os = null;
		try{
			//response.setContentType(contentType);
			Template template = gt.getTemplate(key);
			Enumeration<String> attrs = request.getAttributeNames();

			while (attrs.hasMoreElements()){
				String attrName = attrs.nextElement();
				template.binding(attrName, request.getAttribute(attrName));
			}
			WebVariable webVariable = new WebVariable();
			webVariable.setRequest(request);
			webVariable.setResponse(response);
			webVariable.setSession(request.getSession());

			template.binding("session", new SessionWrapper(webVariable.getSession()));

			template.binding("servlet", webVariable);
			template.binding("request", request);
			template.binding("ctxPath", request.getContextPath());

			modifyTemplate(template, key, request, response, args);

			String strWebAppExt = gt.getConf().getWebAppExt();
			if(strWebAppExt!=null){
				WebRenderExt renderExt = this.getWebRenderExt(strWebAppExt);
				renderExt.modify(template, gt, request, response);
			}
			if (gt.getConf().isDirectByteOutput()){
				os = response.getOutputStream();
				template.renderTo(os);
			}else{
				writer = response.getWriter();
				template.renderTo(writer);
			}

		} catch (IOException e){
			handleClientError(e);
		} catch (BeetlException e){
			handleBeetlException(e);
		} finally{
			try{
				if (writer != null)
					writer.flush();
				if (os != null)
					os.flush();
			} catch (IOException e){
				handleClientError(e);
			}
		}
	}

	/**
	 * 可以添加更多的绑定
	 * @param template 模板
	 * @param key 模板的资源id
	 * @param request
	 * @param response
	 * @param args  调用render的时候传的参数
	 */
	protected void modifyTemplate(Template template, String key, HttpServletRequest request,
		HttpServletResponse response, Object... args){
	}

	/**处理客户端抛出的IO异常
	 * @param ex
	 */
	protected void handleClientError(IOException ex){
		//do nothing
	}

	/**处理客户端抛出的IO异常
	 * @param ex
	 */
	protected void handleBeetlException(BeetlException ex){
		throw ex;
	}
}
```



#### 4.3. Serlvet集成

只需要在Servlet代码里引用ServletGroupTemplate就能集成Beetl，他提供了一个render(String child, HttpServletRequest request, HttpServletResponse response)方法。例子如下：

```java
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    //模板直接访问users
    request.setAttribute("users",service.getUsers());
    ServletGroupTemplate.instance().render("/index.html", request, response);
}
```

ServletGroupTemplate同其他web集成一样，将读取配置文件来配置，如果需要通过代码配置，可以在Serlvet listener里 ServletGroupTemplate.instance().getGroupTemplate()方法获取GroupTemplate



#### 4.4. SpringMVC集成

需要做如下配置即可

```xml
<bean id="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init"/>
<bean id="viewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
        <property name="contentType" value="text/html;charset=UTF-8"/>
</bean>
```

同其他集成方式一样，模板的配置将放在beetl.properties中。

如果想获取GroupTemplate,可以调用如下代码

```java
BeetlGroupUtilConfiguration config = (BeetlGroupUtilConfiguration) this.getApplicationContext().getBean("beetlConfig");
GroupTemplate group = config.getGroupTemplate();
```

Controller代码如下:

```java
@RequestMapping(value = "/", method = RequestMethod.GET)
public ModelAndView index(HttpServletRequest req) {
    ModelAndView view = new ModelAndView("/index");
    //total 是模板的全局变量，可以直接访问
    view.addObject("total",service.getCount());
    return view;
}
```

[http://git.oschina.net/xiandafu/springbeetlsql](http://git.oschina.net/xiandafu/springbeetlsql) 有完整例子



#### 4.5. SpringMVC集成高级

spring集成还允许注册被spring容器管理的Function，Tag等，也还允许配置多个视图解析器等功能

```xml
<bean name="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init">
	<property name="configFileResource" value="/WEB-INF/beetl.properties"/>
	<property name="functions">
		<map>
			<entry key="testFunction" value-ref="testFunction"/>
		</map>
	</property>

	<property name="functionPackages">
		<map>
			<entry key="fp" value-ref="testFunctionPackage"/>
		</map>
	</property>

	<property name="tagFactorys">
		<map>
			<entry key="html.output" value-ref="testTagFactory"/>
			<entry key="html.output2" value-ref="testTagFactory2"/>
		</map>
	</property>

</bean>

<bean name="testTagFactory" class="org.beetl.ext.spring.SpringBeanTagFactory">
	<property name="name" value="testTag"/>
</bean>
<bean name="testTagFactory2" class="org.beetl.ext.spring.SpringBeanTagFactory">
	<property name="name" value="testTag2"/>
</bean>


<bean name="beetlViewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
	<property name="config" ref="beetlConfig"/>
	<property name="contentType" value="text/html;charset=UTF-8"/>
</bean>
```

如上图所示，BeetlGroupUtilConfiguration有很多属性，列举如下

-   configFileResource 属性指定了配置文件所在路径，如果不指定，则默认在classpath下
-   functions 指定了被spring容器管理的function，key为注册的方法名，value-ref 指定的bean的名称
-   functionPackages，指定了被spring容器管理的functionPackage，key为注册的方法包名，value-ref 指定的bean的名称
-   tagFactorys ，注册tag类，key是tag类的名称，value-ref指向一个org.beetl.ext.spring.SpringBeanTagFactory实例，该子类是一个Spring管理的Bean。属性name对应的bean就是tag类。需要注意，由于Tag是有状态的，因此，必须申明Scope为 "prototype"。如代码:

```java
@Service
@Scope("prototype")
public class TestTag extends Tag {
}
```

-   typeFormats: 同functions，参数是 Map<Class<?>, Format>，其中key为类型Class
-   formats：同functions，参数是 Map<String, Format>，其中key为格式化函数名
-   virtualClassAttributes 同functions，参数Map<Class<?>, VirtualClassAttribute>，其中key为类型Class
-   virtualAttributeEvals ，类型为List<VirtualAttributeEval>
-   resourceLoader，资源加载器 ，值是 实现ResourceLoader的一个Bean
-   errorHandler ，错误处理，值是实现ErrorHandler的一个Bean
-   sharedVars,同functions，类型是Map<String, Object>，可以在此设置共享变量
-   configProperties，类型是Properties，可以覆盖配置文件的某些属性

如下配置，指定了三个视图解析器，一个用于beetl页面渲染，一个用于cms，采用了beetl技术，另外一个一些遗留的页面采用jsp

```xml
<bean name="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init">
	<property name="configFileResource" value="/WEB-INF/beetl.properties"/>
</bean>


<bean name="cmsbeetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init">
	<property name="configFileResource" value="/WEB-INF/cms-beetl.properties"/>
</bean>


<!-- Beetl视图解析器1 -->
<bean name="beetlViewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
	<!-- 多视图解析器，需要设置viewNames和order -->
	<property name="viewNames">
		<list>
			<value>/template/**</value>
		</list>
	</property>
	<property name="suffix" value=".btl"/>
	<property name="contentType" value="text/html;charset=UTF-8"/>
	<property name="order" value="0"/>
	<!-- 多GroupTemplate，需要指定使用的bean -->
	<property name="config" ref="beetlConfig"/>

</bean>

<!-- Beetl视图解析器2 -->
<bean name="cmsBeetlViewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
	<!-- 多视图解析器，需要设置viewNames和order -->
	<property name="viewNames">
		<list>
			<value>/cmstemplate/**</value>
		</list>
	</property>
	<property name="contentType" value="text/html;charset=UTF-8"/>
	<property name="order" value="1"/>
	<!-- 多GroupTemplate，需要指定使用的bean -->
	<property name="config" ref="cmsbeetlConfig"/>

</bean>

<!-- JSP视图解析器 -->
<bean name="JSPViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<!-- 注意JSP的这个视图解析器order必须在最后 -->
	<property name="order" value="256"/>
	<!-- beetl配置不支持前缀，这不同于jsp 和 freemaker -->
	<property name="prefix" value="/WEB-INF/"/>
	<property name="suffix" value=".jsp"/>
	<property name="contentType" value="text/html;charset=UTF-8"/>
</bean>
```

Beetl视图解析器属性同spring自带的视图解析器一样，支持contentType,order,prefix,suffix等属性。

注意视图解析器里属性viewNames，这个用于判断controller返回的path到底应该交给哪个视图解析器来做。

-   以/template开头的是beetlViewResolver来渲染。
-   以/cmstemplate是交给cmsBeetlViewResolver渲染。
-   如果都没有匹配上，则是jsp渲染

如果你想更改此规则，你只能增加canHandle方法指定你的逻辑了。详情参考org.springframework.web.servlet.view.UrlBasedViewResolver.canHandle

对于仅仅需要redirect和forward的那些请求，需要加上相应的前缀

-   以"redirect:"为前缀时：表示重定向，不产生BeetlView渲染模版，而直接通过Servlet的机制返回重定向响应.redirect:前缀后面的内容为重定向地址，可以采用相对地址（相对当前url)，绝对地址(完整的url)，如果采用/开头的地址，会自动的在前面接上当前Web应用的contextPath，即contextPath为test的Web应用中使用redirect:/admin/login.html 实际重定向地址为 /test/admin/login.html
-   以"forward:"为前缀时：表示转发，不产生BeetlView渲染模版。而是直接通过Servlet的机制转发请求（关于转发和重定向的区别，请自行查看Servlet API) forward:前缀后面的内容为转发地址，一般都是以/开头相对于当前Web应用的根目录

其他集成需要注意的事项:

-   spring集成，请不要使用spring的 前缀配置,改用beetl的RESOURCE.ROOT 配置，否则include，layout会找不到模板



#### 4.6. Spring Boot集成

Spring Boot 通过java config来配置 beetl需要的BeetlGroupUtilConfiguration，和 BeetlSpringViewResolver，参考代码如下

```java
@Configuration
public class BeetlConf {

	@Value("${beetl.templatesPath}") String templatesPath;//模板跟目录 
	@Bean(initMethod = "init", name = "beetlConfig")
	public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
		try {
			ClasspathResourceLoader cploder = new ClasspathResourceLoader(BeetlConf.class.getClassLoader(),templatesPath);
			beetlGroupUtilConfiguration.setResourceLoader(cploder);
			return beetlGroupUtilConfiguration;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Bean(name = "beetlViewResolver")
	public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
		return beetlSpringViewResolver;
	}

 }
```

spring boot集成需要注意的是要添加spring-devtools.properties文件,并配置如下选项

```properties
restart.include.beetl=/beetl-xxx.jar
restart.include.beetlsql=/beetlsql-xxx..jar
```

spring-devtools.properties 为spring boot的配置文件,位于META-INF目录下



#### 4.7. Jodd集成

需要配置web.xml,将所有请求交给jodd处理，参考:http://jodd.org/doc/madvoc/setup.html

```xml
<filter>
	<filter-name>madvoc</filter-name>
	<filter-class>jodd.madvoc.MadvocServletFilter</filter-class>
	<init-param>
			<param-name>madvoc.webapp</param-name>
			<param-value>test.MyWebApplication</param-value>
	</init-param>
    <init-param>
		<param-name>madvoc.configurator</param-name>
		<param-value>test.MyAutomagicMadvocConfigurator</param-value>
	</init-param>

</filter>
<filter-mapping>
	<filter-name>madvoc</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

MyWebApplication 和 MyAutomagicMadvocConfigurator 需要自己参照如下例子写一个，前者用来设置beetl作为视图渲染，后者配置Jodd不要扫描beetl struts集成里引用的struts类

```java
public class MyAutomagicMadvocConfigurator extends AutomagicMadvocConfigurator {
	public MyAutomagicMadvocConfigurator(){
		super();
		//不扫描beetl 里jar文件里的action和result，否则，会扫描StrutsResultSupport不相干的class
		this.rulesJars.exclude("**/*beetl*.jar");
	}
}
```

```java
public class MyWebApplication  extends WebApplication{
	@Override
	protected void init(MadvocConfig madvocConfig, ServletContext servletContext) {
		//设置默认
		madvocConfig.setDefaultActionResult(BeetlActionResult.class);
	}
 }
```

最后，可以写Action了，浏览器输入/index.html,jodd将执行world方法，并渲染ok.html模板。如果你想配置GroupTemplate，正如其他集成框架一样，只需要写一个beetl.properties 即可。

```java
@MadvocAction
public class IndexAction {
	@Out
	String value;
	@Action("/index.html")
	public String world() {
		value = "Hello World!";
		return "/ok.html";
	}
}
```

[https://git.oschina.net/xiandafu/beetl-jodd-sample](https://git.oschina.net/xiandafu/beetl-jodd-sample) 有完整例子



#### 4.8. JFinal集成

Beetl提供 JFinal 集成，使用BeetlRenderFactory ，通过如下注册即可使用beetl模板引擎

```java
import org.beetl.ext.jfinal.BeetlRenderFactory
public class DemoConfig extends JFinalConfig{
        public void configConstant(Constants me){
                me.setMainRenderFactory(new BeetlRenderFactory());
                // 获取GroupTemplate ,可以设置共享变量等操作
                GroupTemplate groupTemplate = BeetlRenderFactory.groupTemplate ;
        }
}
```

业务逻辑代码:

```java
public void modify(){
	int artId = getParaToInt(0, -1);
	setAttr("title", "修改文章");
	List<Cate> cateLists = Cate.getAllCate();
	//模板里访问cateLists,atr,
	setAttr("cateLists", cateLists);
	setAttr("art", Article.dao.findById(artId));
	render("/modify.html");
}
```

BeetlRenderFactory 默认使用FileResourceLoader ，其根目录位于WebRoot目录下，如果你需要修改到别的目录，可以设置配置文件，如

```properties
RESOURCE.root= /WEB-INF/template/
```

[https://git.oschina.net/xiandafu/beetl-jfinal-sample](https://git.oschina.net/xiandafu/beetl-jfinal-sample) 有完整例子，采用jfinal+beetl写的一个博客系统



#### 4.9. Nutz集成

Nutz集成提供了 BeetlViewMaker ，实现了 ViewMaker方法，如下代码

```java
@At("/ctx")
@Ok("beetl:ctx.btl")
public Context withContext() {
	Context ctx = Lang.context();
	Pager pager = dao.createPager(1, 20);
	pager.setRecordCount(dao.count(UserProfile.class));
	List<UserProfile> list = dao.query(UserProfile.class, null, pager);
	ctx.set("pager", pager);
	ctx.set("list", list);
	return ctx;
}
```

```xml
<html>
<head>
<title>Beetl&Nutz</title>
</head>
<body>
<p>总共 ${list.~size}<p/>
<%
for(user in list){
%>
<p>hello,${user.nickname};<p/>
<%}%>

<p>当前页${pager.pageNumber},总共${pager.pageCount}页<p/>
</body>
</html>
```

需要注意的是，如果使用了nutz的obj（http://www.nutzam.com/core/mvc/view.html），则需要在模板顶部申明obj是动态对象，如

```javascript
<%
directive dynamic obj
%>

${obj.user.title}
${obj.user.name}
```



#### 4.10. Struts2集成

需要在struts2配置文件里添加result-types做如下配置

```xml
<package name="default" namespace="/" extends="struts-default">
<!--  ....   -->
<result-types>
	<result-type name="beetl"
		class="org.beetl.ext.struts2.Struts2BeetlActionResult" default="true" >
		<param name="contentType">text/html; charset=UTF-8</param>
	</result-type>
</result-types>

<action name="HelloWorld" class="com.beetl.struts.HelloWorld">
	<result>/hello.html</result>
</action>
<action name="Ajax" class="com.beetl.struts.AjaxHtml">
	<result>/table.html#table</result>
</action>
<!--  ....   -->
</package>
```

该类会根据struts配置文件获取模板，如上例的hello.html,并将formbean的属性，以及request属性作为全局变量传递给模板

[https://git.oschina.net/xiandafu/beetl-struts2-sample](https://git.oschina.net/xiandafu/beetl-struts2-sample) 有完整例子

>   #### 郑重申明
>
>   鉴于struts2有安全漏洞，而官方补丁打法很消极，所以请谨慎使用Struts2，Beetl的安全性已经通过在线体验和多个使用Beetl的网站得以体现 一旦你的struts2网站被攻破，请先确定是否是struts2 的问题



#### 4.11. 直接Web中运行Beetl模板

对于web应用来说，必须通过controller才能渲染模板，beetl也可以写完模板后，在未完成controller情况下，直接渲染模板 此方法既可以作为通常的全栈式开发人员使用，也可以用于前端人员单独开发模板用。

步骤如下：

-   配置监听器，监听器指定对*.btl的请求进行监听(假定模板名字都是以btl.结尾)。

-   实现监听器，该监听器继承父类 org.beetl.ext.web.SimpleCrossFilter，实现protected abstract GroupTemplate getGroupTemplate()方法。依据不同的集成方式，比如你的环境是Servlet，则只需要调用ServletGroupTemplate.instance().getGroupTemplate(),如果是Jfinal，需要调用BeetlRenderFactory.groupTemplate等

-   SimpleCrossFilter 提供一些有用的方法，可以帮助你定制一些特性，可以参考源码了解

-   置完成后，对于要测试的模板，可以新建一个对应的伪模型文件，比如要测试模板WebRoot/user/userList.html,可以新建立WebRoot/values/user/userList.html.var 。 values是监听器默认的伪模型的根目录

-   编辑伪模型文件，对应于userList.html需要的全局变量，userList.html.var可以申明这些些变量

    ```javascript
    var proudct = {id:1,name:'测试产品',pic:'xxxx.jpg'};
    var userList = [{id:2,name:'用户一'}];
    var session= {admin:{id:1,name:'admin'}};
    ```

-   通过浏览器直接访问http://ip:port/user/userList.html ，监听器会预先执行userList.html.var，并将返回值作为模板的全局变量，传给userList.html

-   可以将一些公共的变量放到WebRoot/values/common.var里（比如上面代码的session）. 监听器会先执行common.var,然后再执行userList.html.var

>   直接访问模板前提是使用了伪模型，这与实际的项目采用的模型并不一致，因此当模板采用伪模型验证后，需要重启web应用，才能使用真正的模型去测试，否则，模板引擎会报错，这是因为beetl默认的FastRuntimeEngine会根据模型优化模板，对同一个模板不同的模型会报错，除非采用DefaultTemplateEngine 或者页面申明类型变量是动态的。



#### 4.12. 整合ajax的局部渲染技术

越来越多web网站依赖于ajax，如table的翻页，流行方式是浏览器发出ajax请求，后台处理后返回一个json，浏览器端将json数据拆开，拼成一条一条的行数据，然后生成dom节点，追加到表格里。 作为另外一种可选技术，beetl支持局部渲染技术，允许后台处理返回的是一个完成的html片段，这样，前端浏览器可以直接将这个html片段追加到表格里。在我做的性能测试里，俩种方式性能差别不大([http://beetlajax.oschina.mopaas.com/](http://beetlajax.oschina.mopaas.com/))

比如模板index.html有很多动态内容，有动态生成的菜单，有右侧的top10，也有核心区域的表格，大概内容如下

```javascript
<#menu/>
<#top10> ....</#top10>
<div id="table-container" >
<%
//ajax片段开始
#ajax userTable: {
%>

<table>
        <tr><td width=100>id</td><td width=100>姓名</td></tr>
        <%for(user in users){%>
        <tr><td>${user.id}</td><td>${user.name}</td></tr>
        <%}%>
</table>

当前页面<span id="current">${page!1}</span><span style="width:20px"></span>
<a href="#"><span  class="page">next</span></a> <a href="#" ><span  class="page">pre</span></a>
<%
//ajax片段结尾
}
%>
```

\#ajax 用于告诉告诉模板引擎，此处是个局部渲染标记，标记为"userTable",对于正常渲染视图"index.html"页面,#ajax标记没什么用处,table仍能得到正常渲染。如果渲染的视图是index.html#userTable,则模板只会渲染#ajax标记得模板片段，其他部分将忽略。关于完整例子，可以参考http://beetlajax.oschina.mopaas.com/

后台代码如下:

```javascript
render("/index.html#userTable");
```

ajax 片段渲染也支持默认情况下不渲染，仅仅做为一个片段使用，如一个页面有许多后台交互操作，并返回相应的html片段，可以将这些html片段也放到同一个模板里，使用ajax norender，表示渲染整个模板的时候默认并不需要渲染此ajax片段

```javascript
<%
<html>

</html>
#ajax norender success: {
%>
<div id="success"> 操作成功
</div>

<%
}
%>

#ajax norender failure: {
%>
<div id="failure"> 操作失败
</div>

<%
}
%>
```

这样，此页面默认情况下并没有输出success,和 failure片段

>注意，Ajax片段本质上是从模版的ajax标记处开始渲染，因此，ajax需要的变量在模版里也必须是全局变量，如果你只是个局部变量，beetl会报出找不到变量，即使你binding了这个变量，beetl也认为这个是局部变量，如
>
>```javascript
><%
>var tableData = paras.table;
>#ajax userTable: {
>for(user in tableData);
>%>
>
><%
>//ajax片段结尾
>}
>%>
>```
>
>变量tableData是从paras里获取的，是个临时变量，因此就算你在后台binding了一个tableData，beetl 也不能识别。在渲染ajax片段的时候会报变量tableData找不到。改正的办法只能是让tableData全局变量。

>   返回Json好还是返回html片段好？这个难以定论.
>
>   -   从后台性能看，将模型序列化成json性能会比渲染模板性能更好，但是，json还需要前端重新解析生成最终html dom节点，这可能会延迟最终数据的现实效果。而返回的html片段就是已经生成好的dom
>   -   从网络传入来看，json无疑更好的，html片段会有额外的html标记，css属性，以及有可能的js调用。传入流量有可能增加50%到100%。但是，对于web应用类，这些额外数据，并不算多。
>   -   从开发效率来讲，返回html片段的开发效率更高一些，因为渲染在后台操作，可以随心所欲的用模板语言来渲染，来取得后台数据，完成复杂渲染，而json就比较困难，可以说所有的json lib都没有完美的解决办法。
>   -   从用户体验上来讲，Beetl 采用ajax标记，混合了传统的模板渲染和ajax加载。用户进入页面即能看到数据，而经典的ajax json方式还需要异步加载，显示延迟。另外如果页面同时有多个ajax加载，则会对服务器造成很大的压力。
>   -   关心服务器cpu消耗？ 模板方式消耗更多的cpu，json方式则少点。但是俩者差距并不大。而且更多的web网站面临的情况是有富余的服务器CPU能力
>   -   关心客户端CPU消耗？ 过多的js无疑是客户端运行慢的主要原因。如果采用经典的json方式，返回的json数据必然还需要经过js的计算和渲染。会影响客户机器cpu。



#### 4.13. 在页面输出错误提示信息

2.2.3版本以后，新增加org.beetl.ext.web.WebErrorHandler,可以在web开发的时候在页面输出提示信息，在产品模式下载后台输出提示信息（通过配置属性ESOURCE.autoCheck= true来认为是开发模式），仅仅需要配置如下:

```properties
ERROR_HANDLER = org.beetl.ext.web.WebErrorHandler
```





### 5. 附录

#### 5.1. 内置方法

##### 5.1.1. 常用内置方法

-   **date** 返回一个java.util.Date类型的变量，如 date() 返回一个当前时间(对应java的java.util.Date); ${date( "2011-1-1" , "yyyy-MM-dd" )} 返回指定日期
-   **print** 打印一个对象 print(user.name);
-   **println** 打印一个对象以及回车换行符号，回车换号符号使用的是模板本身的，而不是本地系统的.如果仅仅打印一个换行符，则直接调用println() 即可
-   **nvl** 函数nvl，如果对象为null，则返回第二个参数，否则，返回自己 nvl(user,"不存在")
-   **isEmpty** 判断变量或者表达式是否为空，变量不存在，变量为null，变量是空字符串，变量是空集合，变量是空数组，此函数都将返回true
-   **isNotEmpty** 同上，判断对象是否不为空
-   has 变量名为参数，判断是否存在此全局变量，如 has(userList),类似于1.x版本的exist("userList"),但不需要输入引号了
-   **assert** 如果表达式为false，则抛出异常
-   **trunc** 截取数字，保留指定的小数位，如trunc(12.456,2) 输出是12.45
-   **decode** 一个简化的if else 结构，如 decode(a,1,"a=1",2,"a=2","不知道了")},如果a是1，这decode输出"a=1",如果a是2，则输出"a==2", 如果是其他值，则输出"不知道了"
-   debug 在控制台输出debug指定的对象以及所在模板文件以及模板中的行数，如debug(1),则输出1 [在3行@/org/beetl/core/lab/hello.txt],也可以输出多个，如debug("hi",a),则输出hi,a=123,[在3行@/org/beetl/core/lab/hello.txt]
-   **parseInt** 将数字或者字符解析为整形 如 parseInt("123");
-   **parseLong** 将数字或者字符解析为长整形，parseInt(123.12);
-   **parseDouble** 将数字或者字符解析为浮点类型 如parseDouble("1.23")
-   **range** 接收三个参数，初始值，结束值，还有步增（可以不需要，则默认为1），返回一个Iterator，常用于循环中，如for(var i in range(1,5)) {print(i)},将依次打印1234.
-   **flush** 强制io输出。
-   **json**，将对象转成json字符串，如 var data = json(userList) 可以跟一个序列化规则 如,var data = json(userList,"[*].id:i"),具体参考 [https://git.oschina.net/xiandafu/beetl-json](https://git.oschina.net/xiandafu/beetl-json)
-   **pageCtx** ，仅仅在web开发中，设置一个变量，然后可以在页面渲染过程中，调用此api获取，如pageCtx("title","用户添加页面")，在其后任何地方，可以pageCtx("title") 获取该变量
-   **type.new** 创建一个对象实例，如 var user = type.new("com.xx.User"); 如果配置了IMPORT_PACKAGE，则可以省略包名，type.new("User")
-   **type.name** 返回一个实例的名字，var userClassName = type.name(user),返回"User"

##### 5.1.2. 字符串相关方法

>   strutil方法对参数均不做空指针检测，你可自定义方法来覆盖这些内置的方法

-   **strutil.startWith** ${ strutil.startWith(“hello”,”he”) 输出是true
-   **strutil.endWith** ${ strutil.endWith(“hello”,”o”) 输出是true
-   **strutil.length** ${ strutil. length (“hello”),输出是5
-   **strutil.subString** ${ strutil.subString (“hello”,1),输出是“ello”
-   strutil.subStringTo ${ strutil.subStringTo (“hello”,1,2),输出是“e”
-   **strutil.split** ${ strutil.split (“hello,joeli”,”,”),输出是数组，有俩个元素，第一个是hello，第二个是joelli”
-   strutil.contain ${ strutil.contain (“hello,”el”),输出是true
-   **strutil.toUpperCase** ${ strutil.toUpperCase (“hello”),输出是HELLO
-   **strutil.toLowerCase** ${ strutil.toLowerCase (“Hello”),输出是hello
-   **strutil.replace** ${ strutil.replace (“Hello”,”lo”,”loooo”),输出是helloooo
-   strutil.format ${ strutil.format (“hello,{0}, my age is {1}”,”joeli”,15),输出是hello,joelli, my age is 15. 具体请参考http://docs.oracle.com/javase/6/docs/api/java/text/MessageFormat.html
-   **strutil.trim** 去掉字符串的尾部空格
-   **strutil.formatDate** var a = strutil.formatDate(user.bir,’yyyy-MM-dd’);
-   **strutil.index** var index = strutil.index("abc","a");返回 索引0
-   **strutil.lastIndex** var index = strutil.lastIndex("aba","a");返回索引2

##### 5.1.3. 数组相关方法

-   **array.range** 返回数组或者Collection一部分，接受三个参数，第一个是数组或者Collection子类，第二，三个参数分别是起始位置
-   **array.remove** 删除某个数组或者Collection的一个元素，并返回该数组或者Collection.第一个是数组或者Collection子类,第二个参数是元素
-   **array.add** 向数组或者Collection添加一个元素，并返回该数组或者Collection。第一个是数组或者Collection子类,第二个参数是元素
-   array.contain 判断数组或者元素是否包含元素，如果包含，返回true。否则false。第一个是数组或者Collection子类,第二个参数是元素
-   **array.toArray** 转化成数组,如array.toArray(1,2,"a");
-   **array.collection2Array** 将java集合转化为数组 array.collection2Array([1,2,''])

##### 5.1.4. 正则表达式相关方法

-   **reg.match(str,regex)** str为需要处理的字符串，regex是表达式
-   **reg.replace(str,regex,replace)**，str为需要处理的字符串，regex是表达式，替换的字符串替换字符串
-   **reg.find(str,regex)** 返回找到的符合表达式的第一个字符串，否则返回空字符串
-   **reg.findList(str,regex)** 找到所有符合表达式的字符串，否则返回空列表
-   **reg.split(str,regex)**,对字符串进行切分，返回列表
-   **reg.split(str,regex,limit)** 同上，limit是最多返回个数

##### 5.1.5. Spring 相关函数

Spring函数并没有内置，需要注册，如下

```xml
<bean name="beetlGroupUtilConfiguration" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init">
	<property name="functions">
		<map>
			<!-- 定义SpEL方法 -->
			<entry key="spel">
				<bean class="org.beetl.ext.spring.SpELFunction"/>
			</entry>
		</map>
		</property>
		 <property name="functionPackages">
		<map>
			<entry key="sputil">
				<bean class="org.beetl.ext.spring.UtilsFunctionPackage"/>
			</entry>
		</map>
	</property>
</bean>
```

spel(spelString, rootObject) SpEL方法传入一个Spring SpEL表达式以获取表达式结果，方法建议以函数的方式定义在BeetlGroupUtilConfiguration的functions中

spelString: SpEL表达式字符串，必传(否则返回null) rootObject: 作为spel的根对象（对应#root），可以是一个Map或Bean对象，默认取空Map。由于Beetl运行上下文无法直接获取模版局部变量的变量名，建议局部变量采用自定义Map的方式传入

-   列表筛选（以自定义Map为根对象传入局部变量）

    ```javascript
    <% var intArray = [12, 1, 2, 3]; %>
    ${spel('#root.intArray.?[#this>10]', {intArray: intArray})}
    ```

-   以Bean对象为根对象

    ```javascript
    <% var now = date(); %>
    ${spel('#root.year + 1900', now)}
    ```

-   直接new对象

    ```javascript
    ${spel('(new java.util.Date()).year + 1900')}
    ```

-   直接引用Spring Bean

    ```javascript
    ${spel('@testBean')}
    ```

-   默认变量

-   \#root 表示SpEL的根对象, 由spel函数第二参数传入，默认是一个空map

-   \#context 表示Beetl执行上下文

-   \#global 表示Beetl的共享变量Map，由于Beetl上下文无法获取临时变量名，临时变量建议使用根对象的方式传入

-   \#ctxPath 表示Servlet Context Path（由Beetl WebRender提供）

-   \#servlet 可以从中获取到Servlet request，response，session原生实例（由Beetl WebRender提供）

-   \#parameter 表示请求参数Map（由Beetl WebRender提供）

-   \#request 表示请求对象（由Beetl WebRender提供）

-   \#session 表示会话域属性Map（由Beetl WebRender提供）

sputil 提供了spring内置的一些功能，如

```java
// 测试source中是否包含了candidates的某个成员(相当于交集非空)
sputil.containsAny(Collection<?> source, Collection<?> candidates)
// 返回在source集合总第一个也属于candidates集的元素
sputil.findFirstMatch(Collection<?> source, Collection<?> candidates)
// 测试指定文本是否匹配指定的Ant表达式(\*表达式), 多个表达式只要一个匹配即可
sputil.antMatch(String input, String... patterns)
// 返回指定路径表示的文件的扩展名(不带点.)
sputil.fileExtension(String path)
// 忽略大小写的endsWith
sputil.endsWithIgnoreCase(String input, String suffix)
// 忽略大小写的startsWith
sputil.startsWithIgnoreCase(String input, String prefix)
// 测试输入值是否为空白, null视为空白, 无视字符串中的空白字符
sputil.isBlank(String input)
// 首字母大写转换
sputil.capitalize(String input)
// 首字母小写转换
sputil.uncapitalize(String input)
// 在集合或数组元素之间拼接指定分隔符返回字符串
// null表示空集, 其他类型表示单元素集合
sputil.join(Object collection, String delim)
// 同上, 只是会在最后结果前后加上前缀和后缀
// 注意这个函数名叫做joinEx
sputil.joinEx(Object collection, String delim, String prefix, String suffix)
// 对文本进行html转义
sputil.html(String input)
// 对文本进行javascript转义
sputil.javaScript(String input)
```

##### 5.1.6. Spring security

下列三个函数只需以函数的方式定义在BeetlGroupUtilConfiguration的functions中即可，与spel函数一样的，函数名声明在functions中，可以更改

-   auth() 对应类: org.beetl.ext.spring.AuthenticationFunction 方法无参数 返回值: 返回当前安全上下文中的用户认证凭证Authentication实例 如果当前环境不存在Spring Security安全上下文，将返回null值
-   urlIf(\<url\>, \<method\>) 对应类: org.beetl.ext.spring.AccessUrlIfFunction 参数: url: 字符串表示的测试URL Path，不需要指定Context Path，缺省会直接返回true method: 字符串表示的访问方式, 默认为GET, 建议全大写 返回值: 测试当前登录用户是否能访问指定的URL Path, 返回true or false

示例:

```javascript
urlIf('/system/admin_update.do', 'POST'))
```

如果当前环境不存在Spring Security安全上下文，将返回true 如果当前环境不存在用户认证凭证，作为匿名登录进行测试

-   expIf(\<exp\>) 对应类: org.beetl.ext.spring.AccessExpressionIfFunction 参数: exp: Spring Security安全表达式，缺省会直接返回true 返回值: 测试当前登录用户是否满足指定的安全表达式，返回true or false 示例:

    ```javascript
    expIf('isAuthenticated()')
    ```

如果当前环境不存在Spring Security安全上下文，将返回true 如果当前环境不存在用户认证凭证，作为匿名登录进行测试

注意: 使用此方法，必须开启Spring Security的expression功能(use-expressions="true")：

```xml
<sec:http auto-config="true" use-expressions="true"></sec:http>
```

Spring Security Expression相关语法，请阅读： [http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#el-access](http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#el-access)

##### 5.1.7. shiro

参考文档 [https://my.oschina.net/xiandafu/blog/143109](https://my.oschina.net/xiandafu/blog/143109)



#### 5.2. 内置格式化方法

-   dateFormat 日期格式化函数，如 $*yyyy-Mm-dd*，等于符号后的参数也可以没有，则使用本地默认来做格式化如 ${date,dateFormat}
-   numberFormat ${0.345,numberFormat="#.%"} 输出是 34.5%,具体请参考文档 [http://docs.oracle.com/javase/6/docs/api/java/text/DecimalFormat.html](http://docs.oracle.com/javase/6/docs/api/java/text/DecimalFormat.html)



#### 5.3. 内置标签函数

-   include include一个模板，如 :

    ```javascript
    <%include("/header.html"){}%>
    ```

    如果想往子模板中传入参数，则可以后面跟一个json变量

    ```javascript
    <%include("/header.html",{'user':user,'id',user.id}){}%>
    ```

    这样user，和id 可以在header.html被引用，并成为header.html的全局变量

    >   (beetl1.2 也叫includeFileTemplate ，2.0仍然支持，但不再文档里体现了)

-   layout 提供一个布局功能，每个页面总是由一定布局，如页面头，菜单，页面脚，以及正文。 layout标签允许为正文指定一个布局，如下使用方式

    content.html内容如下：

    ```javascript
    <%
    //content.html内容如下：
    layout("/inc/layout.html"){%>
    this is 正文
    ..........
    <%}%>
    ```

    layout.html 是布局文件，内容如下

    ```javascript
    <%include("/inc/header.html"){} %>
    this is content:${layoutContent}
    this is footer:
    ```

    运行content.html模板文件后，，正文文件的内容将被替换到layoutContent的地方，变成如下内容

    ```javascript
    this is header
    this is content:this is 正文
    ............
    this is footer:
    ```

    如果想往layout页面传入参数，则传入一个json变量，如下往layout.html页面传入一个用户登录时间

    ```javascript
    <%layout("/inc/header.html",{'date':user.loginDate,'title':"内容页面"}){%>
    this is 正文
    ..........
    <%}%>
    ```

    如果layoutContent 命名有冲突，可以在layout第三个参数指定，如

    ```javascript
    <%layout("/inc/header.html",{'date':user.loginDate,'title':"内容页面"},"myLayoutContent"){%>
    this is 正文
    ..........
    <%}%>
    ```

-   cache 能Cache标签的内容，并指定多长时间刷新，如

    ```javascript
    <%:cache('key2',10,false){  %>
    内容体
    <%}%>
    ```

    需要指定三个参数

    -   第一个是cache的Key值
    -   第二个是缓存存在的时间，秒为单位
    -   第三个表示是否强制刷新，false表示不，true表示强制刷新

    Cache默认实现org.beetl.ext.tag.cache.SimpleCacheManager. 你可以设置你自己的Cache实现，通过调用CacheTag. cacheManager= new YourCacheImplementation();

    可以在程序里调用如下方法手工删除Cache：

    ```java
    public void clearAll();

    public void clearAll(String key);

    public void clearAll(String... keys);
    ```

-   includeJSP,可以在模板里包括一个jsp文件，如：

    ```javascript
    <%
    includeJSP("/xxxx.jsp",{"key":"value"}){}
    %>
    ```

    key value 都是字符串，将以parameter的形式提供给jsp，因此jsp可以通过request.getParameter("key")来获取参数

    主要注意的是，这个标签并非内置，需要手工注册一下

    ```java
    groupTemplate.registerTag("incdlueJSP",org.beetl.ext.jsp.IncludeJSPTag.class);
    ```



#### 5.4. 性能优化的秘密

Beetl2.0目前只完成了解释引擎，使用解释引擎好处是可以适用于各种场景，性能测试表明，Beetl2.0引擎是Freemaker的4－6倍，跟最好的 的编译引擎性能相比，也相差只有30%百分点。为什么Beetl能跑的如此之快呢，简单的说，有如下策略

-   优化IO输出，允许使用字节直接输出，模板中的静态文本事先转化为字节
-   encode优化，对于number类型，输出通常是.toString 转化成String，然后encode输出，这中间浪费了大量的资源，Beetl实现了encode，输出一步到位
-   Context 采用一维数组，语言里的Context通常采用Map实现，每次进入{} ，就新增一个child Map，尽管map很快，但不够快。也有其他模板语言采用二位数组提高性能，Beetl是通过固定大小一维数组来维护模板的Context，因此访问更快，也避免了Map和二维素组的频繁创建。其实除了此处，beetl很多地方都不采用Map来维护key-value, 而都采用数组索引，以追求性能极限
-   字节码访问属性，通过反射获取性能比较慢，就算JVM有优化，但优化效果也不确定。Beetl通过字节码生成了属性访问类，从而将属性访问速度提高了一个数量级
-   类型推测：Beetl 是强制类型的，因此预先知道类型，可以对模板做一些优化而省去了动态判断类型的时间
-   使用数组Buffer，避免频繁创建和销毁数组
-   编译引擎将模板编译成类，会产生大量的类，虚拟机很难对这些做优化。而解释引擎只有几十个固定的类，虚拟机容易优化

>   #### 相关文章
>
>   -   为什么JSP会比Beetl慢 [http://my.oschina.net/xiandafu/blog/475740](http://my.oschina.net/xiandafu/blog/475740)
>   -   Beetl 性能揭秘 2 ：语言如何存取变量 [http://my.oschina.net/xiandafu/blog/293167](http://my.oschina.net/xiandafu/blog/293167)
>   -   Beetl 性能揭秘 1 ：如何输出一个整型变量 [http://my.oschina.net/xiandafu/blog/284823](http://my.oschina.net/xiandafu/blog/284823)



#### 5.5. 性能测试对比

测试用例一 [https://github.com/javamonkey/ebm](https://github.com/javamonkey/ebm)

![beetl1](beetl1.jpg)

测试用例二 [http://git.oschina.net/kiang/teb](http://git.oschina.net/kiang/teb)

![beetl2](beetl2.png)

测试用例三 https://github.com/javamonkey/template-benchmark

![beetl3](beetl3.png)

| Benchmark      | version | Threads | Samples | Score            | Score Error (99.9%) | Unit  |
| -------------- | ------- | ------- | ------- | ---------------- | ------------------- | ----- |
| **Beetl**      | 2.7     | 1       | 50      | **42125.112914** | 3512.147131         | ops/s |
| **Freemarker** | 2.3     | 1       | 50      | **13099.139808** | 339.612022          | ops/s |
| **Handlebars** | 4.0     | 1       | 50      | **15808.044125** | 235.109622          | ops/s |
| **Mustache**   | 0.9     | 1       | 50      | **17961.391809** | 158.524109          | ops/s |
| **Rocker**     | 0.1     | 1       | 50      | **33631.370722** | 417.915637          | ops/s |
| **Thymeleaf**  | 3.0     | 1       | 50      | **4625.981276**  | 67.313609           | ops/s |

>   #### 注意
>
>   Score得分越高表示模板引擎每秒处理量越大性能越好
>
>   这个性能测试基本上结合了国内外的模板引擎，随着JDK版本的升级，JDK8提高了反射能力，减少了和Freemarker等模板引擎的性能差距，但Beetl依旧以3倍以上的性能优势秒杀Freemarker。

#### 5.6. Beetl 开发团队

作者

-   闲.大赋

助手

-   作死模式：核心代码开发
-   一粟蜉蝣：核心代码开发和版本发布

代码捐助者

-   逝水fox ：出色完成spring集成
-   kraken: 集合方法等扩展
-   西安玛雅牛：复合加载器
-   级?!: beetl扩展，crossMVC
-   orangetys： beetl插件
-   Oo不懂oO: beetl插件
-   原上一颗草:Beetl早期使用者。
-   龙图腾飞 ，WebErrorHandler，用来开发模式在 web上显示错误而不是控制台
-   nutz: nutz 集成和MapResourceLoader
-   天方地圆 :提供正则方法

文档校验

-   九月
-   Daemons