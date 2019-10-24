<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FetchBooks">
	<!--<input type="text" name ="srch" placeholder="Search by Name"> 
	<button type="Submit">Search</button> - -->
	<input type="text" name ="newName" placeholder="Add Name"> <br>
	<input type="text" name ="newPrice" placeholder="Add Price"> <br>
	<input type="text" name ="newAuthor" placeholder="Add Author"> <br>
	<input type="text" name ="newReview" placeholder="Add Review"> <br>
	<button type="Submit" name="btn1">Add</button>
	
	</form>
<table>
		<tr>
			<td>Name</td><td>Price</td><td>Author</td>
		</tr>
		<c:forEach var="books" items="${list}">
			<tr>
				<td>${books.name} </td>
				<td>${books.price}</td>
				<td>${books.author}
				<form action="index2.jsp"><button type="Submit"  name="view">View Review</button></form>
				</td>
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>