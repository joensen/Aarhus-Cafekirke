<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:p="http://primefaces.prime.com.tr/ui" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<f:view>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Podcast Arkiv</title>
	<p:resources /> 
	<link rel="icon" type="image/png" href="img/icon/icon16.png" />
	<link rel="apple-touch-icon" href="img/icon/icon129.png" />
	<link rel="stylesheet" type="text/css" href="style/podcast.css" />
</head>
<body>

	<h:form prependId="false">

	<h1><h:outputText value="Podcast Arkiv"></h:outputText></h1>

	<p:dataTable value="#{podcast.allItems}" var="item" dynamic="true" >
		<p:column sortBy="#{item.lang}">
			<f:facet name="header">
				<h:outputText value="Sprog"></h:outputText>
			</f:facet>
			<h:graphicImage value="/img/icon/#{item.lang}.gif"></h:graphicImage>
		</p:column>
		<p:column sortFunction="#{podcast.sortDate}" sortBy="#{item.date}">
			<f:facet name="header">
				<h:outputText value="Dato"></h:outputText>
			</f:facet>
			<h:outputText style="color: blue;" value="#{item.date.date}"></h:outputText>
		</p:column>
		<p:column sortBy="#{item.title}" >
			<f:facet name="header">
				<h:outputText value="Titel"></h:outputText>
			</f:facet>
			<h:outputText value="#{item.title}"></h:outputText>
		</p:column>
		<p:column sortBy="#{item.author}">
			<f:facet name="header">
				<h:outputText value="Taler"></h:outputText>
			</f:facet>
			<h:outputText value="#{item.author}"></h:outputText>
		</p:column>
		<p:column sortFunction="#{podcast.sortDuration}" sortBy="#{item.duration}">
			<f:facet name="header">
				<h:outputText value="L\346ngde"></h:outputText>
			</f:facet>
			<h:outputText value="#{item.duration}"></h:outputText>
		</p:column>
		<p:column sortFunction="#{podcast.sortSize}" sortBy="#{item.MB}">
			<f:facet name="header">
				<h:outputText value="MB"></h:outputText>
			</f:facet>
			<h:outputText value="#{item.MB}"></h:outputText>
		</p:column>
		<p:column>
			<f:facet name="header">
				<h:outputText value="Download"></h:outputText>
			</f:facet>
			<p:linkButton value="Download" href="#{item.podcastUrl}"></p:linkButton>
		</p:column>
	</p:dataTable>
	
	</h:form>

</body>
</f:view>
</html>
</jsp:root>