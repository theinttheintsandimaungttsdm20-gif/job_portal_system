<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>

<h1>CATEGORY  PAGE</h1>
<sform:form modelAttribute="jobCategoryModel" action="updateCatPath" method="post">
  
         <table>
	         <tr>
				<th>Category Id</th>
				<td>${jobCategoryModel.jobCategory.id}</td>
				<input type="hidden" 
					value="${jobCategoryModel.jobCategory.id}" name="frmCatId" />
			</tr>
         	<tr>
               <td>Enter new Job Category:</td>
               <td><sform:input path="frmJobTitle" value="${jobCategoryModel.jobCategory.jobTitle}"/></td>
            </tr>
           <tr>
           	<td>
           		<input type="submit" value="Update"/>
           	</td>
           </tr>
           </table>
</sform:form>
  <br>
<form action="logOutPath">
<input type="submit" value="Log Out" name="logout">
</form>
           