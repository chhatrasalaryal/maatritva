<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<title>Rating</title>
	<link rel='stylesheet' type='text/css' href='css/rating.css'>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css">
<link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel='stylesheet' type='text/css' href='css/rating.css'>



    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="rating.js"></script>
    <link rel="stylesheet" type="text/css" href="rating.css" />
    
    
    
    
    
    <script type="text/javascript">
        $(function ()
        {
            $('.rating').rating();

            $('.ratingEvent').rating({ rateEnd: function (v) { $('#result').text(v); } });
        });
    </script>
     <style scoped>

        .button-success{
            color: white;
            border-radius: 4px;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
        }

        .button-success {
            background: rgb(28, 184, 65); 
        }
</style>






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
               
 <div class="collapse navbar-collapse menubar">
                <ul class="nav navbar-nav navbar-right">
                  <%--  <li class='dropdown'><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-support"></i>EXPERTS</a>
					<ul class='dropdown-menu'>
					<li>
					<a href="<%=request.getContextPath()%>/Expert?action=get">EXPERT</a></li>
                                      
					</ul>
					</li> --%>
					 <li class='dropdown'><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-support"></i>USERS</a>
					<ul class='dropdown-menu'>
					<li>
					<a href="<%=request.getContextPath()%>/Users?action=get">USERS</a></li>
					                            
					</ul>
					</li>
                    <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>GYNAECOLOGIST/EXPERT</a>
					<ul class="dropdown-menu">
						<li>
					<a href="<%=request.getContextPath()%>/Gyredirect?action=get" >ADD</a></li>
                      <li>
                      
                      <a href="<%=request.getContextPath()%>/ManageGyano?action=get" >EDIT</a>
                      </li> 
                                       
					</ul>
					</li>
                 
					       <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>CHANGE PASSWORD</a>
					<ul class="dropdown-menu">
					<li>
					<a href="<%=request.getContextPath()%>/ChangePass?no=1" >CHANGE PASSWORD</a></li>
                                 
					</ul>
					</li>
                 
				
                   
                   
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-users"></i>LOGOUT<i class="icon-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="adminlogin.jsp?no=2">SIGNOUT</a></li>
                           
                        </ul>
                    </li>
             
                    
                </ul>
            </div>
            </div>
			
</div>
</header><!---->

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
            
           
              <h4><font style=" font-style: italic;">GYNAECOLOGIST CREATION PAGE</font></h4>
              <div id="contact_form">
               <form  action="<%=request.getContextPath()%>/Gynaecologist" method="post" enctype="multipart/form-data">  
             
                <input type="hidden" name="add" value="YES" />
                  <div class="row">
                  
                   <div class="col-sm-6">
                      <div class="form-group">
                          <label>ID</label>
                          <input style="color:  #000000;" name="id" type="text" placeholder="ID"/>
                       
                      </div>
                    </div>
                    
                     <div class="col-sm-6">
                      <div class="form-group">
                          <label>Password</label>
                          <input style="color:  #000000;" name="password" type="text" placeholder="Password"/>
                       
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                          <label>NAME</label>
                          <input style="color:  #000000;" name="name" type="text" placeholder="Name"/>
                       
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
                          <input style="color: #000000;" name="city" type="text" placeholder="State"/>
                    
                      </div>
                    </div>
                    
                     <div class="col-sm-6">
                      <div class="form-group">
                       <label>STATE</label>
                          <input style="color: #000000;" name="state" type="text" placeholder="State"/>
                    
                      </div>
                    </div>
                    
                     
                     
         
                    
                    <div class="col-sm-6">
                      <div class="form-group">
                       <label>EMAIL</label>
                          <input style="color:  #000000;" name="email" type="text"   onblur="validateEmail(this);" placeholder="Email"/>
                    
                      </div>
                    </div>
                    
       
                       <div class="col-sm-6">
                      <div class="form-group">
                       <label>PHONE</label>
                          <input style="color:  #000000;" name="phone" type="text" maxlength="10" placeholder="Phone"/>
                    
                      </div>
                    </div>
                    
       
                    
                    
            
                       <div class="col-sm-6">
                      <div class="form-group">
                       <label>PHOTO</label>
                         <input type="file"  style="color:#0E304A " name="photo" />
                    
                      </div>
                    </div>
                            
                        
                         
                   
       <div class="col-sm-6">
                      <div class="form-group">               
        <table> 
     
		<tr align="center">
		
		
			
		
	        <td>
	        	<font color="#696969">	SEX</font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<select name="sex" style="color: black">
					<option value="male" >Male</option>
					<option value="female">female</option>
					</select>
					
				</td>
				
			 <td width="200px"></td>	
	        
						
	
		</tr>
	
		
						

		
		
	      
                    
        </table> 
        </div>
        </div>              
      <div class="col-md-12">
                     <div class="form-group">
                      <label> Rating      </label>
                        <p>Please rate this Gyanoecalist:</p>
							<fieldset class="rating">		
								<input type="radio" name="stars" id="4_stars" value="4" >
								<label class="stars" for="4_stars">4 stars</label>
								<input type="radio" name="stars" id="3_stars" value="3" >
								<label class="stars" for="3_stars">3 stars</label>
								<input type="radio" name="stars" id="2_stars" value="2" >
								<label class="stars" for="2_stars">2 stars</label>
								<input type="radio" name="stars" id="1_stars" value="1" >
								<label class="stars" for="1_stars">1 star</label>
								<input type="radio" name="stars" id="0_stars" value="0" required>
								<label class="stars" for="0_stars">0 star</label>
								<span  class="label"> Rating: </span>
							</fieldset>
              
                   
						
                      </div>
                    </div>
                    
                    
                    
                    <div class="col-md-12">
                     <div class="form-group">
                      <label> SPECIALIZATION       </label>
                        <textarea style="color: #000000;"  name="spec" placeholder="Your Specialization"></textarea>
                      <input name="action" type="submit" value="Addgyano"/>
                   
						<input type="hidden" name="add" value="YES" />
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
            		alert('GYNAECOLOGIST Details Added Successfully......');
            		
            		</script>
            				
            		<%
            			}
            			
            			if(no==2)
            			{
            		%>
            		
            			<script type="text/javascript">
            		alert('Opps,Something Went Wrong Try Again Latter!!!!!');
            		
            		</script>
            					
            		<%
            			}
            			if(no==3)
            			{
            		%>
            		
            				<script type="text/javascript">
            		alert('Sorry,This GYNAECOLOGIST ID Already Exists !!!!!');
            		
            		</script>
            						
            		<%
            			}
            		%>


</body>
</html>