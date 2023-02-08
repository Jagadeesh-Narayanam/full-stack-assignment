import { redirect, useRouteLoaderData } from "react-router-dom";
import { getAuthToken } from "../../util/Token";

function Profile() {
  const data = useRouteLoaderData("profile");
  return (
    <>
      <h1>Profile</h1>
      <p>Business Name : {data.businessName}</p>
      <p>Contact Person : {data.contactPerson}</p>
      <p>Drug License : {data.drugLicense}</p>
      <p>GST : {data.gst}</p>
      <p>Phone No : {data.phoneNumber}</p>
    </>
  );
}
export default Profile;

export async function profileLoader({ request, params }) {
  const username = localStorage.getItem("username");
  const response = await fetch(
    "http://localhost:8080/user/" + username + "/profile",{
      headers: {
        authorization: getAuthToken(),
      },
    }
  );
  if (!response.ok) {
    console.log("Could not load User Profile");
  } else {
    console.log("User Profile loaded successfully");
    const resData = await response.json();
    // console.log(resData);
    return resData;
  }
  return response;
}
