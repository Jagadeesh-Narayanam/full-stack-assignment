function RequestApproved(){
    return <>
    <p>New User added</p>
    </>
}
export default RequestApproved;

export async function requestApprovedLoader({request,params}){
    // const url= new URL(request.url).href;
    const requestId = params.requestId;
    // console.log(params);

    // const response = await fetch(url);
    const response = await fetch("http://localhost:8080/admin/new_requests/"+requestId+"/accept");
    // console.log(url);
    if(!response.ok){
        console.log("Could not Approve");
    }
    else{
        console.log("Request Approved !! ")
    }
    return null;
}