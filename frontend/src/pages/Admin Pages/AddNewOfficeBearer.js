import { Form,redirect } from "react-router-dom";
import { getAuthToken } from "../../util/Token";

function AddNewOfficeBearer() {
  return (
    <>
      <h1>Add New Office Bearer</h1>
      <Form method="post">
        <label htmlFor="position">Position</label>
        <input type="text" name="position" />
        <br />
        <label htmlFor="name">Name</label>
        <input type="text" name="name" />
        <br />
        <label htmlFor="phoneNumber">Phone Number</label>
        <input type="text" name="phoneNumber" />
        <br />
        <label htmlFor="email">Email</label>
        <input type="email" name="email" />
        <br />
        <button type="submit">Submit</button>
      </Form>
    </>
  );
}
export default AddNewOfficeBearer;

export async function addOfficeBearerAction({ request, params }) {
  const formData = await request.formData();
  const data= {
    position:formData.get("position"),
    name:formData.get("name"),
    phoneNumber:formData.get("phoneNumber"),
    email:formData.get("email")
  }
  const response = await fetch(
    "http://localhost:8080/admin/add_new_office_bearer",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        authorization: getAuthToken(),
      },
      body: JSON.stringify(data),
    }
  );
  if(!response.ok){
    console.log("Could not add new office bearer");
  }
  else{
    console.log("Office Bearer added successfully");
  }
  return redirect("/admin/add_new_office_bearer");
}
