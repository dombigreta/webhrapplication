<!DOCTYPE html>
<html>
<head>
    <title>webhr-application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style type="text/css">
        <%@ include file="resources/main.css" %>
    </style>
</head>
<body>
<div id='root'></div>

<script src="https://fb.me/react-15.0.1.js"></script>
<script src="https://fb.me/react-dom-15.0.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react-router/4.3.1/react-router.js"></script>

<script type="text/babel">
    <%@ include file="resources/HomePageComponent.js"%>
    <%@ include file="resources/ApplicantPageComponent.js"%>
    <%@ include file="resources/JobPageComponent.js"%>
    <%@ include file="resources/main.js"%>
</script>
</body>
</html>