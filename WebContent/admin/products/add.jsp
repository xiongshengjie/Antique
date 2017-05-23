<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">

<script type="text/javascript"
			src="../js/datecontrol/WdatePicker.js"></script>
</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/addAntique" method="post"
		enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加博物</STRONG> </strong>
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">博物名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="name" class="bg"/>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">博物类别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="category" id="category">
						<option value="" selected="selected">--选择博物类加--</option>
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
				</select>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">博物尺寸：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="size" 
					class="bg" />
				</td>
				
				<td align="center" bgColor="#f5fafe" class="ta_01">
						出土时间：
				</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="findtime" 
							class="Wdate" onclick="new WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value=""/>
					</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">出土地点：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="findplace" 
					class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01"></td>
				<td class="ta_01" bgColor="#ffffff">
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">博物朝代：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="createtime" 
					class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">博物图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<input
					type="file" name="upload" size="30" value=""/>
				</td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">博物描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="description" cols="30" rows="3" style="WIDTH: 96%"></textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定">	
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置" class="button_cancel">
					
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1">
					
					</span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>