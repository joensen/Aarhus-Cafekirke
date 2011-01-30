<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:p="http://primefaces.prime.com.tr/ui" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" > ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<f:view locale="#{lang.locale}">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<meta name="google-site-verification" content="u5iWZjV0iBYJuF9GrUH9IOzbXpCrPlhDnGHMDcHZlSU" />
	<meta nam="description" content="I Århus Cafékirke har vi en hyggelig atmosfære hvor alle er velkomne." />
	<title><h:outputText value="#{msgs.title}"></h:outputText></title>
	<h:outputText value="#{msgs.css}" escape="false"></h:outputText>
	<p:resources /> 
	<link rel="stylesheet" type="text/css" href="style/window.css" />
	<link rel="icon" type="image/png" href="img/icon/icon16.png" />
	<link rel="apple-touch-icon" href="img/icon/icon129.png" />
</head>
<body onload="document.getElementById('wkalender').style.display='block';document.getElementById('wnyhedsbrev').style.display='block';document.getElementById('wpodcast').style.display='block';document.getElementById('winformation').style.display='block';document.getElementById('windgang').style.display='block'">

	<h:form prependId="false">
	<div id="menu">
		<ul id="mlist">
			<!-- <li id="mkalender"><a href="#" onclick="kalender.show()"></a></li> -->
			<li id="mkalender"><p:commandLink actionListener="#{frontMenu.showKalender}" onclick="kalender.show()" update="kalenderFrame"></p:commandLink></li>
			<li id="mpodcast"><a href="#" onclick="podcast.show()"></a></li>
			<li id="minformation"><a href="#" onclick="information.show()"></a></li>
			<li id="mnyhedsbrev"><a href="#" onclick="nyhedsbrev.show()"></a></li>
		</ul>
	</div>
	<p:hotkey bind="esc" onsuccess="podcast.hide(); information.hide(); nyhedsbrev.hide(); kalender.hide(); indgang.hide()"></p:hotkey>
	
	</h:form>
	
	
	<p:dialog id="wnyhedsbrev" resizable="false" widgetVar="nyhedsbrev" effect="fade" effectDuration="0.5" modal="true" constrainToViewport="true" underlay="none">
		<h2><h:outputText value="#{msgs.newsletter_title}"></h:outputText></h2>
		<p><h:outputText value="#{msgs.newsletter_text}"></h:outputText></p>
		<h:form prependId="false">
			<h3><h:outputText value="#{msgs.newsletter_subtext}"></h:outputText></h3>
				<label for="email"><h:outputText value="#{msgs.email}" /></label>
				<h:inputText id="email" value="#{newsletter.email}" />
				<p:commandButton value="#{msgs.subscribe}" action="#{newsletter.sub}" update="message" />
				<br />
				<h:outputText styleClass="#{newsletter.style}" value="#{newsletter.message}" id="message" />
				
		</h:form>
		
		<h:form prependId="false">
			<h3><h:outputText value="#{msgs.newsletter_unsubtext}"></h:outputText></h3>
				<label for="unemail"><h:outputText value="#{msgs.email}" /></label>
				<h:inputText id="unemail" value="#{newsletter.email}" />
				<p:commandButton value="#{msgs.unsubscribe}" action="#{newsletter.unsub}" update="unmessage" />
				<br />
				<h:outputText styleClass="#{newsletter.style}" value="#{newsletter.message}" id="unmessage" />
				
		</h:form>
		<h3><h:outputText value="#{msgs.newsletter_lastest}" /> </h3>
		<p class="extratop"><h:outputLink value="#{news.latest.url}" target="_blank"><h:outputText value="#{msgs.newsletter_week} #{news.latest.week} - #{news.latest.year}" /></h:outputLink></p>
		<p class="extratop"><a href="http://www.aarhuscafekirke.dk/news" target="_blank"><h:outputText value="#{msgs.newsletter_more}" /></a></p>
	</p:dialog>
	
	<p:dialog id="wpodcast" widgetVar="podcast" effect="fade" effectDuration="0.5" modal="true" constrainToViewport="true" underlay="none">
		<h2>Podcast</h2>
		<p><h:outputText value="#{msgs.podcast_text}"></h:outputText></p>
		<p><h:outputLink value="#{msgs.podcast_itunes}"><img src="img/icon/itunes.png" /></h:outputLink><h:outputLink value="#{msgs.podcast_itunes}">iTunes</h:outputLink><a href=""><img src="img/icon/rss.png" /></a><a href="http://www.aarhuscafekirke.dk/podcast/rss.xml" target="_blank">RSS</a></p>
		<h3><h:outputText value="#{msgs.podcast_latest}"></h:outputText></h3>
		<h:dataTable value="#{podcast.items}" var="item">
			<h:column>
				<p class="date"><h:outputText value="#{item.date.date}"></h:outputText></p>
				<p class="descr"><h:outputText value="#{item.author}"></h:outputText>: <h:outputText value="#{item.title}"></h:outputText></p>
				<p class="download"><h:outputLink value="#{item.podcastUrl}" target="_blank">Download</h:outputLink> (<h:outputText value="#{item.duration}"></h:outputText>)</p>
			</h:column>
		</h:dataTable>
		<p class="extratop"><a href="podcast.html" target="_blank" ><h:outputText value="#{msgs.podcast_more}"></h:outputText></a></p>
	</p:dialog>
	
	<p:dialog id="winformation" widgetVar="information" effect="fade" effectDuration="0.5" modal="true" constrainToViewport="true" underlay="none">
		<h2>Information</h2>
		<p></p>
		<p><h:outputText value="#{msgs.info_text}" escape="false"></h:outputText></p>
		<a href="http://maps.google.dk/maps/place?cid=9523366081967877791" target="_blank"><h:graphicImage styleClass="right" value="img/kort3.png"></h:graphicImage></a>
		<p></p>
		<p><a href="#" onclick="indgang.show()"><h:outputText value="#{msgs.info_indgang}"></h:outputText></a></p>
		<h3><h:outputText value="#{msgs.info_findonweb}"></h:outputText></h3>
		<p><a href="http://www.facebook.com/aarhuscafekirke" target="_blank"><h:outputText value="#{msgs.info_fb}"></h:outputText></a><br />
		<a href="http://www.twitter.com/aarhuscafekirke" target="_blank"><h:outputText value="#{msgs.info_twitter}"></h:outputText></a><br />
		<a href="http://www.youtube.com/aarhuscafekirke" target="_blank"><h:outputText value="#{msgs.info_youtube}"></h:outputText></a><br />
		<a href="http://www.flickr.com/photos/aarhuscafekirke" target="_blank"><h:outputText value="#{msgs.info_flickr}"></h:outputText></a><br />
		<a href="http://www.kiva.org/team/aarhuscafekirke" target="_blank"><h:outputText value="#{msgs.info_kiva}"></h:outputText></a>
		</p>
		<h3><h:outputText value="#{msgs.info_contact}"></h:outputText></h3><p>mail@aarhuscafekirke.dk<br /><br />Århus Cafékirke<br />Fuglebakkevej 1A<br />8210 Århus V<br />
		</p>
	</p:dialog>
	
	<p:dialog id="windgang" widgetVar="indgang" header="Indgang / Entrance" effect="fade" effectDuration="0.5" modal="true" constrainToViewport="true" underlay="none">
		<h:graphicImage value="img/indgang.png"></h:graphicImage>
	</p:dialog>
	
	<p:dialog id="wkalender" header="#{msgs.calendar_title}" widgetVar="kalender" effect="fade" effectDuration="0.5" modal="true" constrainToViewport="true" underlay="none">
		<p:ajaxStatus>
			<f:facet name="start">
				<h:outputText value="Loading.."></h:outputText>
			</f:facet>
			<f:facet name="complete"><h:outputText id="kalenderFrame" value="#{frontMenu.kalender}" escape="false"></h:outputText></f:facet>
		</p:ajaxStatus>
	</p:dialog>
	<h:form prependId="false">
		<div id="lang">
			<h:commandLink action="#{lang.danish}" styleClass="la_da"></h:commandLink>
			<h:commandLink action="#{lang.english}" styleClass="la_en"></h:commandLink>
		</div>
	</h:form>
	
	<script type="text/javascript">
			var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
			document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<script type="text/javascript">
			try {
				var pageTracker = _gat._getTracker("UA-15098098-2");
				pageTracker._trackPageview();
			} catch(err) {}
	</script>
</body>
</f:view>
</html>
</jsp:root>