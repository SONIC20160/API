import { useState } from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import About from "./pages/About";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Signin from "./pages/Signin";
import Profile from "./pages/Profile";
import NavBar from "./Components/Navbar";

function App() {

  return (
    <>
      <BrowserRouter>
        <NavBar/>
        <Routes>
          <Route path='/' element={<Home />}/>
          <Route path='/about' element={<About />}/>
          <Route path='/login' element={<Login />}/>
          <Route path='/signin' element={<Signin />}/>
          <Route path='/profile' element={<Profile />}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
