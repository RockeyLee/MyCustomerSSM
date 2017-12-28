<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  
  <body>
    <h1>客户列表管理</h1><hr>
    <c:if test="${user==null}">
    	游客您好！
    	<a href="${pageContext.request.contextPath }/user/toLoginJsp.action">登录</a>
    	<a href="${pageContext.request.contextPath }/user/toRegisterJsp.action">注册</a>
    </c:if>
    <c:if test="${user!=null}">
    	欢迎登入，${user.name}<br/>
    	<a href="${pageContext.request.contextPath }/user/logOut.action">注销</a><br/>
    	<c:if test="${user.role=='admain'}">
    		<a href="${pageContext.request.contextPath }/customer/addCustomer.action">添加用户信息</a><br/>
    	</c:if>
    	<c:if test="${page!=null}">
    		<a href="${pageContext.request.contextPath }/customer/showCustomer.action?targetpage=${page.thispage }">显示用户信息</a><br/>
    	</c:if>
    	<c:if test="${page==null}">
    		<a href="${pageContext.request.contextPath }/customer/showCustomer.action?targetpage=1">显示用户信息</a><br/>
    	</c:if>
    </c:if>
    
  </body>
</html>
