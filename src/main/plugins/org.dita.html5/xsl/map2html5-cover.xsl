<?xml version="1.0" encoding="UTF-8" ?>
<!-- This file is part of the DITA Open Toolkit project.

  Copyright 2012 Jarno Elovirta

     See the accompanying license.txt file for applicable licenses. -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0">

  <xsl:import href="plugin:org.dita.html5:xsl/map2html5-coverImpl.xsl"/>

  <dita:extension id="dita.xsl.html5.cover" 
      behavior="org.dita.dost.platform.ImportXSLAction" 
      xmlns:dita="http://dita-ot.sourceforge.net"/>

  <xsl:output method="html"
              encoding="UTF-8"
              doctype-system="about:legacy-compat"
              omit-xml-declaration="yes"/>

</xsl:stylesheet>
