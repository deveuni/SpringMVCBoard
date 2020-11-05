<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title"> ITWILL 게시판 목록 </h3>
				</div>
				<!-- /.box-header -->
				
				 <!-- /.box-body -->
				 <div class="box-body">
				   <%-- ${boardList } --%>
				 
				    <table class="table table-bodered">
				      <tr>
				        <th>번호</th>
				        <th>제목</th>
				        <th>글쓴이</th>
				        <th>날짜</th>
				        <th>조회수</th>
				      </tr>
				     
				     <c:forEach items="${boardList }" var="boardVO"> 
				      <tr>
				        <td>${boardVO.bno }</td>
				        <td>
				         <a href="/board/readPage?bno=${boardVO.bno }&page=${pm.cri.page}&pageSize=${pm.cri.pageSize}">${boardVO.title }</a>				        
				        </td>
				        <td>${boardVO.writer }</td>
				        <td>
				          <fmt:formatDate value="${boardVO.regdate }" 
				             pattern="yyyy-MM-dd HH:mm"
				               />
				              <!--    type="both"
				              timeStyle="short" -->
				        </td>
				        <td>
				          <span class="badge bg-red">
				            ${boardVO.viewcnt }
				          </span>				          
				        </td>
				      </tr>
				     </c:forEach>
				      
				      
				      
				    </table>
				 </div>
				  <!-- /.box-body -->
				  
				 <div class="box-footer">
				<%--  ${pm} --%>
				 
				    <div class="text-center">
				       <ul class="pagination">
				       
				    <!-- 이전 --> 
				    <c:if test="${pm.prev}">
				    	<li> 
				    	
				    		<a href="listPage?page=${pm.startPage-1}">&laquo;</a> 
				    		
				    	</li>
				    </c:if>  
				       
				       <c:forEach begin="${pm.startPage }"
				       			  end="${pm.endPage}"
				       			  var="idx"
				       >
				       <!-- model에서 전달된 값을 사용해서 태그의 class명을 지정 
				       		-> css 적용
				        -->
				          <li
				          	${pm.cri.page == idx? 'class=active':''}
				          >
				          	<a href="listPage?page=${idx}">${idx}</a>
				          </li>
				       </c:forEach>   
				       
				       <!-- 다음 -->
				      <c:if test="${pm.next && pm.endPage > 0}">
				    	<li> 
				    	
				    		<a href="listPage?page=${pm.endPage+1}">&raquo;</a> 
				    	
				    	</li>
				      </c:if>  
				          				       
				       </ul>				    
				    </div>	
				    <!-- text-center  -->			 
				 </div>
				 <!-- box-footer -->

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
<script type="text/javascript">
   //alert("테스트");
   var result = '${result}';

   if(result == "SUCCESS" ){
	    alert("result : "+result);
	    alert("글쓰기 정상 처리 완료!");
	    //location.href="/board/register";
   }

   if(result == "upok"){
       alert("글 수정완료! ");
	}

	if(result == "delok"){
       alert("글 삭제 완료!");
	}

   
 
</script>



<%@ include file="../include/footer.jsp" %>
