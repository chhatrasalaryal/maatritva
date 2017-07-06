<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                   <li class='dropdown'><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-support"></i>HOME PAGE</a>
					<ul class='dropdown-menu'>
					<li>
					<a href="<%=request.getContextPath()%>/ViewAllCommonpostings?action=get" >VIEW ALL POSTINGS</a></li>
                                      
					</ul>
					</li>
					 <li class='dropdown'><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-support"></i>PROFILE</a>
					<ul class='dropdown-menu'>
					<li>
					<a href="<%=request.getContextPath()%>/UserView?action=get" >VIEW-EDIT</a></li>
					                            
					</ul>
					</li>
                    <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>NEW POST</a>
					<ul class="dropdown-menu">
					<li>
					<a href="<%=request.getContextPath()%>/UsercommonQuestions?action=get" >CREATE QUESTION</a></li>
                                     
					</ul>
					</li>
					 <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>PRIVATE QUESTION</a>
					<ul class="dropdown-menu">
					<li>
					<a href="<%=request.getContextPath()%>/PrivatequestionExpert?action=get" >CREATE QUESTION</a></li>
                                   
					</ul>
					</li>
					 <%--  <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>POST MANAGEMENT</a>
					<ul class="dropdown-menu">
					<li>
					<a href="<%=request.getContextPath()%>/Gyredirect?action=get" >VIEW ALL POST</a></li>
                      <li>
                      
                      <a href="<%=request.getContextPath()%>/ManageGyano?action=get" >EDIT POST</a>
                      </li>  
                       <li>
                      
                      <a href="<%=request.getContextPath()%>/ManageGyano?action=get" >DELETE POST</a>
                      </li>   
                      
                         <li>
                      
                      <a href="<%=request.getContextPath()%>/ManageGyano?action=get" >CHANGE  POST STATUS</a>
                      </li>             
					</ul>
					</li> --%>
                      <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>GYNAECOLOGIST</a>
					<ul class="dropdown-menu">
					<li>
					<a href="<%=request.getContextPath()%>/ViewRateGyano?action=get" >VIEW RATE</a></li>
                                   
					</ul>
					</li>
					
					     <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>FAQ</a>
					<ul class="dropdown-menu">
					<li>
					<a href="<%=request.getContextPath()%>/FAQ?action=get" >VIEW</a></li>
                                    
					</ul>
					</li>
					       <li class="dropdown"><a href="#" class='dropdown-toggle' data-toggle='dropdown'><i class="fa fa-fw fa-home"></i>CHANGE PASSWORD</a>
					<ul class="dropdown-menu">
					<li>
					<a href="<%=request.getContextPath()%>/ChangePassUser?no=1" >CHANGE PASSWORD</a></li>
                                 
					</ul>
					</li>
                 
				
                   
                   
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-users"></i>LOGOUT<i class="icon-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="pllogin.jsp?no=2">SIGNOUT</a></li>
                           
                        </ul>
                    </li>
             
                    
                </ul>
            </div>
</div>
</header><!---->

<footer class="shym-contact">
    
      <div class="container"> 
        
        <!--======= TITTLE PART =========-->
        <div class="tittle">
          <h3 class='shym-text-center'>FREQUENTLY ASKED QUESTIONS</h3>
         
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
       
       
       
       
            <div class="shym-picture-detail-inner" style="width: 1300px;">
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">1. What are the earliest signs to know that I am expecting?</font> </b></h3>
                                <p>Wondering if you are pregnant? A pregnancy test is the way to know for sure. But what if it is too soon for accurate results? You may notice some subtle signs of pregnancy fatigue, nausea, frequent urination, aversions to foods that you normally love, morning sickness, breast swelling and tenderness, and a missed period if you are very regular with menstruation.</p>
                               
                            </div> 
       
       
        
            <div class="shym-picture-detail-inner" style="width: 1300px;"> 
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">2.  How do I calculate my babys due date?</font> </b></h3>
                                <p>Wondering if you are pregnant? A pregnancy test is the way to know for sure. But what if it is too soon for accurate results? You may notice some subtle signs of pregnancy fatigue, nausea, frequent urination, aversions to foods that you normally love, morning sickness, breast swelling and tenderness, and a missed period if you are very regular with menstruation.</p>
                               
                            </div> 
       
        <div class="shym-picture-detail-inner" style="width: 1300px;">
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">3. Is it safe to have sex when pregnant?</font> </b></h3>
                                <p>Typically, sex is perfectly safe in pregnancy right up until delivery. So put aside your fears that intercourse will hurt your baby. The amniotic sac, the uterus, and the mucus plug in the cervix all provide strong protection your baby. However, there some instances where your doctor may tell you to abstain from intercourse altogether while pregnant, such as if you risk premature labor, or if you suffer from placenta previa (the placenta is too close to the cervix), or vaginal bleeding.</p>
                               
                            </div> 
                                <div class="shym-picture-detail-inner" style="width: 1300px;">
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">4. What should I expect from my first prenatal checkup?</font> </b></h3>
                                <p>A lot will happen at your first prenatal visit and it’s best to be ready for a lengthy appointment that will include the following:</p>
<p>a)      A blood and urine test to confirm you are pregnant and estimate your due date</p>
<p>b)      A detailed medical history review</p>
<p>c)       A general physical health exam to examine weight, blood pressure, heart, lung, pelvic, and breast, health</p>
<p>d)      A blood test to check for things like anemia, existing STDs, and antibodies to rule out any genetic disorders (if it’s in your medical history)</p>
<p>e)      A Pap smear and culture to check for vaginal infection and cervical cancer</p>
<p>f)       A urine test to check for infection, as well as measure sugar and protein levels</p>
<p>g)      A discussion about your nutrition and lifestyle, and to answer any questions you might have about your pregnancy</p>

                               
                               
                            </div> 
                            
                            
            <div class="shym-picture-detail-inner" style="width: 1300px;"> 
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">5. How important is it to take prenatal vitamins?</font> </b></h3>
                                <p>Prenatal vitamins are vital in the wake of the increased demands of pregnancy. Growing a new person isn’t easy on your body, and you will require additional vitamins and minerals in your diet like folic acid, calcium, and iron for a healthy pregnancy and a healthy baby. Rather than just selecting a prenatal vitamin yourself, talk to your doctor or midwife about if you need a special formulation (i.e., in cases of anemia or nutritional deficiencies), and if a tablet, capsule, or liquid prenatal vitamin will work most efficiently..</p>
                               
                            </div> 
                            
                                              
            <div class="shym-picture-detail-inner" style="width: 1300px;"> 
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">6. What can I do to prevent this nasty heartburn?</font> </b></h3>
                                <p>Heartburn plagues most expecting women due to a growing uterus and progesterone, a hormone that relaxes muscles (including the stomach valve) to ready the body for pregnancy both allowing acid into the esophagus. However, you can use certain tricks, such as eating smaller and more frequent meals, taking a walk after meals, keeping the head and chest elevated while you sleep, wearing loose clothing, sipping ginger root tea, and taking antacids to alleviate indigestion and gas.</p>
                               
                            </div> 
                            
                                                                
            <div class="shym-picture-detail-inner" style="width: 1300px;"> 
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">7. How can I prevent stretch marks?</font> </b></h3>
                                <p>Approximately 90-percent of pregnant women develop stretch marks as their body grows during pregnancy on the stomach, thighs, buttocks, and breasts. You don’t have to be in the majority! You can do your part to prevent stretch marks by drinking lots of water to keep skin hydrated, by massaging your skin daily with a moisturizer or oil that’s high in vitamin A and vitamin E (i.e., cocoa butter) to prevent stretch marks, and increase circulation and tissue repair; and by consuming a diet that’s rich in skin-supporting vitamins E, C, A, and zinc</p>
                               
                            </div> 
                                                                                    
            <div class="shym-picture-detail-inner" style="width: 1300px;"> 
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">8. Which types of fitness activities are safe for pregnant women?</font> </b></h3>
                                <p>You no longer have to swear off exercise during your pregnancy. There are ways to stay active, fit, and safe while you await the arrival of your little bundle of joy. Unless your doctor advises otherwise, gentle, low impact exercise—such as low gravity swimming, aqua aerobics, walking, jogging (if you did it before your pregnancy), yoga, Pilates, tai chi, and dance are all totally safe. Just steer clear of activities with jumping or shaking movements, or contact sports that pose fall, collision, or injury risks</p>
                               
                            </div> 
                            
                               <div class="shym-picture-detail-inner" style="width: 1300px;"> 
                                <h3><b><font style="font-size: 25px; font-family: cursive; color: #FFFFFF">9. Why is my doctor screening me for gestational diabetes?</font> </b></h3>
                                <p>
Many doctors do routine tests for gestational diabetes for pregnant women who are older than 25 years old, have a family history or ethnicity that is prone to the condition, are obese, have delivered a baby over 9 pounds in weight, or have had a previous instance of gestational diabetes with another pregnancy. The condition affects approximately 10 precent of all pregnancies and is caused by hormonal shifts that lead to glucose intolerance that can affect both mom and baby just while pregnant.
</p>
                               
                            </div> 
       
       
            </div>
          </div>
        </div>
		</div>
      </div>


      
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
                                <h3><a href="#">MAATRITVA theme</a> </h3>
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
                                <h3><a href="#">MAATRITVA theme</a> </h3>
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
                                <h3><a href="#">MAATRITVA theme</a> </h3>
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
                                <h3><a href="#">MAATRITVA theme</a> </h3>
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
	
	
   	





</body>
</html>