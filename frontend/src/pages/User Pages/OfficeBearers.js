import { useLoaderData } from "react-router-dom";
import "./User CSS Files/OfficeBearers.css";

function OfficeBearers() {
  const data = useLoaderData();

  return (
    <>
      <h1>Office Bearers</h1>
      <ul className="office-bearers">
        {data.map((officeBearer) => (
          <div key={officeBearer.id} className="office-bearer">
            <p>Position : {officeBearer.position}</p>
            <p>Name : {officeBearer.name}</p>
            <p>Phone Number : {officeBearer.phoneNumber}</p>
            <p>Email : {officeBearer.email}</p>
          </div>
        ))}
      </ul>
    </>
  );
}
export default OfficeBearers;

export async function officeBearersLoader() {
  const response = await fetch("http://localhost:8080/user/officeBearers");
  if (!response.ok) {
    console.log("Could not fetch Office Bearers");
  } else {
    // console.log("Office Bearers loaded suucessfully");
    const resData = await response.json();
    return resData;
  }
  return null;
}
