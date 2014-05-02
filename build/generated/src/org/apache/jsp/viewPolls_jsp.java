package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewPolls_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View Polls</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"resources/css/jquery-ui.css\">\n");
      out.write("  <script src=\"resources/js/jquery.min.js\"></script>\n");
      out.write("  <script src=\"resources/js/jquery-ui.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                $.ajax({\n");
      out.write("           type: \"POST\",       // the dNodeNameefault\n");
      out.write("           url: \"polls?fn=2\",\n");
      out.write("           data: { //detailJSON:detailJSON, qtnJSON:qtnJSON,ansJSON:ansJSON\n");
      out.write("               },\n");
      out.write("           success: function(data){\n");
      out.write("               console.log(data);\n");
      out.write("               var pollJSON=JSON.parse(data);\n");
      out.write("               console.log(pollJSON);\n");
      out.write("                 //alert(data);\n");
      out.write("                 for(var i=0; i<pollJSON.length;i++)\n");
      out.write("                     {\n");
      out.write("                         $(\"#pollList\").append('<p onclick=\"openPoll('+parseInt(pollJSON[i][0])+')\">'+pollJSON[i][3]+'</p>');\n");
      out.write("                     }\n");
      out.write("               \n");
      out.write("            }\n");
      out.write("            });\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("           function openPoll(pid)\n");
      out.write("           {\n");
      out.write("               $( \"#dialog-modal\").load( 'solvePoll.jsp', {pid: pid}, function( response, status, xhr ) {\n");
      out.write("  if ( status == \"error\" ) {\n");
      out.write("    var msg = \"Sorry but there was an error: \";\n");
      out.write("    $( \"#dialog-modal\" ).html( msg + xhr.status + \" \" + xhr.statusText );\n");
      out.write("  }\n");
      out.write("});\n");
      out.write("               /*$( \"#dialog-modal\" ).dialog({\n");
      out.write("                   resizable: false,\n");
      out.write("                 position: { my: \"center\", at: \"center\" },\n");
      out.write("                height: 'auto',\n");
      out.write("                width:400,\n");
      out.write("                 modal: true,\n");
      out.write("                 buttons: {\n");
      out.write("        Close: function() {\n");
      out.write("          $( this ).dialog( \"close\" );\n");
      out.write("        }}\n");
      out.write("    });*/\n");
      out.write("           }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>HEllo World!</h1>\n");
      out.write("        <div id=\"pollList\" style=\"float:left\">\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <div id=\"dialog-modal\" title=\"Solve Poll\" style=\"float:right\">\n");
      out.write("  <p>Adding the modal overlay screen makes the dialog look more prominent because it dims out the page content.</p>\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
