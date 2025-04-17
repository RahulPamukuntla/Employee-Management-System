<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Add New Employee</h2>
        <form:form action="/saveEmployee" modelAttribute="employee" method="post">
        
            <!--Name -->
            <div class="mb-3">
                <form:label path="name" class="form-label">Name</form:label>
                <form:input path="name" class="form-control" required="true"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            
            <!-- Email -->
            <div class="mb-3">
                <form:label path="email" class="form-label">Email</form:label>
                <form:input path="email" class="form-control" required="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" 
                           title="Please enter a valid email address (e.g., example@domain.com)"/>
                <form:errors path="name" cssClass="text-danger"/>
                <div id="emailError" class="text-danger" style="display:none;">Please enter a valid email address</div>
            </div>
            
            <!-- Date if birth -->
            <div class="mb-3">
                <form:label path="dob" class="form-label">Date of Birth</form:label>
                <form:input path="dob" type="date" class="form-control" required="true"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            
            <!-- Salary -->
            <div class="mb-3">
                <form:label path="salary" class="form-label">Salary</form:label>
                <form:input path="salary" class="form-control" required="true"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            
            <!-- Status -->
            <div class="mb-3">
                <form:label path="status" class="form-label">Status</form:label>
                <form:select path="status" class="form-control" required="true">
                    <form:option value="true">Active</form:option>
                    <form:option value="false">Inactive</form:option>
                </form:select>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            
            <!-- Submit -->
            <div class="text-center">
                <input type="submit" value="Save" class="btn btn-primary"/>
                <a href="/" class="btn btn-secondary">Cancel</a>
            </div>
        </form:form>
    </div>
    <script>
        function validateEmail() {
            const email = document.getElementById("email").value;
            const emailError = document.getElementById("emailError");
            const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

            if (!emailPattern.test(email)) {
                emailError.style.display = "block";
                return false;
            }
            emailError.style.display = "none";
            return true;
        }
    </script>
</body>
</html>