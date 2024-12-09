<label for="user">User:</label>
<select name="user.id" required>
    <c:forEach var="user" items="${users}">
        <option value="${user.id}" ${employee.user != null && employee.user.id == user.id ? 'selected' : ''}>${user.name}</option>
    </c:forEach>
</select><br/>

<label for="company">Company:</label>
<select name="company.id" required>
    <c:forEach var="company" items="${companies}">
        <option value="${company.id}" ${employee.company != null && employee.company.id == company.id ? 'selected' : ''}>${company.name}</option>
    </c:forEach>
</select><br/>
