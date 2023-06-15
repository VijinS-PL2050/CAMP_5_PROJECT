<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restricted Page</title>
    <script>
        // Disable browser back button
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        };

        // Function to clear session and logout
        function logout() {
            // Perform logout action here (e.g., invalidate session or clear session attributes)
            // Redirect to the login page
            window.location.href = "${pageContext.request.contextPath}/login/logout";
        }
    </script>
</head>
<body>
    <h1>Welcome to the Restricted Page!</h1>
    
    <%-- Display user information --%>
    <p>Logged in as: <strong><%= session.getAttribute("username") %></strong></p>
    
    <%-- Navigation or actions --%>
    <ul>
        <li><a href="/dashboard">Go to Dashboard</a></li>
        <li><a href="/profile">View Profile</a></li>
        <li><a href="javascript:void(0);" onclick="logout();">Logout</a></li>
    </ul>
</body>
</html>
