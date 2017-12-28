<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    <h1>客户列表管理_登录<h1><hr>
    <!-- 显示错误信息 -->
	<c:if test="${allErrors!=null }">
		<c:forEach items="${allErrors }" var="error">
			${ error.defaultMessage}<br />
		</c:forEach>
	</c:if>
    <form action="${pageContext.request.contextPath }/user/login.action" method="POST">
    <c:if test="${userlogin==null}">
    	<table>
    		<tr>
    			<td>username</td>
    			<td><input type="text" name="name"/></td>
    		</tr>
    		<tr>
    			<td>password</td>
    			<td><input type="password" name="password"/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" name="submit" value="login"/></td>
    		</tr>
    	</table>
    </c:if>
    <c:if test="${userlogin!=null}">
    	<table>
    		<tr>
    			<td>username</td>
    			<td><input type="text" name="name" value="${userlogin.name }"/></td>
    		</tr>
    		<tr>
    			<td>password</td>
    			<td><input type="password" name="password" value="${userlogin.password }"/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" name="submit" value="login"/></td>
    		</tr>
    	</table>
    </c:if>
    </form>
  </body>
</html>
