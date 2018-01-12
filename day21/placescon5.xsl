<xsl:stylesheet 
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform"      
      version="1.0"  >
<xsl:template match="/">
  <html>
   <head><title>Places in  Table</title></head>
   <body>
    <center>
     <table  border="3" cellspacing="1" cellpadding="5">
        <tr><td>Name</td><td bgcolor='yellow'>NOP</td></tr>
        <xsl:for-each select="//place">
        <xsl:sort data-type="number" select="NOP" />
         <tr><td><xsl:value-of select="name" /></td>
             <td><xsl:value-of select="NOP" /></td>
         </tr>
        </xsl:for-each>        
     </table>
    </center>
   </body>
  </html>
</xsl:template>


</xsl:stylesheet> 
  
    