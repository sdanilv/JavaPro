<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
    <link href="style.css" rel="stylesheet">
</head>
<body >
<center>
    <p>
        <h class="quest">First question</h>
    </p>
    <table>
<form action="/QuestionServlet" method="post">
        <tr>
            <td><input type="radio" name="Q1" value="A" checked>A</td>
            <td><input type="radio" name="Q1" value="B">B</td>
        </tr>
        <tr>
            <td><input type="radio" name="Q1" value="C">C</td>
            <td><input type="radio" name="Q1" value="D">D</td>
        </tr>
    </table>
    <p>
        <h class="quest">Second question</h>
    </p>
    <table>
        <tr>
            <td><input type="radio" name="Q2" value="A" checked>A</td>
            <td><input type="radio" name="Q2" value="B">B</td>
        </tr>
        <tr>
            <td><input type="radio" name="Q2" value="C">C</td>
            <td><input type="radio" name="Q2" value="D">D</td>
        </tr>
    </table>
    <p>
        <h class="quest">Third question</h>
    </p>
    <table>
        <tr style="background: coral">
            <td><input type="radio" name="Q3" value="A" checked>A</td>
            <td><input type="radio" name="Q3" value="B">B</td>
        </tr>

        <tr>
            <td><input type="radio" name="Q3" value="C">C</td>
            <td><input type="radio" name="Q3" value="D">D</td>
        </tr>
    </table>
    <td>
        <input type="submit" value="Send" style="margin: auto">
    </td>
</form>
    <td>
        <form action="/logout" method="post">
    <input type="submit" value="Logout">
        </form>
    </td>
    </table>
</center>
</body>
</html>
