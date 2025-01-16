import "../assets/register.css"
import signUp from "../service/auth/signUp";
import LoginError from "../components/LoginError";
import { useState } from "react";
import signIn from "../service/auth/signIn";
import { useNavigate } from "react-router-dom";
import checkToken from "../service/auth/checkToken";

export default function Register() {
    const { opened } = location.state || { opened: false };
    const { openedSuccess } = location.state || { openedSuccess: false };
    const [openError, setOpenError] = useState(opened);
    const [openSuccess, setOpenSuccess] = useState(openedSuccess);
    const navigate = useNavigate();

    async function handleSubmit(e) {
        e.preventDefault();
        const login = e.target.login.value;
        const email = e.target.logEmail.value;
        const phone = e.target.logTel.value;
        const password = e.target.logPass.value;
        const verPass = e.target.logVerPass.value;

        if (password == verPass) {
            await signUp(login, password, phone, email)
            const success = await signIn(login, password);
            if (success && checkToken()) {
                setOpenSuccess(true)
            } else {
                setOpenError(true)
            }
        } else {
            setOpenError(true)
        }
    }
    return (
        <>
            <div className="form-box">
                <form className="form" action="post" onSubmit={handleSubmit}>
                    <span className="title">Sign up</span>
                    <span className="subtitle">Create a free account with your email.</span>
                    <div className="form-container">
                        <input type="text" className="input" placeholder="Full Name" />
                        <input type="email" className="input" placeholder="Email" />
                        <input type="number" className="input" placeholder="Phone" />
                        <input type="password" className="input" placeholder="Password" />
                        <input type="password" className="input" placeholder="Confirm Password" />
                    </div>
                    <button>Sign up</button>
                </form>
                <div className="form-section">
                    <p>Have an account? <a href="/login" type="submit"> Log in </a></p>
                </div>
            </div>
            {openSuccess && (
                <LoginSuccess open={openSuccess} setOpen={setOpenSuccess} />
            )}
            {openError && <LoginError open={openError} setOpen={setOpenError} />}
        </>
    );
}