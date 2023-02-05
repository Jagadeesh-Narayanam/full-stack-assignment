function RequestDeclined() {
  return (
    <>
      <p>Registration Request Declined</p>
    </>
  );
}
export default RequestDeclined;
export async function requestDeclinedLoader({request,params}){
    // const url = new URL(request.url).href;
    const requestId = params.requestId;
    
    const response = await fetch("http://localhost:8080/admin/new_requests/"+requestId+"/decline");
    if(!response.ok){
        console.log("Decline failed");
    }
    else{
        console.log("Registration Declined");
    }
    return null;
}
