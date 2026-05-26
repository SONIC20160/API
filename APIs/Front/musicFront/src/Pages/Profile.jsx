import { useContext, useEffect } from "react"
import { AuthContext } from "../context/AuthContext"
import { useNavigate } from "react-router-dom"

const Profile = () => {

    const {user, logout} = useContext(AuthContext)
    const nami = useNavigate()

    useEffect(() => {
        if(user == null){
            nami('/login')
        }
    }, [user])

    if(user == null){return null}

    return (    
        <>
            <h1>{user.username}</h1>
            <h1>{user.email}</h1>
            <button onClick={logout}>Log out</button>
        </>
    )
}
export default Profile