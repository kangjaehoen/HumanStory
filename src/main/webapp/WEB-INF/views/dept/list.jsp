<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/sideBar.jsp"%>


<link rel="dns-prefetch" href="//unpkg.com" />
<link rel="dns-prefetch" href="//cdn.jsdelivr.net" />
<link rel="stylesheet"
	href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css">

<script
	src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.js"
	defer></script>
<script src="https://cdn.tailwindcss.com"></script>

<style type="text/css">

</style>

<style>
[x-cloak] {
	display: none;
}
</style>


<div class="p-1 sm:ml-64 mt-32">

	<div class="flex justify-center">
		<h1 class="text-center text-3xl font-bold">부서 관리</h1>
	</div>

	<!-- /.col-lg-12 -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="flex justify-between items-center mt-4">
				<div class="panel-heading">

					<button id='regBtn' type="button"
						class="bg-gray-800 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded mr-2">
						Register New department</button>

					<button id='modiBtn' type="button"
						class="bg-gray-800 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded mr-2">
						Update department</button>

				</div>

				<div class="flex justify-end">
					<form id='searchForm' action="/dept/list" method='get'
						class="flex items-center">
						<select name='type' class="mr-2">
							<option value="">--</option>
							<option value="C">부서명</option>

						</select> <input type='text' name='keyword'
							value='<c:out value="${pageMaker.cri.keyword}"/>' class="mr-2" />
						<input type='hidden' name='${_csrf.parameterName}'
							value='${_csrf.token}'>
						<button
							class='bg-gray-800 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded mr-2'>Search</button>
					</form>
				</div>
				<!-- /.panel-heading -->
				<div class="relative overflow-x-auto shadow-md sm:rounded-lg flex justify-center">
					<table
						class="w-full text-sm text-left rtl:text-right text-black-500 dark:text-gray-400">
						<thead
							class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
							<tr>
								<th>체크박스</th>
								<th>번호</th>
								<th>부서명</th>
							</tr>
						</thead>

						<c:forEach items="${list}" var="dept">
							<tr>
								<td><input type="checkbox" class="deptCheckbox"
									value="<c:out value='${dept.deptNum}' />"></td>
								<td
									class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
										value="${dept.deptNum}" /></td>
								<td
									class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
										value="${dept.deptName}" /></td>
							</tr>
						</c:forEach>
					</table>
					<div class="dataTables_paginate paging_simple_numbers"
						id="dataTable_paginate">
						<nav aria-label="Page navigation example">
							<ul class="pagination flex justify-start">
								<!-- 변경된 부분 -->
								<c:if test="${pageMaker.prev}">
									<li><a href="${pageMaker.startPage -1}"
										class="px-3 py-1 bg-gray-200 text-gray-700 rounded-md hover:bg-gray-300">Previous</a></li>
								</c:if>

								<c:forEach var="num" begin="${pageMaker.startPage}"
									end="${pageMaker.endPage}">
									<li
										class="paginate_button  ${pageMaker.cri.deptpageNum == num ? 'active':''} ">
										<a
										class="page-link inline-block px-4 py-2 bg-gray-200 text-gray-700 rounded-md hover:bg-gray-300"
										href="${num}">${num}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next}">
									<li class="paginate_button next"><a aria-label="Next"
										href="${pageMaker.endPage +1 }"
										class="px-3 py-1 bg-gray-200 text-gray-700 rounded-md hover:bg-gray-300">Next</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>

				<!--  end Pagination -->
			</div>

			<form id='actionForm' action="/dept/list" method='get'>
				<input type='hidden' name='deptpageNum'
					value='${pageMaker.cri.deptpageNum}'> <input type='hidden'
					name='deptamount' value='${pageMaker.cri.deptamount}'> <input
					type='hidden' name='type'
					value='<c:out value="${ pageMaker.cri.type }"/>'> <input
					type='hidden' name='keyword'
					value='<c:out value="${ pageMaker.cri.keyword }"/>'>
			</form>

			<!-- Modal  추가 -->
			<div
				class="fixed inset-0 z-50 overflow-auto bg-gray-900 bg-opacity-75 flex justify-center items-center"
				id="myModal" style="display: none;">
				<div class="bg-white w-1/3 p-4 rounded-lg">
					<button type="button"
						class="close absolute top-0 right-0 mt-4 mr-4"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="text-lg font-semibold mb-4">모달 타이틀</h4>
					<div class="modal-body">처리가 완료되었습니다.</div>
					<div class="modal-footer mt-4">
						<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
			<!-- /.modal -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->

	<!-- /.row -->

</div>


<script type="text/javascript">
	$(document).ready(
			function() {

				var result = '<c:out value="${result}"/>';

				checkModal(result);

				history.replaceState({}, null, null);

				function checkModal(result) {

					if (result === '' || history.state) {
						return;
					}

					$("#myModal").modal("show");
				}

				$("#regBtn").on("click", function() {

					self.location = "/dept/register";

				});
				$("#modiBtn").on("click", function() {

					var selectedDeptNums = [];
					$(".deptCheckbox:checked").each(function() {
						selectedDeptNums.push($(this).val());
					});
					if (selectedDeptNums.length == 0) {
						console.log("수정할 부서를 선택해주세요.");
						return;
					}
					if (selectedDeptNums.length > 1) {
						console.log("다중 선택은 지원되지 않습니다.");
						return;
					}

					var selectedDeptNum = selectedDeptNums[0];

					self.location = "/dept/modify?deptNum=" + selectedDeptNum;

				});

				var actionForm = $("#actionForm");

				$(".paginate_button a").on(
						"click",
						function(e) {

							e.preventDefault();

							console.log('click');

							actionForm.find("input[name='deptpageNum']").val(
									$(this).attr("href"));
							actionForm.submit();
						});

				var searchForm = $("#searchForm");

				$("#searchForm button").on("click", function(e) {

					if (!searchForm.find("option:selected").val()) {
						alert("검색종류를 선택하세요");
						return false;
					}

					if (!searchForm.find("input[name='keyword']").val()) {
						alert("키워드를 입력하세요");
						return false;
					}

					searchForm.find("input[name='deptpageNum']").val("1");
					e.preventDefault();

					searchForm.submit();

				});

			});
</script>
