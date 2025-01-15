import "../assets/register.css"

export default function Register() {
    return (
        <>
            <div className="form-box">
                <form className="form" action="post">
                    <span className="title">Sign up</span>
                    <span className="subtitle">Create a free account with your email.</span>
                    <div className="form-container">
                        <input type="text" className="input" placeholder="Full Name" />
                        <input type="email" className="input" placeholder="Email" />
                        <input type="password" className="input" placeholder="Password" />
                        <input type="password" className="input" placeholder="Confirm Password" />
                    </div>
                    <button>Sign up</button>
                </form>
                <div className="form-section">
                    <p>Have an account? <a href="/login"> Log in </a></p>
                </div>
            </div>
        </>
    );
}