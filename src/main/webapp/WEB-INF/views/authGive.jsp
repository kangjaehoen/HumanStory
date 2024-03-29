<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Employee authGive</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Employee authGive</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<form role="form" action="/emp/authGive" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />


					<div class="form-group">
						<label>empNum</label> <input class="form-control" name='empNum'
							value='<c:out value="${auth.empNum}"/>' readonly="readonly">
					</div>

						<div class="form-group">
							<label>auth</label> <input class="form-control" name='auth'
								id="authInput"/>'>
						</div>


					<button type="submit" data-oper='authGive' class="btn btn-secondary">Modify</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>

				</form>


			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel panel-default -->
	</div>
	<!-- end col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {

		var formObj = $("form");

		$('button').on("click", function(e) {

			e.preventDefault();

			var operation = $(this).data("oper");
			console.log(operation);

			if (operation === 'list') {
				//move to list
				self.location = "/emp/list";
				return;
			}

			formObj.submit();
		});

	});
</script>
