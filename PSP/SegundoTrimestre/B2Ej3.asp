<% Option Explicit %>
<HTML>
<HEAD>
  <TITLE>Boletín 2 Ejercicio 3 Inicio y respuesta</TITLE>
</HEAD>

<BODY bgcolor="#FFFFFF" text="#000000">
<%
  Dim i,j,ini,inc
  Dim esPrimeraVez, esFinVacio, esError

  If Request.form("hinicio")<>"" Then
        ini=Request.form("hinicio")
  Else
        ini=1
  End If   

  If Request.form("hincremento")<>"" Then
        inc=Request.form("hincremento")
  Else
        inc=1
  End If
  
  esPrimeraVez = Request.form=""
  esFinVacio = Not esPrimeraVez And Request.form("hfin")=""
  esError = Not esPrimeraVez And Not esFinVacio And _
            ((ini < Request.form("hfin") And inc < 0) Or (ini > Request.form("hfin") And inc > 0))

  If esPrimeraVez Or esFinVacio Or esError Then 
%>
    <FORM name="form" method="post" action="B2Ej3.asp">
     <P>Formulario de entrada de datos.<BR>
        Este formulario llama a B2Ej3.asp y le pasa los datos de los tres campos 
        de texto.<BR>
     </P>
     <P>
        El primer campo de texto se llama hinicio.<BR>
        El segundo campo de texto se llama hfin.<BR>
        El tercer campo de texto se llama hincremento.<BR>
     </P>
     <TABLE border=0 align="center">
      <TR>
       <TD>Inicio Contador: </TD>
       <TD><INPUT type="text" name="hinicio" value=<%=ini%> maxlength="3" size="5"></TD>
       <TD>Si no se indica se asumirá 1</TD> 
      </TR> 
      <TR>
       <TD>Fin Contador: </TD>
       <TD><INPUT type="text" name="hfin" maxlength="3" size="5"></TD>
       <TD>
    <%   If esFinVacio Then %>
          <FONT color="#FF0000">Debe indicarse un valor final</FONT>
    <%   End If %>
       </TD>
      </TR>
      <TR>
       <TD>Incremento: </TD>
       <TD><INPUT type="text" name="hincremento" value=<%=inc%> maxlength="3" size="5"></TD>
       <TD>Si no se indica se asumirá incremento 1 </TD>
      </TR>
      <TR>
       <TD colspan=3 align="center"><INPUT type="submit" value="Enviar Datos"></TD>
      </TR>
     </TABLE> 
    </FORM>
    <% If esError Then %>
          <FONT color="#FF0000">
             Imposible obtener desde <%=ini%> a <%=Request.form("hfin")%>
                                con incremento <%=inc%>
          </FONT>
<% 
       End If       
   Else 
%>
     <TABLE align="center">
<%
       j=1
       For i=ini To Request.form("hfin") Step inc
%>
           <TR>
            <TD>valor <%=j%>º&nbsp=&nbsp <%=i%></TD>
           </TR>
<%
           j=j+1
       Next
%>
     </TABLE>

<%End If %>

</BODY>
</HTML>
