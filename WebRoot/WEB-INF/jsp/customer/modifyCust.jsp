<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<h1>
			客户管理系统_修改用户
		</h1>
		<hr>
		<!-- 显示错误信息 -->
		<c:if test="${allErrors!=null }">
			<c:forEach items="${allErrors }" var="error">
			${ error.defaultMessage}<br />
			</c:forEach>
		</c:if>
		<form
			action="${pageContext.request.contextPath}/customer/updateCustomer.action"
			method="post">
			<c:if test="${modifyCustomer==null}">
				<input type="hidden" name="id" value="${cust.id }" />
				<input type="hidden" name="pagenum"
					value="${sessionScope.page.thispage }" />
				<table border="1dp">
					<tr>
						<td>
							name:
						</td>
						<td>
							<input type="text" name="name" value="${cust.name }"
								readonly="readonly" style="background: silver" />
						</td>
					</tr>
					<tr>
						<td>
							gender:
						</td>
						<td>
							<input type="radio" name="gender" value="男"
								<c:if test="${cust.gender=='男'}">
    						checked = 'checked'
    					</c:if> />
							男
							<input type="radio" name="gender" value="女"
								<c:if test="${cust.gender=='女'}">
    						checked = 'checked'
    					</c:if> />
							女
						</td>
					</tr>
					<tr>
						<td>
							birthday:
						</td>
						<td>
							<input type="text" name="birthday" value="${cust.birthday }" />
						</td>
					</tr>
					<tr>
						<td>
							cellphone:
						</td>
						<td>
							<input type="text" name="cellphone" value="${cust.cellphone }" />
						</td>
					</tr>
					<tr>
						<td>
							email:
						</td>
						<td>
							<input type="text" name="email" value="${cust.email }" />
						</td>
					</tr>
					<tr>
						<td>
							preference:
						</td>
						<td>
							<input type="checkbox" name="preference" value="篮球"
								<c:if test="${fn:contains(cust.preference,'篮球') }">
    						checked='checked'
    					</c:if> />
							篮球
							<input type="checkbox" name="preference" value="足球"
								<c:if test="${fn:contains(cust.preference,'足球') }">
    						checked='checked'
    					</c:if> />
							足球
							<input type="checkbox" name="preference" value="排球"
								<c:if test="${fn:contains(cust.preference,'排球') }">
    						checked='checked'
    					</c:if> />
							排球
						</td>
					</tr>
					<tr>
						<td>
							type:
						</td>
						<td>
							<select name="type">
								<option value="钻石VIP"
									<c:if test="${cust.type=='钻石VIP' }">
								 selected='selected'
							</c:if>>
									钻石VIP
								</option>
								<option value="铂金VIP"
									<c:if test="${cust.type=='铂金VIP' }">
								 selected='selected'
							</c:if>>
									铂金VIP
								</option>
								<option value="普通用户"
									<c:if test="${cust.type=='普通用户' }">
								selected='selected'
							</c:if>>
									普通用户
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							description:
						</td>
						<td>
							<textarea name="description" rows="6" cols="40">${cust.description }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="submit">
						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${modifyCustomer!=null}">
				<input type="hidden" name="id" value="${modifyCustomer.id }" />
				<input type="hidden" name="pagenum"
					value="${modifyCustomer.pagenum }" />
				<table border="1dp">
					<tr>
						<td>
							name:
						</td>
						<td>
							<input type="text" name="name" value="${modifyCustomer.name }"
								readonly="readonly" style="background: silver" />
						</td>
					</tr>
					<tr>
						<td>
							gender:
						</td>
						<td>
							<input type="radio" name="gender" value="男"
								<c:if test="${modifyCustomer.gender=='男'}">
    						checked = 'checked'
    					</c:if> />
							男
							<input type="radio" name="gender" value="女"
								<c:if test="${modifyCustomer.gender=='女'}">
    						checked = 'checked'
    					</c:if> />
							女
						</td>
					</tr>
					<tr>
						<td>
							birthday:
						</td>
						<td>
							<input type="text" name="birthday"
								value="${modifyCustomer.birthday }" />
						</td>
					</tr>
					<tr>
						<td>
							cellphone:
						</td>
						<td>
							<input type="text" name="cellphone"
								value="${modifyCustomer.cellphone }" />
						</td>
					</tr>
					<tr>
						<td>
							email:
						</td>
						<td>
							<input type="text" name="email" value="${modifyCustomer.email }" />
						</td>
					</tr>
					<tr>
						<td>
							preference:
						</td>
						<td>
							<input type="checkbox" name="preference" value="篮球"
								<c:if test="${fn:contains(modifyCustomer.preference,'篮球') }">
    						checked='checked'
    					</c:if> />
							篮球
							<input type="checkbox" name="preference" value="足球"
								<c:if test="${fn:contains(modifyCustomer.preference,'足球') }">
    						checked='checked'
    					</c:if> />
							足球
							<input type="checkbox" name="preference" value="排球"
								<c:if test="${fn:contains(modifyCustomer.preference,'排球') }">
    						checked='checked'
    					</c:if> />
							排球
						</td>
					</tr>
					<tr>
						<td>
							type:
						</td>
						<td>
							<select name="type">
								<option value="钻石VIP"
									<c:if test="${modifyCustomer.type=='钻石VIP' }">
								 selected='selected'
							</c:if>>
									钻石VIP
								</option>
								<option value="铂金VIP"
									<c:if test="${modifyCustomer.type=='铂金VIP' }">
								 selected='selected'
							</c:if>>
									铂金VIP
								</option>
								<option value="普通用户"
									<c:if test="${modifyCustomer.type=='普通用户' }">
								selected='selected'
							</c:if>>
									普通用户
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							description:
						</td>
						<td>
							<textarea name="description" rows="6" cols="40">${modifyCustomer.description }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="submit">
						</td>
					</tr>
				</table>
			</c:if>
		</form>
	</body>
</html>
