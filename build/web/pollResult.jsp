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
        <script src="resources/js/d3/d3.min.js"></script>
        <script src="http://dimplejs.org/dist/dimple.v1.1.5.min.js"></script>
        <link rel="stylesheet" href="resources/css/ui.dropdownchecklist.css" />
   
          <script src="resources/js/ui.dropdownchecklist.js"></script>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>rect {width:10px;}</style>
        <script>
             
            ///////////
            var pollResult;
                var qtnJSON;
                var ansJSON;
                var pollDetails;
                var pollAns;
                var pid=<%=pid %>;
                //alert("its"+pid);
            $(document).ready(function(){
                $.ajax({
           type: "POST",       
           url: "polls",
           data: { pid:pid, fn:4
               },
           success: function(data)
                                {console.log("Poll Details");
                                    console.log(data);
                                    pollDetails=JSON.parse(data);
                                    qtnJSON=JSON.parse(pollDetails[5]);
                                    ansJSON=JSON.parse(pollDetails[6]);
                                    $.ajax({
                                    type: "POST",       
                                    url: "polls",
                                    data: { pid:pid, fn:3
                                        },
                                    success: function(data)
                                        {
                                            console.log(data);
                                            pollResult=JSON.parse(data);
                                           setData(); 
                                        }
                
                                   
                                         });
                                }
                

                    });
                
            });
            
            function setData()
            {
                console.log("PollDetails=");
                console.log(pollDetails);
                console.log("qtnJSON=");
                console.log(qtnJSON);
                console.log("ansJSON=");
                console.log(ansJSON);
                console.log("pollResult=");
                console.log(pollResult);
                pollAns=new Array();
                for(var i=0; i<pollResult.length; i++)
                {
                    pollAns[i]=JSON.parse(pollResult[i][2]);
                }
                console.log("pollAns=");
                console.log(pollAns);
                $("#pollArea").append("<h2>Title: "+pollDetails[3]+"</h2><h4>Description:"+pollDetails[4]+"</h4>");
                for(var i=0; i<qtnJSON.length; i++)
                {
                    $("#pollArea").append("<h5>Qtn "+ qtnJSON[i][0]+":" + qtnJSON[i][2]);
                    switch(qtnJSON[i][1])
                    {
                        case "mcss":{displayMC(i);}break;
                        case "mcms":{displayMC(i);}break;
                        case "tb":  {displayTB(i);}break;
                        case "moc": {displayMat(i);}break;
                        case "momc":{displayMat(i);}break;
                        
                    }
                    
                }
            }
            
            function displayMC(m)
            {console.log('displayMC() of '+m);
                var options=ansJSON[m][1].split("\n");
                console.log('options');
                console.log(options);
                var count=new Array();
                for(var i=0; i<options.length; i++)
                {
                    count[i]=0;
                }
                for(var i=0; i<pollAns.length; i++)
                {
                    console.log(pollAns[i][m][2][0]);
                    var temp=pollAns[i][m][2][0];
                    console.log("temp"+i+"="+temp);
                    for(var j=0; j<temp.length; j++)
                    {
                        count[parseInt(temp[j])-1]++;
                    }
                }
                
                console.log('count');
                console.log(count);
                console.log(options.length);
                for(var i=0; i<options.length; i++)
                {
                    $("#pollArea").append( options[i]+":" + count[i]+"<br/>");
                }
                drawChart(options,count);
            }
            
            function displayTB(m)
            {
                console.log('displayTB() of '+m);
                var finalTB=new Array();
                for(var i=0; i<pollAns.length; i++)
                {
                   var temp=new Array();
                    temp=pollAns[i][m][2];
                    //console.log("temp"+i+"= "+temp);
                    for(var j=0; j<temp[0].length; j++)
                    {
                        finalTB.push(temp[0][j]);
                    }
                }
                console.log(finalTB);
               var options=new Array();
               var count=new Array();
               for(var i=0; i<finalTB.length; i++)
               {
                   if(options.indexOf(finalTB[i])===-1)
                   {options.push(finalTB[i]);
                       count.push(1);
                   }
                   else
                   {
                       count[options.indexOf(finalTB[i])]++;
                   }
                   
               }
               console.log("options and count");
               console.log(options);
               console.log(count);
               for(var i=0; i<options.length; i++)
                {
                    $("#pollArea").append( options[i]+":" + count[i]+"<br/>");
                }
                drawChart(options,count);
            }
            
            function displayMat(m)
            {console.log('displayMat() of '+m);
                var options=JSON.parse(ansJSON[m][1]);
                console.log('options');
                
                var options2=options;
                console.log(options2);
                for(var x=1; x<options.length; x++)
                    {
                        for(var y=1; y<options[x].length; y++)
                       {
                           if(options[x][y]==="")
                           {
                               options[x][y]="0";
                           }
                       }   
                    }
                for(var i=0; i<pollAns.length; i++)
                {
                   var temp=new Array();
                    temp=pollAns[i][m][2];
                    
                    //console.log("temp"+i+"= "+temp);
                    for(var j=0; j<temp.length; j++)
                    {if(temp[j]!==null)
                        {
                        var temp2=temp[j].split(',');
                        if(options[parseInt(temp2[0])][parseInt(temp2[1])]==="0")
                        {
                            options[parseInt(temp2[0])][parseInt(temp2[1])]="1";
                        }
                        else
                        {var temp3=parseInt(options[parseInt(temp2[0])][parseInt(temp2[1])]);
                            temp3++;
                            options[parseInt(temp2[0])][parseInt(temp2[1])]=temp3.toString();
                        }
                    }
                    }
                    
                }
                console.log(options);
                $("#pollArea").append("<table id='Mat"+m+"'><table>");
                for(var x=0; x<options.length; x++)
                    {var tr="<tr>";
                        for(var y=0; y<options[x].length; y++)
                       {
                           tr=tr+"<td>"+options[x][y]+"</td>";
                       }
                       tr=tr +"</tr>";
                       $("#Mat"+m).append(tr);
                    }
                   
            }
        </script>
    </head>
    <body><h2>Poll Results</h2>
        <div id="pollArea">
            
        </div>
        
    </body>
    <script>
            function drawChart(options, count)
            {
        var svg = dimple.newSvg("#pollArea", 400, 300);
    var data = [];
   // data.push({ "Word":"India", "Awesomeness":3000 });
    for(var i=0; i< options.length; i++)
    {
        data.push({ "Word":options[i], "Awesomeness":count[i] });
    }
    var chart = new dimple.chart(svg, data);
    chart.addCategoryAxis("x", "Word");
    chart.addMeasureAxis("y", "Awesomeness");
    chart.addSeries(null, dimple.plot.bar);
    chart.draw();
            }
            //drawChart();
    </script>
</html>
