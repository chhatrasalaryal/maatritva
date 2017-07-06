<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.util.*" %>
            <%@ page import="com.DAO.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css">
<link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript">


window.datedis = function() {
	if(document.getElementById("custom").checked) {
		
		document.getElementById("message").disabled = false;
	} else {
		
		document.getElementById("message").disabled=true;
	}
}


</script>
<script>
        function validateEmail(emailField)
        {
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

        if (reg.test(emailField.value) == false) 
        {
            alert('Invalid Email Address');
            emailField.value = null;
            return false;
        }

        return true;

}
        </script>
</head>

<body>
<!-- PRELOADER STARTS HERE -->
  <div class="shym-preloader"></div>
  <!-- /PRELOADER ENDS HERE-->
  

  
<!-- HEADER STARTS HERE --> 
 <header class="navbar navbar-inverse navbar-fixed-top heading" role="banner">
<div class="container">
<div class="navbar-header">
<button type="button" class="navbar-toggle togglebutton" data-toggle="collapse" data-target=".navbar-collapse">
<span class="sr-only">Toggle</span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>


</button>


<a class='shym-logo'> <img src='img/bg.png' alt='Shym'/></a>

</div>

 <div class="collapse navbar-collapse menubar">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>ADMIN</a>
					<ul class="dropdown-menu">
					<li>
					<a href="adminlogin.jsp">LOGIN</a></li>
                                           
					</ul>
					</li>
                    <li class='dropdown'><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-support"></i>USER/PREGNANT LADY</a>
					<ul class='dropdown-menu'>
					<li><a href="plregistration.jsp">REGISTRATION</a></li>
					<li><a href="pllogin.jsp">LOGIN</a>
                  
					
					</li>
					</ul>
                   
                   
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-users"></i>EXPERTS<i class="icon-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="experts.jsp">LOGIN</a></li>
                           
                        </ul>
                    </li>
             
                    
                </ul>
            </div>
			
</div>
</header><!---->
<% 
ResultSet rs=AdminDAO.getgynocologist();



%>  
<footer class="shym-contact">
    
      <div class="container"> 
        
        <!--======= TITTLE PART =========-->
        <div class="tittle">
          <h3 class='shym-text-center'>MAATRITVA</h3>
         
        </div>
        
        <!--======= SOCIAL ICONS PART =========-->
        <div class="social_icons">
          <ul>
            <li class="facebook"> <a href="#." data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s"><i class="fa fa-facebook"></i> </a> </li>
            <li class="twitter"> <a href="#." data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s"><i class="fa fa-twitter"></i> </a> </li>
            <li class="dribbble"> <a href="#." data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s"><i class="fa fa-dribbble"></i> </a> </li>
            <li class="googleplus"> <a href="#." data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s"><i class="fa fa-google"></i> </a> </li>
            <li class="linkedin "> <a href="#." data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s"><i class="fa fa-linkedin"></i> </a> </li>
            <li class="pinterest"> <a href="#." data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s"><i class="fa fa-pinterest"></i> </a> </li>
          </ul>
        </div>
        
        <!--======= CONTACT INFO PART =========-->
        <div class="con-info">
          <div class="row">
		  <div class='container'>
          
          
            <div class="col-md-6 col-sm-6"> <i class="ion-flag"></i>
            
            <form action="<%=request.getContextPath()%>/UserRegister" method="post">
              <h4><font style=" font-style: italic;">USER REGISTRATION PAGE</font></h4>
              <div id="contact_form">
                <form id="contact-form" class="contact-form " accept-charset="utf-8" method="post" >
                  <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                          <label>USER ID</label>
                          <input style="color:  #000000;" name="uid" type="text" placeholder="User Id" />
                       
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                       <label>PASSWORD</label>
                          <input style="color:  #000000;" name="pass" type="text" placeholder="Password"/>
                    
                      </div>
                    </div>
                     <div class="col-sm-6">
                      <div class="form-group">
                       <label>NAME</label>
                          <input style="color: #000000;" name="name" type="text" placeholder="Name"/>
                    
                      </div>
                    </div>
                    
                       <div class="col-sm-6">
                      <div class="form-group">
                       <label>AGE</label>
                          <input style="color:  #000000;" name="age" type="text" placeholder="Age"/>
                    
                      </div>
                    </div>
                    
                     <div class="col-sm-6">
                      <div class="form-group">
                       <label>CITY</label>
                          <input style="color:  #000000;" name="city" type="text" placeholder="City"/>
                    
                      </div>
                    </div>
                    
                    <div class="col-sm-6">
                      <div class="form-group">
                       <label>STATE</label>
                          <input style="color:  #000000;" name="state" type="text" placeholder="State"/>
                    
                      </div>
                    </div>
                    
            <div class="col-md-12">
                     <div class="form-group">
                     <label> GYNECOLOGIST       </label>
                    
                    
                    <select style="color:  #000000;" name="gname">
                     <%
                     while(rs.next())
                     {
                    	 %>
                    <option style="color:  #000000;" value="<%=rs.getInt(1) %>"><%=rs.getString(2) %>  </option>
                       
                      <% 
                   }
                     %>
                    </select>
                  
                    </div></div>    
                    
                    
                    
                    
                    
                        
                         
                   
       <div class="col-sm-6">
                      <div class="form-group">               
        <table> 
     
		<tr align="center">
		
		
			
		
	        <td>
	        	<font color="#696969">	SEX</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					
						<input type="radio" name="sex" value="male" checked="checked"/>MALE
								</td>
								
								    <td width="10x"></td>	
								<td>
							
   						<input type="radio" name="sex" value="female"/>FEMALE
				</td>
				
			 <td width="200px"></td>	
	        
						
	
		</tr>
		
		
		
	      
                    
        </table> 
        </div>
        </div>              
                              
       <div class="col-sm-6">
                      <div class="form-group">               
        <table> 
     
		<tr align="center">
		
		
			
	        <td>
	        	<font color="#696969">	PREGNANT?</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					
						<input type="radio" name="pl" value="yes"  id="custom" onclick="datedis()" />YES
								</td>
								
								   <td width="10x"></td>	
								<td>
							
   						<input type="radio" name="pl" value="no" onclick="datedis()" checked="checked"/>NO
				</td>
						
	
		</tr>
		
		
		
	      
                    
        </table> 
        </div>
        </div>           
                     
                    
                    
                    <div class="col-md-12">
                     <div class="form-group">
                      <label> PROBLEM       </label>
                        <textarea style="color: #000000;"  id="message" name="message"  disabled placeholder="Your Problem"></textarea>
               
                     
                      </div>
                    </div>
                    
                    
                  <div class="col-sm-6">
                      <div class="form-group">
                       <label>EMAIL</label>
                          <input  style="color:  #000000;"  id="email" name="email"  name="eamil" type="email" onblur="validateEmail(this);" placeholder="Email"/>
                    
                      </div>
                    </div> 
                    
                       <div class="col-sm-6">
                      <div class="form-group">
                       <label>CELL NO</label>
                          <input  style="color: #000000;" id="cell" name="cell"  type="text"   maxlength="10" placeholder="Cell No"/>
                     <input name="problem" type="submit" value="SUBMIT YOUR DETAILS" />
                      </div>
                    </div> 
                       
                    
                    
                    
                    
                  </div>
                </form>
                <div class="clearfix"></div>
              </div>
              </form>
            </div>
          </div>
        </div>
		</div>
      </div>
    </div>
    <div class="copyrights">
      
  </footer>



 <!--  <section class='gallery'>
  
  
   <div class="home-caption">
               
            </div>
  
  
  
  </section>
  

	
 -->
	
<!--/APPLICATION ENDS HERE-->	
<!--pink satrts here-->	

<!-- <section class='shym-feature'>
<div class='container'>
<div class='row'>





</div>



<div class='row'>






</div>

----------------------------------------------------------------------------------------


<div class='row'>
<div class='col-sm-4  shym-feature-data'>

<div class='col-xs-3 fe-icon'>
<span data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s" ><i class="fa fa-book"></i></span>
</div>

</div>



</div>

----------------------------------------------------------------------------------------
</div>
</section> -->
<!--/FEATURE ENDS HERE -->

<!--SHYM-USER STARTS HERE -->
	
<section class='shym-user'>
<div class='container'>
<div class='shym-user-title' >
        <h3 class='shym-text-center shym-text-uppercase'>Best Pictures</h3>
      
      </div>
      
      <!--======= SLIDER PART =========-->
      <div id="owl-team"> 
        
        <!--======= SLIDER PART =========-->
        <div class="team">
          <div class="img"> <img class="img-responsive" src="img/baby_0.jpg" alt="" >
            <div class="over">
			<i class="fa fa-eye"></i>
              <div class="des"> <a href="#"></a>
                <p>Some people have questions about how pregnancy happens. Some have questions about avoiding a pregnancy. 
              

                  
                 
</p>
              </div>
            </div>
          </div>
       
        </div>
        
        <!--======= SLIDER PART =========-->
        <div class="team">
          <div class="img"> <img class="img-responsive" src="img/baby.jpg" alt="" >
            <div class="over">
			<i class="fa fa-eye"></i>
              <div class="des"> <a href="#"></a>
              
               <p>Others are considering pregnancy and have questions about pre-pregnancy health, or infertility. And some wonder about options for an unintended pregnancy</p>
              </div>
            </div>
          </div>
         
        </div>
        
        <!--======= SLIDER PART =========-->
        <div class="team">
          <div class="img"> <img class="img-responsive" src="img/baby_2.jpg" alt="" >
            <div class="over">
              <i class="fa fa-eye"></i>
              <div class="des"> <a href="#"></a>
               <p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
              </div>
            </div>
          </div>
        
        </div>
        
        <!--======= SLIDER PART=========-->
        <div class="team">
          <div class="img"> <img class="img-responsive" src="img/baby_4.jpg" alt="" >
            <div class="over">
              <i class="fa fa-eye"></i>
              <div class="des"> <a href="#"></a>
                <p>And women who are concerned about pregnancy loss may have lots of questions about miscarriage or ectopic pregnancy </p>
              </div>
            </div>
          </div>
         
        </div>
		
		
        
        <!--======= SLIDER PART =========-->
        <div class="team">
          <div class="img"> <img class="img-responsive" src="img/baby_6.jpg" alt="" >
            <div class="over">
              <i class="fa fa-eye"></i>
              <div class="des"> <a href="#"></a>
              <p>
              Only you can decide what is best for you when it comes to pregnancy. But we are here to help</p>
              </div>
            </div>
          </div>
          
        </div>
		
		<!--======= SLIDER PART =========-->
        <div class="team">
          <div class="img"> <img class="img-responsive" src="img/baby_7.jpg" alt="" >
            <div class="over">
<i class="fa fa-eye"></i>
              <div class="des"> <a href="#"></a>
                <p>
                
                A staff member at your local Planned Parenthood health center can talk with you about all of your pregnancy-related concerns. And we can help you get care that you need
                
                </p>
              </div>
            </div>
          </div>
         
        </div>
		
		
		
		
		
		
		
		
      </div>
</div>
</section>
	<!--/SHYM -USER ENDS HERE -->
<!--PICTURE INFORMATION STARTS HERE-->
<section class='picture-information'>
<div class='container'>
<div class='row'>
<div class='col-md-12 shym-text-center'>
<h3 class='shym-text-uppercase'>MAATRITVA</h3> 
</div>


<div class='gap'>

</div>
<div class='col-md-12 col-sm-12 col-xs-12'>
<div class='col-sm-3 '>
<div class='picture-info' data-scroll-reveal="wait 0.25s, then enter right and move 40px over 1s">
<img src='img/baby_0.jpg'/>
<p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
<div class="shym-overlay">
                            <div class="shym-picture-detail-inner">
                                <h3><a href="#">Maatritva theme</a> </h3>
                                <p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
                               
                            </div> 
                        </div>
						</div>
</div>
<div class='col-sm-3 '>
<div class='picture-info' data-scroll-reveal="wait 0.25s, then enter left and move 40px over 1s">
<img src='img/baby_2.jpg'/>
<p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
<div class="shym-overlay">
                            <div class="shym-picture-detail-inner">
                                <h3><a href="#">Maatritva theme</a> </h3>
                                <p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
                             
                            </div> 
                        </div>
						</div>
</div>
<div class='col-sm-3'>
<div class='picture-info' data-scroll-reveal="wait 0.25s, then enter bottom and move 40px over 1s">
<img src='img/baby_7.jpg'/>
<p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
<div class="shym-overlay">
                            <div class="shym-picture-detail-inner">
                                <h3><a href="#">Maatritva theme</a> </h3>
                                <p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
                              
                            </div> 
                        </div>
						</div>
</div>
<div class='col-sm-3'>
<div class='picture-info' data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s">
<img src='img/baby_6.jpg'/>
<p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
<div class="shym-overlay">
                            <div class="shym-picture-detail-inner">
                                <h3><a href="#">Maatritva theme</a> </h3>
                                <p>Many women need information about pregnancy tests. Pregnant women may also have questions about prenatal care and the stages of pregnancy.</p>
                              
                            </div> 
							</div>
</div>
</div>

</div>

</div>
</div>

</section>



	
  
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/owl.carousel.min.js"></script> 
	<script src="js/scrollReveal.js"></script>
	<script src="js/function.js"></script>
	
	
   	



<%
	int no=StringConversion.Conversion(request.getParameter("no"));
	if(no==1)
	{
		    
%>       
    		<script type="text/javascript">
    			alert('Registration Successfull');
    			</script>
    	 
<%
	}
	
	if(no==2)
	{
		    
%>       
    		<script type="text/javascript">
    			alert('oops error in registration');
    			</script>
    	 
<%
	}
	
	if(no==3)
	{
		    
%>       
    		<script type="text/javascript">
    			alert('This User Already Exists Please register with Differenrt UserId');
    			</script>
    	 
<%
	}
	
	if(no==11)
	{
		    
%>       
    		<script type="text/javascript">
    			alert('Fill all the fields');
    			</script>
    	 
<%
	}
%>



</body>
</html>