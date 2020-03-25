<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "mockjava";
String userId = "root";
String password = "kaushik22india";
try {
Class.forName(driverName).newInstance();
System.out.println("Driver Connected");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>CPU values</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr>
<td><b>TransactionName</b></td>
<td><b>Average</b></td>
<td><b>Maximum</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM analysis";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("tansaction_name") %></td>
<td><%=resultSet.getString("average_value") %></td>
<td><%=resultSet.getString("maximum_value") %></td>


</tr>

<% 
}
} catch (Exception e) {	
e.printStackTrace();
}
%>
</table>