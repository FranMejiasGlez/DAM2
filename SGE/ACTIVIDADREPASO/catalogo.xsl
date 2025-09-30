<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <!-- Plantilla principal -->
  <xsl:template match="/">
    <html>
      <head>
        <title>Catálogo de Productos</title>
        <style>
          table { border-collapse: collapse; width: 60%; }
          th, td { border: 1px solid black; padding: 8px; text-align: left; }
          th { background-color: #f2f2f2; }
        </style>
      </head>
      <body>
        <h2>Catálogo de Productos</h2>
        <table>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Stock</th>
          </tr>
          <!-- Iterar sobre cada producto -->
          <xsl:for-each select="catalogo/producto">
            <tr>
              <td><xsl:value-of select="id"/></td>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="precio"/></td>
              <td><xsl:value-of select="stock"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>