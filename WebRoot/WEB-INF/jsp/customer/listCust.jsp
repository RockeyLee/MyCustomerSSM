<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function checkAll(allC){
  			var otherCs = document.getElementsByName("delId");
  			for(var i=0;i<otherCs.length;i++){
  				otherCs[i].checked = allC.checked;
  			}
  		}
  		function changepage(obj){
  			if(isNaN(obj.value)){
  				alert("必须是数字");
  				obj.value=${page.thispage}
  				return;
  			}else if(obj.value > ${page.pagecount}||obj.value <=0){
  				alert("必须在页数范围内");
  				obj.value=${page.thispage}
  				return;
  			}else{
  				window.location.href="${pageContext.request.contextPath}/customer/showCustomer.action?targetpage="+obj.value;
  			}	
  		}
  	</script>
  </head>
  <body style="text-align: center;">
  	<h1>客户列表页面</h1><hr>
  	<!-- 显示错误信息 -->
		<c:if test="${allErrors!=null }">
			<c:forEach items="${allErrors }" var="error">
				${ error.defaultMessage}<br />
			</c:forEach>
		</c:if>
  	<form action="${pageContext.request.contextPath }/customer/findCustomerByConds.action" method="POST">
  		客户姓名:<input type="text" name="name" value="${customerConds.name}"/>
  		客户电话：<input type="text" name="cellphone" value="${customerConds.cellphone}"/>
		<input type="submit" value="查询客户"/>
  	</form>
  	<form action="${pageContext.request.contextPath}/customer/batchDelelteCustomers.action" method="POST">
  	<table border="1" width="100%">
  		<tr>
  			<c:if test="${user.role=='admain'}">
  				<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
  			</c:if>
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
  		<c:forEach items="${sessionScope.page.list}" var="cust">
	  		<tr>
	  			<c:if test="${user.role=='admain'}">
	  				<td><input type="checkbox" name="delId" value="${cust.id }" /></td>
	  			</c:if>
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
  	<input type="submit" value="批量删除"/>
  	共${page.rowcount}条记录，共${page.pagecount }页
    	<c:if test="${page.thispage==page.firstpage}">
    		首页
    	</c:if>
    	<c:if test="${page.thispage!=page.firstpage}">
    		<a href="${pageContext.request.contextPath}/customer/showCustomer.action?targetpage=${page.firstpage }">首页</a>
    	</c:if>
    	<c:if test="${page.thispage==page.firstpage}">
    		上一页
    	</c:if>
    	<c:if test="${page.thispage!=page.firstpage}">
    		<a href="${pageContext.request.contextPath}/customer/showCustomer.action?targetpage=${page.prepage }">上一页</a>
    	</c:if>
    	<!-- if pagecount<=5
				show all page
			else if pagecount>5
				if thispage<=3
					show 1--5
				if thispage>=pagecount-2
					show pagecount-4 -- pagecount
				else 
					show thispage-2 -- thispage+2 -->
    	<c:if test="${page.pagecount<=5}">
    		<c:set  var="begin" value="1" scope="page"></c:set>
    		<c:set  var="end" value="${page.pagecount}" scope="page"></c:set>
    	</c:if>
    	<c:if test="${page.pagecount>5}">
    		<c:choose>
    			<c:when test="${page.thispage<=3}">
    				<c:set  var="begin" value="1" scope="page"></c:set>
    				<c:set  var="end" value="5" scope="page"></c:set>
    			</c:when>
    			<c:when test="${page.thispage>=page.pagecount-2}">
    				<c:set  var="begin" value="${page.pagecount-4}" scope="page"></c:set>
    				<c:set  var="end" value="${page.pagecount}" scope="page"></c:set>
    			</c:when>
    			<c:otherwise>
    				<c:set  var="begin" value="${page.thispage-2}" scope="page"></c:set>
    				<c:set  var="end" value="${page.thispage+2}" scope="page"></c:set>
    			</c:otherwise>
    		</c:choose>
    	</c:if>
    	<c:forEach begin="${begin}" end="${end}" step="1" var="num">
    		<c:if test="${num==page.thispage}">
    			${num }
    		</c:if>
    		<c:if test="${num!=page.thispage}">
    			<a href ="${pageContext.request.contextPath}/customer/showCustomer.action?targetpage=${num}">${num}</a>
    		</c:if>
    	</c:forEach>
    	<c:if test="${page.thispage==page.pagecount}">
    		下一页
    	</c:if>
    	<c:if test="${page.thispage!=page.pagecount}">
    		<a href="${pageContext.request.contextPath}/customer/showCustomer.action?targetpage=${page.nextpage }">下一页</a>
    	</c:if>
    	<c:if test="${page.thispage==page.pagecount}">
    		尾页
    	</c:if>
    	<c:if test="${page.thispage!=page.pagecount}">
    		<a href="${pageContext.request.contextPath}/customer/showCustomer.action?targetpage=${page.lastpage }">尾页</a>
    	</c:if>
    	跳至<input type="text" style="width:40px;" onchange="changepage(this)"/>页
  	</form>
  </body>
</html>
