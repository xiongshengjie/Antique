<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/add.jsp";
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/findAntique"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3">
						<strong>查 询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									博物名称：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="name" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									博物类别：</td>
								<td class="ta_01" bgColor="#ffffff"><select name="category"
									id="category">
										<option value="" selected="selected">--选择博物类别--</option>
										<option value="青铜器">青铜器</option>
										<option value="陶瓷器">陶瓷器</option>
										<option value="佛造像">佛造像</option>
										<option value="玉器">玉器</option>
										<option value="金银器">金银器</option>
										<option value="钱币">钱币</option>
										<option value="书法">书法</option>
										<option value="绘画">绘画</option>
										<option value="绣织">绣织</option>
										<option value="文玩">文玩</option>
								</select></td>
							</tr>
							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" name="reset" value="&#37325;&#32622;"
									class="button_view" />
								</td>
							</tr>
						</table>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商 品 列 表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="21%">编号</td>
								<td align="center" width="6%">名称</td>
								<td align="center" width="6%">类别</td>
								<td align="center" width="6%">尺寸</td>
								<td align="center" width="9%">朝代</td>
								<td align="center" width="9%">出土时间</td>
								<td align="center" width="6%">出土地点</td>
								<td align="center" width="21%">描述</td>
								<td width="3%" align="center">编辑</td>
								<td width="3%" align="center">删除</td>
							</tr>

							<c:forEach items="${ps}" var="p">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="200">${p.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="6%">${p.name }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="6%">${p.category }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="6%">${p.size }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${p.createtime}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${p.findtime}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${p.findplace}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${p.description}</td>
									<td align="center" style="HEIGHT: 22px" width="3%"><a
										href="${pageContext.request.contextPath}/findAntiqueById?id=${p.id}&type=admin">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>

									<td align="center" style="HEIGHT: 22px" width="3%"><a
										href="${pageContext.request.contextPath}/delAntique?id=${p.id}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

