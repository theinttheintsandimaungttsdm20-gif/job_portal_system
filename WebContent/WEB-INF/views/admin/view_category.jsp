<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
   <table border="1" width="50%" >
        <thead>
          <tr>
			<th>No</th>
			<th>Job Title</th>
			<th>Delete Job Category</th>
		  </tr>
        </thead>
                <tbody>
            <c:forEach var="at" items="${jobCategoryModel.frmJobCategoryList}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.jobTitle}</td>				
				
				<td><a href="deleteCatPath?frmCatId=${at.id}">Delete</a></td>
			</tr>
		
		</c:forEach>
                </tbody>
              </table>
              <br>
<form action="logOutPath">
<input type="submit" value="Log Out" name="logout">
</form>
