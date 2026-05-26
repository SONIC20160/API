import { useState } from "react"
import axios from 'axios'
import { useContext } from "react"
import { AuthContext } from "../context/AuthContext"
import { useNavigate } from "react-router-dom"

const Signin = () => {

    const nami = useNavigate()
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [email, setEmail] = useState("")

    const handleSubmit = (event) => {
        event.preventDefault()
        axios.post("http://localhost:8080/users", {username, email, password})
        .then(response =>nami('/login'))
        .catch(error => {console.log("Mamo")})
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <h2>Username</h2>
                <input type="text" value={username} onChange={(event) => setUsername(event.target.value)}/>
                <h2>email</h2>
                <input type="text" value={email} onChange={(event) => setEmail(event.target.value)}/>
                <h2>Password</h2>
                <input type="text" value={password} onChange={(event) => setPassword(event.target.value)}/>
                <button type="submit">Send</button>
            </form>
        </>
    )
}
export default Signin