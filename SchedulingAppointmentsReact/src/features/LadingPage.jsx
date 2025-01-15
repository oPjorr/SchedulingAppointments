import React from "react";
import "../styles/styles.css"

const LadingPage = () => {
  return (
    <div className="content">
        <header>
            <div className="container">
            <h2>SchedulingAppointments</h2>
            <div className="buttons">
                <a href="/login" className="btn">Login</a>
                <a href="/register" className="btn">Cadastro</a>
            </div>
            </div>
        </header>

        <section className="main-content">
          <h2>Agende suas consultas médicas com facilidade!</h2>
          <p>Encontre os melhores profissionais e marque sua consulta online.</p>
        </section>
        <div className="background"></div>
    </div>
  );
};

export default LadingPage;
