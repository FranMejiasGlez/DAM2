<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
    <h2>Lista de Alumnos</h2>
    <table border="1">
      <tr>
        <th>Nombre</th>
        <th>ID</th>
        <th>Nota</th>
      </tr>
      <xsl:for-each select="alumnos/alumno">
      <tr>
        <td><xsl:value-of select="Nombre"/></td>
        <td><xsl:value-of select="id"/></td>
        <td><xsl:value-of select="nota"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>