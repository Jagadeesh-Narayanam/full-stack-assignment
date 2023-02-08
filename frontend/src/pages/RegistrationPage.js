import { Form, redirect } from "react-router-dom";

function RegistrationPage() {

  return (
    <>
      <h1>Register here</h1>
      <Form method="post">
        <label htmlFor="businessName">Business Name</label>
        <input type="text" name="businessName" />
        <br />
        <label htmlFor="contactPerson">Contact Person</label>
        <input type="text" name="contactPerson" />
        <br />
        <label htmlFor="drugLicense">Drug License</label>
        <input type="text" name="drugLicense" />
        <br />
        <label htmlFor="gst">GST ID</label>
        <input type="text" name="gst" />
        <br />
        <label htmlFor="phoneNumber">Phone Number</label>
        <input type="text" name="phoneNumber" />
        <br/>
        <label htmlFor="username">UserName</label>
        <input type="text" name="username"/>
        <br/>
        <label htmlFor="password">Password</label>
        <input type="text" name="password"/>
        <br/>
        <button type="submit">Submit</button>
      </Form>
    </>
  );
}
export default RegistrationPage;
export async function action({ request, params }) {
  const formData = await request.formData();
//   console.log(formData);
  const data = {
    businessName: formData.get("businessName"),
    contactPerson: formData.get("contactPerson"),
    drugLicense: formData.get("drugLicense"),
    gst: formData.get("gst"),
    phoneNumber: formData.get("phoneNumber"),
    username:formData.get("username"),
    password:formData.get("password")
  };
  const response = await fetch("http://localhost:8080/public/register", {
    method: "POST",
    headers:{
        "Content-Type":"application/json"
    },
    body: JSON.stringify(data),
    mode:"cors"
  });
  if(!response.ok){
    console.log("error while registering");
  }
  console.log("success");
  return redirect("/registration_success");
}
