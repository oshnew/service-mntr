<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="strToday"><fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyyMMdd"/></c:set>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Cache-Control" content="no-cache"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="shortcut icon" href="/resources/img/dfk_logo.png">
	
	<!-- CSS, JS -->
	<script src="/resources/js/lib/jquery-1.11.1.min.js"></script>
	<script src="/resources/js/common.js?ver=${strToday}"/></script>
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css?ver=${strToday}" />
	<title>모니터링</title>
</head>
<body>

	<!-- main_container  -->
	<decorator:body />
	<!-- //main_container -->

    </body>
</html>
    
