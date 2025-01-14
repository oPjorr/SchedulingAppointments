import "../assets/register.css"

export default function Register() {
    return (
        <>
            <div class="form-box">
                <form class="form">
                    <span class="title">Sign up</span>
                    <span class="subtitle">Create a free account with your email.</span>
                    <div class="form-container">
                        <input type="text" class="input" placeholder="Full Name" />
                        <input type="email" class="input" placeholder="Email" />
                        <input type="password" class="input" placeholder="Password" />
                        <input type="password" class="input" placeholder="Confirm Password" />
                    </div>
                    <button>Sign up</button>
                </form>
                <div class="form-section">
                    <p>Have an account? <a href="/login"> Log in </a></p>
                </div>
            </div>
        </>
    );
}