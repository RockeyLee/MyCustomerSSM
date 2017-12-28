<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<h1>
			客户列表管理_注册
			<h1>
				<hr>
				<!-- 显示错误信息 -->
				<c:if test="${allErrors!=null }">
					<c:forEach items="${allErrors }" var="error">
				${ error.defaultMessage}<br />
					</c:forEach>
				</c:if>
				<form
					action="${pageContext.request.contextPath }/user/registerUser.action"
					method="POST">
					<input type="hidden" name="role" value="normal" />
					<c:if test="${userRegister==null}">
						<table>
							<tr>
								<td>
									username
								</td>
								<td>
									<input type="text" name="name" />
								</td>
							</tr>
							<tr>
								<td>
									password
								</td>
								<td>
									<input type="password" name="password" />
								</td>
							</tr>
							<tr>
								<td>
									confirmpwd
								</td>
								<td>
									<input type="password" name="password2" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" name="submit" value="submit" />
								</td>
							</tr>
						</table>
					</c:if>
					<c:if test="${userRegister!=null}">
						<table>
							<tr>
								<td>
									username
								</td>
								<td>
									<input type="text" name="name" value="${userRegister.name }" />
								</td>
							</tr>
							<tr>
								<td>
									password
								</td>
								<td>
									<input type="password" name="password"
										value="${userRegister.password }" />
								</td>
							</tr>
							<tr>
								<td>
									confirmpwd
								</td>
								<td>
									<input type="password" name="password2"
										value="${userRegister.password2 }" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" name="submit" value="submit" />
								</td>
							</tr>
						</table>
					</c:if>
				</form>
	</body>
</html>
