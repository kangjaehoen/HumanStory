<%@include file="../includes/sideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
 	#divBox{
 		margin-left: 300px;
 		margin-top : 100px;
 	
 	}
 	h2{
 		font-size: 30px;
 		font-weight: bold;
 		margin-bottom: 50px;
 	}
 
 
    input[type="date"] {
        appearance: none; 
        border: 1px solid #ccc;
        border-radius: 5px; 
        padding: 8px; 
        font-size: 16px;
        outline: none; 
    }

 
    input[type="date"]:focus {
        border-color: #007bff; 
    }
    
    p{
    color:red;
    }
</style>

</head>
<body>

<div id="divBox">

	<div>
		<h2> admin 휴가 설정</h2>
	</div>
	
	<div>	
		<form action="leaveGrant" method="post">
			<input id="dateInput" type="date" name="leaveDay" value=""/> 
			<input type="submit" value="연차 부여일자 설정">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> 
		</form>
		
		
	
		<p>현재 연차 휴가 설정일은 ${day.leaveGrantDay } 입니다.</p>
	</div>

	
	
	<div>
		<form action="annualNumSetting" method="post">
			<input id="textInput" type="text" name="annualNum" value="15"/><br>
			<input type="submit" value="연차일수 설정">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> 
		</form>
		<p>현재 연차 부여일은 ${num.leaveNumSet }일입니다.(추가로 2년이상 근무시 +1일)</p>
	</div>
	
	
	
	<div>	
		<form action="annualLeave" method="post">
			<input type="submit" value="관리자 수동 등록">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> 
		</form>
	</div>
</div>
	
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#dateInput").change(function() {
		let value = $(this).val();
		console.log(value);
	})
	
	$("#dataInput").click(function(){
		
		
	})
});

</script>

<%@include file="../includes/footer.jsp"%>