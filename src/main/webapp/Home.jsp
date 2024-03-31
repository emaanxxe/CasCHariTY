<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="../Styles.css">
   <!--   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  	-->
  	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Reem+Kufi:wght@400..700&family=Work+Sans:wght@300;500;700;900&display=swap" rel="stylesheet"> 
	
	
	
	<style>
    /* Styles for Navbar */
    
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
		
	
	    nav {
	      display: flex;
	      justify-content: space-between;
	      align-items: center;
	      color: #fff;
	      padding: 60px 150px;
	    }
	
	    h1 {
	      /*color:#46cedd;*/
	      color:#1334A9;
	    }
	
	    .navbar-links-container .section {
	      text-decoration: none;
	      margin-right: 28px;
	      font-weight:bold;
	   	  color: black;
		 
	    }
	    .navbar-links-container .section:hover {
	  	  color:#1334A9;
	    }
	    
	
	    .primary-button {
	      text-decoration: none;
	      border: none;
	      padding: 0.5rem 1.75rem;
	      margin-right: 10px;
		  background-color:#1334A9;
		  color:white;
		  outline: none;
		  border-radius: 5rem;
		  font-size: 1.1rem;
		  cursor: pointer;
		  font-weight: 600;
		  transition: 0.3s;
		  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	    }
	    
	    .primary-button:hover {
		  background-color: rgb(234, 234, 234);
		  color:#1334A9;
	}
	
	    .navbar-menu-container {
	      display: none;
	      cursor: pointer;
	    }
	    
	    .home-banner-container {
		  position: relative;
		  display: flex;
		  padding-top: 1.50rem;
		  margin-bottom:200px;
		 
		}
		.home-image-section {
		  max-width: 500px;
		  flex: 0.45;
		  margin-right: 150px;
		}
		.home-text-section {
		  flex: 1;
		  display: flex;
		  flex-direction: column;
		  justify-content: center;
		  align-items: flex-start;
		}
		
		@keyframes growImage {
		  from {
		    transform: scale(0.5); /* L'image commence à 80% de sa taille normale */
		  }
		  to {
		    transform: scale(1); /* L'image atteint sa taille normale */
		  }
		}
		
		.home-image-section {
		  overflow: hidden; /* Pour éviter tout débordement d'image */
		}
		
		.image-home {
		  transform: scale(0.5); /* L'image commence à 80% de sa taille normale */
		  animation: growImage 2s ease forwards; /* Utilisation de l'animation CSS */
		  width: 95%; /* Assurez-vous que l'image remplit son conteneur */
		  height: auto; /* Ajustez la hauteur automatiquement en fonction de la largeur */
		   /* Définit une largeur maximale pour l'image */
		  
	  	  display: block;
		}
		
		.primary-heading {
		  font-size: clamp(2rem, 2.6vw, 2.7rem);
		  color: hsl(0, 0%, 30%);
		  /* line-height: 5rem; */
		  max-width: 650px;
		  margin-left: 170px;
		}
		.primary-text {
		  font-size: clamp(1rem, 1.2vw, 1.5rem);
		  max-width: 570px;
		  color: #6a6a6a;
		  margin: 1.5rem 0rem;
		  margin-left: 170px;
		}
		.secondary-button {
		  padding: 1rem 2.5rem;
		  background-color: #1334A9;
		  outline: none;
		  border: none;
		  border-radius: 5rem;
		  font-size: 1.1rem;
		  cursor: pointer;
		  font-weight: 600;
		  color: white;
		  transition: 0.2s;
		  display: flex;
		  align-items: center;
		  justify-content: center;
		  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
		  text-decoration: none;
		  margin-left: 170px;
		}
		
		.secondary-button:hover {
		  font-size: 1.12rem;
		}
		.link-button {
		  text-decoration: none; /* Supprime la décoration de texte par défaut (comme les soulignements) */
		}
		
		.legal {
			text-align: center;
			padding: 15px 0;
			color: grey;
		}
		.legal p {
		  font-size: 15px;
		}
		
		.modal {
		  width: 80%;
		  box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.1), 0px 90px 50px rgba(0, 0, 0, 0.05), 0px 30px 30px rgba(0, 0, 0, 0.09), 0px 6px 15px rgba(0, 0, 0, 0.1), 0px 0px 0px rgba(0, 0, 0, 0.1);
		  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.12);
		  margin: 5px auto;
		  margin-top:100px;
		  margin-bottom:50px;
		}

		.banner {
		  width: 100%;
		  height: 30px;
		  margin: 0;
		  background-size: 100%;
		  background-repeat: no-repeat;
		}
		
		.title {
		  font-size: 35px;
		  line-height: 21px;
		  text-align: center;
		  margin-bottom: 35px;
		}
		
		.description {
		  max-width: 90%;
		  margin: auto;
		  line-height: 1.5;
		  text-align:center;
		  font-size: clamp(1rem, 1.1vw, 1.2rem);
		  color: #6a6a6a;
		
		}
		.form {
		  display: flex;
		  flex-direction: column;
		  gap: 15px;
		}
		/* Media query for responsive design */
	    @media (max-width: 768px) {
	      .navbar-links-container a {
		    margin-right: 1rem;
		    font-size: 1rem;
	      }
		  .primary-button {
		    font-size: 1rem;
		  }
		  .home-bannerImage-container {
		    max-width: 600px;
		  }
	    }
	    
	    @media (max-width: 1000px) {
		  .navbar-links-container a {
		    margin-right: 1rem;
		    font-size: 1rem;
	      }
		  .primary-button {
		    font-size: 1rem;
		  }
		  .home-bannerImage-container {
		    max-width: 600px;
		  }
		 }
		@media (max-width: 800px) {
		nav {
	      padding: 40px 25px;
	      
	    }
		
	  .nav-logo-container {
	    max-width: 140px;
	  }
	  .navbar-links-container {
	    display: none;
	  }
	  .navbar-menu-container {
	    display: flex;
	  }
	  .home-bannerImage-container {
	    max-width: 450px;
	  }
	  .home-banner-container,
	  .about-section-container {
	    flex-direction: column-reverse;
	    align-items: center;
	    justify-content: center;
	    padding-top: 1rem;
	  }
	  .about-section-container {
	    flex-direction: column;
	  }
	  .home-image-section,
	  .about-section-image-container {
	    width: 100%;
	    max-width: 400px;
	  }
	  .home-image-section {
	  margin-right:0px;
	}
	  .primary-heading {
	    text-align: center;
	    max-width: 90%;
	    margin-left: 0px;
	  }
	  .primary-text {
	    text-align: center;
	    max-width: 80%;
	    margin-left: 0px;
	  }
	  .home-text-section,
	  .about-section-text-container {
	    justify-content: center;
	    align-items: center;
	    margin-top: 4rem;
	  }
	  .secondary-button {
	    font-size: 1rem;
	    padding: 0.8rem 2rem;
	    cursor: pointer;
	    margin-left: 0px;
	  }
	  .about-section-container {
	    margin-top: 5rem !important;
	  }
	  .about-buttons-container {
	    justify-content: center;
	    flex-direction: column;
	  }
	  .primary-subheading {
	    text-align: center;
	  }
	  
	  .about-section-image-container {
	    margin-right: 0rem !important;
	  }
	  
	}
	@media (max-width: 600px) {
	  .home-bannerImage-container,
	  .about-background-image-container {
	    display: none;
	  }
		.home-banner-container,
	  .about-section-container {
	    
	    padding-top: 0.5rem;
	    margin-bottom:100px;
	  }
	  
	  .images {
	  display: flex; /* Changez pour "grid" si vous utilisez une grille */
	  flex-wrap: none; /* Désactivez le wrap */
	  justify-content: center; /* Centre les images horizontalement */
	}
	
	/* Style du conteneur d'image */
	.image {
	  width: 200px; /* Ajustez la largeur selon vos images */
	  margin-bottom: 20px;
	}
	
	/* Style de l'image */
	.image img {
	  width: 100%;
	  height: auto;
	}
	
	/* Style du titre de l'image */
	.image h3 {
	  text-align: center;
	  margin-top: 10px;
	}
}
	
.article {
  position: relative;
  border-radius: 16px;
  transform-origin: center;
  transition: all 0.4s ease-in-out;
  overflow: hidden;
  --title-color: #28666e;
  --link-icon-translate: 0;
  --link-icon-opacity: 1;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
}

article h2 {
  color: black;
  transition: color 0.3s ease-out;
}

figure {
  margin: 0;
  padding: 0;
  aspect-ratio: 16 / 9;
  overflow: hidden;
}

article img {
  max-width: 100%;
  transform-origin: center;
  transform: scale(var(--img-scale));
  transition: transform 0.4s ease-in-out;
}

.article-body {
  padding: 24px;
}


.articles {
  display: grid;
  max-width: 1250px;
  margin-inline: auto;
  padding-inline: 24px;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  gap: 27px;
  margin-bottom:25px;
}

@media screen and (max-width: 960px) {
  article ,.Cont {
    container: card/inline-size;
  }
  
}

@container card (min-width: 380px) {
  .article-wrapper {
    display: grid;
    grid-template-columns: 100px 1fr;
    gap: 16px;
  }
  .article-body {
    padding-left: 0;
  }
  figure {
    width: 100%;
    height: 100%;
    overflow: hidden;
  }
  figure img {
    height: 140%;
    aspect-ratio: 1;
    object-fit: cover;
  }
  
  .articles2 {
  	grid-template-columns: repeat(1, minmax(320px, 1fr));
}
}

.sr-only:not(:focus):not(:active) {
  clip: rect(0 0 0 0); 
  clip-path: inset(50%);
  height: 1px;
  overflow: hidden;
  position: absolute;
  white-space: nowrap; 
  width: 1px;
}

.article-body .c ,.article-body .citation{
  flex: 1;
  padding: 15px;
  color:black;
  font-weight: bold;
}

.article-body span{
  flex: 1;
  padding: 15px;
  color:grey;
  font-weight: normal;
}
	
.social-icons li, .address-links li {
  list-style: none;
  margin-bottom: 5px;
}

.social-icons a {
  color: inherit;
  text-decoration: none;
}

.social-icons a:hover{
  color:black;
}

.Cont {
  position: relative;
  border-radius: 16px;
  transform-origin: center;
  transition: all 0.4s ease-in-out;
  overflow: hidden;
  --title-color: #28666e;
  --link-icon-translate: 0;
  --link-icon-opacity: 1;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 2px 10px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
}

.articles2 {
  display: grid;
  max-width: 1200px;
  margin-inline: auto;
  padding-inline: 24px;
  grid-template-columns: repeat(1, minmax(320px, 1fr));
  gap: 27px;
  margin-bottom:25px;
}

  </style>
  
</head>


<body>

  <nav id="home">
      <h1>CasCHariTY</h1>
    
    <div class="navbar-links-container">
      <a class="section" href="#home">Home</a>
      <a href="SignINAdmin.jsp" class="section">Admin</a>
      <a class="section" href="#about">About us</a>
      <a class="section" href="#activities">Our activities</a>
      <a class="section" href="#contact">Contact us</a>
      <a href="You.jsp" class="primary-button">Sign Up</a>
    </div>
    
    
    <div class="navbar-menu-container">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24" fill="#1334A9">
        <path fill="none" d="M0 0h24v24H0V0z"/>
        <path d="M4 18h16c.55 0 1-.45 1-1s-.45-1-1-1H4c-.55 0-1 .45-1 1s.45 1 1 1zm0-5h16c.55 0 1-.45 1-1s-.45-1-1-1H4c-.55 0-1 .45-1 1s.45 1 1 1zM3 7c0 .55.45 1 1 1h16c.55 0 1-.45 1-1s-.45-1-1-1H4c-.55 0-1 .45-1 1z"/>
      
      </svg>
      
      
    
    </div>
  </nav>
  
  <div class="home-banner-container">
    <div class="home-text-section">
      <h1 class="primary-heading">
        CAS Giving Portal: Building a Better Tomorrow, Together
      </h1>
      <p class="primary-text">
        Where Generosity Meets Purpose, Where Contributions Spark Progress, and Where Together, We Forge a Future of Impact and Hope.
      </p>
      <br>
      <a href="You.jsp" class="link-button"><button class="secondary-button"><pre>Donate now    &rarr;</pre><i class="fi-arrow-right"></i></button></a>
    </div>
    <div class="home-image-section">
      <img src="images/backk2.png" alt="" class="image-home">
    </div>
  </div>
  
  <div class="modal" id="about">
            <div class="form">
                <div class="banner"></div>
                <h1 class="title">CAS</h1>
    
                <div class="description">
                    <p>
                    
                    
                    
                    Founded by a group of dynamic young volunteers from the National Institute of Posts and Telecommunications (INPT), CAS stands out for its non-profit humanitarian mission. With a commitment to national development and solidarity, CAS strives to address the challenges and urgent needs of the most vulnerable populations in Morocco.

CAS members dedicate their energy, time, and skills to assist those most in need and engage in concrete actions to improve the living conditions of marginalized individuals and disadvantaged regions.

At the core of its initiatives, CAS promotes fundamental values such as solidarity, social inclusion, and sustainable development. Through innovative projects and targeted intervention programs, the organization aims to create a positive and lasting impact on disadvantaged regions.

<br><br><br>

CAS embodies the hope for significant social change and the promise of a better future for future generations.
                    
                    
                    
                    
                    
                    </p>
							                    <br></br><br>
                   
                </div>
            </div>
        </div>
  
  
  
  <div id="activities">
            <div class="form">
                <div class="banner"></div>
                <h1 class="title">Some Of Our Activities</h1>
    
              	<div class="description">
                	<section class="articles">
						  <article class="article">
						    <div class="article-wrapper">
						      <figure>
						        <img src="images/Act1.jpg" alt="N9raw Jmi3 image" />
						      </figure>
						      <div class="article-body">
						        <p>N9raw Jmi3</p>						       
						      </div>
						    </div>

				  		</article>
				  		
				  		<article class="article">
						    <div class="article-wrapper">
						      <figure>
						        <img src="images/Act2.jpg" alt="" />
						      </figure>
						      <div class="article-body">
						        <p>Caravane AL IHSSANE</p>
						        
						      </div>
						    </div>  
				  		</article>
				  		
				  		<article class="article">
						    <div class="article-wrapper">
						      <figure>
						        <img src="images/Act3.jpg" alt="" />
						      </figure>
						      <div class="article-body">
						        <p>Don du Sang</p>
						     
						      </div>
						    </div>  
				  		</article>
				  		
				  		<article class="article">
						    <div class="article-wrapper">
						      <figure>
						        <img src="images/Act4.jpg" alt="" />
						      </figure>
						      <div class="article-body">
						        <p>Cours de Soutien</p>
						      
						      </div>
						    </div>  
				  		</article>
				  		
				  		<article class="article">
						    <div class="article-wrapper">
						      <figure>
						        <img src="images/Act-5.jpg" alt="" />
						      </figure>
						      <div class="article-body">
						        <p>Activités Orphelins</p>
						   
						      </div>
						    </div>  
				  		</article>
				  		
				  			
				  		<article class="article">
						    <div class="article-wrapper">
						      <figure>
						        <img src="images/Act6.png" alt="" />
						      </figure>
						      <div class="article-body">
						        <p>Action de l’AID</p>
						       
						      </div>
						    </div>  
				  		</article>
				  		
				  		
				</section>   
				                   	       
                   	                  
             </div>
                
                
                
            </div>
        </div>
        
        
     <div class="modal" id="contact">
            <div class="form">
                <div class="banner"></div>
                <h1 class="title">Contact us</h1>
    
                <div class="description">
                
                	<section class="articles2">
						  <article class="Cont">
						    <div class="article-wrapper">
						      <div class="article-body">
						      	<p class="citation">"The best way to find yourself is to lose yourself in the service of others." <span> -Dalai Lama</span></p>
						     
						      </div>
						    </div>

				  		</article>
				  		
				  		<article class="Cont">
						    <div class="article-wrapper">
						      <div class="article-body">
						        <p class="c">Follow Us</p>
						        
						        <div class="social-icons">
									<li><a href=""> Facebook</a></li>
									<li><a href=""> Instagram</a></li>
									<li><a href=""> Linkedin</a></li>
								</div>
						
						        
						      </div>
						    </div>  
				  		</article>
				  		
				  		<article class="Cont">
						    <div class="article-wrapper">
						      <div class="article-body">
						        <p class="c">Addresse</p>
						        
						        <div class="address-links">
								<li class="address1"><pre>Avenue Allal Al Fassi
Madinat Al Irfane,INPT- Rabat.</pre></li>
								   <li> +212 612-450171 </li>
								   <li> mail@1234567.com</li>
							</div>
						</div>
					</div>
                  
				  		</article>
				  		
				  		
				  		<article class="Cont">
						    <div class="article-wrapper">
						      <div class="article-body">
						        <p class="c">Our RIB To donate</p>
						        
						        <p><pre>
Bank : CIH BANK
RIB CIH Bank : 5192494211005100

RIB from another bank :
230810519249421100510060</pre></p>
							</div>
						</div>
					
				  		</article>
				   </section>
                <br>
                
                </div>
              
         
            </div>
        </div>
  
  
  
      <footer>
      <div class="legal">
        <p>
          Copyright &copy;2024 | made with &#10084;<i className='fa fa-heart'></i> by Eman
        </p>
      </div>
      </footer>
      
      
  
</body>
</html>