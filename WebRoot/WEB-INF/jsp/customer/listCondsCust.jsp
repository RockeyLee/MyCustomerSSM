<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<h1>客户列表页面</h1><hr>
  	<table border="1" width="100%">
  		<tr>
  			<th>客户姓名</th>
  			<th>客户性别</th>
  			<th>出生日期</th>
  			<th>手机号码</th>
  			<th>电子邮箱</th>
  			<th>客户爱好</th>
  			<th>客户类型</th>
  			<th>描述信息</th>
  			<c:if test="${user.role=='admain'}">
  				<th>修改</th>
  				<th>删除</th>
  			</c:if>
  		</tr>
  		<c:forEach items="${listByConds}" var="cust">
	  		<tr>
	  			<td><c:out value="${cust.name }"/></td>
	  			<td><c:out value="${cust.gender }"/></td>
	  			<td><c:out value="${cust.birthday }"/></td>
	  			<td><c:out value="${cust.cellphone }"/></td>
	  			<td><c:out value="${cust.email }"/></td>
	  			<td><c:out value="${cust.preference }"/></td>
	  			<td><c:out value="${cust.type }"/></td>
	  			<td><c:out value="${cust.description }"/></td>
	  			<c:if test="${user.role=='admain'}">
	  				<td><a href="${pageContext.request.contextPath }/customer/modifyCustomer.action?custId=${cust.id }">修改</a></td>
	  				<td><a href="${pageContext.request.contextPath }/customer/deleteCustomer.action?custId=${cust.id }">删除</a></td>
	  			</c:if>
	  		</tr>
  		</c:forEach>
  	</table>
  </body>
</html>
