import { Form, useRouteLoaderData,redirect } from "react-router-dom";

function EditProfile() {
  const data = useRouteLoaderData("profile");
  return (
    <>
      <h1>Edit Profile</h1>
      <Form method="POST">
        <label htmlFor="businessName">Business Name</label>
        <input
          type="text"
          name="businessName"
          defaultValue={data.businessName}
        />
        <br />
        <label htmlFor="contactPerson">Contact Person</label>
        <input
          type="text"
          name="contactPerson"
          defaultValue={data.contactPerson}
        />
        <br />
        <label htmlFor="drugLicense">Drug License</label>
        <input type="text" name="drugLicense" defaultValue={data.drugLicense} />
        <br />
        <label htmlFor="gst">GST</label>
        <input type="text" name="gst" defaultValue={data.gst} />
        <br />
        <label htmlFor="phoneNumber">Phone Number</label>
        <input type="text" name="phoneNumber" defaultValue={data.phoneNumber} />
        <br />
        <button type="submit">Submit</button>
      </Form>
    </>
  );
}
export default EditProfile;

export async function editProfileAction({ request, params }) {
  const userId = params.userId;
  const formData = await request.formData();
  console.log(formData);

  const data = {
    businessName: formData.get("businessName"),
    contactPerson: formData.get("contactPerson"),
    drugLicense: formData.get("drugLicense"),
    gst: formData.get("gst"),
    phoneNumber:formData.get("phoneNumber")
  };
  const response = await fetch(
    "http://localhost:8080/user/" + userId + "/profile/edit",
    {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    }
  );
  if(!response.ok){
    console.log("Could not edit user profile");
    return response;
  }
  else{
    return redirect("../");
  }
}
