<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #121212;
            color: #ffffff;
        }
        h2, h1, .lead {
            color: #ffffff;
        }
        .table {
            background-color: #1a1a1a;
            color: #d3d3d3;
        }
        .table-bordered th,
        .table-bordered td {
            border-color: #333333;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        .btn-warning {
            background-color: #ffc107;
            color: #000000;
        }
        .btn-warning:hover {
            background-color: #e0a800;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-danger:hover {
            background-color: #b02a37;
            border-color: #b02a37;
        }
        a {
            color: #ffffff;
        }
        a:hover {
            color: #cccccc;
        }
        .search-box input {
            background-color: #1a1a1a;
            color: #ffffff;
            border: 1px solid #444;
        }
        .search-box input::placeholder {
            color: #cccccc;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <!-- Hero Section -->
        <div class="text-white p-4 mb-4 rounded" style="background: linear-gradient(to right, #007bff, #6610f2);">
            <h1 class="display-6">Welcome to the Employee Management System</h1>
            <p class="lead">Manage your employees effectively with our sleek dashboard.</p>
        </div>

        <!-- Search and Add -->
        <div class="row mb-3">
            <div class="col-md-6 search-box">
                <form action="/searchEmployee" method="get">
                    <input type="text" name="keyword" class="form-control" placeholder="Search by name or email">
                </form>
            </div>
            <div class="col-md-6 text-end">
                <a href="/showNewEmployeeForm" class="btn btn-primary">Add New Employee</a>
            </div>
        </div>

        <!-- Employee Table -->
        <h2 class="text-center mb-3">Employee List</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>DOB</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${listEmployees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.email}</td>
                        <td>${employee.dob}</td>
                        <td>${employee.age}</td>
                        <td>${employee.salary}</td>
                        <td>
                            <span class="badge ${employee.status ? 'bg-success' : 'bg-secondary'}">
                                ${employee.status ? 'Active' : 'Inactive'}
                            </span>
                        </td>
                        <td>
                            <a href="/showFormForUpdate/${employee.id}" class="btn btn-sm btn-warning">Edit</a>
                            <a href="/deleteEmployee/${employee.id}" class="btn btn-sm btn-danger"
                               onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>
