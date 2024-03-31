<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Sign In</title>
	<link rel="stylesheet" type="text/css" href="../Styles.css">
  	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Reem+Kufi:wght@400..700&family=Work+Sans:wght@300;500;700;900&display=swap" rel="stylesheet"> 

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
		  margin: 130px auto;
		  
		  box-shadow: 0px 187px 75px rgba(0, 0, 0, 0.01), 0px 105px 63px rgba(0, 0, 0, 0.05), 0px 47px 47px rgba(0, 0, 0, 0.09), 0px 12px 26px rgba(0, 0, 0, 0.1), 0px 0px 0px rgba(0, 0, 0, 0.1);
		}

		.heading {
		  text-align: center;
		  font-weight: 900;
		  font-size: 25px;
		  /*color: #3EC9F5;*/
		  color: #1334A9;
		  margin-bottom:65px;
		  margin-top:40px;
		}
		
		.form {
		  margin-top: 15px;
		}
		
		
		.agreement {
		  display: block;
		  text-align: center;
		  margin-top: 40px;
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
		  margin-top:15px;
		}
		.legal p {
		  font-size: 15px;
		}
		
		.primary-button {
	      text-decoration: none;
	      border: none;
	      padding: 0.9rem 1.75rem;
		  background-color:#3EC9F5;
		  color:white;
		  outline: none;
		  border-radius: 5rem;
		  font-size: 1.1rem;
		  cursor: pointer;
		  font-weight: 600;
		  text-align:center;
		  display: block;
		  width: 90%;
		  font-weight: bold;
		  background: linear-gradient(
		    45deg,
		    rgb(16, 137, 211) 0%,
		    #1334A9 100%
		  );
		  
		  padding-block: 18px;
		  margin: 20px auto;
		  border-radius: 20px;
		  box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 20px 10px -15px;

		  transition: all 0.2s ease-in-out;
		  
	    }
	    
			
	</style>
</head>

<body>
	
	<div class="container">
    		<div class="heading">Welcome to your space!</div>
			<form class="form" action="You" method="post">
      			<a href="SignUPDonateur.jsp" class="primary-button">Donor Space</a>
      			<a href="SignUPAssociation.jsp" class="primary-button">Association Space</a>
    			
			</form>
			
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