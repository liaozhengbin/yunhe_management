<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" />

<!-- 日期选择器 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="//code.jquery.com/jquery-1.9.1.js" ></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css" />
<!------------>

<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
<!-- 提示框 -->

<!-- 提示框 -->
<script type="text/javascript" src="js/student.js"></script>
<!-- 提示框 -->


<title>积分信息管理</title>

<script type="text/javascript">
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  $(function() {
	$( "#datepicker2" ).datepicker();
  });
  
  function deleteClick(scoreId){
		if(confirm("确认删除吗？")){
			location.href="score_controller?method=delete&scoreId="+scoreId;
		}
	}
  
</script>




</head>

<body>
<!-- 访问路径导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">
				<a href="#">积分管理</a>&nbsp;>>&nbsp;
				<a href="#">XXXXXXX</a>
			</span>
		</div>
	</div>
	
</nav>



<nav class="navbar navbar-default" role="navigation" style="margin-left: 60px;margin-right: 60px; margin-top:10px">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">筛选</span>
		</div>
		
		<div>
			<form class="navbar-form navbar-left" role="search" action="score_controller?method=select" method="post" >
				<select class="form-control" name="type_id">
			      <option value="" selected='selected'>--请选择类型--</option>
			      <option value="1" ${requestScope.one}>纪律考核分</option>
			      <option value="2" ${requestScope.two}>技术考核分</option>
			      <option value="3" ${requestScope.three}>职业能力考核分</option>
			    </select>
				<div class="form-group">
				
					<input type="text" id="datepicker" name="time" class="form-control" placeholder="请选择日期" value="${requestScope.time==null?"":requestScope.time}" />
				</div>
				<select class="form-control" name="stu_id">
			      <option value="" selected="selected">--请选择姓名--</option>
			      <option value="1" ${requestScope.stu1}>黎立</option>
			      <option value="2" ${requestScope.stu2}>肖冉燎</option>
			      <option value="3" ${requestScope.stu3}>何吕盼</option>
			      <option value="4" ${requestScope.stu4}>王明旸</option>
			      <option value="5" ${requestScope.stu5}>池湘鄂</option>
			    </select>
				<button type="submit" class="btn btn-default">查询</button>
			</form>
		</div>
		
	</div>
</nav>


<nav class="navbar navbar-default" role="navigation" style="margin-left: 60px;margin-right: 60px">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">添加</span>
		</div>
		<div>
			<form id="myForm" class="navbar-form navbar-left" role="search" action="score_controller?method=add" method="post">
				<select class="form-control" name="i_type_id" id="i_type_id">
			      <option value="">--请选择类型--</option>
			      <option value="1">纪律考核分</option>
			      <option value="2">技术考核分</option>
			      <option value="3">职业能力考核分</option>
			    </select>
				<div class="form-group">
					<input type="text" id="datepicker2" class="form-control" placeholder="请选择日期" name="i_time" id="i_time" />
				</div>
				<select class="form-control" name="i_stu_id" id="i_stu_id">
			      <option value="" selected="selected">--请选择姓名--</option>
			      <option value="1">黎立</option>
			      <option value="2">肖冉燎</option>
			      <option value="3">何吕盼</option>
			      <option value="4">王明旸</option>
			      <option value="5">池湘鄂</option>
			    </select>
			    <input type="text" class="form-control" placeholder="请输入描述" name="i_score_contents" id="i_score_contents" />
			    <input type="text" class="form-control" placeholder="请输入分值" name="i_score_value" id="i_score_value" />
			    <button type="submit" class="btn btn-default">添加</button>
				
			</form>
		</div>
	</div>
</nav>


<div id="content" style="margin-left: 60px;margin-right: 60px">
    <span>共有 <b>${requestScope.zonglines}</b> 条记录</span>
    <table border="1" cellspacing="0" cellpadding="0" class="table table-striped table-hover table-bordered">
        <tr id="theTableTitle">
       		<th>类型</th>
            <th>日期</th>
            <th>姓名</th>
            <th>描述</th>
            <th>分值</th>
            <th>操作</th>
        </tr>
        
        
        <c:forEach items="${requestScope.scoreList}" var="score" >

        <tr>
        	<td>
        	<c:if test="${score.score_type==1 }">
        		纪律考核分
	        </c:if>
	        <c:if test="${score.score_type==2 }">
	        	技术考核分
	        </c:if>
	        <c:if test="${score.score_type==3 }">
	       	 	职业能力考核分
	        </c:if>
        	</td>
            <td>${score.time}</td>
            <td>${score.stu_name}</td>
            <td>${score.score_contents}</td>
            <td>${score.score_value}</td>
            <td>
            <input type="hidden" name="score_Id" value="${score.score_id}" />
            
            	<a href="javascript:deleteClick(${score.score_id})">[删除]</a>
                <a href="score_controller?method=update2&scoreId=${score.score_id}">[修改]</a>
            </td>
        </tr>
        
        
        </c:forEach>
	

    </table>
</div>

<div class="footer" style="margin-left: 60px;margin-right: 60px">
    <ul class="pagination pagination myul">
    
    
     <c:set var="formParam" value="&stu_name=${requestScope.type_id}&stu_profession=${requestScope.time}&stu_sex=${requestScope.stuName}&class_id=${requestScope.class_id}" />
		
		<li class='${requestScope.yeshu==1?"disabled":""}'>
		<a href='${requestScope.yeshu==1?"#":"score_controller?method=select&yeshu=1"}${formParam}'>&laquo;首页</a>
		</li>
		<li class='${requestScope.yeshu==1?"disabled":""}'>
		<a href='${requestScope.yeshu==1?"#":"score_controller?method=select&yeshu="}${requestScope.yeshu-1}${formParam}'>上一页</a>
		</li>
		
	<c:set var="hys"  >	
		<c:if test="${requestScope.yeshu%10==0}">
		 	<fmt:formatNumber value="${requestScope.yeshu/10}" pattern="#" />
		</c:if>
		<c:if test="${requestScope.yeshu%10!=0}">
			<fmt:formatNumber value="${requestScope.yeshu/10+0.5}" pattern="#" />
		</c:if>
	</c:set>							
		
		<c:forEach begin="${(hys-1)*10+1 }"  end="${hys*10}"  var="i" step="1">
			<c:if test="${i<=requestScope.zongys }">
			<li class='${i==requestScope.yeshu?"active":"" }'><a href='score_controller?method=select&yeshu=${i }${formParam }'>${i }</a></li>
			</c:if>
		</c:forEach>

		<li class='${requestScope.yeshu==requestScope.zongys?"disabled":""}'>
			<a href='${requestScope.yeshu==requestScope.zongys?"#":"score_controller?method=select&yeshu="}${requestScope.yeshu+1}${formParam}'>下一页 </a>
		</li>
		<li class='${requestScope.yeshu==requestScope.zongys?"disabled":""}'>
			<a href='${requestScope.yeshu==requestScope.zongys?"#":"score_controller?method=select&yeshu="}${requestScope.zongys}${formParam}'>末页 </a>
		</li>
    
        
    </ul>
</div>
</body>
</html>
