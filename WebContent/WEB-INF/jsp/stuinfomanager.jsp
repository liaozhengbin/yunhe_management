<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学员信息管理</title>
<script type="text/javascript">
  
  function deleteClick(stuId){
		if(confirm("确认删除吗？")){
			location.href="Student_controller?method=delete&stuId="+stuId;
		}
	}
</script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
<!-- 提示框 -->
</head>
<body>
<!-- 访问路径导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">
				<a href="#">学员管理</a>&nbsp;>>&nbsp;
				<a href="#">XXXXXXX</a>
			</span>
		</div>
	</div>
</nav>
<nav class="navbar navbar-default" role="navigation" style="margin-left: 60px;margin-right: 60px; margin-top:10px" >
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">筛选</span>
		</div>
		<div>
			<form class="navbar-form navbar-left" role="search"  action="Student_controller?method=select" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="请输入姓名" name="stu_name" value="${requestScope.stu_name}"/>
					<input type="text" class="form-control" placeholder="请输入专业" name="stu_profession" value="${requestScope.stu_profession}"/>
					<select class="form-control" name="stu_sex">
			        	<option value="" selected="selected">--请选择性别--</option>
			        	<option value="男" ${requestScope.strMan} >男</option>
			        	<option value="女" ${requestScope.strWomen} >女</option>
			        </select>
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form>
		</div>
	</div>
</nav>
<nav class="navbar navbar-default" role="navigation" style="margin-left: 60px;margin-right: 60px; margin-top:10px" >
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">添加</span>
		</div>
		<div>
			<form class="navbar-form navbar-left" role="search"  action="Student_controller?method=add2" method="post">
				<button type="submit" class="btn btn-default">添加学员</button>
			</form>
		</div>
		
	</div>
</nav>
<div id="content" style="margin-left: 60px;margin-right: 60px">
    <span>共有 <b>${requestScope.num}</b> 条记录</span>
    <table border="1" cellspacing="0" cellpadding="0" class="table table-striped table-hover table-bordered">
        <tr id="theTableTitle">
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>专业</th>
            <th>身份证</th>
            <th>电话</th>
            <th>生日</th>
            <th>QQ</th>
            <th>所属班级</th>
            <th>操作</th>
        </tr>
	<c:forEach items="${requestScope.studentList}" var="stu" >
        <tr>
            <td>${stu.stu_no}</td>
            <td>${stu.stu_name}</td>
            <td>${stu.stu_sex}</td>
            <td>${stu.stu_profession}</td>
            <td>${stu.stu_icno}</td>
            <td>${stu.stu_phone}</td>
            <td>${stu.stu_birth}</td>
            <td>${stu.stu_qq}</td>
            <td>${stu.class_name}</td>
            <td>
            	<a href="javascript:deleteClick(${stu.stu_id})">[删除]</a>
                <a href="Student_controller?method=update2&stuId=${stu.stu_id}">[修改]</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

<div class="footer"  style="margin-left: 60px;margin-right: 60px">
    <ul class="pagination pagination myul">
    <c:set var="formParam" value="&stu_name=${requestScope.stu_name}&stu_profession=${requestScope.stu_profession}&stu_sex=${requestScope.stu_sex}&class_id=${requestScope.class_id}" />
		<li class='${requestScope.currentPage==1?"disabled":""}'>
		<a href='${requestScope.currentPage==1?"#":"Student_controller?method=select&currentPage=1"}${formParam}'>&laquo;首页</a>
		</li>
		<li class='${requestScope.currentPage==1?"disabled":""}'>
		<a href='${requestScope.currentPage==1?"#":"Student_controller?method=select&currentPage="}${requestScope.currentPage-1}${formParam}'>上一页</a>
		</li>
		<%//1>根据当前页，求出所在第几组当前组=当前页/10+1 %>
	<c:set var="hys"  >	
		<c:if test="${requestScope.currentPage%10==0}">
		 	<fmt:formatNumber value="${requestScope.currentPage/10}" pattern="#" />
		</c:if>
		<c:if test="${requestScope.currentPage%10!=0}">
			<fmt:formatNumber value="${requestScope.currentPage/10+0.5}" pattern="#" />
		</c:if>
	</c:set>	
	
									
		<%//2>显示当前组里面的所有页码号（循环）%>
		
		<c:forEach begin="${(hys-1)*10+1 }"  end="${hys*10}"  var="i" step="1">
			<c:if test="${i<=requestScope.lines }">
			<li class='${i==requestScope.currentPage?"active":"" }'><a href='Student_controller?method=select&currentPage=${i }${formParam }'>${i }</a></li>
			</c:if>
		</c:forEach>

		<li class='${requestScope.currentPage==requestScope.lines?"disabled":""}'>
			<a href='${requestScope.currentPage==requestScope.lines?"#":"Student_controller?method=select&currentPage="}${requestScope.currentPage+1}${formParam}'>下一页 </a>
		</li>
		<li class='${requestScope.currentPage==requestScope.lines?"disabled":""}'>
			<a href='${requestScope.currentPage==requestScope.lines?"#":"Student_controller?method=select&currentPage="}${requestScope.lines}${formParam}'>末页 </a>
		</li>
        
    </ul>
</div>
</body>
</html>
