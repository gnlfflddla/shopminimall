
<%@page import="com.dto.CartDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>


	<form name="myForm">
	    
	    
	  

<script type="text/javascript">
	$(document).ready(function(){
		function total(){
			var total=0;
			$(".sum").each(function(idx, obj){
				total+=Number.parseInt($(obj).text());
				console.log(total);
			});
			$("#totalresult").text(total);
		}
		$(".delBtn").on("click",function(){					//하나 삭제하기
			var num = $(this).attr("data-xxx");
			location.href="CartDelServlet?num="+num;
		});
		$(".orderBtn").on("click",function(){				//하나 주문하기
			var num = $(this).attr("data-ooo");
			location.href="CartOrderConfirmServlet?num="+num;
		});
		$("#allCheck").click(function(){ 
			if($("#allCheck").prop("checked")) { 
				$(".check").prop("checked",true); 
			} else { 
				$(".check").prop("checked",false); 
			} 
		});
		
		$(".modBtn").on("click",function(event){
			var num = $(this).attr("data-Modified");
			var amount = $("#CART_AMOUNT"+num).val();
			$.ajax({
				type:"get",
				url:"CartModServlet",					
				data:{
					num: num,
					amount : amount
				},
				dataType:"text",
				success:function(responsedata,status,xhr){
					if(responsedata==1){
						$("#sum"+num).text($("#gPrice"+num).val()*$("#CART_AMOUNT"+num).val());
						total();
					}
					
				},
				error:function(jqXHR,textStatus,errorThrown){
					console.log(errorThrown);
				}
			});
			
		});
		$("#selectDel").on("click",function(){
			var num=[];
			$("input:checkbox[name='check']:checked").each(function(idx,obj){
				num[idx]=$(this).val();
			});
			location.href="CartSelectDelServlet?num="+num;
		});
		$("#selectDel2").on("click",function(){
			$("form").attr("action","CartSelectDelServlet2");
			$("form").submit();	//트리거
		});
		$("#orderAllConfirm").on("click",function(){
			$("form").attr("action","CartOrderAllConfirmServlet");
		$("form").submit();	//트리거
		});
	});
	
</script>
<c:forEach var="c" items="${cartList}" varStatus="status">
		
		<input type="text" name="num${c.num}" value="${c.num}" id="num${c.num}">
		<input type="text" name="gImage${c.num}" value="${c.gImage}" id="gImage${c.num}">
		<input type="text" name="gName${c.num}" value="${c.gName}" id="gName${c.num}">
		<input type="text" name="gSize${c.num}" value="${c.gSize}" id="gSize${c.num}">
		<input type="text" name="gColor${c.num}" value="${c.gColor}" id="gColor${c.num}"> 
		<input type="text" name="gPrice${c.num}" value="${c.gPrice}" id="gPrice${c.num}"><br>

		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check${c.num}" class="check" value="${c.num}"></td>
			<td class="td_default" width="80">${c.num}</td>
			<td class="td_default" width="80"><img
				src="images/items/${c.gImage}.gif" border="0" align="center"
				width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'>${c.gName}
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(${c.gSize})
					, 색상(${c.gColor})]
			</font></td>
			<td class="td_default" align="center" width="110">
			${c.gPrice}


			</td>
			<td class="td_default" align="center" width="90"><input
				class="input_default" type="text" name="CART_AMOUNT"
				id="CART_AMOUNT${c.num}" style="text-align: right" maxlength="3"
				size="2" value="${c.gAmount}"></input></td>
			<td><input type="button" value="수정" class="modBtn" data-Modified="${c.num}"></td>
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'><span id="sum${c.num}" class="sum">
				${c.gPrice*c.gAmount}
				</span></td>
			<td><input type="button" value="주문"
				class="orderBtn" data-ooo="${c.num}"></td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'><input type="button" value="삭제" 
				class="delBtn" data-xxx="${c.num}">
			</td>
			<td height="10"></td>
		</tr>

</c:forEach>

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
		<span id="totalresult"></span>
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black" href="#"
			id="orderAllConfirm"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="#" id="selectDel"> 선택 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#" id="selectDel2"> 선택 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
