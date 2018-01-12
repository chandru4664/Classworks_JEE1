<xsl:stylesheet 
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform"      
      version="1.0"  >
<xsl:template match="/">
  <html>
   <head><title>Places in  Table</title></head>
   <body>
    <center>
     <table  border="3" cellspacing="1" cellpadding="5">
        <tr> <td bgcolor='yellow'>Place-Name</td></tr>
         <xsl:apply-templates  select="//place" />
         
     </table>
    </center>
   </body>
  </html>
</xsl:template>

<xsl:template match="place">
  <tr>
    <td bgcolor='cyan'>
      <xsl:value-of  select="name" />
    </td>
 </tr>   
</xsl:template> 

</xsl:stylesheet> 
  
    