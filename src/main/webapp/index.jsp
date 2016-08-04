<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
        	$('#call').click(function ()
            {
        		/*
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "newOrderHeader.htm", //this is my servlet
                    data: "{\"order_id\":\"1\","+
                    	"\"order_number\":\"1\","+
                    	"\"order_date\":\"2015-12-31\","+
                    	"\"partner_id_seller\":\"1\","+
                    	"\"partner_id_customer\":\"2\","+
                    	"\"seller_name\":\"Koka\","+
                    	"\"customer_name\":\"Kola\","+
                    	"\"session_id\":\"1\","+
                    	"\"total_discount\":\"0\","+
                    	"\"total_value\":\"0\","+
                    	"\"confirmed\":\"0\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("newOrderHeader");  
                    }
                });
        		
        
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "updateOrderHeader.htm", //this is my servlet
                    data: "{\"order_id\":\"3\","+
                    	"\"order_number\":\"1\","+
                    	"\"order_date\":\"2015-12-31\","+
                    	"\"partner_id_seller\":\"1\","+
                    	"\"partner_id_customer\":\"2\","+
                    	"\"seller_name\":\"Koka\","+
                    	"\"customer_name\":\"Kola\","+
                    	"\"session_id\":\"1\","+
                    	"\"total_discount\":\"0\","+
                    	"\"total_value\":\"0\","+
                    	"\"confirmed\":\"0\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("updateOrderHeader");  
                    }
                });
        		
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "closeOrder.htm", //this is my servlet
                    data: "{\"order_id\":\"3\","+
                    	"\"order_number\":\"1\","+
                    	"\"order_date\":\"2015-12-31\","+
                    	"\"partner_id_seller\":\"1\","+
                    	"\"partner_id_customer\":\"2\","+
                    	"\"seller_name\":\"Koka\","+
                    	"\"customer_name\":\"Kola\","+
                    	"\"session_id\":\"1\","+
                    	"\"total_discount\":\"0\","+
                    	"\"total_value\":\"0\","+
                    	"\"confirmed\":\"0\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("closeOrder");  
                    }
                });
        		
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "addOrderDetail.htm", //this is my servlet
                    data: "{\"row_id\":\"1\","+
                    	"\"order_id\":\"1\","+
                    	"\"line_id\":\2\","+
                    	"\"product_id\":\"1\","+
                    	"\"product_name\":\"Koka\","+
                    	"\"quantity\":\"10\","+
                    	"\"units\":\"Dus\","+
                    	"\"discount_value\":\"10\","+
                    	"\"discount_percentage\":\"10\","+
                    	"\"price\":\"100\","+
                    	"\"total_price\":\"1000\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("addOrderDetail");  
                    }
                });
        		
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "updateOrderDetail.htm", //this is my servlet
                    data: "{\"row_id\":\"2\","+
                    	"\"order_id\":\"1\","+
                    	"\"line_id\":\2\","+
                    	"\"product_id\":\"1\","+
                    	"\"product_name\":\"Koka Kola\","+
                    	"\"quantity\":\"100\","+
                    	"\"units\":\"Dus\","+
                    	"\"discount_value\":\"10\","+
                    	"\"discount_percentage\":\"10\","+
                    	"\"price\":\"1000\","+
                    	"\"total_price\":\"1000\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("updateOrderDetail");  
                    }
                });
        		*/
        		
        		/*$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "addProduct.htm", //this is my servlet
                    data: "{\"product_id\":\"1\","+
                    	"\"partner_seller_id\":\"1\","+
                    	"\"product_external_id\":\"1\","+
                    	"\"product_name\":\"Koka Kola\","+
                    	"\"product_description\":\"Enak\","+
                    	"\"product_price\":\"100\","+
                    	"\"product_unit\":\"kg\","+
                    	"\"active\":\"0\","+
                    	"\"how_to_order\":\"how\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("addProduct");  
                    }
                });
        		
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "updateProduct.htm", //this is my servlet
                    data: "{\"product_id\":\"1\","+
                    	"\"partner_seller_id\":\"2\","+
                    	"\"product_external_id\":\"2\","+
                    	"\"product_name\":\"Koka Kola\","+
                    	"\"product_description\":\"EnakWe\","+
                    	"\"product_price\":\"100\","+
                    	"\"product_unit\":\"kg\","+
                    	"\"active\":\"1\","+
                    	"\"how_to_order\":\"how2\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("updateProduct");  
                    }
        		});
        	
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "activateProduct.htm", //this is my servlet
                    data: "{\"product_id\":\"1\","+
                    	"\"partner_seller_id\":\"2\","+
                    	"\"product_external_id\":\"2\","+
                    	"\"product_name\":\"Koka Kola\","+
                    	"\"product_description\":\"EnakWe\","+
                    	"\"product_price\":\"100\","+
                    	"\"product_unit\":\"kg\","+
                    	"\"active\":\"1\","+
                    	"\"how_to_order\":\"how2\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("activateProduct");  
                    }
        		});
        		
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "inactivateProduct.htm", //this is my servlet
                    data: "{\"product_id\":\"1\","+
                    	"\"partner_seller_id\":\"2\","+
                    	"\"product_external_id\":\"2\","+
                    	"\"product_name\":\"Koka Kola\","+
                    	"\"product_description\":\"EnakWe\","+
                    	"\"product_price\":\"100\","+
                    	"\"product_unit\":\"kg\","+
                    	"\"active\":\"0\","+
                    	"\"how_to_order\":\"how2\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("inactivateProduct");  
                    }
        		});
        		*/
        		
        		/*
        		$.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "newQAService.htm", //this is my servlet
                    data: "{\"question_id\":\"1\",\"partner_id\":\"1\",\"question_description\":\"1294101\",\"line_order\":\"1\"}",
                    success: function(msg){      
                        console.log(msg);
                    	console.log("newQAService");  
                    }
                });
                
                $.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "updateQAService.htm", //this is my servlet
                    data: "{\"question_id\":\"2\",\"partner_id\":\"2\",\"question_description\":\"berubah\",\"line_order\":\"2\"}",
                    success: function(msg){      
                    	console.log(msg);
                    	console.log("updateQAService");  
                    }
                });
                
                $.ajax({
                    type: "post",
                    dataType: "json",
                    async: false,
                    url: "deleteQAService.htm", //this is my servlet
                    data: "{\"question_id\":\"7\",\"partner_id\":\"2\",\"question_description\":\"berubah\",\"line_order\":\"2\"}",
                    success: function(msg){      
                    	console.log(msg);
                    	console.log("deleteQAService");  
                    }
                }); */
                
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    async: false,
                    url: "inputcheck.htm", //this is my servlet
                    data: "{\"question_id\":\"7\",\"partner_id\":\"2\",\"question_description\":\"berubah\",\"line_order\":\"2\"}",
                    success: function(msg){      
                    	console.log(msg);
                    	console.log("checkinput");  
                    }
                });
                
            });
        });
    </script>
<title>Being Java Guys | Hello World</title>

</head>
<body>
	
	<center>
		<h2>Being Java Guys | Hello World</h2>
		<h4>
			<a href="asik.htm">Click Here</a>
		</h4>
		<h4>
			<a href="hello2.htm">Click Here</a>
		</h4>
		<input type="button" value="Call Servlet" name="Call Servlet" id="call"/>
	</center>
</body>
</html>