
<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.CartDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form name="myForm" method="GET">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#same").on("click",function(){
		if(this.checked) { 
			$("#orderName").val($("#mname").val());
			$("#post").val($("#mpost").val());
			$("#addr1").val($("#maddress1").val());
			$("#addr2").val($("#maddress2").val());
			$("#phone").val($("#mphone").val());
		} else { 
			$("#orderName").val("");
			$("#post").val("");
			$("#addr1").val("");
			$("#addr2").val("");
			$("#phone").val("");
		}
	});

});
</script>   

	<table width="80%" cellspacing="0" cellpadding="0">

		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>주문상품 확인</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>

		<tr>
			<td>
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		<tr>
			<td height="5">
		</tr>

		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="td_default" align="center"><strong>주문번호</strong></td>
						<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
						<td class="td_default" align="center"><strong>판매가</strong></td>
						<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>

					</tr>

					<tr>
						<td colspan="4">
							<hr size="1" color="CCCCCC">
						</td>
					</tr>
<!--  변수 선언 -->					
					
<%
	int total=0;
	List<CartDTO> list = (List<CartDTO>)request.getAttribute("cDTOList");
	for(CartDTO dto : list){
		String userid = dto.getUserid();
		int num = dto.getNum();
		String gCode = dto.getgCode();
		String gImage = dto.getgImage();
		String gName = dto.getgName();
		String gSize = dto.getgSize();
		String gColor = dto.getgColor();
		int gPrice = dto.getgPrice();
		int gAmount = dto.getgAmount();
%>					
			
<!-- 누적 -->
							
<input type="hidden" name="userid" value="<%=userid %>" >
<input type="hidden" name="num" value="<%=num %>" >
<input type="hidden" name="gCode" value="<%=gCode %>" >
<input type="hidden" name="gImage" value="<%=gImage %>" >
<input type="hidden" name="gName" value="<%=gName %>" >
<input type="hidden" name="gSize" value="<%=gSize %>" >
<input type="hidden" name="gColor" value="<%=gColor %>" >
<input type="hidden" name="gPrice" value="<%=gPrice %>" >
<input type="hidden" name="gAmount" value="<%=gAmount %>" >   
					<tr>
						<td class="td_default" width="80"><%=num %></td>
						<td class="td_default" width="80"><img
							src="images/items/bottom1.gif" border="0" align="center"
							width="80" /></td>
						<td class="td_default" width="300" style='padding-left: 30px'>
						<%=gName %>
							<br> <font size="2" color="#665b5f">[옵션 : 사이즈(<%=gSize %>)
								, 색상(<%=gColor %>)]
						</font></td>
						<td class="td_default" align="center" width="110">
						￦<%=gPrice %>
						
						</td>
						<td class="td_default" align="center" width="90"><%=gAmount %></td>

					</tr>
                		
<%
		total+=gAmount*gPrice;
	}
%>	

                
					<tr>
						<td height="30"></td>
						<td class="td_default" align="right">총 결제 금액 :</td>
						<td class="td_default" align='right'>
						￦<%=total %>원</td>
					</tr>
				</table>
		<tr>
			<td>
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		</td>
		</tr>
		<!--  고객 정보 시작-->
		<%
		MemberDTO member = (MemberDTO)request.getAttribute("mAllConfirmDTO");
		String username=member.getUsername();
		String post=member.getPost();
		String addr1=member.getAddr1();
		String addr2=member.getAddr2();
		String getPhone1=member.getPhone1();
		String getPhone2=member.getPhone2();
		String getPhone3=member.getPhone3();
		%>
		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>고객 정보</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>


		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse: collapse" bordercolor="#CCCCCC">
					<tr>
						<td width="125" height="35" class="td_default">
							이 름
						</td>
						<td height="35" class="td_default"><input
							class="input_default" type="text" id="mname" size="20"
							maxlength="20" value="<%=username%>"></input></td>
					</tr>
					<tr>
						<td height="35" class="td_default">우편번호</td>
						<td height="35" class="td_default"><input
							class="input_default" type="text" id="mpost" size="5"
							maxlength="5" value="<%=post%>" readonly></input>
					</tr>
					<tr>
						<td height="35" class="td_default">주 소</td>
						<td height="35" class="td_default"><input
							class="input_default" type="text" id="maddress1" size="100"
							maxlength="200" value="<%=addr1%>" readonly></input><br> <input
							class="input_default" type="text" id="maddress2" size="100"
							maxlength="200" value="<%=addr2%>" readonly></input></td>
					</tr>

					<tr>
						<td height="35" class="td_default">휴대전화</td>
						<td height="35" class="td_default"><input
							class="input_default" type="text" id="mphone" size="15"
							maxlength="15" value="<%=getPhone1+getPhone2+getPhone3%>"></input>

						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!--  고객 정보 끝-->
		<tr>
			<td height="30">
		</tr>

		<tr>
			<td class="td_default"><input type="checkbox" name="same"
				id="same"> 배송지가 동일할 경우 선택하세요.</td>
		</tr>
		<!--  배송지 정보 시작-->
		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>배송지 정보</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>


		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse: collapse" bordercolor="#CCCCCC">
					<tr>
						<td width="125" height="35" class="td_default">이 름</td>
						<td height="35" class="td_default"><input
							class="input_default" type="text" id="orderName" name="orderName"
							size="20" maxlength="20" value=""></input></td>
					</tr>
					<tr>
						<td height="35" class="td_default">우편번호</td>
						<td height="35" class="td_default">
							<!-- 다음주소 시작--> <input name="post" id="post" size="5"
							readonly=""> <input onclick="openDaumPostcode()"
							type="button" value="우편번호찾기"> <br> <input
							name="addr1" id="addr1" size="100" readonly="" placeholder="도로명주소">
							<br> <span style="line-height: 10%;"><br></span> <input
							name="addr2" id="addr2" size="100" placeholder="지번주소"> <!-- 다음주소 끝 -->
						</td>
					</tr>

					<tr>
						<td height="35" class="td_default">휴대전화</td>
						<td height="35" class="td_default"><input
							class="input_default" type="text" id="phone" name="phone"
							size="15" maxlength="15" value=""></input></td>
					</tr>
				</table>
			</td>
		</tr>
		<!--  배송지 정보 끝-->

		<tr>
			<td height="30">
		</tr>
		<tr>
			<td><b>결제수단</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>
		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse: collapse" bordercolor="#CCCCCC">
					<tr>
						<td width="125" height="35" class="td_default"><input
							type="radio" name="payMethod" value="신용카드" checked>신용카드</input> <input
							type="radio" name="payMethod" value="계좌이체">계좌이체</input> <input
							type="radio" name="payMethod" value="무통장 입금">무통장 입금</input></td>

					</tr>

				</table>
			</td>
		</tr>

		<tr>
			<td height="30">
		</tr>


		<tr>
			<td class="td_default" align="center"><input type='button'
				value='취소' onclick="javascript:history.back()"> <input
				type='button' value='결제하기' onclick="orderAllDone(myForm)"></td>
		</tr>

	</table>

</form>

