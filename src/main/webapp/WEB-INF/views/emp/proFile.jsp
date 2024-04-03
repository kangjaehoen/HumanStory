<%@include file="sideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<style type="text/css">
.container {
	max-width: 800px;
	margin-left: 50px;
	padding-left: 100px;
	padding-right: 100px;
	padding-top: 0px;
	padding-bottom: 30px;
	border: 1px solid #ddd;
	border-radius: 5px;
	background-color: #fff;
}

label {
	font-size: 20px;
}

#title {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border-bottom: 3px solid #ddd;
	border-left: none;
	border-right: none;
	border-top: none;
	box-sizing: border-box;
	margin-bottom: 30px;
	height: 80px;
	font-size: 24px;
	padding-bottom: 0px;
	margin-top: 15px;
}

#title:focus {
	outline: none;
}

#detail {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-sizing: border-box;
	height: 300px;
}

/* 입력 필드와 라벨 스타일 */
.input-group {
	margin-bottom: 20px;
}

.input-group label {
	display: block;
	margin-bottom: 5px;
}

.input-group input[type="text"], .input-group textarea {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-sizing: border-box;
}

.input-group textarea {
	height: 150px;
}

.panel-body {
	padding: 20px;
}

.uploadDiv label {
	display: inline-block;
	padding: 10px 15px;
	font-size: 16px;
	background-color: #b5b7e5;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.uploadDiv label:hover {
	background-color: #5c5e91;
}

.uploadResult ul {
	list-style: none;
	padding: 0;
}

.uploadResult li {
	margin-bottom: 10px;
	overflow: hidden;
}

.uploadResult li span {
	display: block;
	margin-bottom: 5px;
	font-size: 16px;
}

.uploadResult li img {
	max-width: 100px;
	height: auto;
	margin-top: 5px;
	display: block;
}

.uploadResult li button {
	display: inline-block;
	margin-left: 10px;
	padding: 5px;
	font-size: 14px;
	background-color: #f44336;
	color: #fff;
	border: none;
	border-radius: 50%;
	cursor: pointer;
	transition: background-color 0.3s;
}

.upload-box {
	border: 2px dashed #aaa;
	border-radius: 5px;
	padding: 20px;
	text-align: center;
	cursor: pointer;
}

.uploadResult li button:hover {
	background-color: #d32f2f;
}

/* 등록 버튼 스타일 */
#submitBtn {
	display: block;
	width: 100%;
	padding: 13px;
	font-size: 18px;
	background-color: #b5b7e5;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
	margin-top: 30px;
}

#submitBtn:hover {
	background-color: #5c5e91;
}

.navigation {
	margin-left: 430px;
	margin-top: 100px;
}

.navigation div {
	display: inline;
	padding-bottom: 10px;
	margin-right: 50px;
}

.navigation div a {
	text-decoration: none;
	color: #a5a5a5;
	font-weight: bold;
	display: block; /* a태그는 글자성격 = inline */
	float: left;
	font-size: 16px;
	font-weight: 900;
	line-height: 80px;
	padding: 0 30px;
	margin-right: 10px;
}

.navigation div a:hover {
	color: #2900c5;
}

#policyNav {
	color: #333;
}

#policyNav:hover {
	color: #2900c5;
}
</style>
    
	

<div class="border-gray-300 rounded-lg dark:border-gray-600 h-32 md:h-64">
		<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading"></div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="form-group uploadDiv">
							<div class="upload-box" id="dropArea">
								<div>클릭하여 파일을 선택하세요.</div>
								<input type="file" name='uploadFile' multiple>

								<div class='uploadResult'>
									<ul>

									</ul>
								</div>

							</div>
						</div>





					</div>
					<!--  end panel-body -->
				</div>
				<!--  end panel-body -->
			</div>
			<!-- end panel -->
		</div>
		<!-- /.row -->

		<form role="form" action="/emp/proFile" method="post">

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			<input type="hidden" id="empNumCheck" name="empNum" value="<sec:authentication property='principal.emp.empNum'/>">
				
				 <input id="submitBtn" type="submit" value="프로필 등록">
		</form>
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
		$(function() {
			
			const token = $("meta[name='_csrf']").attr("content");
			const header = $("meta[name='_csrf_header']").attr("content");

			let empNumCheck = $("#empNumCheck").val()

			console.log("프로필 등록 확인번호"+empNumCheck);

			var formObj = $("form[role='form']");

			$("#submitBtn").on("click",function(e) {
								e.preventDefault();
								console.log("submit clicked");
								var str = "";

								$(".uploadResult ul li").each(function(i, obj) {

													var jobj = $(obj);

													console.dir(jobj);
													console
															.log("-------------------------");
													console.log(jobj
															.data("filename"));

													str += "<input type='hidden' name='fileName' value='"
															+ jobj
																	.data("filename")
															+ "'>";
													str += "<input type='hidden' name='uuid' value='"
															+ jobj.data("uuid")
															+ "'>";
													str += "<input type='hidden' name='uploadPath' value='"
															+ jobj.data("path")
															+ "'>";
													str += "<input type='hidden' name='fileType' value='"
															+ jobj.data("type")
															+ "'>";
												});

								console.log(str);

								formObj.append(str).submit();
							});

			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; //5MB

			function checkExtension(fileName, fileSize) {

				if (fileSize >= maxSize) {
					alert("파일 사이즈 초과");
					return false;
				}

				if (regex.test(fileName)) {
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}
				return true;
			}

			$("input[type='file']").change(function(e) {
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;

				   if (files.length > 0) {
				        if (!checkExtension(files[0].name, files[0].size)) {
				            return false;
				        }
				        formData.append("uploadFile", files[0]);
				    }

				$.ajax({
					url : '/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type : 'POST',
					dataType : 'json',
					 beforeSend : function(xhr) {
					        xhr.setRequestHeader(header, token);
					    },
					success : function(result) {
						console.log(result);
						showUploadResult(result); //업로드 결과 처리 함수 

					}
				}); //$.ajax		    
			});//end change   

			function showUploadResult(uploadResultArr) {

				if (!uploadResultArr || uploadResultArr.length == 0) {
					return;
				}

				var uploadUL = $(".uploadResult ul");

				var str = "";

				$(uploadResultArr)
						.each(
								function(i, obj) {

									if (obj.image) {
										var fileCallPath = encodeURIComponent(obj.uploadPath
												+ "/s_"
												+ obj.uuid
												+ "_"
												+ obj.fileName);
										str += "<li data-path='"+obj.uploadPath+"'";
					str +=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'"
					str +" ><div>";
										str += "<span> " + obj.fileName
												+ "</span>";
										str += "<button type='button' data-file=\'"+fileCallPath+"\' "
					str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
										str += "<img src='/display?fileName="
												+ fileCallPath + "'>";
										str += "</div>";
										str + "</li>";
									} else {
										var fileCallPath = encodeURIComponent(obj.uploadPath
												+ "/"
												+ obj.uuid
												+ "_"
												+ obj.fileName);
										var fileLink = fileCallPath.replace(
												new RegExp(/\\/g), "/");

										str += "<li "
					str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
										str += "<span> " + obj.fileName
												+ "</span>";
										str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
					str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
										str += "<img src='/resources/img/attach.png'></a>";
										str += "</div>";
										str + "</li>";
									}

								});

				uploadUL.append(str);
			}

		})
	</script>


	
<%@include file="footer.jsp"%>
