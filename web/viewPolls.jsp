<%-- 
    Document   : viewPolls
    Created on : Apr 1, 2014, 12:44:23 PM
    Author     : abc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Polls</title>
        <link rel="stylesheet" href="resources/css/jquery-ui.css">
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/jquery-ui.js"></script>
        <script>
            $(document).ready(function(){
                
                
                $.ajax({
           type: "POST",       // the dNodeNameefault
           url: "polls",
           data: { fn:2
               },
           success: function(data){
               console.log(data);
               var pollJSON=JSON.parse(data);
               console.log(pollJSON);
                 //alert(data);
                 for(var i=0; i<pollJSON.length;i++)
                     {$("#pollList").append('<div id="pid'+pollJSON[i][0]+'"><h3>'+pollJSON[i][0]+":"+pollJSON[i][3]+'</h3></div>')
                         $("#pid"+pollJSON[i][0]).append('<button onclick="openPoll('+parseInt(pollJSON[i][0])+')">Take Poll</button>');
                         $("#pid"+pollJSON[i][0]).append('<button onclick="pollResult('+parseInt(pollJSON[i][0])+')">Results</button>');
                     }
               
            }
            });
            });
            
           function openPoll(pid)
           {
               $( "#dialog-modal").load( 'solvePoll.jsp', {pid: pid}, function( response, status, xhr ) {
  if ( status == "error" ) {
    var msg = "Sorry but there was an error: ";
    $( "#dialog-modal" ).html( msg + xhr.status + " " + xhr.statusText );
  }
});
           }
           
           function pollResult(pid)
           {//alert(pid);
               $( "#dialog-modal").empty().load( 'pollResult.jsp', {pid: pid}, function( response, status, xhr ) {
  if ( status == "error" ) {
    var msg = "Sorry but there was an error: ";
    $( "#dialog-modal" ).html( msg + xhr.status + " " + xhr.statusText );
  }
});
           }
        </script>
    </head>
    <body>
        <h1>HEllo World!</h1>
        <div id="pollList" style="float:left">
            
        </div>
        <div id="dialog-modal" title="Solve Poll" style="float:right">
  <p>.</p>
</div>
    </body>
</html>
