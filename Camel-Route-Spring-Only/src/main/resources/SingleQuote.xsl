<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" omit-xml-declaration="yes"/>

    <xsl:template match="/xml_api_reply/finance">
        <html>
            <head>
                <title>Stock Sheet for <xsl:value-of select="company/@data"/></title>
            </head>
            <body>
                <p>
                Current value of <b><xsl:value-of select="symbol/@data"/></b> (<xsl:value-of select="company/@data"/>) at exchange <xsl:value-of select="exchange/@data"/> is <xsl:value-of select="last/@data"/> (<xsl:value-of select="currency/@data"/>)
                </p>
            </body>
        </html>


    </xsl:template>
</xsl:stylesheet>