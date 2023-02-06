import { useState } from "react";
import { Form, redirect } from "react-router-dom";

function AddNewProducts() {
  const [inputFields, setInputFields] = useState([
    { productName: "", productDescription: "" },
  ]);
  const handleFormChange = (index, event) => {
    let data = [...inputFields];
    data[index][event.target.name] = event.target.value;
    setInputFields(data);
  };
  const addFields = () => {
    let newfield = { productName: "", productDescription: "" };
    setInputFields([...inputFields, newfield]);
  };
  const submit = (e) => {
    e.preventDefault();
    console.log(inputFields);
    return inputFields;
  };
  const removeFields = (index) => {
    let data = [...inputFields];
    data.splice(index, 1)
    setInputFields(data)
}
  return (
    <>
      <h1>Add New Products</h1>
      <Form method="post">
        {inputFields.map((input, index) => {
          return (
            <div key={index}>
              <input
                name="productName"
                placeholder="Product Name"
                value={input.productName}
                required
                onChange={(event) => handleFormChange(index, event)}
              />
              <input
                name="productDescription"
                placeholder="Product Description"
                value={input.productDescription}
                required
                onChange={(event) => handleFormChange(index, event)}
              />
              <button onClick={() => removeFields(index)}>Remove</button>
            </div>
          );
        })}
        <button
          type="submit"
          // onClick={submit}
        >
          Submit
        </button>
      </Form>
      <button onClick={addFields}>Add More..</button>
    </>
  );
}
export default AddNewProducts;

export async function addNewProductsAction({ request, params }) {
  const formData = await request.formData();
  const dataList = [];
//   console.log(formData);
    let i = 1;

  let object={};
  for (const value of formData.values()) {
    
    if (i % 2 == 1) {
        object["productName"]= value
    }
    else{
        object["productDescription"]=value;
        // console.log(data)
        dataList.push(object);
        object={};
    }
    i++;
  }
  const data = [];
  const response = await fetch("http://localhost:8080/admin/add_new_products", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(dataList),
  });
  if (!response.ok) {
    console.log("Could not upload list of products");
  } else {
    return response;
  }
}
