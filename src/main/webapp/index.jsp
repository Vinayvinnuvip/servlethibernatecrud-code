<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.http.*" %>
<%@page session="false" %>
<html>
<head>
<style type="text/css">button{width=300px;height=200px}</style>
</head>
<body>
<h2>Hello World!</h2>
<%HttpSession session=request.getSession(false);
if(session!=null){
 %>
<a href="register.html"><button>Register</button> </a> <br><br>
<a href="viewall.jsp"><button>ViewAll</button> </a><br><br>
<a href="update.html"><button>Update</button> </a><br><br>
<a href="delete.html"><button>Delete</button> </a><br><br>
<a href="logout"><button>Logout</button> </a><br><br>
<%}else{
	out.println("not a valid user");
	request.getRequestDispatcher("login.html").include(request, response);
} %>
</body>
</html>
