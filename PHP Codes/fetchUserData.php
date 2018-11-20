<?php 
require "connect.php";
$user_name =$_POST["User_Name"];

$mysql_qry = "select * from users where user_name like '$user_name';";
$result = mysqli_query($conn ,$mysql_qry);

$resultArray=array();



if(mysqli_num_rows($result) > 0) {
	
	while($row = mysqli_fetch_array($result)){
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