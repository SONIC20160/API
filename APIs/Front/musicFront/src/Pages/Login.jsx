import { useState } from "react"
import axios from 'axios'
import { useContext } from "react"
import { AuthContext } from "../context/AuthContext"
import { useNavigate } from "react-router-dom"
import { Link } from "react-router-dom"

const Login = () => {

    const {login} = useContext(AuthContext)
    const nami = useNavigate()
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    const handleSubmit = (event) => {
        event.preventDefault()
        axios.post("http://localhost:8080/users/login", {username, password})
        .then(response => {
            login(response.data)
            nami('/profile')
        })
        .catch(error => {console.log("Mamo")})
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <h2>User</h2>
                <input type="text" value={username} onChange={(event) => setUsername(event.target.value)}/>
                <h2>Password</h2>
                <input type="text" value={password} onChange={(event) => setPassword(event.target.value)}/>
                <button type="submit">Send</button>
                <button onClick={() => nami('/signin')}>Sign In</button>
            </form>
        </>
    )
}
export default Login