import { Form, Link, Outlet } from "react-router-dom";

function UserHome() {
  const username = localStorage.getItem("username");
  function logoutHandler(){
    window.confirm("Are you sure to logout?");
  }
  return (
    <>
      <div>
        <h1>User HomePage</h1>
        <Form action="/logout" method="post">
          <button onClick={logoutHandler}>Logout</button>
        </Form>
      </div>
      <div className="links">
        <Link to="officeBearers">Office Bearers</Link>
        <Link to="products">Products</Link>
        <Link to={`${username}/profile`}>Profile</Link>
        <Link to={`${username}/profile/edit`}>Edit your Profile</Link>
      </div>
      <Outlet />
    </>
  );
}
export default UserHome;
