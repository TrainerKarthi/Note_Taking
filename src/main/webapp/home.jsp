<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.Notes"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/cssStyles.jsp"%>
</head>
<body>

	<%@ include file="components/homeNavbar.jsp"%>
	<h1 class="text-center">Welcome to Home</h1>
	<%
	String str = (String) session.getAttribute("success");
	if (str != null) {
	%>
	<p class="text-center text-success fs-4"><%=str%></p>
	<%
	session.removeAttribute("success");
	%>
	<%
	}
	%>
	<%
	int id = (Integer) session.getAttribute("userId");
	UserDao dao = new UserDao();
	User user = dao.fetchUserById(id);
	List<Notes> list = user.getNoteses();
	System.out.println("Hello");
	System.out.println(list);
	%>
	<div class="container border border-primary">
		<div>
			<a class="btn btn-primary" href="addNotes.jsp">Add Notes</a>
		</div>
		<div class="row">
		<%
		for (Notes n : list) {
			System.out.println("notes -->"+n);
		%>
		<div class="card border col-md-4 m-3" style="width: 18rem" >
			<div class="card-body">
				<div class="d-flex flex-wrap justify-content-evenly">
					<div class="">
						<h2 class="text-success card-title"><%=n.getTitle()%></h2>
						<a href="view_notes.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-info">view</a>
						<a href="view_notes.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-primary">Update</a>
						<a href="deleteNotes.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-danger">Delete</a>
						<%-- <h3 class="card-text"><%=n.getDescription()%></h3> --%>
					</div>
				</div>
			</div>
		</div>
		<%
		}
		%>
		</div>
	</div>

</body>
</html>