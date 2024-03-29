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



<style>
[x-cloak] {
	display: none;
}
</style>
<div class="p-1 sm:ml-64 mt-32">

	<div class="flex justify-center">
		<h1 class="text-center text-3xl font-bold">사원 관리</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="flex justify-between items-center mt-4">
				<div class="panel-heading">


					<div>
						<button id='regBtn' type="button"
							class="bg-gray-800 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded mr-2">신규
							직원 등록</button>

						<button id='modiBtn' type="button"
							class="bg-gray-800 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded mr-2">직원
							정보 수정</button>
						<form id="authForm" action="authGive" method="POST"
							class="max-w-sm mx-auto">
							<div class="mb-4">
								<label for="authDropdown"
									class="block text-sm font-medium text-gray-700">권한 선택</label>
								<div class="relative">
									<select id="authDropdown" name="selectedAuth"
										class="block appearance-none w-full bg-white border border-gray-300 hover:border-gray-400 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
										<option value="ROLE_MANAGER">매니저</option>
										<option value="ROLE_ADMIN">어드민</option>
									</select>
									<div
										class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
										<svg class="fill-current h-4 w-4"
											xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path fill-rule="evenodd"
												d="M6.293 7.293a1 1 0 0 1 1.414 0L10 9.586l2.293-2.293a1 1 0 1 1 1.414 1.414l-3 3a1 1 0 0 1-1.414 0l-3-3a1 1 0 0 1 0-1.414z" />
                </svg>
									</div>
								</div>
							</div>
							<!-- CSRF 토큰 추가 -->
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button type="submit" id="authBtn"
								class="w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">권한
								부여</button>
						</form>



					</div>

				</div>
			</div>
			<div class="flex justify-end">
				<form id='searchForm' action="/emp/list" method='get'
					class="flex items-center">
					<select name='type' class="mr-2">
						<option value="">--</option>
						<option value="T">사원번호</option>
						<option value="C">사원명</option>
						<option value="W">부서명</option>
						<option value="TC">사원번호 or 사원명</option>
						<option value="TW">사원번호 or 부서명</option>
						<option value="TWC">사원번호 or 사원명 or 부서명</option>
					</select> <input type='text' name='keyword'
						value='<c:out value="${emppageMaker.cri.keyword}"/>' class="mr-2">
					<input type='hidden' name='${_csrf.parameterName}'
						value='${_csrf.token}'>
					<button
						class="bg-gray-800 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded mr-2">검색</button>
				</form>
			</div>
		</div>
		<!--Seaching  -->


		<!-- /.panel-heading -->
		<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
			<table
				class="w-full text-sm text-left rtl:text-right text-black-500 dark:text-gray-400">
				<!-- divide-y divide-gray-800 divide-x divide-gray-800 -->
				<!-- border border-gray-700 -->
				<thead
					class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
					<tr>
						<th>체크박스</th>
						<th>번호</th>
						<th>사원명</th>
						<th>비밀번호</th>
						<th>직책</th>
						<th>휴대폰번호</th>
						<th>고용일</th>
						<th>email</th>
						<th>연차일수</th>
						<th>주소</th>
						<th>근속기간</th>
						<th>주민번호</th>
						<th>부서명</th>
					</tr>
				</thead>
				<c:forEach items="${list}" var="emp">
					<tr>
						<td><input type="checkbox" class="empCheckbox"
							value="<c:out value='${emp.empNum}' />"></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.empNum}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.empName}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.pw}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.job}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.phoneNum}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><fmt:formatDate
								value="${emp.hireDate}" pattern="yyyy-MM-dd" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.email}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.annualLeaveNum}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.address}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.workDate}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.birthDate}" /></td>
						<td
							class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"><c:out
								value="${emp.department.deptName}" /></td>
					</tr>
				</c:forEach>
			</table>



			<div class='dataTables_paginate paging_simple_numbers'
				id="dataTable_paginate">
				<nav aria-label="Page navigation example">
					<ul class="pagination flex justify-end">
						<c:if test="${emppageMaker.prev}">
							<li><a href="${emppageMaker.startPage - 1}"
								class="px-3 py-1 bg-gray-200 text-gray-700 rounded-md hover:bg-gray-300">Previous</a>
							</li>
						</c:if>
						<c:forEach var="num" begin="${emppageMaker.startPage}"
							end="${emppageMaker.endPage}">

							<li
								class="paginate_button ${emppageMaker.cri.emppageNum == num ? 'active' : ''}">
								<a
								class="page-link inline-block px-4 py-2 bg-gray-200 text-gray-700 rounded-md hover:bg-gray-300"
								href="${num}">${num}</a>
							</li>

						</c:forEach>

						<c:if test="${emppageMaker.next}">
							<li class="paginate_button next"><a aria-label="Next"
								href="${emppageMaker.endPage + 1}"
								class="px-3 py-1 bg-gray-200 text-gray-700 rounded-md hover:bg-gray-300">Next</a>
							</li>
						</c:if>
					</ul>
				</nav>
			</div>

		</div>


	</div>

	<form id='actionForm' action="/emp/list" method='get'>
		<input type='hidden' name='emppageNum'
			value='${emppageMaker.cri.emppageNum}'> <input type='hidden'
			name='empamount' value='${emppageMaker.cri.empamount}'> <input
			type='hidden' name='type'
			value='<c:out value="${ emppageMaker.cri.type }"/>'> <input
			type='hidden' name='keyword'
			value='<c:out value="${ emppageMaker.cri.keyword }"/>'>
	</form>

	<!--Modal  추가-->

	<div
		class="fixed inset-0 z-50 overflow-auto bg-gray-900 bg-opacity-75 flex justify-center items-center"
		id="myModal" style="display: none;">
		<div class="bg-white w-1/3 p-4 rounded-lg">
			<button type="button" class="close absolute top-0 right-0 mt-4 mr-4"
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






</div>
<!--  end panel-body -->
</div>
<!-- end panel -->
</div>
</div>
<!-- /.row -->

<script>
	document.getElementById('dropdownMenuButton').addEventListener('click',
			function() {
				var dropdownMenu = document.getElementById('dropdownMenu');
				dropdownMenu.classList.toggle('hidden');
			});
</script>



<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#myModal").modal("hide");
						var result = '<c:out value="${result}"/>';

						checkModal(result);

						history.replaceState({}, null, null);

						function checkModal(result) {

							if (result === '' || history.state) {
								return;
							}

							$("#myModal").modal("show");
						}

						$(".dropdown-item").on("click", function(event) {

							event.preventDefault();
							var selectedAuth = $(this).attr("data-value");
							var empnum=$(".empCheckbox:checked").val();
							$("#authDropdown").text($(this).text());
							$("#selectedAuth").val(selectedAuth);
						};
						

						$("#regBtn").on("click", function() {

							self.location = "/emp/register";

						});
						$("#modiBtn").on(
								"click",
								function() {

									var selectedEmpNums = [];
									$(".empCheckbox:checked").each(function() {
										selectedEmpNums.push($(this).val());
									});
									if (selectedEmpNums.length == 0) {
										console.log("수정할 직원을 선택해주세요.");
										return;
									}
									if (selectedEmpNums.length > 1) {
										console.log("다중 선택은 지원되지 않습니다.");
										return;
									}

									var selectedEmpNum = selectedEmpNums[0];

									self.location = "/emp/modify?empNum="
											+ selectedEmpNum;

								});
						
						$("#authBtn").on(
								"click",
								function() {

									var selectedEmpNums = [];
									$(".empCheckbox:checked").each(function() {
										selectedEmpNums.push($(this).val());
									});
									if (selectedEmpNums.length == 0) {
										console.log("수정할 직원을 선택해주세요.");
										return;
									}
									if (selectedEmpNums.length > 1) {
										console.log("다중 선택은 지원되지 않습니다.");
										return;
									}

									var selectedEmpNum = selectedEmpNums[0];


								});

						var actionForm = $("#actionForm");

						$(".paginate_button a").on(
								"click",
								function(e) {

									e.preventDefault();

									console.log('click');

									actionForm.find("input[name='emppageNum']")
											.val($(this).attr("href"));
									actionForm.submit();
								});

						$(".move")
								.on(
										"click",
										function(e) {

											e.preventDefault();
											actionForm
													.append("<input type='hidden' name='empNum' value='"
															+ $(this).attr(
																	"href")
															+ "'>");
											actionForm.attr("action",
													"/emp/get");
											actionForm.submit();

										});

						var searchForm = $("#searchForm");

						$("#searchForm button").on(
								"click",
								function(e) {

									if (!searchForm.find("option:selected")
											.val()) {
										alert("검색종류를 선택하세요");
										return false;
									}

									if (!searchForm.find(
											"input[name='keyword']").val()) {
										alert("키워드를 입력하세요");
										return false;
									}

									searchForm.find("input[name='emppageNum']")
											.val("1");
									e.preventDefault();

									searchForm.submit();

								});

					});
</script>
</div>
<%@include file="../includes/footer.jsp"%>

