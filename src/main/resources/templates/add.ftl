<!DOCTYPE html>
<html lang="en">
<head>

    <#import "/spring.ftl" as spring/>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet"
              type="text/css" href="<@spring.url '/css/style.css'/>"/>
    </head>
<body>

<div>
    <fieldset>
        <legend>Add student</legend>
        <form name="student" action="" method="POST">
<#--            ID:<@spring.formInput "studentForm.id" "" "text"/>-->
<#--            <br>-->
            name:<@spring.formInput "studentForm.name" "" "text"/>
            <br>
           grupa:<@spring.formInput "studentForm.grupa" "" "text"/>
            <br>
            mark:<@spring.formInput "studentForm.mark" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>