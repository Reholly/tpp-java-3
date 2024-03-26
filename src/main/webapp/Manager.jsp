<<%@ page import="java.io.File" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String directory = request.getParameter("path");
    File file = new File(directory);
    String parentDirectoryPath = "/";



        parentDirectoryPath = file.getParent();  // Получаем путь к папке-родителю

        if (parentDirectoryPath == null) {
            parentDirectoryPath = "/";
        }


%>
<html>
<head>
    <title>Менеджер файлов</title>

</head>
<body>

    <h1>Текущая директория: "<%=(String) request.getAttribute("currentPath")%> "</h1>
    <p><a href=<%="?path="+parentDirectoryPath%>/>Назад</p>
    <%
        String generatedAt = (String) request.getAttribute("generationTime"); // Получаем список из объекта запроса
    %>
    <p><%=generatedAt%></p>
    <table>
        <tr>
            <th>Папка</th>
            <th>Перейти</th>
            <th>Размер(байты)</th>
            <th>Последнее изменение</th>
        </tr>
        <%
            File[] itemList = (File[]) request.getAttribute("folders"); // Получаем список из объекта запроса
            for (File item : itemList) {
        %>
        <tr>
            <th><%= item.getName()%></th>
            <th><a href=<%="?path="+item.getAbsolutePath()%>/>Перейти</th>
            <th></th>
            <th><%= new Date(item.lastModified())%></th>
        </tr>
        <% } %>
        <tr>
            <th>Файл</th>
            <th>Ссылка на скачивание</th>
            <th>Размер(байты)</th>
            <th>Последнее изменение</th>
        </tr>
        <%
            File[] list = (File[]) request.getAttribute("files"); // Получаем список из объекта запроса
            for (File item : list) {
        %>
        <tr>
            <th><%= item.getName()%></th>

            <th><a href=<%="http://localhost:8080/tpp_java_3_war_exploded/Download?path="+ item.getAbsolutePath()%>> Скачать </a> </th>
            <th><%= item.length()%></th>
            <th><%= new Date(item.lastModified())%></th>
        </tr>
        <% } %>
    </table>


    <p></p>
</body>
</html>
