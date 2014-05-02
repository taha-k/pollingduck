package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createPoll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>form</title>\r\n");
      out.write(" \r\n");
      out.write("<script src=\"resources/js/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>create poll</h1>\r\n");
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("var detailArray=new Array();\r\n");
      out.write("var qtnArray= new Array();\r\n");
      out.write("var ansArray= new Array();\r\n");
      out.write("var count=0;\r\n");
      out.write("var uid=2;\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("  });\r\n");
      out.write("  \r\n");
      out.write("  function addQuestion()\r\n");
      out.write("    {\r\n");
      out.write("        $(\"#addQuestion\").prop(\"disabled\", true);\r\n");
      out.write("        $(\"#d3\").append('Question: <input type=\"text\" name=\"question\" id=\"question\"/><br/>Question Type: <select id=\"Qtype\" onchange=\"createQtn()\"><option>Select One</option><option value=\"mcss\">Multiple choice Single select</option><option value=\"mcms\">Multiple choice Multiple select</option><option value=\"tb\">Textbox</option><option value=\"moc\">Matrix of choices</option><option value=\"momc\">Matrix of Multiple choices</option></select>');\r\n");
      out.write("    }\r\n");
      out.write("    function createQtn()\r\n");
      out.write("    {\r\n");
      out.write("        var qtype=$('#Qtype').val();\r\n");
      out.write("        alert(qtype);\r\n");
      out.write("        //$(\"#d3\").empty();\r\n");
      out.write("        switch(qtype)\r\n");
      out.write("        {\r\n");
      out.write("            case 'mcss': {$(\"#d3\").append('Answer choices:<textarea id=\"answers\" ></textarea>');}break;\r\n");
      out.write("            case 'mcms': {$(\"#d3\").append('Answer choices:<textarea id=\"answers\" ></textarea>');}break;\r\n");
      out.write("            case 'tb': {$(\"#d3\").append('A textbox will be created for the user to fill in the answer <input type=\"hidden\" id=\"answers\"/>');}break;\r\n");
      out.write("            case 'moc': {$(\"#d3\").append('Enter columns and rows <textarea id=\"columns\" ></textarea><textarea id=\"rows\" ></textarea>');}break;\r\n");
      out.write("            case 'momc': {$(\"#d3\").append('Enter columns and rows <textarea id=\"columns\" ></textarea><textarea id=\"rows\" ></textarea>');}break;\r\n");
      out.write("        }\r\n");
      out.write("        $(\"#d3\").append('<button onclick=\"submitQtn()\">Submit Question</button>');\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    function submitQtn()\r\n");
      out.write("    {\r\n");
      out.write("        var question=$('#question').val();\r\n");
      out.write("        var qtype=$('#Qtype').val();\r\n");
      out.write("        qtnArray[count]=new Array(3);\r\n");
      out.write("        qtnArray[count][0]=count+1;\r\n");
      out.write("        qtnArray[count][1]=qtype;\r\n");
      out.write("        qtnArray[count][2]=question;\r\n");
      out.write("        \r\n");
      out.write("        if(qtype===\"moc\" || qtype===\"momc\")\r\n");
      out.write("        {ansArray[count]=new Array(3);\r\n");
      out.write("            var columns=$('#columns').val();\r\n");
      out.write("            var rows=$('#rows').val();\r\n");
      out.write("            ansArray[count][0]=count+1;\r\n");
      out.write("            ansArray[count][1]=columns;\r\n");
      out.write("        ansArray[count][2]=rows; \r\n");
      out.write("        $(\"#d2\").append(\"Question:\"+question+\"<br/>Type: \"+qtype+\"<br>Columns: \"+columns+\"<br>rows:\"+rows);\r\n");
      out.write("        }\r\n");
      out.write("        else\r\n");
      out.write("        {\r\n");
      out.write("        var answers=$('#answers').val();\r\n");
      out.write("        ansArray[count]=new Array(3);\r\n");
      out.write("        ansArray[count][0]=count+1;\r\n");
      out.write("        ansArray[count][1]=answers;\r\n");
      out.write("        \r\n");
      out.write("        $(\"#d2\").append(\"Question:\"+question+\"<br/>Type: \"+qtype+\"<br>Options:\"+answers);\r\n");
      out.write("        }\r\n");
      out.write("        $(\"#d3\").empty();\r\n");
      out.write("        var json=JSON.stringify(ansArray);\r\n");
      out.write("        console.log(json);\r\n");
      out.write("        count++;\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        $(\"#addQuestion\").prop(\"disabled\", false);\r\n");
      out.write("        \r\n");
      out.write("            \r\n");
      out.write("    }\r\n");
      out.write("    function send()\r\n");
      out.write("    {\r\n");
      out.write("        detailArray[0]=uid;\r\n");
      out.write("        detailArray[1]=$(\"#title\").val();\r\n");
      out.write("        detailArray[2]=$(\"#desc\").val();\r\n");
      out.write("        detailArray[3]=$(\"#category\").val();\r\n");
      out.write("        detailArray[4]=count;\r\n");
      out.write("        var detailJSON=JSON.stringify(detailArray);\r\n");
      out.write("        var qtnJSON=JSON.stringify(qtnArray);\r\n");
      out.write("        var ansJSON=JSON.stringify(ansArray);\r\n");
      out.write("        console.log(detailJSON);\r\n");
      out.write("        console.log(qtnArray);\r\n");
      out.write("        console.log(ansArray);\r\n");
      out.write("       $.ajax({\r\n");
      out.write("           type: \"POST\",       // the dNodeNameefault\r\n");
      out.write("           url: \"polls?fn=1\",\r\n");
      out.write("           data: { detailJSON:detailJSON, qtnJSON:qtnJSON,ansJSON:ansJSON},\r\n");
      out.write("           success: function(data){\r\n");
      out.write("               console.log(data);\r\n");
      out.write("               if (data)\r\n");
      out.write("               {  alert('successful');\r\n");
      out.write("               }   \r\n");
      out.write("               else \r\n");
      out.write("               {alert('unsuccesful');\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<div id='d1'>\r\n");
      out.write(" Title:<input type=\"text\" name=\"t1\" id=\"title\"><br/> \r\n");
      out.write(" Description:<textarea name=\"t1\" id=\"desc\"></textarea><br/> \r\n");
      out.write("</div>\r\n");
      out.write("Category:<select id=\"category\"><option value=\"1\">Java</option><option value=\"2\">Java</option><option value=\"3\">Java</option></select>\r\n");
      out.write("\r\n");
      out.write("<div id='d2'>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div id='d3'>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div id='d1'>\r\n");
      out.write("    <button onclick=\"addQuestion()\" id=\"addQuestion\">Add Question</button>\r\n");
      out.write("    \r\n");
      out.write("    <input type='button'onclick=\"send()\" value='Submit Survey' id='Submit'>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
