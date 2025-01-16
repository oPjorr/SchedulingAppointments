import apiAuth from "../apiAuth";

async function signUp(login, password, phone, email) {
  try {
    apiAuth.post("/auth/register", {
      login: login,
      password: password,
      phone: phone,
      email: email,
      role: "PACIENT",
    });
  } catch (e) {
    console.log("Não foi possível criar um novo usuário");
  }
}

export default signUp;
