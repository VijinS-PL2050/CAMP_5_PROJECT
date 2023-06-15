<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LOGIN</title>
    <meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="expires" content="0">
    <script>
        setTimeout(function() {
            window.location.href = "${pageContext.request.contextPath}/login/user";
        }, 1); // Redirect after 5 seconds (adjust the delay as needed)
        history.replaceState(null, "", "${pageContext.request.contextPath}/login/user");
        
        if (window.history && window.history.pushState) {
    		window.history.replaceState(null, null, window.location.href);
    		window.history.pushState(null, null, window.location.href);
    		window.onpopstate = function(event) {
    			window.history.go(1);
    		};
    	}
    </script>
</head>
<body>
    <p>If you are not automatically redirected, please <a href="${pageContext.request.contextPath}/login/user">click here</a>.</p>
</body>
</html>
