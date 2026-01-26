<% Option Explicit %>
<HTML>
<HEAD>
  <TITLE>Boletín 2 Ejercicio 2 Respuesta</TITLE>
</HEAD>

<BODY bgcolor="#FFFFFF" text="#000000">
 <TABLE align="center">
<%
 Dim i,j
 
 j=1
 For i=Request.form("inicio") To Request.form("fin") Step Request.form("incremento")
%>
   <TR>
     <TD>valor <%=j%>º&nbsp=&nbsp <%=i%></TD>
   </TR>
<%
     j=j+1
     Next
%>
</TABLE>
</BODY>
</HTML>
