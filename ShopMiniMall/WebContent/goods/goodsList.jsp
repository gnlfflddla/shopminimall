
<%@page import="com.dto.PageDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table width="100%" cellspacing="0" cellpadding="0">

	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">

				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>

				<tr>
<%	
	PageDTO pDTO=null;
	List<GoodsDTO> list=null;
	try{
	pDTO = (PageDTO)session.getAttribute("goodsPage");
	list= pDTO.getList();
	}catch(NullPointerException e){}
	int totalPage = pDTO.getTotalCount()/pDTO.getPerPage();
	if(totalPage%2 !=0 ) totalPage++;
	int curPage = pDTO.getCurPage();
	for(int i=1;i<list.size()+1; i++){
	GoodsDTO dto = list.get(i-1);
	String gCode = dto.getGcode();
	String gCategory = dto.getGcategory();
	String gName = dto.getGname();
	String gContent = dto.getGcontent();
	int gPrice = dto.getGprice();
	String gImage = dto.getGimage();
%>

					<td>
						<table style='padding: 15px'>
							<tr>
								<td><a href="GoodsRetrieveServlet?gCode=<%=gCode%>"> <img
										src="images/items/<%=gImage%>.gif" border="0" align="center"
										width="200">
								</a></td>
							</tr>
							<tr>

								<td height="10">
							</tr>
							<tr>
								<td class="td_default" align="center"><a class="a_black"
									href="GoodsRetrieveServlet?gCode=<%=gCode%>"><%=gName %><br>
								</a> <font color="gray"> -------------------- </font></td>

							</tr>
							<tr>
								<td height="10">
							</tr>
							<tr>
								<td class="td_gray" align="center"><%=gContent %></td>
							</tr>
							<tr>
								<td height="10">
							</tr>
							<tr>
								<td class="td_red" align="center"><font color="red"><strong>
											<%=gPrice %> </strong></font></td>
							</tr>
						</table>
					</td>
					<%--  <%if(i%4==0){ %>
						<tr>
						<td height="10"></td>
						</tr>
					<%} %>  --%>
<%} %>

				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<%for (int i = 1; i <= totalPage; i++) {
			//if(Math.abs(i-curPage)<2){	//보이는 페이지 번호가 최대 5개 왼쪽 2개 오른쪽 2개
			if (i == curPage) {%>
				<%=i %> 
			<%} else {%>
				<a href="GoodsListServlet?curPage=<%=i%>"> <%=i%> </a>
			<% }
			//}
		} %>
	</tr>
</table>
