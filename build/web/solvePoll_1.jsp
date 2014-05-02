<%-- 
    Document   : solvePoll
    Created on : Apr 1, 2014, 3:44:20 PM
    Author     : abc
--%>
<% 
int pid=Integer.parseInt(request.getParameter("pid"));

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <!-- -->
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/jquery-ui.js"></script>
        <link rel="stylesheet" href="resources/css/jquery-ui.css" />
        <script src="resources/js/ui.core.js"></script>
        
        
        <link rel="stylesheet" href="resources/css/ui.dropdownchecklist.css" />
        -->
          <script src="resources/js/ui.dropdownchecklist.js"></script>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            $(document).ready(function(){
                
                
                $.ajax({
           type: "POST",       // the dNodeNameefault
           url: "solvePoll",
           data: { pid:<%=pid %>
               },
           success: function(data){
               console.log(data);
               var pollJSON=JSON.parse(data);
               console.log(pollJSON);
               var qtnJSON=JSON.parse(pollJSON[5]);
               var ansJSON=JSON.parse(pollJSON[6]);
                 //alert(data);
                 
              $("#pollArea").append('<h1>'+pollJSON[3]+'</h1><h2>'+pollJSON[4]+'</h2>');
                  for(var i=0; i<qtnJSON.length; i++)
                  {
                      $("#pollArea").append("<p>Qtn "+qtnJSON[i][0]+":"+qtnJSON[i][2]+"</p>");
                      switch(qtnJSON[i][1])
                      {
                          case "mcss":{
                                        var answers=ansJSON[i][1].split("\n");
                                        for (var j=0; j<answers.length;j++)
                                            {
                                                $("#pollArea").append('<input type="radio" name="qtn'+(i+1)+'" value="'+(j+1)+'"/>'+answers[j]+'<br/>');
                                            }
                                      }break;
                          case "mcms":{//console.log(ansJSON[i][1]);
                                        var answers=ansJSON[i][1].split("\n");
                                       
                                        $("#pollArea").append('<select multiple id="qtn'+(i+1)+'" name="qtn'+(i+1)+'"></select>');
                                        for (var j=0; j<answers.length;j++)
                                            {//console.log(answers[j]);
                                                $("#qtn"+(i+1)).append('<option value="'+(j+1)+'">'+answers[j]+'</option>');
                                                //$("#qtn"+(i+1)).append('<option>Hello</option>');
                                                
                                            }
                                            //$("#pollArea").append('</select>');
                                            $("#qtn"+(i+1)).dropdownchecklist({maxDropHeight:120,width:100,emptyText: "select"});
                                            
                                      }break;
                           case "tb":{
                                       //console.log(ansJSON[i]);
                                       $("#pollArea").append('Enter your answer here. If you have multiple answers then separete them with enter<br/><textarea id="qtn'+(i+1)+'" name="qtn'+(i+1)+'"></textarea>');
                                      }break;
                            case "moc":{
                                       var columns=ansJSON[i][1].split("\n");
                                       var rows=ansJSON[i][2].split("\n");
                                       console.log(columns);
                                       console.log(rows);
                                       var matrix=createMatrix(columns, rows);
                                      
                                           console.log("matrix");
                                           console.log(matrix);
                                           $("#pollArea").append('<table id="moc'+(i+1)+'"></table>');
                                           for(var k=0; k<=rows.length;k++)
                                           {$("#moc"+(i+1)).append('<tr id="moctr'+k+'"></tr>')
                                               for(var j=0; j<=columns.length;j++)
                                           {    if(matrix[k][j]===k +"%"+j)
                                                   {
                                                       $("#moctr"+k).append("<td><center><input type='radio' name='qtn"+(i+1)+"%row"+k+"' value='"+k+"%"+j+"'/></center></td>");
                                                   }
                                                   else
                                                       {
                                                        $("#moctr"+k).append("<td><center>"+matrix[k][j]+"</center></td>");
                                                       }
                                           }
                                           }
                                       //$("#pollArea").append('Enter your answer here. If you have multiple answers then separete them with enter<br/><textarea id="qtn'+(i+1)+'" name="qtn'+(i+1)+'"></textarea>');
                                      }break;
                          
                    case "momc":{
                                     var columns=ansJSON[i][1].split("\n");
                                       var rows=ansJSON[i][2].split("\n");
                                       var matrix=createMatrix(columns, rows);
                                       console.log(columns);
                                       console.log(rows);
                                       
                                       
                                           console.log("matrix");
                                           console.log(matrix);
                                           $("#pollArea").append('<table id="momc'+(i+1)+'"></table>');
                                           for(var k=0; k<=rows.length;k++)
                                           {$("#momc"+(i+1)).append('<tr id="momctr'+k+'"></tr>')
                                               for(var j=0; j<=columns.length;j++)
                                           {    if(matrix[k][j]===k +"%"+j)
                                                   {
                                                       $("#momctr"+k).append("<td><center><input type='checkbox' name='qtn"+(i+1)+"%row"+k+"' value='"+k+"%"+j+"'/></center></td>");
                                                   }
                                                   else
                                                       {
                                                        $("#momctr"+k).append("<td><center>"+matrix[k][j]+"</center></td>");
                                                       }
                                           }
                                           }
                                       //$("#pollArea").append('Enter your answer here. If you have multiple answers then separete them with enter<br/><textarea id="qtn'+(i+1)+'" name="qtn'+(i+1)+'"></textarea>');
                                      }break;
                              
                      }
                  }
               
            }
            
            
            });
            });
            function createMatrix( columns, rows)
            {
                var matrix=new Array(rows.length+1);
                                       for(var m=0; m<=columns.length;m++)
                                           {
                                               matrix[m]=new Array(columns.length+1);
                                           }
                                        for(var m=0; m<=rows.length;m++)
                                           {
                                               for(var j=0; j<=columns.length;j++)
                                           {
                                               if(m==0 && j==0)
                                                    {
                                                        matrix[m][j]="rows\columns";
                                                    }
                                               else if(m==0)
                                                    {
                                                        matrix[m][j]=columns[j-1];
                                                    }
                                               else if(j===0)
                                                    {
                                                        matrix[m][j]=rows[m-1];
                                                    }
                                                else
                                                    {
                                                        matrix[m][j]=m +"%"+j;
                                                    }
                                                   
                                                       
                                           }
                                           }
                                           return matrix;
            }
        </script>
    </head>
    <body>
        <div id="pollArea">
            
        </div>
    </body>
</html>
