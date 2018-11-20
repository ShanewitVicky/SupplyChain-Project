<?php 
require "connect.php";
$user_name =$_POST["User_Name"];

$mysql_qry = "select * from users where user_name like ?";
$stmt=$conn->prepare($mysql_qry);
$stmt->bind_param("s",$user_name);



$resultArray=array();



if($stmt->execute()) {
	$result = $stmt->get_result();
	while($row = $result->fetch_assoc()){
    array_push($resultArray,array(
        'Usr_id'=>$row['Usr_id'],
        'User_Name'=>$row['User_Name'],
        'password'=>$row['password'],
        'First_Name'=>$row['First_Name'],
        'Last_Name'=>$row['Last_Name'],
		'Phone_Number1'=>$row['Phone_Number1'],
		'URL'=>$row['URL'],
		'Email_id'=>$row['Email_id'],
		'Address'=>$row['Address']
    ));
}

echo json_encode(array('result'=>$resultArray));


	
	

}
else {
echo "login not success";
}
?>