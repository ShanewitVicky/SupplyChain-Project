<?php 
require "connect.php";
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$mysql_qry = "select * from users where user_name like ? and password like ?;";
$stmt=$conn->prepare($mysql_qry);
$stmt->bind_param("ss",$user_name,$user_pass);
$stmt->execute();
if($stmt->fetch()) {
echo "login success !!!!! Welcome user";
}
else {
echo "login not success";
}
 
?>