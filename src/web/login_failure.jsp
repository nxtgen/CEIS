<%-- 
    Document   : login_failure
    Created on : Jun 1, 2013, 6:31:55 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="email_list.css">
        <script src="email_list.js"></script>
        <title>CEIS</title>        
    </head>
    
    <body>
        <h1>Sign-In</h1>
        <form id="email_form" name="email_form" action="login" method="post">
        <div class="signin-box">    		
            <div class="email-div">
		<label for="Email"><strong class="email-label">Username</strong></label>
		<input type="email" spellcheck="false" name="Email" id="Email" value="" >		  		
            </div>
            <div class="passwd-div">
		<label for="Passwd"><strong class="passwd-label">Password</strong></label>
		<input type="password" name="Passwd" id="Passwd" >
            </div>			
  	</div>
            <input type="submit" id="signIn"  value="Sign in">
        </form> 
        <p>${message}</p>
    </body>
</html>
