<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="Beans.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
  <title>Association Space</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css2?family=Reem+Kufi:wght@400..700&family=Work+Sans:wght@300;500;700;900&display=swap" rel="stylesheet"/> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>

    *{
        margin: 0;
        padding: 0;
        border: none;
        outline: none;
        box-sizing: border-box;
        font-family: "Reem Kufi", sans-serif !important;
    }

    body{
        
        background-color: #f6f6f6;
    }

    h2{
        margin-bottom: 77px;
        padding: 10px;
        color: white;
    }
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
    /* Set gray background color and 100% height */
    .sidenav {
        position: sticky;
        top:0;
        left: 0;
        bottom: 0;
        width: 240px;
        height: 100vh;
        padding: 0 1.7rem;
        overflow: hidden;
        transition: all 0.5s linear;
        background: #1334A9;
    }
       
    .well .header{
        display: flex;
        justify-content: space-between;
        width: 100%;
        transition: left 300ms;
    }

    .search-wrapp{
        border: 1px solid black;
        border-radius: 20px;
        height: 38px;
        display: flex;
        align-items: center;
        overflow-x: hidden;
        border: 1px solid grey;
    }
    .search-wrapp input{
        height: 100%;
        padding: .5rem;
        border: none;
        outline: none;
        padding: 0rem 1.5rem;
        background-color: #f6f6f6;
       
    }

    .search-wrapp input::placeholder{
        color:grey;
    }


    ul li a{
        color: white;
    }

    ul li{
    padding-bottom:0.7rem;
   }

    ul .logout{
        position: absolute;
        bottom: 0;
    }

    
    #h4{
        color:#1334A9;
    }

    .well{
        border: none;
        box-shadow: rgba(0, 0, 0, 0.16) 0px 2px 10px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
    }


    #customers {
    font-family: Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
    }

    #customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
    }

    #customers tr:nth-child(even){background-color: #f2f2f2;}

    #customers tr:hover {background-color: #ddd;}

    #customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #2644b2;
    color: white;
    }
    
    @media only screen and (min-width: 200px) and (max-width: 900px) {
		h2{
			font-size:15px;
		}
		.sidenav {
        	width: 120px;
        	padding: 0 0.9rem;
        }
	}
	
	/* Large devices (laptops/desktops, 992px and up) */
	@media only screen and (min-width: 900px) and (max-width: 1430px) {
		h2{
			font-size:25px;
		}
		.sidenav {
        	width: 190px;
        	padding: 0 0.9rem;
        }
	}

    /* On small screens, set height to 'auto' for the grid */
    @media screen and (max-width: 767px) {
      .row.content {height: auto;} 
    }
    
  </style>
</head>
<body>

<nav class="navbar navbar-inverse visible-xs">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">CasCHariTY</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#home">Home</a></li>
        <li><a href="#donor">Profile</a></li>
        <li><a href="#donor">Collaborations</a></li>
        <li><a href="newCollaboration.jsp">New Collaboration</a></li>
        <li><a href="Home.jsp">Log Out</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid" id="sidebar">
  <div class="row content">
    <div class="col-sm-3 sidenav hidden-xs">
      <h2>CasCHariTY</h2>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="#home">Home</a></li>
        <li><a href="#donor">Profile</a></li>
        <li><a href="#donor">Collaborations</a></li>
        <li><a href="newCollaboration.jsp">New Collaboration</a></li>
        <li class="logout"><a href="Home.jsp">Log Out</a></li>
      </ul><br>
    </div>
    <br>
    
    <div class="col-sm-10" id="home">
      <div class="well well1">
        <div class="header">
            <h4 id="h4">Association Space</h4>
            <div class="search-wrapp well1">
                <input type="search" name="" placeholder="search">
            </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-12">
          <div class="well" id="back1">
            <h4>Collaborations</h4>
            <p><c:out> ${ CollaborationCount }</c:out></p>
          </div>
        </div>
      </div>
      <div class="row" id="donor">
        <div class="col-sm-12">
          <div class="well">
            <h4>Collaborations</h4>
            <table id="customers">
                <tr>
                  <th>Collaboration ID</th>
                  <th>with</th>
                  <th>Topic</th>
                  <th>Description</th>
                  <th>Date</th>
                  <th>Action</th>
                </tr>
                <% 
			        List<Collaboration> list = (List<Collaboration>) request.getAttribute("list");
			        if (list != null) {
			            for (Collaboration collaboration : list) {
			    %>
				    <tr>
				    	<td><%= collaboration.getId() %></td>
				        <td><%= collaboration.getWithCAS() %></td>
				        <td><%= collaboration.getTopic() %></td>
				        <td><%= collaboration.getDescription() %></td>
				        <td><%= collaboration.getDate() %></td>
				        <td><%= collaboration.getAction() %></td>
				    </tr>
			    <% 
			            }
			        }
			    %>
            </table>
          </div>
        </div>
    </div>

    
            
</div>

</body>
</html>