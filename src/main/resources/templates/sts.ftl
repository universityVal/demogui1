<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>



<h3>Student list</h3>
<br>

    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Grupa</th>
            <th>Mark</th>
            <th>Delete</th>

        </tr>
        <#list students as student>
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
               <td>${student.grupa}</td>
                <td>${student.mark}</td>
                <td><a href="/student/delete/${student.id}">Delete</a></td>
            </tr>
        </#list>
    </table>

<a href="/student/add">Add new student</a>

</body>
</html>