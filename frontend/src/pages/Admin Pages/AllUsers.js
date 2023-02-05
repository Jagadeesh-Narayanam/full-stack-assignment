import { redirect, useLoaderData } from "react-router-dom";
import "./Admin CSS files/AllUsers.css";
function AllUsers() {
  const data = useLoaderData();
//   console.log(data);
  return (
    <>
      <h1>List of Users</h1>
      <table className="users_table">
        <tbody>
          <tr>
            <th>Business Name</th>
            <th>Contact Person</th>
            <th>Drug License</th>
            <th>GST</th>
            <th>Phone Number</th>
          </tr>
          {data.map((user) => (
            <tr key={user.drugLicense}>
              <td>{user.businessName}</td>
              <td>{user.contactPerson}</td>
              <td>{user.drugLicense}</td>
              <td>{user.gst}</td>
              <td>{user.phoneNumber}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}
export default AllUsers;
export async function usersLoader() {
  const response = await fetch("http://localhost:8080/admin/users");
  // console.log(response);
  if (!response.ok) {
    console.log("Could not fetch users");
    return redirect("/admin");
  } else {
    const resData = await response.json();
    // console.log(JSON.stringify(resData));
    return resData;
  }
}
