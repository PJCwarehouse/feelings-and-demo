实现XML映射的流程
1.首先在Dao层中设计需要的接口文件
sql文件中的变量通过@Param传参传进去的
例如：
  Users checkUser(@Param("username")String userName);
2.在resource下新建一个mapper文件夹，创建mapper.xml配置文件夹
mapper配置需要包括以下内容：
(1)<mapper>中包含namespace对应相应的mapper包
(2)方法中要通过id去对应mapper类中的方法 
例如：
    <sql id="Base_Column_List">
        humi, exception_id, exception_record_time,temp,light,temp_exception,humi_exception,light_exception
    </sql>
(3)使用resultType设置对应的返回结果类型
例如：
    <select id="selectFirstTenExceptions" resultType="com.example.smartagriculture.demos.web.Entity.Exceptions">
        SELECT * FROM exceptions ORDER BY exception_id DESC LIMIT 10;
    </select>
(4)变量要用对应的参数来映射，如果直接使用识别不了，就用arg0，arg1...来映射
例如：
    <insert id="signup" parameterType="String">
        INSERT INTO users (user_name, password) VALUES (#{arg0}, #{arg1} )
    </insert>
经过测试，直接使用识别不了的解决方法是在Mapper接口中没有使用“@Param”注解，使用后即可在xml中直接使用名字来映射
Mapper层    void signup(@Param("userName") String userName,@Param("password") String password );
xml中sql语句：        
    <insert id="signup" parameterType="com.example.smartagriculture.demos.web.Entity.Users">
        INSERT INTO users (user_name, password) VALUES (#{userName}, #{password} )
    </insert>

3.在application.properties文件中配置xml文件和mapper文件的对应关系
例如：
mybatis.mapper-locations=classpath:mappers/*xml


一键创建映射文件的技巧：
file  -->  settings  -->  editor(编辑器)  -->  file and code templates(文件和代码模板)  --> 点击加号 -->  name：mapper.xml 
切记要把 Extension改成xml，否则会报错 然后将下面的代码复制到空白处即可

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--mybatis-3-mapper.dtd:约束文件的名称，限制和检查在当前文件中出现的标签和属性符合mybatis的要求-->
<!--namespace：命名空间，要有唯一的值，要求使用dao接口的权限定名称（一个dao接口对应一个mapper，namespace指明对应哪个dao接口）-->
<mapper namespace="根据自己的路径填写">
 <!-- 所有的数据库操作都要写在mapper标签中，可以使用特定的标签表示数据库中的特定操作 -->
</mapper>
