import { useContext } from "react"
import { AuthContext } from "../context/AuthContext"
import { Link } from "react-router-dom"

const NavBar = () => {

    const { user } = useContext(AuthContext)

    return (
        <>
            <h1>Imagen</h1><h1>Music</h1><Link to="/about">About</Link>

             {user ? <Link to="/profile">Profile</Link> : (
                <>
                    <Link to="/login">Login</Link> 
                    <Link to="/signin">Sign In</Link>
                </>
            )}
        </>
    )
}
export default NavBar