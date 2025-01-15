import { useCallback } from "react";
import "../assets/register.css"
import signIn from "../service/auth/signIn";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import checkToken from "../service/auth/checkToken";

export default function Login() {
    const navigate = useNavigate();
    const { opened } = location.state || { opened: false };
    const [open, setOpen] = useState(opened);

    const handleSubmit = useCallback(async (e) => {
        e.preventDefault()
        const login = e.target.loguser.value;
        const password = e.target.logpass.value;
        const success = await signIn(login, password)

        if (success && checkToken()) {
            navigate("/home")
          } else {
            setOpen(true);
          }
    });

    return (
        <>
            <div className="form-box">
                <form className="form" onSubmit={handleSubmit} action="post">
                    <span className="title">Sign in</span>
                    <span className="subtitle">Login in your account with your nick.</span>
                    <div className="form-container">
                        <input type="text" className="input" placeholder="Login" id="loguser"/>
                        <input type="password" id="logpass" className="input" placeholder="Password" />
                        <input type="password" className="input" placeholder="Confirm Password" />
                    </div>
                    <button>Sign in</button>
                </form>
                <div className="form-section">
                    <p>Don't Have an account? <a href="/register"> Sign up </a></p>
                </div>
            </div>
        </>
    );
}