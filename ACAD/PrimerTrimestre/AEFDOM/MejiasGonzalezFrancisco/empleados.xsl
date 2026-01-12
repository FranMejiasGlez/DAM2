<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
        <head>
            <title>Empleados</title>
            <style>
                body { font-family: Arial, sans-serif; margin: 20px; }
                h1 { color: #333; }
                table { border-collapse: collapse; width: 100%; }
                th, td { border: 1px solid #ddd; padding: 8px; }
                th { background-color: #4CAF50; color: white; }
                tr:nth-child(even) { background-color: #f2f2f2; }
            </style>
        </head>
        <body>
            <h1>Lista de Empleados</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Apellidos</th>
                    <th>Departamento</th>
                    <th>Salario</th>
                </tr>
                <xsl:for-each select="empleados/empleado">
                <tr>
                    <td><xsl:value-of select="@id"/></td>
                    <td><xsl:value-of select="apellidos"/></td>
                    <td><xsl:value-of select="departamento"/></td>
                    <td><xsl:value-of select="salario"/> €</td>
                </tr>
                </xsl:for-each>
            </table>
        </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>