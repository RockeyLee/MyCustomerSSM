<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<h1>
			客户管理系统_添加用户
		</h1>
		<hr>
		<!-- 显示错误信息 -->
		<c:if test="${allErrors!=null }">
			<c:forEach items="${allErrors }" var="error">
				${ error.defaultMessage}<br />
			</c:forEach>
		</c:if>
		<form
			action="${pageContext.request.contextPath}/customer/insertNewCustomer.action"
			method="post">
			<c:if test="${custadd==null}">
				<table border="1dp">
					<tr>
						<td>
							name:
						</td>
						<td>
							<input type="text" name="name" />
						</td>
					</tr>
					<tr>
						<td>
							gender:
						</td>
						<td>
							<input type="radio" name="gender" value="男" />
							男
							<input type="radio" name="gender" value="女" />
							女
						</td>
					</tr>
					<tr>
						<td>
							birthday:
						</td>
						<td>
							<input type="text" name="birthday" />
						</td>
					</tr>
					<tr>
						<td>
							cellphone:
						</td>
						<td>
							<input type="text" name="cellphone" />
						</td>
					</tr>
					<tr>
						<td>
							email:
						</td>
						<td>
							<input type="text" name="email" />
						</td>
					</tr>
					<tr>
						<td>
							preference:
						</td>
						<td>
							<input type="checkbox" name="preference" value="篮球" />
							篮球
							<input type="checkbox" name="preference" value="足球" />
							足球
							<input type="checkbox" name="preference" value="排球" />
							排球
						</td>
					</tr>
					<tr>
						<td>
							type:
						</td>
						<td>
							<select name="type">
								<option value="钻石VIP">
									钻石VIP
								</option>
								<option value="铂金VIP">
									铂金VIP
								</option>
								<option value="普通用户">
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
							<textarea name="description" rows="6" cols="40"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="submit">
						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${custadd!=null}">
				<table border="1dp">
    		<tr>
    			<td>name:</td>
    			<td><input type="text" name="name" value="${custadd.name }" /></td>
    		</tr>
    		<tr>
    			<td>gender:</td>
    			<td>
    				<input type="radio" name="gender" value="男"
    					<c:if test="${custadd.gender=='男'}">
    						checked = 'checked'
    					</c:if>
    				/>男
    				<input type="radio" name="gender" value="女"
    					<c:if test="${custadd.gender=='女'}">
    						checked = 'checked'
    					</c:if>
    				/>女
    			</td>
    		</tr>
    		<tr>
    			<td>birthday:</td>
    			<td><input type="text" name="birthday" value="${custadd.birthday }"/></td>
    		</tr>
    		<tr>
    			<td>cellphone:</td>
    			<td><input type="text" name="cellphone" value ="${custadd.cellphone }"/></td>
    		</tr>
    		<tr>
    			<td>email:</td>
    			<td><input type="text" name="email" value ="${custadd.email }"/></td>
    		</tr>
    		<tr>
    			<td>preference:</td>
    			<td>
    				<input type="checkbox" name="preference" value="篮球"
    					<c:if test="${fn:contains(custadd.preference,'篮球') }">
    						checked='checked'
    					</c:if>
    				/>篮球
    				<input type="checkbox" name="preference" value="足球"
    					<c:if test="${fn:contains(custadd.preference,'足球') }">
    						checked='checked'
    					</c:if>
    				/>足球
    				<input type="checkbox" name="preference" value="排球"
    					<c:if test="${fn:contains(custadd.preference,'排球') }">
    						checked='checked'
    					</c:if>
    				/>排球
    			</td>
    		</tr>
    		<tr>
    			<td>type:</td>
    			<td>
    				<select name="type">
    					<option value="钻石VIP" 
    						<c:if test="${custadd.type=='钻石VIP' }">
								 selected='selected'
							</c:if>>钻石VIP</option>
    					<option value="铂金VIP"
    						<c:if test="${custadd.type=='铂金VIP' }">
								 selected='selected'
							</c:if>>铂金VIP</option>
    					<option value="普通用户"
    						<c:if test="${custadd.type=='普通用户' }">
								selected='selected'
							</c:if>>普通用户</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>description:</td>
    			<td>
    				<textarea name="description" rows="6" cols="40" >${custadd.description }</textarea>
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
