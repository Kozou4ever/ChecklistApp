import http from "../http-common";

class AuthService {

  signup(data: any): Promise<any> {
    return http.post("/auth/signup", data);
  }

  signin(data: any): Promise<any> {
    return http.post("/auth/signin", data);
  }
}

export default new AuthService();