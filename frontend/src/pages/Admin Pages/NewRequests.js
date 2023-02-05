import { Link, redirect, useLoaderData } from "react-router-dom";

function NewRequests() {
  const data = useLoaderData();
  return (
    <>
      <h1>New Registration Requests</h1>
      <table>
        <tbody>
          <tr>
            <th>Business Name</th>
            <th>Contact Person</th>
            <th>Drug License</th>
            <th>GST</th>
            <th>Phone Number</th>
            <th>Approve/Decline</th>
          </tr>
          {data.map((request) => (
            <tr key={request.id}>
              <td>{request.businessName}</td>
              <td>{request.contactPerson}</td>
              <td>{request.drugLicense}</td>
              <td>{request.gst}</td>
              <td>{request.phoneNumber}</td>
              <td>
                <Link to={`${request.id}/accept`}>Approve</Link>
                <br/>
                <Link to={`${request.id}/decline`}>Decline</Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}
export default NewRequests;

export async function requestsLoader() {
  const response = await fetch("http://localhost:8080/admin/new_requests");
  if (!response.ok) {
    console.log("Could not fetch New Registration Requests");
    return redirect("/admin");
  } else {
    const resData = await response.json();
    // console.log(resData);
    return resData;
  }
}

export async function requestsAction({request,params}){
    console.log("In Requests Action");
    const link = new URL(request.URL);
    console.log(link);
    return null;
}
