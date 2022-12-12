
<html>
  <head>
     <title>Validation Page</title>
     <link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet">
     
     <style>
      .validation-form{
           width: 500px;
           height: 260px;
           position: absolute;
           background-color: #5B5EA6;
           border-radius: 20px;
           top: 50%;
           left: 50%;
           margin-right: -50%; transform: translate(-50%, -50%)
          
      }
     
     </style>
   </head>
   <body>
     	
     <div class="validation-form">
     <c:if test="${not empty errorMsg}">
     		<div class="alert alert-danger" role="alert">${errorMsg}</div>
     </c:if>
       <div class="container-fluid">
         <form method="post">
            <input type = "text" name = "userName" class="form-control mt-3" placeholder="User Name">
           <input type = "text" name = "phoneNumber" class="form-control mt-3"placeholder="Phone Number">
          <button class="btn btn-dark btn-block mt-3">Submit</button>
         </form>
        </div>
     </div>
  </body>
</html>