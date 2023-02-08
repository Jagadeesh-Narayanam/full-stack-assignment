import { Link } from "react-router-dom";

function Welcome() {
  return (
    <>
      <h1>Welcome page</h1>
      <Link to="/public/register">Register</Link>
      <br/>
      <Link to="/login">Login</Link>
      <br/>
      {/* <Link to="/admin">Admin</Link>
      <br/>
      <Link to="/user">User</Link> */}
    </>
  );
}
export default Welcome;
