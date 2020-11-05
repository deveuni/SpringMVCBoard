<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">ITWILL 글 상세페이지</h3>
				</div>
				<!-- /.box-header -->
				
				<form method="post" role="form">
				
					<input type="hidden" name="bno" value="${vo.bno}">
				
				</form><!-- form태그 잘라서 가는 이유는 input태그 값들을 가지고 가지 않기 위해 -->
				
				<!-- /.box-body -->
				  <div class="box-body">
					 <div class="form-group">
					   <label for="exampleInputEmail">제목</label>
					   <input type="text" name="title"
					   		   class="form-control" value="${vo.title}" readonly
					   >
					 </div>
					 <div class="form-group">
					   <label for="exampleInputPassword1">내용</label>
					 	<textarea rows="3" name="content" class="form-control" readonly>${vo.content}</textarea>
					 </div>
					 <div class="form-group">
					   <label for="exampleInputEmail">작성자</label>
					   <input type="text" name="writer"
					   		   class="form-control" value="${vo.writer}" readonly
					   >
					 </div>
				  </div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="submit" class="btn btn-warning">수정</button>			
					<button type="submit" class="btn btn-danger">삭제</button>			
					<button type="submit" class="btn btn-primary">목록</button>			
				</div>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

	<script>
		$(document).ready(function(){
			//alert("JQuery!")
		/* 	var tmp = '${vo.bno}';
			alert(tmp); */ // 이방식 말고 다른 방식으로 보내기 위해서 저 위에 form태그 사용

			var formObj = $("form[role='form']");
				//alert(formObj);
				console.log(formObj);

			// 목록으로	
			$(".btn-primary").on("click",function(){
					//alert("목록으로 가기 버튼 클릭");
					location.href="/board/listAll";
				});

			// 수정 버튼 클릭
			$(".btn-warning").click(function(){
					//alert("수정 버튼 클릭");
					
					formObj.attr("action","/board/modify");
					formObj.attr("method","get")
					formObj.submit();
				
				});

			// 삭제 버튼 
			$(".btn-danger").click(function(){
				formObj.attr("action","/board/delete");
				formObj.submit();
			});
				

			
	    });


		
			
			


	    

	</script>











<%@ include file="../include/footer.jsp" %>


