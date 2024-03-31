<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Sign Up</title>
	<link rel="stylesheet" type="text/css" href="../Styles.css">
  	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Reem+Kufi:wght@400..700&family=Work+Sans:wght@300;500;700;900&display=swap" rel="stylesheet"> 
	<!-- <meta http-equiv="refresh" content="0;url=Association.jsp"> -->
	<style>
		html {
		  scroll-behavior: smooth;
		}
		
		* {
		  margin: 0;
		  padding: 0;
		  box-sizing: border-box;
		  font-family: "Reem Kufi", sans-serif !important;
		}
		
		body {
		  max-width: 100%;
		  overflow-x: hidden;
		  background-color: #f6f6f6;
		}
		.container {
		  max-width: 450px;
		  background: #f6f6f6;
		  background: linear-gradient(
		    0deg,
		    rgb(255, 255, 255) 0%,
		    #f6f6f6 100%
		  );
		
		  padding: 25px 35px;
		  border: 5px solid rgb(255, 255, 255);
		  box-shadow: black 0px 10px 20px -20px;
		  margin: 20px auto;
		  box-shadow: 0px 187px 75px rgba(0, 0, 0, 0.01), 0px 105px 63px rgba(0, 0, 0, 0.05), 0px 47px 47px rgba(0, 0, 0, 0.09), 0px 12px 26px rgba(0, 0, 0, 0.1), 0px 0px 0px rgba(0, 0, 0, 0.1);
		}

		.heading {
		  text-align: center;
		  font-weight: 900;
		  font-size: 30px;
		  color: #1334A9;
		}
		
		.form {
		  margin-top: 20px;
		}
		
		.form .input {
		  width: 100%;
		  background: white;
		  border: none;
		  padding: 15px 20px;
		  border-radius: 20px;
		  margin-top: 15px;
		  box-shadow: #cff0ff 0px 10px 10px -5px;
		  border-inline: 2px solid transparent;
		}
		
		.form .input::-moz-placeholder {
		  color: rgb(170, 170, 170);
		}
		
		.form .input::placeholder {
		  color: rgb(170, 170, 170);
		}
		
		.form .input:focus {
		  outline: none;
		  border-inline: 2px solid #1334A9;
		}
		
		
		.form .login-button {
		  display: block;
		  width: 100%;
		  font-weight: bold;
		  background: linear-gradient(
		    45deg,
		    rgb(16, 137, 211) 0%,
		    #1334A9 100%
		  );
		  color: white;
		  padding-block: 18px;
		  margin: 20px auto;
		  margin-top:40px;
		  border-radius: 20px;
		  box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 20px 10px -15px;
		  border: none;
		  transition: all 0.2s ease-in-out;
		  cursor: pointer;
		}
		
		
		.social-account-container {
		  margin-top: 25px;
		}
		
		.social-account-container .title {
		  display: block;
		  text-align: center;
		  font-size: 10px;
		  color: rgb(170, 170, 170);
		}
		
		.agreement {
		  display: block;
		  text-align: center;
		  margin-top: 15px;
		}
		
		.agreement a {
		  text-decoration: none;
		  color: #0099ff;
		  font-size: 9px;
		}
		
		.legal {
		  text-align: center;
		  padding: 10px 0;
		  color: grey;
		  margin-top:42px;
		  
		}
		.legal p {
		  font-size: 15px;
		}
			
	</style>
</head>

<body>

	<%
        String Message = (String) request.getAttribute("Message");
        if (Message != null) {
    %>
        <p style="color: green; text-align:center ;margin-top:5px">
            <%= Message %>
        </p>
    <%
        }
    %>
	
	<div class="container">
    	<div class="heading">Sign Up</div>
			<form class="form" action="SignUPAssociation" method="post">
				<input  class="input" type="text" name="AssId" placeholder="Association ID" required="">
			    <input  class="input" type="text" name="AssName" placeholder="Association Name" required="">
			    <input  class="input" type="text" name="AssEmail" placeholder="Association Email" required="">
			    <input  class="input" type="password" name="AssPassword" placeholder="Password" required="">
			    <input  class="input" type="text" name="AssPhone" placeholder="Association Phone Number" required="">
			    <input  class="input" type="text" name="AssAddress" placeholder="Association Address" required="">
			    
    			<input value="Create Account" type="submit" class="login-button" />
    			
			</form>
			<div class="social-account-container">
    			<span class="title">Already you have an Account? <span><a href="SignINAssociation.jsp">Sign In</a></span></span>
    		</div>
    		<span class="agreement"><a href="#">Learn user licence agreement</a></span>
		</div>
		
	</div>
	
	<div>
      <footer>
      <div class="legal">
        <p>
          Copyright &copy;2024 | made with &#10084;<i className='fa fa-heart'></i> by Eman
        </p>
      </div>
      </footer>
    </div>


</body>
</html>