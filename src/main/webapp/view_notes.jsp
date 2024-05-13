<%@page import="com.org.dto.Notes"%>
<%@page import="com.org.dao.NotesDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<%@ include file="components/cssStyles.jsp"%>
	<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="components/homeNavbar.jsp"%>
	<% int id =Integer.parseInt( request.getParameter("id"));
		NotesDao dao = new NotesDao();
		Notes notes = dao.fetchNotesById(id);
	
	%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Write Your Notes Here</p>
						
						<form action="add_notes" method="post">
							<div class="mb-3">
								<label class="form-label">Title</label> <input name="title"
									type="text" class="form-control" value="<%=notes.getTitle() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label>
								<textarea rows="10" cols="8" class="form-control"
									name="description"><%=notes.getDescription()%></textarea>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Update
								Notes</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>