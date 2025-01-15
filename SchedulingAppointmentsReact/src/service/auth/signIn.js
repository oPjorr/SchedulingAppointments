import apiAuth from "../apiAuth";

async function signIn(login, password) {
  try {
    const response = await apiAuth.post("/auth/login", {
      login,
      password,
    });
    const token = response.data.token;
    document.cookie = `token=${token}`;
    return true
  } catch (e) {
    return false
  }
}

export default signIn;
